package com.systemxstudios.data;

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
                condition = new WeatherCondition(id, "Unknown", "path_to_icon");
                break;
            case CONDITION_CLEAR:
                condition = new WeatherCondition(id, "Clear", "path_to_icon");
                break;
            case CONDITION_CLOUDY:
                condition = new WeatherCondition(id, "Cloudy", "path_to_icon");
                break;
            case CONDITION_FOGGY:
                condition = new WeatherCondition(id, "Foggy", "path_to_icon");
                break;
            case CONDITION_HAZY:
                condition = new WeatherCondition(id, "Hazy", "path_to_icon");
                break;
            case CONDITION_ICY:
                condition = new WeatherCondition(id, "Icy", "path_to_icon");
                break;
            case CONDITION_RAINY:
                condition = new WeatherCondition(id, "Rainy", "path_to_icon");
                break;
            case CONDITION_SNOWY:
                condition = new WeatherCondition(id, "Snowy", "path_to_icon");
                break;
            case CONDITION_STORMY:
                condition = new WeatherCondition(id, "Stormy", "path_to_icon");
                break;
            case CONDITION_WINDY:
                condition = new WeatherCondition(id, "Windy", "path_to_icon");
                break;
        }

        return condition;
    }
}