package testSuite;

import activities.whenDo.AddTaskScreen;
import activities.whenDo.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class WhenDoTest {
    MainScreen mainScreen = new MainScreen();
    AddTaskScreen addTaskScreen = new AddTaskScreen();

    @Test
    public void createNewTaskTest(){
        String title="UCB"+new Date().getTime();
        mainScreen.addButton.click();
        addTaskScreen.titleTxtBox.setText(title);
        addTaskScreen.noteTxtBox.setText("this is a note");
        addTaskScreen.saveButton.click();
        Assertions.assertTrue(mainScreen.getTaskName(title).isControlDisplayed(),
                "ERROR la tarea no fue creada");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }


}
