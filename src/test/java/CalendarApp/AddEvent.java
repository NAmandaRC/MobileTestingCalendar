package CalendarApp;
import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddEvent {
    public TextBox titleTxtBox = new TextBox(By.id("com.samsung.android.calendar:id/title"));
    public TextBox StartTime=new TextBox(By.id("com.samsung.android.calendar:id/start_time"));

    public TextBox Time_NumberPicker=new TextBox(By.id("com.samsung.android.calendar:id/numberpicker_input"));

    public TextBox EndTime=new TextBox(By.id("com.samsung.android.calendar:id/end_time"));

    public TextBox noteTxtBox = new TextBox(By.id("com.samsung.android.calendar:id/note_text"));

    public Button saveButton = new Button(By.id("com.samsung.android.calendar:id/navigation_bar_item_small_label_view"));
}
