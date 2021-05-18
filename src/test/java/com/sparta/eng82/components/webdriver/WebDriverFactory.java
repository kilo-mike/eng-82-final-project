package com.sparta.eng82.components.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
    }


    public WebDriver getWebDriver(WebDriverTypes driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                driver = null;
                break;

        }
        return driver;
    }
}
