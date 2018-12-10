package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.Product;
import model.User;

public class Input{

	public static ArrayList<User> retrieveUsersFromDataBase(){
		ArrayList<User> userList = new ArrayList<User>();
		try {
			FileInputStream fileInput = new FileInputStream(new File("./.data/.users"));
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			userList = (ArrayList<User>)objectInput.readObject();
		}catch(Exception e) {
			
		}
		return userList;
	}
	
	public static ArrayList<Product> retrieveProductsFromDataBase(){
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			FileInputStream fileInput = new FileInputStream(new File("./.data/.products"));
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			productList = (ArrayList<Product>)objectInput.readObject();
		}catch(Exception e) {
			
		}
		return productList;
	}
}