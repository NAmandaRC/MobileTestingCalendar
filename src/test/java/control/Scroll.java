package control;

import session.Session;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll {
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) Session.getSession().getDevice();
        js.executeScript("window.scrollBy(0, arguments[0]);", 300);
    }
}

