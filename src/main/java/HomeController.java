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
import javafx.scene.control.Button;
import javafx.scene.control.FocusModel;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.Book;
import model.Book.Format;
import model.Book.LiteraryGenre;
import model.Product;
import model.Product.Department;
import model.Time;

public class HomeController implements Initializable{

	private ObservableList<Book> list = FXCollections.observableArrayList();
	
	private Book focusedProduct;

    @FXML
    private ListView<Book> productListView;

    @FXML
    private Label titleLabel;

    @FXML
    private Label prizeLabel;

    @FXML
    private Label departmentLabel;

    @FXML
    private Label authorLabel;

    @FXML
    private Label literaryGenreLabel;

    @FXML
    private Label isbnLabel;

    @FXML
    private Label formatLabel;
    
    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button profileButton;

    @FXML
    private Button buyButton;
    
    @FXML
    void pressedBuyButton(ActionEvent event) {
    	Time simulateServerRequest = new Time();
    	buyButton.setVisible(false);
    	buyButton.setDisable(false);
    	simulateServerRequest.start();
    	while(simulateServerRequest.isAlive());
    	buyButton.setVisible(true);
    	buyButton.setDisable(true);
    	Main.user.buyProduct(focusedProduct);
    }

    @FXML
    void pressedProfileButton(ActionEvent event) {
    	if(Main.user != null) {
    		changeWindow("ProfileView.fxml");
    	}
    }

    @FXML
    void pressedSignInButton(ActionEvent event) {
    	changeWindow("SignInView.fxml");
    }

    @FXML
    void pressedSignUpButton(ActionEvent event) {
    	changeWindow("SignUpView.fxml");
    }
	
	public void updateProducts() {
		loadProducts();
		productListView.setItems(list);
		productListView.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Book>() {
					
			@Override
			public void changed(ObservableValue<? extends Book> observable, Book oldValue, Book newValue) {
				focusedProduct = newValue;
				titleLabel.setText(newValue.getTitle());
				prizeLabel.setText(Double.toString(newValue.getPrize()));
				departmentLabel.setText(newValue.getDepartment().toString());
				authorLabel.setText(newValue.getAuthor());
				literaryGenreLabel.setText(newValue.getLiteraryGenre().toString());
				isbnLabel.setText(newValue.getISBN());
				formatLabel.setText(newValue.getFormat().toString());
			}
			
		});
	}
	
	private void loadProducts() {
		Book one = new Book();
		one.setTitle("La fuerza de uno");
		one.setAuthor("Bryce Courternay");
		one.setPrize(50.9);
		one.setLiteraryGenre(LiteraryGenre.DRAMA);
		one.setStock(212);
		one.setDepartment(Department.BOOKS);
		one.setFormat(Format.PAPERBACK);
		one.setISBN("123456789102");
		list.add(one);
		Book two = new Book();
		two.setTitle("El nombre del viento");
		two.setAuthor("Patrick Rothfuss");
		two.setPrize(24.99);
		two.setLiteraryGenre(LiteraryGenre.TRAGEDY);
		two.setStock(500);
		two.setDepartment(Department.BOOKS);
		two.setFormat(Format.EBOOK);
		two.setISBN("123123456987");
		list.add(two);
		Book cdr = new Book();
		cdr.setTitle("Choque de reyes");
		cdr.setAuthor("George R. R. Martin");
		cdr.setPrize(29.99);
		cdr.setLiteraryGenre(LiteraryGenre.DRAMA);
		cdr.setStock(3333333);
		cdr.setDepartment(Department.BOOKS);
		cdr.setFormat(Format.EBOOK);
		cdr.setISBN("24243223456987");
		list.add(cdr);
		Book gsg = new Book();
		gsg.setTitle("El guerrero a la sombra del cerezo");
		gsg.setAuthor("David B. Gil");
		gsg.setPrize(24.99);
		gsg.setLiteraryGenre(LiteraryGenre.HISTORY);
		gsg.setStock(5333);
		gsg.setDepartment(Department.BOOKS);
		gsg.setFormat(Format.HARDCOVER);
		gsg.setISBN("993123456987");
		list.add(gsg);
		Book ready = new Book();
		ready.setTitle("Ready Player One");
		ready.setAuthor("Ernest Cline");
		ready.setPrize(24.99);
		ready.setLiteraryGenre(LiteraryGenre.SCIENCE_FICTION);
		ready.setStock(5033333);
		ready.setDepartment(Department.BOOKS);
		ready.setFormat(Format.EBOOK);
		ready.setISBN("23414324987");
		list.add(ready);
		Book go1984 = new Book();
		go1984.setTitle("1984");
		go1984.setAuthor("George Orwell");
		go1984.setPrize(9.99);
		go1984.setLiteraryGenre(LiteraryGenre.SCIENCE_FICTION);
		go1984.setStock(5222);
		go1984.setDepartment(Department.BOOKS);
		go1984.setFormat(Format.EBOOK);
		go1984.setISBN("123121356987");
		list.add(go1984);
		Book brisingir = new Book();
		brisingir.setTitle("Brisingir");
		brisingir.setAuthor("Christopher Paolini");
		brisingir.setPrize(18.99);
		brisingir.setLiteraryGenre(LiteraryGenre.SCIENCE_FICTION);
		brisingir.setStock(355);
		brisingir.setDepartment(Department.BOOKS);
		brisingir.setFormat(Format.AUDIOBOOK);
		brisingir.setISBN("233123456987");
		list.add(brisingir);
		Book tandia = new Book();
		tandia.setTitle("Tandia");
		tandia.setAuthor("Bryce Courternay");
		tandia.setPrize(24.99);
		tandia.setLiteraryGenre(LiteraryGenre.DRAMA);
		tandia.setStock(540);
		tandia.setDepartment(Department.BOOKS);
		tandia.setFormat(Format.PAPERBACK);
		tandia.setISBN("123123452387");
		list.add(tandia);
		Book eragon = new Book();
		eragon.setTitle("Eragon");
		eragon.setAuthor("Christopher Paolini");
		eragon.setPrize(19.99);
		eragon.setLiteraryGenre(LiteraryGenre.SCIENCE_FICTION);
		eragon.setStock(500);
		eragon.setDepartment(Department.BOOKS);
		eragon.setFormat(Format.HARDCOVER);
		eragon.setISBN("123123456930");
		list.add(eragon);
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
		updateProducts();
	}
	
}

