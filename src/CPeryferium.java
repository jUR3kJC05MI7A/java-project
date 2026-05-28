import java.util.Objects;

public class CPeryferium extends CProdukt {
	final static String[] TYPY = { "Output", "Input", "Output/Input" };
	final static String[] INTERFEJSY = { "USB", "USB-C", "BLUETOOTH", "HDMI", "DISPLAYPORT", "JACK" };

	String typPeryferium;
	String interfejs;

	public CPeryferium() {
		super();
		this.typPeryferium = null;
		this.interfejs = null;
	}

	public CPeryferium(String indentyfikator, CData dataPrzyjecia, int ilosc, int cena, String kategoria,
			String producent, String model, CData dataProdukcji, String typPeryferium, String interfejs)
			throws TowarException, DataException, ProduktException, PeryferiumException {

		super(indentyfikator, dataPrzyjecia, ilosc, cena, kategoria, producent, model, dataProdukcji);

		if (typPeryferium.equals(TYPY[0]) || typPeryferium.equals(TYPY[1]) || typPeryferium.equals(TYPY[2])) {
			this.typPeryferium = typPeryferium;
		} else {
			throw new PeryferiumException();
		}

		if (interfejs.equals(INTERFEJSY[0]) || interfejs.equals(INTERFEJSY[1])
				|| interfejs.equals(INTERFEJSY[2]) || interfejs.equals(INTERFEJSY[3])
				|| interfejs.equals(INTERFEJSY[4]) || interfejs.equals(INTERFEJSY[5])) {

			this.interfejs = interfejs;

		} else {

			throw new PeryferiumException();

		}

		this.typPeryferium = typPeryferium;
		this.interfejs = interfejs;
	}

	public CPeryferium(String peryferium)
			throws TowarException, DataException, ProduktException, PeryferiumException {
		String regex = ",";
		String[] pomocnicza = peryferium.split(regex);

		if (pomocnicza.length != 10) {
			throw new PeryferiumException();
		}

		setIndentyfikator(pomocnicza[0]);
		setDataPrzyjecia(new CData(pomocnicza[1]));
		setIlosc(Integer.parseInt(pomocnicza[2]));
		setCena(Integer.parseInt(pomocnicza[3]));
		setKategoria(pomocnicza[4]);
		setProducent(pomocnicza[5]);
		setModel(pomocnicza[6]);
		setDataProdukcji(new CData(pomocnicza[7]));

		if (pomocnicza[8].equals(TYPY[0]) || pomocnicza[8].equals(TYPY[1]) || pomocnicza[8].equals(TYPY[2])) {
			this.typPeryferium = pomocnicza[8];
		} else {
			throw new PeryferiumException();
		}

		if (pomocnicza[9].equals(INTERFEJSY[0]) || pomocnicza[9].equals(INTERFEJSY[1])
				|| pomocnicza[9].equals(INTERFEJSY[2]) || pomocnicza[9].equals(INTERFEJSY[3])
				|| pomocnicza[9].equals(INTERFEJSY[4]) || pomocnicza[9].equals(INTERFEJSY[5])) {
			this.interfejs = pomocnicza[9];
		} else {
			throw new PeryferiumException();

		}
	}

	public String getTypPeryferium() {
		return this.typPeryferium;
	}

	public void setTypPeryferium(String typPeryferium) throws PeryferiumException {
		if (typPeryferium.equals(TYPY[0]) || typPeryferium.equals(TYPY[1]) || typPeryferium.equals(TYPY[2])) {
			this.typPeryferium = typPeryferium;
		} else {
			throw new PeryferiumException();
		}
	}

	public String getInterfejs() {
		return this.interfejs;
	}

	public void setInterfejs(String interfejs) throws PeryferiumException {
		if (interfejs.equals(INTERFEJSY[0]) || interfejs.equals(INTERFEJSY[1])
				|| interfejs.equals(INTERFEJSY[2]) || interfejs.equals(INTERFEJSY[3])
				|| interfejs.equals(INTERFEJSY[4]) || interfejs.equals(INTERFEJSY[5])) {
			this.interfejs = interfejs;
		} else {
			throw new PeryferiumException();
		}
	}

	@Override
	public String toString() {
		return super.toString() + " " + getTypPeryferium() + " " + getInterfejs();
	}

	@Override
	public boolean equals(Object obiekt) {
		if (this == obiekt)
			return true;

		if (obiekt == null || getClass() != obiekt.getClass())
			return false;

		if (!super.equals(obiekt))
			return false;

		CPeryferium inny = (CPeryferium) obiekt;

		return Objects.equals(this.typPeryferium, inny.typPeryferium) &&
				Objects.equals(this.interfejs, inny.interfejs);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.typPeryferium, this.interfejs);
	}
}
