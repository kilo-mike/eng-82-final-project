package com.sparta.eng82.tests.stepdefs;

import com.sparta.eng82.components.pages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.admin.AdminProfilePageImpl;
import com.sparta.eng82.components.pages.other.LoginPageImpl;
import com.sparta.eng82.components.pages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.tests.stepdefs.stepdefutil.DriverManager;
import com.sparta.eng82.tests.stepdefs.stepdefutil.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SharedStepDefs {
//    @Given("I am logged in as an {string}")
//    public void iAmLoggedInAsAn(String user) {
//        switch (user) {
//            case "admin":
//                Pages.adminHomePage = (AdminHomePageImpl) new LoginPageImpl(DriverManager.driver, user).login();
//                break;
//            case "trainer":
//                Pages.trainerHomePage = (TrainerHomePageImpl) new LoginPageImpl(DriverManager.driver, user).login();
//            case "trainee_DO_NOT_SUBMIT":
//            case "trainee":
//                Pages.traineeHomePage = (TraineeHomePageImpl) new LoginPageImpl(DriverManager.driver, user).login();
//        }
//    }
//
//    @And("I am on the {string} profile page")
//    public void iAmOnTheProfilePage(String arg0) {
//        Pages.adminProfilePage = (AdminProfilePageImpl) Pages.adminHomePage.goToProfilePage();
//    }
//
//    @When("I click on {string} home page button")
//    public void iClickOnHomePageButton(String arg0) {
//
//    }
//
//    @Then("I go to the {string}home page")
//    public void iGoToTheHomePage(String arg0) {
//    }
}
