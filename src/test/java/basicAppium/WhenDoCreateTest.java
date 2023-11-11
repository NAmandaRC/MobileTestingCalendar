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

public class WhenDoCreateTest {


    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","samsung SM-A315G");
        config.setCapability("platformVersion","12.0");
        config.setCapability("appPackage","com.vrproductiveapps.whendo");
        config.setCapability("appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
        // implicit / explicit / fluent
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void verifyCreateTaskTest() throws InterruptedException {
        String nameTask = "UCBTask";
        // click +
        mobile.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();

        // set title
        mobile.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(nameTask);
        // set note
        mobile.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("this is a note");
        // click save
        mobile.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
        // verification
        Thread.sleep(5000);
        Assertions.assertTrue(mobile.findElements(By.xpath("//android.widget.TextView[@text='"+nameTask+"']")).size() == 1,
               "ERROR> la tarea no fue creada" );
    }

    @AfterEach
    public void closeApp(){
        mobile.quit();
    }

}
