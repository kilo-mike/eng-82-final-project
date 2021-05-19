package com.sparta.eng82.tests.unit.other;


import com.sparta.eng82.components.webdriver.WebDriverFactory;
import com.sparta.eng82.components.webdriver.WebDriverTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.EnumSet;
import java.util.Set;

public class LoginPageImplTests {

    private static final EnumSet<WebDriverTypes> normalTypes = EnumSet.of(WebDriverTypes.CHROME, WebDriverTypes.EDGE);
    static WebDriver driver;
    static WebDriverFactory webDriverFactory;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    private static Set<WebDriverTypes> normalTypesTest() {
        return normalTypes;
    }

    @ParameterizedTest
    @MethodSource("normalTypesTest")
    @DisplayName("Test all normal types")
    void testAllDriverTypes(WebDriverTypes webDriverType) {
        driver = webDriverFactory.getWebDriver(webDriverType);
    }
}
