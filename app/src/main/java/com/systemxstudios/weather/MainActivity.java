package com.systemxstudios.weather;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.systemxstudios.object.Weather;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_text) TextView tvMain;

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

        // Testing creating a kotlin object within java
        Float fTemp = 25.0f;
        Float fTempFeelsLike = 2.0f;
        Float fDew = 2.0f;
        int numHumidity = 2;
        int[] arrConditions = new int[] {1,2,3};

        Weather weather = new Weather(fTemp,fTempFeelsLike,numHumidity,fDew,arrConditions);
        tvMain.setText(String.valueOf(weather.getTemp()));
    }
}
