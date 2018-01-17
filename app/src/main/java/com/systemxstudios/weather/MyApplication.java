package com.systemxstudios.weather;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * This class sits above all the activities, so we can set a custom font at the topmost level.
 */
public class MyApplication extends Application {

    /**
     * Definez the custom font to use throughout the application
     */
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/RobotoCondensed-Regular.ttf").setFontAttrId(R.attr.fontPath).build());
    }
}
