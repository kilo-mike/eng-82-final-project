package com.sparta.eng82.tests.stepdefs;


import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class loginStepDefs {

    @Before
    public void setUp() {
        DriverManager.setUp();
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        Pages.loginPage = new LoginPageImpl(DriverManager.driver, "admin").driverGet();
    }

    @When("I type the admin username")
    public void iTypeTheAdminUsername() {
        Pages.loginPage.enterEmail();
    }

    @And("admin password")
    public void adminPassword() {
        Pages.loginPage.enterPassword();
    }

    @And("I click sign in as an admin")
    public void iClickSignInAsAnAdmin() {
        Pages.adminHomePage = (AdminHomePageImpl) Pages.loginPage.clickLogin();
    }

    @Then("I should be directed to the admin homepage")
    public void iShouldBeDirectedToTheAdminHomepage() {
        Assertions.assertTrue(Pages.adminHomePage.isOnHomePage());
    }
}
