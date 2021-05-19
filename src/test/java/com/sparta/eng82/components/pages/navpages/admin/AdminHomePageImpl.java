package com.sparta.eng82.components.pages.navpages.admin;

import com.sparta.eng82.components.pages.navpages.admin.addpages.AddTrainerPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.admin.AdminHomePage;
import com.sparta.eng82.interfaces.pages.navpages.admin.addpages.AddTrainerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminHomePageImpl implements AdminHomePage {

    WebDriver driver;

    private final By mainContent = new By.ById("main-content");
    private final By redButton = new By.ByClassName("btn bg-color-red");
    private final By trainersTable = new By.ById("trainersTable");
    private final By trainersTableBody = new By.ByTagName("tbody");

    public AdminHomePageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public AddTrainerPage addTrainer() {
        driver.findElement(mainContent).findElement(redButton).click();
        return new AddTrainerPageImpl(driver);
    }

    @Override
    public boolean isTrainerAdded(String firstName, String lastName, String group) {
        return driver.findElement(mainContent).findElement(new By.ByLinkText(firstName)).isDisplayed()
                && driver.findElement(mainContent).findElement(new By.ByLinkText(lastName)).isDisplayed()
                && driver.findElement(mainContent).findElement(new By.ByLinkText(group)).isDisplayed();
    }

    @Override
    public String[][] getAllTrainersAvailable() {
        ArrayList<ArrayList<String>> output = new ArrayList<>();
        for (WebElement webElement : driver.findElement(trainersTable).findElements(trainersTableBody)) {
            ArrayList<String> temp = new ArrayList<>();
            List<WebElement> entries = webElement.findElements(By.tagName("td"));
            for (WebElement entry : entries) {
                temp.add(entry.getText());
            }
            output.add(temp);
            temp.clear();
        }
        return output.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
    }
}
