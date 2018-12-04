import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void pressedBackButton(ActionEvent event) {
    	changeWindow("HomeView.fxml");
    }

    @FXML
    void pressedSignInButton(ActionEvent event) {
    	changeWindow("HomeView.fxml");
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
}
