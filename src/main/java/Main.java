import java.util.ArrayList;

import io.Input;
import io.Output;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Product;
import model.User;

public class Main extends Application{
	
	public static Stage window;
	
	public static User user;
	
	public static ArrayList<User> userList;
	
	public static ArrayList<Product> productList;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		retrieveFromDataBase();
		Main.window = stage;
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("HomeView.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Amazonia");
		stage.setScene(scene);
		stage.show();
	}
	
	private static void retrieveFromDataBase() {
		userList = Input.retrieveUsersFromDataBase();
		productList = Input.retrieveProductsFromDataBase();
	}
	
	public static void setToDataBase() {
		Output.setUsersToDataBase(userList);
		Output.setProductsToDataBase(productList);
	}

	public static boolean oauth(User tryUser) {
		boolean pass = false;
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUsername().equals(tryUser.getUsername()) && userList.get(i).getPassword().equals(tryUser.getPassword())) {
				pass = true;
				tryUser = userList.get(i);
				Main.user = userList.get(i);
				break;
			}
		}
		return pass;
	}
}
