package com.sparta.eng82.components.pages.navpages;

import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompetenciesPageImpl implements CompetenciesPage {

    WebDriver driver;

    private final By competenciesContainer = new By.ById("competency-container");

    private final By analytic = new By.ById("Analytic");
    private final By independent = new By.ById("Independent");
    private final By determined = new By.ById("Determined");
    private final By professional = new By.ById("Professional");
    private final By studious = new By.ById("Studious");
    private final By imaginative = new By.ById("Imaginative");

    private final By fwBold = new By.ByClassName("fw-bold");

    public CompetenciesPageImpl(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean hasAnalyticSection() {
        return driver.findElement(competenciesContainer).findElement(analytic).findElement(fwBold).isDisplayed();
    }

    @Override
    public boolean hasIndependentSection() {
        return driver.findElement(competenciesContainer).findElement(independent).findElement(fwBold).isDisplayed();
    }

    @Override
    public boolean hasDeterminedSection() {
        return driver.findElement(competenciesContainer).findElement(determined).findElement(fwBold).isDisplayed();
    }

    @Override
    public boolean hasProfessionalSection() {
        return driver.findElement(competenciesContainer).findElement(professional).findElement(fwBold).isDisplayed();
    }

    @Override
    public boolean hasStudiousSection() {
        return driver.findElement(competenciesContainer).findElement(studious).findElement(fwBold).isDisplayed();
    }

    @Override
    public boolean hasImaginativeSection() {
        return driver.findElement(competenciesContainer).findElement(imaginative).findElement(fwBold).isDisplayed();
    }
}
