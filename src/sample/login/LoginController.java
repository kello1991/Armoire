package sample.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button loginBtn;

    @FXML
    private Button resetBtn;

    @FXML
    private TextField userTxt;

    @FXML
    private PasswordField passwdTxt;

    @FXML
    private Label error;


    private final String userName = "user";
    private final String pass = "user";


    @FXML
    void login(ActionEvent event) throws Exception{
        if (userTxt.getText().equals(userName)&&passwdTxt.getText().equals(pass)){

            Stage stage1= (Stage) anchorPane.getScene().getWindow();
            stage1.close();
            System.out.println("ok");
            Stage stage = new Stage();
            stage.setTitle("Liste Des Examens");
            AnchorPane myPane = null;
            myPane = FXMLLoader.load(getClass().getResource("../Exams/Exams.fxml"));
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();
            stage1.close();
        }
        else {
            error.setText("Erreur");
            System.out.println("nn");
        }
    }

    @FXML
    void reset(ActionEvent event) {
        userTxt.setText("");
        passwdTxt.setText("");
    }

}
