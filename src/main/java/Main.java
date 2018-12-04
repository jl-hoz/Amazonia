import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static Stage window;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Main.window = stage;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HomeView.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Amazonia");
		stage.setScene(scene);
		stage.show();
	}

}
