package com.sparta.eng82.interfaces.pages.accesspages;

import com.sparta.eng82.components.pages.navpages.admin.AdminHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainee.TraineeHomePageImpl;
import com.sparta.eng82.components.pages.navpages.trainer.TrainerHomePageImpl;
import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.NavPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public interface LoginPage extends Page {


    LoginPage enterEmail();

    LoginPage enterEmail(String email);

    LoginPage enterPassword();

    LoginPage enterPassword(String password);

    NavPage login();

    boolean loginAttempt();

    boolean wrongPasswordAttempt();
}
