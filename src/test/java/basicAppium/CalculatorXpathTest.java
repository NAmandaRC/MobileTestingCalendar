package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorXpathTest {

    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","UCBDiplomadov4");
        config.setCapability("platformVersion","9.0");
        config.setCapability("appPackage","com.android.calculator2");
        config.setCapability("appActivity","com.android.calculator2.Calculator");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
        // implicit / explicit / fluent
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void verifyAddTwoNumber() throws InterruptedException {

      // click 7
      mobile.findElement(By.xpath("//android.widget.Button[@text='7']")).click();
      // click +
      mobile.findElement(By.xpath("//android.widget.Button[@text='+']")).click();
      // click 6
      mobile.findElement(By.xpath("//android.widget.Button[@text='6']")).click();
      // click =
      mobile.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();

      Thread.sleep(5000);
      // verificacion  expected vs actual
      String expectedResult = "13";
      String actualResult =  mobile.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']")).getText();
      Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma es incorrecta");

    }

    @AfterEach
    public void closeApp(){
        mobile.quit();
    }

}
