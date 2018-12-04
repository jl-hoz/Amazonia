import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {

    @FXML
    void pressedProfileButton(ActionEvent event) {
    	
    }

    @FXML
    void pressedSignInButton(ActionEvent event) {
    	changeWindow("SignInView.fxml");
    }

    @FXML
    void pressedSignUpButton(ActionEvent event) {
    	changeWindow("SignUpView.fxml");
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
