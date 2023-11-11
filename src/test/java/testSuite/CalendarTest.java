package testSuite;

import CalendarApp.MainScreen;
import CalendarApp.AddEvent;
import control.Scroll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class CalendarTest {

    MainScreen mainScreen = new MainScreen();
    AddEvent addEvent = new AddEvent();
    Scroll scroll=new Scroll();

    @Test
    public void createNewTaskTest(){
        String title="UCB event"+new Date().getTime();
        mainScreen.addButton.click();
        addEvent.titleTxtBox.setText(title);
        addEvent.StartTime.click();
        addEvent.Time_NumberPicker.setText("1945");
        scroll.scrollDown();
        addEvent.noteTxtBox.setText("this is an event");
        addEvent.saveButton.click();
        Assertions.assertTrue(mainScreen.getTaskName(title).isControlDisplayed(),
                "ERROR el evento no fue creado");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }

}
