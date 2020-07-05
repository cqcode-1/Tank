package com.john.tank;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyManager {
    public static Properties properties = new Properties();

    static {
        try {
            properties.load(Objects.requireNonNull(PropertyManager.class.getClassLoader().getResourceAsStream("config")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if(properties == null)return null;
        return properties.get(key);
    }
}
