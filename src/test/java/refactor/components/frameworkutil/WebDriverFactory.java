package refactor.components.frameworkutil;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

import java.io.File;
import java.io.IOException;

public class WebDriverFactory {

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
    }
    private EdgeDriverService edgeService;
    private ChromeDriverService chromeService;

    public WebDriver getWebDriver(WebDriverTypes driverType) {
        WebDriver driver;
        switch (driverType) {
            case CHROME:
                driver = new ChromeDriver(getChromeService());
                break;
            case EDGE:
                driver = new EdgeDriver(getEdgeService());
                break;
            case CHROME_HEADLESS:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(getChromeService(),options);
                break;
            default:
                driver = null;
                break;

        }
        driver.manage().window().setSize(new Dimension(500, 1200));
        return driver;
    }

    public ChromeDriverService getChromeService(){
        if (chromeService == null) {
            chromeService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            try {
                chromeService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return chromeService;
    }

    public EdgeDriverService getEdgeService(){
        if (edgeService == null) {
            edgeService = new EdgeDriverService.Builder()
                    .usingDriverExecutable(new File("src/test/resources/msedgedriver.exe"))
                    .usingAnyFreePort()
                    .build();
            try {
                edgeService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return edgeService;
    }

    public void endAllServices(){
        if (edgeService != null){
            edgeService.stop();
        }
        if (chromeService != null){
            chromeService.stop();
        }
    }


}


