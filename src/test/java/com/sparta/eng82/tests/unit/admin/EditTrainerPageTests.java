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

    private final String originalFirstName = "jakub";
    private final String originalLastName = "matyjewicz";
    private final String originalGroupName = "hola";

    private final String desiredFirstName = "Jakub";
    private final String desiredLastName = "Matyjewicz";
    private final String desiredGroupName = "No Group";

    private final int rowCount = 4;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        adminHomePage = (AdminHomePageImpl) new LoginPageImpl(driver, userAdmin).login();
    }

    @AfterEach
    void tearDown() {
//        new EditTrainerPageImpl(driver, userAdmin, rowCount).resetTrainerInfo("jakub","matyjewicz");
        driver.quit();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

    @Test
    @DisplayName("Check first name has entered")
    void checkFirstNameHasEntered() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.editTrainer(originalFirstName, originalLastName))
                .editFirstName(desiredFirstName)
        .checkFirstNameInputValueCorrect(desiredFirstName));
    }
    @Test
    @DisplayName("Check last name has entered")
    void checkLastNameHasEntered() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.editTrainer(originalFirstName, originalLastName))
                .editLastName(desiredLastName)
        .checkLastNameInputValueCorrect(desiredLastName));
    }


    @Test
    @DisplayName("Check group has been selected")
    void checkGroupHasBeenSelected() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.editTrainer(originalFirstName, originalLastName))
                .editGroup(originalGroupName)
                .checkGroupNameSelectValueCorrect(originalGroupName));
    }


    @Test
    @DisplayName("Check if tick box is ticked")
    void checkIfTickBoxIsTicked() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.editTrainer(originalFirstName, originalLastName)).tickForRemove()
                .checkIfTickBoxIsTicked());
    }

    @Test
    @DisplayName("Check if all edited inputs have been entered")
    void checkIfAllEditedInputsHaveBeenEntered() {
        Assertions.assertTrue(
                ((EditTrainerPageImpl)  adminHomePage.editTrainer(desiredFirstName, desiredLastName))
                .checkIfAllInputsHaveBeenEntered(desiredFirstName, desiredLastName, desiredGroupName));
    }


}
