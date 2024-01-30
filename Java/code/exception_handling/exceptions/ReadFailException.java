package exception_handling.exceptions;

/**
 * 파일을 읽을 수 없을 때 발생하는 예외
 */
public class ReadFailException extends RuntimeException{

	private static final long serialVersionUID = 514322236349692334L;

	public ReadFailException(String message) {
		super(message);
	}
	
	public ReadFailException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
