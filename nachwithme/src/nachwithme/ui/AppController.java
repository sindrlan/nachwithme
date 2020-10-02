package nachwithme.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import nachwithme.core.Nach;
import nachwithme.core.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class AppController {
    @FXML
    private Button inputSubmit;
    @FXML
    private Button publish;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputAge;
    @FXML
    private TextField inputMail;
    @FXML
    private TextField inputAddress;
    @FXML
    private Label userOutput1;
    @FXML
    private Label userOutput2;
    @FXML
    public ListView<String> nachListOut;
    @FXML
    Pane nachPane;
    @FXML
    Pane registerPane;

    private final User user;

    public AppController controller;

    /*
    Constructor for the controller class of the app.
    The purpose of this constructor is to test the user
    interface.
     */
    public AppController() {
        this.user = new User();
    }

    public User getUser() {
        return this.user;
    }

    @FXML
    public void initialize() {
        controller = new AppController();
        try {
            File obj = new File("dataSaved.txt");
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                nachListOut.getItems().add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @FXML
    public void registerUser() {
        String name = inputName.getText();
        String mail = inputMail.getText();
        String address = inputAddress.getText();

        if (name.isEmpty() || address.isEmpty() || mail.isEmpty() || inputAge.getText().isEmpty()) {
            userOutput1.setText("Fill out all the fields");
            return;
        }

        try {
            System.out.println(inputAge.getText());
            int age = Integer.parseInt(inputAge.getText());
            user.setName(name);
            user.setAddress(address);
            user.setEmail(mail);
            user.setAge(age);
            userOutput1.setText("User created");
            inputName.setDisable(true);
            inputAddress.setDisable(true);
            inputAge.setDisable(true);
            inputMail.setDisable(true);
            inputSubmit.setDisable(true);
            // nachPane.setOpacity(1);
            // registerPane.setOpacity(0);
            // registerPane.setDisable(true);
        } catch (Exception e) {
            System.out.println(e.getClass());
            userOutput1.setText("The 'age' field must be a number");
        }
}

    @FXML
    public void addNach() {
        try {
            Boolean test = user.getAddress().equals("");
        } catch (NullPointerException e) {
            userOutput2.setText("You have to create a user");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        String clock = DateTimeFormatter.ofPattern("HH:mm").format(now);
        Nach nach = new Nach(user, user.getAddress(), clock);
        user.addNachToUser(nach);
        userOutput2.setText("");
        nachListOut.getItems().add(clock
                +
                " ~  "
                +
                user.getName()
                +
                " is hosting a nach at " + nach.getAddress());
        /*
         * for (Nach n : nachList) { System.out.println(n.toString()); }
         */

        try {
            FileWriter myWriter = new FileWriter("dataSaved.txt");
            String time = (DateTimeFormatter.ofPattern("HH:mm")
                    .format(LocalTime.now()));
            String fileContent = time + " ~  " + inputName.getText() +
                    " is hosting a nach at " + inputAddress.getText();
            myWriter.write(fileContent);
            myWriter.close();
            System.out.println("Writing is completed.");
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
