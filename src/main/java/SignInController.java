import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

public class SignInController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Label loginErrorLabel;

    @FXML
    private Label incompleteFormLabel;

    @FXML
    void pressedBackButton(ActionEvent event) {
    	changeWindow("HomeView.fxml");
    }

    @FXML
    void pressedSignInButton(ActionEvent event) {
    	if(!isAllFormsComplete()) {
    		incompleteFormLabel.setVisible(true);
    	}else {
    		User tryUser = new User();
    		tryUser.setUsername(usernameField.getText());
    		tryUser.setPassword(passwordField.getText());
    		if(Main.oauth(tryUser)) {
    			changeWindow("HomeView.fxml");
    		}
    	}
    }

    public void changeWindow(String xmlFile) {
    	Main.window.close();
    	Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource(xmlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		Main.window.setScene(scene);
		Main.window.show();
    }
    
    private boolean isAllFormsComplete() {
    	boolean formComplete = true;
    	if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
    		formComplete = false;
    	}
    	return formComplete;
    }
}
