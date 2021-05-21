//package com.sparta.eng82.components.pages.navpages.trainer;
//
//import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddGroupPageImpl;
//import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddStreamPageImpl;
//import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddTraineePageImpl;
//import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
//import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddGroupPage;
//import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddStreamPage;
//import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddTraineePage;
//import com.sparta.eng82.tests.unit.frameworkutil.PropertiesUtil;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class ManageGroupPageImpl implements ManageGroupPage {
//
//    private final By removeButton = new By.ByLinkText("Remove");
//    private final By deleteTrainerButton = new By.ByLinkText("Delete Trainer");
//    private final By addTraineeButton = new By.ByLinkText("Add Trainee");
//    private final By addGroupButton = new By.ByLinkText("Add Group");
//    private final By addStreamButton = new By.ByLinkText("Add Stream");
//    private final By listClassName = new By.ByClassName("list-group");
//    WebDriver driver;
//    private By removeButtonIdentifier;
//
//    private PropertiesUtil propertiesUtil = new PropertiesUtil();
//
//    public ManageGroupPageImpl(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    @Override
//    public ManageGroupPage removeTrainee(String traineeName) {
//        int numberOfRemoveButtons = driver.findElements(removeButton).size();
//        removeButtonIdentifier = new By.ByXPath("//a[@class='list-group-item list-group-item-action' and text()='" + traineeName + "']");
//
//        if (numberOfRemoveButtons == 1) {
//            driver.findElement(removeButton).click();
//        } else {
//            driver.findElement(listClassName).findElement(removeButtonIdentifier).findElement(removeButton).click();
//            driver.findElement(deleteTrainerButton).click();
//        }
//        return this;
//
//    }
//
//    @Override
//    public AddTraineePage addTrainee() {
//        driver.findElement(addTraineeButton).click();
//        return new AddTraineePageImpl(driver);
//
//    }
//
//    @Override
//    public AddGroupPage addGroup() {
//        driver.findElement(addGroupButton).click();
//        return new AddGroupPageImpl(driver);
//
//    }
//
//    @Override
//    public AddStreamPage addStream() {
//        driver.findElement(addStreamButton).click();
//        return new AddStreamPageImpl(driver);
//    }
//
//    @Override
//    public boolean isTraineeRemoved(String traineeName) {
//        return false;
//    }
//
//    @Override
//    public void clickRemoveButton(int studentIndex) {
//        propertiesUtil.timedMouseClicker(driver, 400, By.cssSelector(".btn:nth-child(" + studentIndex + ")"));
//    }
//
//    @Override
//    public void removeStudent(String studentName) {
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        List<WebElement> students = driver.findElements(By.className("list-group-item-action"));
//        int studentPosition = 0;
//        for (WebElement student:students) {
//            String name = student.getText();
//            System.out.println(name);
//            System.out.println(students.indexOf(student));
//            if (name.equals("Golam Choudhury")) {
//                studentPosition = students.indexOf(student) + 1;
//            }
//        }
//        String removeButtonCss = ".btn:nth-child(" + (studentPosition*2) + ")";
//        propertiesUtil.timedMouseClicker(driver, 400, By.cssSelector(".btn:nth-child(" + (studentPosition * 2) + ")"));
//        propertiesUtil.timedMouseClicker(driver,400, By.linkText("Delete Trainer"));
//    }
//
//    @Override
//    public boolean isStudentPresent(String studentName) {
//        List<WebElement> students = driver.findElements(By.className("list-group-item-action"));
//        boolean isPresent = false;
//        for (WebElement student: students) {
//            if (studentName.equals(student.getText()));
//            isPresent = true;
//            break;
//        }
//        return isPresent;
//    }
//
//    @Override
//    public void addStudent(String firstName, String lastName) {
//        propertiesUtil.timedMouseClicker(driver, 400, By.cssSelector("form > .my-3:nth-child(2)"));
//        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//        Select select = new Select(driver.findElement(By.id("traineeGroup")));
//        select.selectByVisibleText("Engineering 82");
//        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//
//        driver.findElement(By.id("traineeFirstName")).sendKeys(firstName);
//
//        driver.findElement(By.id("traineeLastName")).sendKeys(lastName);
//
//        driver.findElement(By.cssSelector("#addNewTrainee .btn")).click();
//        propertiesUtil.timedMouseClicker(driver,400,By.cssSelector("#addNewTrainee .btn"));
//    }
//}
