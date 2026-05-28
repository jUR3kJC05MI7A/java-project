public class TowarException extends Exception {
	public TowarException() {
		super();
	}

	public TowarException(String komunikat) {
		super(komunikat);
	}

	public TowarException(String komunikat, Throwable przyczyna) {
		super(komunikat, przyczyna);
	}
}
