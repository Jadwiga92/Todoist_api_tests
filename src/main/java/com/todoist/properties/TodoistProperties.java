package com.todoist.properties;

import java.util.ResourceBundle;

public class TodoistProperties {

    private static final String BEARER = "todoist.bearer";

    //    private static String getProperty(String key) {
//        return ResourceBundle.getBundle("todoist").getString(key);
//    }
//
//    public static String getBearer() {
//        return getProperty(BEARER);
//    }
    private static String getProperty(String key) {
        return ResourceBundle.getBundle("todoist").getString(key);
    }

    public static String getBearer() {
        if (getProperty(BEARER).startsWith("YOUR") || getProperty(BEARER).isEmpty()) {
            System.out.println("Get system property TOKEN: " + System.getProperty("TOKEN"));
            return System.getProperty("TOKEN");
        } else {
            return getProperty(BEARER);
        }
    }
}
