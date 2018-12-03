package model;

import exception.EmptyStringException;
import exception.TooManyCharException;

public class Review {
	
	private User user;
	private String message;
	private double assessment;
	public static final int MESSAGE_LENGTH = 120;
	
	public Review(User user) {
		this.user = user;
	}
	
	/**
	 * Set message of a comment if is not empty or exceeds maximum.
	 * @param message
	 * @throws EmptyStringException, TooManyCharException 
	 */
	public void setMessage(String message) throws EmptyStringException, TooManyCharException {
		if(message.isEmpty()) {
			throw new EmptyStringException("Empty String");
		}
		else if(message.length() > MESSAGE_LENGTH) {
			throw new TooManyCharException("Exceed message length: " + MESSAGE_LENGTH + " characters.");
		}else {
			this.message = message;
		}
	}
	
	/**
	 * Get message of a review.
	 * @return
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Get username of comment writer.
	 * @return
	 */
	public String getUsername() {
		return user.getUsername();
	}

	public double getAssessment() {
		return assessment;
	}

	public void setAssessment(double assessment) throws Exception{
		if(assessment < 0 || assessment > 5) {
			throw new Exception();
		}else {
			this.assessment = assessment;
		}
	}
}