package com.systemxstudios.data;

import com.systemxstudios.weather.R;

/**
 * Factory class to create WeatherCondition objects
 */

public class WeatherConditionFactory {

    public static final int CONDITION_UNKNOWN = 0;
    public static final int CONDITION_CLEAR = 1;
    public static final int CONDITION_CLOUDY = 2;
    public static final int CONDITION_FOGGY = 3;
    public static final int CONDITION_HAZY = 4;
    public static final int CONDITION_ICY = 5;
    public static final int CONDITION_RAINY = 6;
    public static final int CONDITION_SNOWY = 7;
    public static final int CONDITION_STORMY = 8;
    public static final int CONDITION_WINDY = 9;

    /**
     * Gets the corresponding WeatherCondition object for the specified conditionID
     *
     * @param id Condition ID returned by Awareness API
     * @return The WeatherCondition object associated with that ID
     */
    public static WeatherCondition getWeatherCondition(int id) {
        WeatherCondition condition;

        switch (id) {
            default:
            case CONDITION_UNKNOWN:
                condition = new WeatherCondition(id, "Unknown", R.drawable.ic_launcher_background);
                break;
            case CONDITION_CLEAR:
                condition = new WeatherCondition(id, "Clear", R.drawable.ic_condition_clear);
                break;
            case CONDITION_CLOUDY:
                condition = new WeatherCondition(id, "Cloudy", R.drawable.ic_condition_cloudy);
                break;
            case CONDITION_FOGGY:
                condition = new WeatherCondition(id, "Foggy", R.drawable.ic_launcher_background);
                break;
            case CONDITION_HAZY:
                condition = new WeatherCondition(id, "Hazy", R.drawable.ic_launcher_background);
                break;
            case CONDITION_ICY:
                condition = new WeatherCondition(id, "Icy", R.drawable.ic_launcher_background);
                break;
            case CONDITION_RAINY:
                condition = new WeatherCondition(id, "Rainy", R.drawable.ic_condition_rainy);
                break;
            case CONDITION_SNOWY:
                condition = new WeatherCondition(id, "Snowy", R.drawable.ic_condition_snowy);
                break;
            case CONDITION_STORMY:
                condition = new WeatherCondition(id, "Stormy", R.drawable.ic_condition_stormy);
                break;
            case CONDITION_WINDY:
                condition = new WeatherCondition(id, "Windy", R.drawable.ic_launcher_background);
                break;
        }

        return condition;
    }
}