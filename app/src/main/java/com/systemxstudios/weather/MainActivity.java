package com.systemxstudios.weather;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.awareness.Awareness;
import com.google.android.gms.awareness.snapshot.WeatherResult;
import com.google.android.gms.awareness.state.Weather;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    final private int REQUEST_PERMISSION_LOCATION = 123;
    private final String TAG = getClass().getSimpleName();

    @BindView(R2.id.main_text) TextView tvMain;

    /**
     * Overriding the system baseContext in order to use custom fonts. Done so by wrapping the
     * system baseContext with the CalligraphyContextWrapper
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getCurrentWeather();
    }

    /**
     * Gets the current weather information by utilizing the Awareness API. Will also get the required permission if the user has not granted already
     */
    private void getCurrentWeather() {
        GoogleApiClient apiClient = getAwarenessAPI();
        apiClient.connect();

        // First check permission
        int hasLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
        if (hasLocationPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION_LOCATION);
            return;
        }

        // Permission has already been granted, can continue
        Awareness.SnapshotApi.getWeather(apiClient)
                .setResultCallback(new WeatherResultCallback());
    }

    /**
     * Creates an handle to Google's API. Awareness API is specified as part of the initialization
     *
     * @return GoogleApiClient object fired up for use of the Awareness API
     */
    private GoogleApiClient getAwarenessAPI() {
        GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(MainActivity.this)
                .addApi(Awareness.API)
                .build();
        return mGoogleApiClient;
    }

    /**
     * Sets the weather data to the views
     * @param currWeather Weather for the current location
     */
    private void setWeatherData(Weather currWeather) {
        tvMain.setText(String.valueOf(currWeather.getTemperature(Weather.FAHRENHEIT)));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted, now get the current weather
                    getCurrentWeather();
                } else {
                    // Permission Denied, let the user know
                    Toast.makeText(MainActivity.this, "Can't refresh weather without location access", Toast.LENGTH_LONG)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    class WeatherResultCallback implements ResultCallback<WeatherResult> {
        Weather currentWeather;

        @Override
        public void onResult(@NonNull WeatherResult weatherResult) {
            if (!weatherResult.getStatus().isSuccess()) {
                Log.v(TAG, "Could not get weather.");
                return;
            }
            currentWeather = weatherResult.getWeather();
            Log.v(TAG, "Weather: " + currentWeather);
            setWeatherData(currentWeather);
        }
    }
}
