package controller;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;


public class LoginController {

	private User user;
	
    @FXML
    private PasswordField passwordSignUpField;

    @FXML
    private TextField usernameSignUpField;

    @FXML
    private CheckBox adminCheckBox;

    @FXML
    private TextField emailSignUpField;

    @FXML
    private PasswordField passwordSignInField;

    @FXML
    private TextField usernameSignInField;

    @FXML
    void clickSignInButton(ActionEvent event) {
    	//TODO NEED DATABASE TO SELECT USERS FOR COMPARE AND INSTANTIATE
    }

    @FXML
    void clickSignUpButton(ActionEvent event) throws IOException {
    	user = new User(emailSignUpField.getText(), usernameSignUpField.getText(), passwordSignUpField.getText(), adminCheckBox.isManaged());
    }

}

