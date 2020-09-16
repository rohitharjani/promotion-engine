package exception;

public class InvalidProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidProductException(String message) {
		super(message);
	}

	public InvalidProductException(String message, Throwable cause) {
		super(message, cause);
	}

}
