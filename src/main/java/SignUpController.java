import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.User;

public class SignUpController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox administratorCheckBox;

    @FXML
    private Label invalidEmailLabel;
    
    @FXML
    private Label incompleteFormLabel;
    
    @FXML
    private TextField emailField;

    @FXML
    void pressedBackButton(ActionEvent event) {
    	changeWindow("HomeView.fxml");
    }

    @FXML
    void pressedSignUpButton(ActionEvent event) {
    	incompleteFormLabel.setVisible(false);
    	if(!isAllFormsComplete()) {
    		incompleteFormLabel.setVisible(true);
    	}else {
    		Main.user = new User(emailField.getText(), usernameField.getText(), passwordField.getText(), administratorCheckBox.isSelected());
        	Main.userList.add(Main.user);
        	Main.setToDataBase();
    		changeWindow("HomeView.fxml");
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
    	boolean formsComplete = true;
    	if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty() || emailField.getText().isEmpty()) {
    		formsComplete = false;
    	}
    	return formsComplete;
    }
    
}
