public class PeryferiumException extends ProduktException {

	public PeryferiumException() {
		super();
	}

	public PeryferiumException(String komunikat) {
		super(komunikat);
	}

	public PeryferiumException(String komunikat, Throwable przyczyna) {
		super(komunikat, przyczyna);
	}
}
