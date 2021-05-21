package com.sparta.eng82.components.pages.navpages.admin;

import com.sparta.eng82.components.pages.navpages.admin.addpages.AddTrainerPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import com.sparta.eng82.interfaces.pages.navpages.admin.addpages.AddTrainerPage;
import com.sparta.eng82.tests.unit.frameworkutil.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.IntStream;

public class AdminHomePageImpl implements AdminHomePage {

    private final By mainContent = new By.ById("main-content");
    private final By redButton = new By.ByClassName("btn bg-color-red");
    private final By trainersTable = new By.ById("trainersTable");
    private final By trainersTableBody = new By.ByTagName("tbody");
    private final By profileButton = new By.ByCssSelector(".bi-person-circle");
    WebDriver driver;

    public AdminHomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AddTrainerPage addTrainer() {
//        driver.findElement(mainContent).findElement(redButton).submit();
        PropertiesUtil.timedMouseClicker(driver, 400, new By.ByXPath("//*[@id=\"main-content\"]/div/div/div/div[1]/button"));
        return new AddTrainerPageImpl(driver);
    }

    @Override
    public boolean isTrainerAdded(String firstName, String lastName, String group) {
        List<WebElement> output = driver.findElement(trainersTable).findElements(new By.ByTagName("td"));

        return IntStream.range(0, output.size()).anyMatch(i -> output.get(i).getText().equals(firstName)
                && output.get(i + 1).getText().equals(lastName)
                && output.get(i + 2).getText().equals(group));
    }

    @Override
    public boolean getAllTrainersAvailable(int howManyTrainers) {

        List<WebElement> output = driver.findElement(trainersTable).findElements(new By.ByTagName("td"));
        return output.size() / 3 == howManyTrainers;

    }
}
