package exception;

public class TooManyCharException extends Exception {

	public TooManyCharException(String message) {
		super(message);
	}
	
	public TooManyCharException() {
		super();
	}
}
