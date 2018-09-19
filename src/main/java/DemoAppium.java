import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by huy.huynh on 19/09/2018.
 */

public class DemoAppium {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("VERSION", "7.0");
        capabilities
                .setCapability("app", System.getProperty("user.dir") + "\\src\\main\\resources\\apk\\DemoAppium.apk");

        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void testDemo() throws Exception {
        WebElement plusButton = driver.findElement(By.id("buttonPlus"));
        plusButton.click();
        WebElement resultTextView = driver.findElement(By.id("textViewResult"));
        Assert.assertEquals(resultTextView.getText(), "1", "Expected result plus one");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
