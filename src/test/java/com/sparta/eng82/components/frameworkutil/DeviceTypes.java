package com.sparta.eng82.components.frameworkutil;




import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.Map;

public enum DeviceTypes {
    IPHONE_X(375, 812),
    PIXEL_2_XL(411, 823),
    GALAXY_S5(360, 640),
    IPAD(768, 1024);

    private static final Map<DeviceTypes, Integer> WIDTH = new HashMap<>();
    private static final Map<DeviceTypes, Integer> HEIGHT = new HashMap<>();

    static {
        for (DeviceTypes dt : values()) {
            WIDTH.put(dt, dt.width);
            HEIGHT.put(dt, dt.height);
        }
    }

    public final Integer width;
    public final Integer height;

    DeviceTypes(Integer width, Integer height){
        this.height = height;
        this.width = width;
    }

    public static Dimension getSize(DeviceTypes device){
        return new Dimension(WIDTH.get(device), HEIGHT.get(device));
    }
}
