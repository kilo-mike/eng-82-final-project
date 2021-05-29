package com.sparta.eng82.tests.stepdefs;

import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeProfilePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerProfilePageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SharedStepDefs {

    @Given("I am logged in as an {string}")
    public void iAmLoggedInAsAn(String user) {
        switch (user) {
            case "admin":
                Pages.adminHomePage = (AdminHomePageImpl) new LoginPageImpl(DriverManager.driverDoNotSubmit, user).login();
                break;
            case "trainer":
                Pages.trainerHomePage = (TrainerHomePageImpl) new LoginPageImpl(DriverManager.driverDoNotSubmit, user).login();
                break;
            case "trainee_DO_NOT_SUBMIT":
                Pages.traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(DriverManager.driverDoNotSubmit, user).login();
                break;
            case "trainee":
                Pages.traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(DriverManager.driverSubmissionsOnly, user).login();
                break;
        }
    }

    @When("I click on {string} home page button")
    public void iClickOnHomePageButton(String user) {
        switch (user) {
            case "admin":
                Pages.adminHomePage = (AdminHomePageImpl) Pages.adminHomePage.goToHomePage();
                break;
            case "trainer":
                Pages.trainerHomePage = (TrainerHomePageImpl) Pages.trainerHomePage.goToHomePage();
                break;
            case "trainee_DO_NOT_SUBMIT":
            case "trainee":
                Pages.traineeHomePage = (TraineeHomePageImpl) Pages.traineeHomePage.goToHomePage();
                break;
        }
    }

    @Then("I am on the {string} home page")
    public void iAmOnTheHomePage(String user) {
        switch (user) {
            case "admin":
                Assertions.assertTrue(Pages.adminHomePage.isOnHomePage());
                break;
            case "trainer":
                Assertions.assertTrue(Pages.trainerHomePage.isOnHomePage());
                break;
            case "trainee_DO_NOT_SUBMIT":
            case "trainee":
                Assertions.assertTrue(Pages.traineeHomePage.isOnHomePage());
                break;
        }
    }

    @When("I click on {string} profile page button")
    public void iClickOnProfilePageButton(String user) {
        switch (user) {
            case "admin":
                Pages.adminProfilePage = (AdminProfilePageImpl) Pages.adminHomePage.goToProfilePage();
                break;
            case "trainer":
                Pages.trainerProfilePage = (TrainerProfilePageImpl) Pages.trainerHomePage.goToProfilePage();
                break;
            case "trainee_DO_NOT_SUBMIT":
            case "trainee":
                Pages.traineeProfilePage = (TraineeProfilePageImpl) Pages.traineeHomePage.goToProfilePage();
                break;
        }
    }

    @Then("I am on the {string} profile page")
    public void iAmOnTheProfilePage(String user) {
        switch (user) {
            case "admin":
                Assertions.assertTrue(Pages.adminProfilePage.getUrl().endsWith("profile"));
                break;
            case "trainer":
                Assertions.assertTrue(Pages.trainerProfilePage.getUrl().endsWith("profile"));
                break;
            case "trainee_DO_NOT_SUBMIT":
            case "trainee":
                Assertions.assertTrue(Pages.traineeProfilePage.getUrl().endsWith("profile"));
                break;
        }
    }

    @When("I click on the competencies page button as an {string}")
    public void iClickOnTheCompetenciesPageButtonAsAn(String user) {
        switch (user) {
            case "admin":
                Pages.competenciesPage = Pages.adminHomePage.goToCompetenciesPage();
                break;
            case "trainer":
                Pages.competenciesPage = Pages.trainerHomePage.goToCompetenciesPage();
                break;
            case "trainee_DO_NOT_SUBMIT":
            case "trainee":
                Pages.competenciesPage = Pages.traineeHomePage.goToCompetenciesPage();
                break;
        }
    }

    @Then("I am on the competencies page as an {string}")
    public void iAmOnTheCompetenciesPageAsAn(String user) {
        switch (user) {
            case "admin":
            case "trainer":
            case "trainee_DO_NOT_SUBMIT":
            case "trainee":
                Assertions.assertTrue(Pages.competenciesPage.getUrl().endsWith("competencies"));
                break;
        }
    }
}
