public class ProduktException extends TowarException {
	public ProduktException() {
		super();
	}

	public ProduktException(String komunikat) {
		super(komunikat);
	}

	public ProduktException(String komunikat, Throwable przyczyna) {
		super(komunikat, przyczyna);
	}
}
