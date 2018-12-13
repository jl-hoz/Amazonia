package model;

import java.util.ArrayList;

import exception.EmptyStringException;
import exception.TooManyCharException;

/**
 * 
 * @author José Luis de la Hoz
 *
 */
public abstract class Product{
	
	protected String title;
	protected double averageAssessment;
	protected ArrayList<Review> reviewList;
	protected int stock;
	protected Language language;
	protected Department department;
	protected double prize;
	//TODO: product release?
	
	public static final int TITLE_LENGTH = 30;
	
	public enum Department {
		MUSIC, BOOKS, FILMS 
	}
	
	/**
	 * Return title product.
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Set product title only if is not empty or exceed maximum title length.
	 * @param title
	 * @throws EmptyStringException
	 * @throws TooManyCharException
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Get average assessment.
	 * @return
	 */
	public double getAverageAssessment() {
		setAverageAssessment();
		return averageAssessment;
	}

	/**
	 * Calculate average of all the reviews and store it in averageAssessment. 
	 */
	private void setAverageAssessment() {
		for(Review review: reviewList) {
			averageAssessment += review.getAssessment();
		}
		averageAssessment /= reviewList.size();
	}
	
	//TODO: ADD IN USER THE ABILITY OF BUY PRODUCTS AND REVIEW IT.
	
	public void addProductsToStock(int amount) {
		//TODO: needed exception for problems
		this.stock += amount;
	}
	
	public void takeProductsFromStock(int amount) {
		//TODO: 0 stock problem & out of stock.
		//TODO: needed exception for problems
		this.stock -= amount;
	}
	
	public int getStock() {
		return stock;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return title;
	}
	
}