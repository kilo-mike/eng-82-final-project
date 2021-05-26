package com.sparta.eng82.tests.unit.admin;

import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.admin.AddTrainerPageImpl;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.admin.EditTrainerPageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.function.BooleanSupplier;

public class EditTrainerPageTests {

    private WebDriver driver;
    private static WebDriverFactory webDriverFactory;
    private AdminHomePageImpl adminHomePage;

    private final String userAdmin = "admin";

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        adminHomePage = (AdminHomePageImpl) new LoginPageImpl(driver, userAdmin).login();
    }

//    @AfterEach
//    void tearDown() {
//        new EditTrainerPageImpl(driver, userAdmin).resetTrainerInfo("jakub","matyjewicz");
//        driver.quit();
//    }
//
//    @AfterAll
//    static void tearDownAll() {
//        webDriverFactory.endAllServices();
//    }

    @Test
    @DisplayName("Check first name has entered")
    void checkFirstNameHasEntered() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.editTrainer("jakub", "matyjewicz"))
                .editFirstName("Jakub")
        .checkFirstNameInputValueCorrect("Jakub"));
    }
    @Test
    @DisplayName("Check last name has entered")
    void checkLastNameHasEntered() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.editTrainer("jakub", "matyjewicz"))
                .editLastName("Matyjewicz")
        .checkLastNameInputValueCorrect("Matyjewicz"));
    }


    @Test
    @DisplayName("Check group has been selected")
    void checkGroupHasBeenSelected() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.editTrainer("jakub","matyjewicz"))
                .editGroup("hola")
                .checkGroupNameSelectValueCorrect("hola"));
    }


}
