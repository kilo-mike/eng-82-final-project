package com.sparta.eng82.tests.unit.admin;

import com.sparta.eng82.components.frameworkutil.WebDriverFactory;
import com.sparta.eng82.components.frameworkutil.WebDriverTypes;
import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.admin.EditTrainerPageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class EditTrainerPageTests {

    private static WebDriverFactory webDriverFactory;
    private final String userAdmin = "admin";
    private final String originalFirstName = "jakub";
    private final String originalLastName = "matyjewicz";
    private final String originalGroupName = "hola";
    private final String desiredFirstName = "Jakub";
    private final String desiredLastName = "Matyjewicz";
    private final String desiredGroupName = "No Group";
    private WebDriver driver;
    private AdminHomePageImpl adminHomePage;

    @BeforeAll
    static void setupAll() {
        webDriverFactory = new WebDriverFactory();
    }

    @AfterAll
    static void tearDownAll() {
        webDriverFactory.endAllServices();
    }

    @BeforeEach
    void setup() {
        driver = webDriverFactory.getWebDriver(WebDriverTypes.CHROME);
        adminHomePage = (AdminHomePageImpl) new LoginPageImpl(driver, userAdmin).login();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Check first name has entered")
    void checkFirstNameHasEntered() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.clickOnTrainer(originalFirstName, originalLastName))
                .editFirstName(desiredFirstName)
                .checkFirstNameInputValueCorrect(desiredFirstName));
    }

    @Test
    @DisplayName("Check last name has entered")
    void checkLastNameHasEntered() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.clickOnTrainer(originalFirstName, originalLastName))
                .editLastName(desiredLastName)
                .checkLastNameInputValueCorrect(desiredLastName));
    }


    @Test
    @DisplayName("Check group has been selected")
    void checkGroupHasBeenSelected() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.clickOnTrainer(originalFirstName, originalLastName))
                .editGroup(desiredGroupName)
                .checkGroupNameSelectValueCorrect(desiredGroupName));
    }


    @Test
    @DisplayName("Check if tick box is ticked")
    void checkIfTickBoxIsTicked() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.clickOnTrainer(originalFirstName, originalLastName)).tickForRemove()
                .checkIfTickBoxIsTicked());
    }

    @Test
    @DisplayName("Check if all edited inputs have been entered")
    void checkIfAllEditedInputsHaveBeenEntered() {
        Assertions.assertTrue(
                ((EditTrainerPageImpl) adminHomePage.clickOnTrainer(originalFirstName, originalLastName))
                        .checkIfAllInputsHaveBeenEntered(desiredFirstName, desiredLastName, desiredGroupName));
    }

    @Test
    @DisplayName("Check if first name and last name inputs have been entered and saved")
    void checkIfFirstNameAndLastNameInputsHaveBeenEnteredAndSaved() {
        Assertions.assertTrue(((EditTrainerPageImpl) adminHomePage.clickOnTrainer(originalFirstName, originalLastName))
                .editFirstName(desiredFirstName)
                .editLastName(desiredLastName)
                .saveChanges()
                .isTrainerAdded(desiredFirstName, desiredLastName, originalGroupName));

        ((EditTrainerPageImpl) adminHomePage.clickOnTrainer(desiredFirstName, desiredLastName))
                .editFirstName(originalFirstName)
                .editLastName(originalLastName)
                .saveChanges();
    }
}
