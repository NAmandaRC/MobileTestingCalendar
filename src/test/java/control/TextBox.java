package control;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends Control{
    public TextBox(By locator) {
        super(locator);
    }

    public void setText(String value){
        findControl();
        control.sendKeys(value);
    }
    public void clearSetText(String value){
        findControl();
        control.clear();
        control.sendKeys(value);
    }
    public void setTextEnter(String value){
        findControl();
        control.sendKeys(value+ Keys.ENTER);
    }
}
