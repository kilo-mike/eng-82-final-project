package com.sparta.eng82.interfaces;

import org.openqa.selenium.WebDriver;

public interface Page {

    default String getUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }


}
