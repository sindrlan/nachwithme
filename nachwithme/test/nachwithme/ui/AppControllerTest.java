package nachwithme.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.scene.Parent;
import javafx.scene.Scene;


class AppControllerTest extends ApplicationTest{
    private Parent parent;
    private AppController controller;
    private TextField inputName;
    private TextField inputAdress;
    private TextField inputAge;
    private TextField inputMail;

    @Before
    private void setUp() {
        controller = new AppController();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("App.fxml"));
        parent = fxmlLoader.load();
        controller = fxmlLoader.getController();
        stage.setScene(new Scene(parent));
        stage.show();
    }

    @Test
    void registerUser() {
        fillForm();
        Assertions.assertEquals(inputName.getText(), "testName");
        Assertions.assertEquals(inputAdress.getText(), "testAddress");
        Assertions.assertEquals(inputMail.getText(), "testMail");
        Assertions.assertEquals(inputAge.getText(), "21");
        Label userOutput2 = (Label) parent.lookup("#userOutput2");
        Assertions.assertNotEquals(userOutput2.getText(), "Fill out all the fields");
        Assertions.assertNotEquals(userOutput2.getText(), "The 'age' field must be a number");
        Node nachTab = parent.lookup("#nachTab");
        clickOn(nachTab);
        Assertions.assertEquals("testName", controller.getUser().getName());
        Assertions.assertEquals("testAddress", controller.getUser().getAddress());
        Assertions.assertEquals("testMail", controller.getUser().getEmail());
        Assertions.assertEquals(21, controller.getUser().getAge());
    }

    @Test
    void addNach() {
        fillForm();
        Node nachTab = parent.lookup("#nachTab");
        clickOn(nachTab);
        Button publish = (Button) parent.lookup("#publish");
        clickOn(publish);
        clickOn(publish);
        Assertions.assertTrue(controller.getUser().getNaches().size() > 0);
    }

    private void fillForm() {
        inputName = (TextField) parent.lookup("#inputName");
        inputName.setText("testName");
        inputAdress = (TextField) parent.lookup("#inputAddress");
        inputAdress.setText("testAddress");
        inputMail = (TextField) parent.lookup("#inputMail");
        inputMail.setText("testMail");
        inputAge = (TextField) parent.lookup("#inputAge");
        inputAge.setText("21");
        Button inputSubmit = (Button) parent.lookup("#inputSubmit");
        clickOn(inputSubmit);
    }
}
