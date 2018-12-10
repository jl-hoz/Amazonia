import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Book;

public class ProfileController implements Initializable{

	private ObservableList<Book> list = FXCollections.observableArrayList();

    @FXML
    private ListView<Book> productHistoryListView;
	
    @FXML
    private Label emailLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label lastLoginLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label amountLabel;

    @FXML
    private Label departmentLabel;

    @FXML
    private Label authorLabel;

    @FXML
    private Label lieteraryGenreLabel;

    @FXML
    private Label isbnLabel;

    @FXML
    private Label formatLabel;

    @FXML
    private Label prizeLabel;

    @FXML
    void pressedBackButton(ActionEvent event) {
    	changeWindow("HomeView.fxml");
    }

    @FXML
    void pressedLogOutButton(ActionEvent event) {
    	
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		emailLabel.setText(Main.user.getEmail());
		usernameLabel.setText(Main.user.getUsername());
		passwordLabel.setText(Main.user.getPassword());
		lastLoginLabel.setText(Main.user.getLastLogin().toString());
		for(int i = 0; i < Main.user.getProductHistory().size(); i++) {
			list.add((Book) Main.user.getProductHistory().get(i));
		}
		productHistoryListView.setItems(list);
		productHistoryListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Book>() {
					
			@Override
			public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
				titleLabel.setText(newValue.getTitle());
				prizeLabel.setText(Double.toString(newValue.getPrize()));
				amountLabel.setText(Integer.toString(newValue.getStock()));
				departmentLabel.setText("BOOKS");
				authorLabel.setText(newValue.getAuthor());
				isbnLabel.setText(newValue.getISBN());
			}
			
		});
	}
    
}
