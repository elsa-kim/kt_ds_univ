package exception_handling.exceptions;

/**
 * 시스템 계정으로 회원가입 하려는 시도를 막아주는 예외.
 */
public class InvalidUserIdException extends RuntimeException {

	private static final long serialVersionUID = -8706174276063571099L;

	public InvalidUserIdException(String message) {
		super(message);
	}

	public InvalidUserIdException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
