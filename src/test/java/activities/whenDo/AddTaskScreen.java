package activities.whenDo;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddTaskScreen {

    public TextBox titleTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
}
