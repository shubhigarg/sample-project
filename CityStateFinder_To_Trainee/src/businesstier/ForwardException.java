package businesstier;

public class ForwardException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message = null;

	public ForwardException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

}
