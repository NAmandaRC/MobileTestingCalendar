package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest {

    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","samsung SM-A315G");
        config.setCapability("platformVersion","12.0");
        config.setCapability("appPackage","com.sec.android.app.popupcalculator");
        config.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
        // tipos de esperador: implicit (tiempo limite de espera, se hace al inicio de las pruebas) / explicit (tiempo especifico para un control, tiene condiciones) / fluent (con condiciones de salida)
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//va esperar 20 segundos a los controles
    }
    @Test
    public void verifyAddTwoNumber() throws InterruptedException {

        // click 7

        mobile.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")).click();
        //mobile.findElement(By.id("com.android.calculator2:id/digit_7")).click();

        // click +
        mobile.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
        //mobile.findElement(By.id("com.android.calculator2:id/op_add")).click();

        // click 6
        mobile.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")).click();
        //mobile.findElement(By.id("com.android.calculator2:id/digit_6")).click();

        // click =
        mobile.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();
        //mobile.findElement(By.id("com.android.calculator2:id/eq")).click();

        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(mobile, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")));

        // verificacion  expected vs actual
        String actualResult = mobile.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula")).getText();
        String expectedResult = "13";
        //String actualResult =  mobile.findElement(By.id("com.android.calculator2:id/result")).getText();
        //para hacer comparaciones
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! la suma es incorrecta"+actualResult);
       // Assertions.assertEquals(13, actualResult, "ERROR! La suma es incorrecta. Resultado del cálculo ==> expected: <13> but was: <" + actualResult + ">");

    }
    @AfterEach
    public void closeApp(){
        mobile.quit();
    }

}
