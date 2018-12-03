import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL res = getClass().getClassLoader().getResource("login.fxml");
		Parent root = FXMLLoader.load(res);
		Scene scene = new Scene(root);
		stage.setTitle("Amazonia");
		stage.setScene(scene);
		stage.show();
	}

}
