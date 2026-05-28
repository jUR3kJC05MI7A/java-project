import java.util.Objects;

public final class PKlawiatura extends CPeryferium {
	final static String[] TYPKLAWIATURY = { "Mechaniczna", "Membranowa" };
	final static String[] UKLADKLAWIATURY = { "QWERTY", "QWERTZ" };
	String typKlawiatury;
	String ukladKlawiatury;

	public PKlawiatura() {
		super();
		this.typKlawiatury = null;
		this.ukladKlawiatury = null;
	}

	public PKlawiatura(String indentyfikator, CData dataPrzyjecia, int ilosc, int cena, String kategoria,
			String producent, String model, CData dataProdukcji, String typPeryferium, String interfejs,
			String typKlawiatury, String ukladKlawiatury)
			throws DataException, TowarException, ProduktException, PeryferiumException {

		super(indentyfikator, dataPrzyjecia, ilosc, cena, kategoria, producent, model, dataProdukcji,
				typPeryferium, interfejs);

		if (typKlawiatury.equals(TYPKLAWIATURY[0]) || typKlawiatury.equals(TYPKLAWIATURY[1])) {
			this.typKlawiatury = typKlawiatury;
		} else {
			throw new PeryferiumException("Zly typ klawiatury.");
		}

		if (ukladKlawiatury.equals(UKLADKLAWIATURY[0]) || ukladKlawiatury.equals(UKLADKLAWIATURY[1])) {
			this.ukladKlawiatury = ukladKlawiatury;
		} else {
			throw new PeryferiumException("Zly uklad klawiszy.");
		}
	}

	public PKlawiatura(String klawiatura)
			throws DataException, TowarException, ProduktException, PeryferiumException {
		String regex = ",";
		String[] pomocnicza = klawiatura.split(regex);

		if (pomocnicza.length != 12) {
			throw new PeryferiumException("Zbyt malo elementow.");
		}

		setIndentyfikator(pomocnicza[0]);
		setDataPrzyjecia(new CData(pomocnicza[1]));
		setIlosc(Integer.parseInt(pomocnicza[2]));
		setCena(Integer.parseInt(pomocnicza[3]));
		setKategoria(pomocnicza[4]);
		setProducent(pomocnicza[5]);
		setModel(pomocnicza[6]);
		setDataProdukcji(new CData(pomocnicza[7]));
		setTypPeryferium(pomocnicza[8]);
		setInterfejs(pomocnicza[9]);

		if (pomocnicza[10].equals(TYPKLAWIATURY[0]) || pomocnicza[10].equals(TYPKLAWIATURY[1])) {
			this.typKlawiatury = pomocnicza[10];
		} else {
			throw new PeryferiumException("Zly typ klawiatury");
		}
		if (pomocnicza[11].equals(UKLADKLAWIATURY[0]) || pomocnicza[11].equals(UKLADKLAWIATURY[1])) {
			this.ukladKlawiatury = pomocnicza[11];
		} else {
			throw new PeryferiumException("Zly uklad klawiszy.");
		}
	}

	public String getTypKlawiatury() {
		return typKlawiatury;
	}

	public String getUkladKlawiatury() {
		return ukladKlawiatury;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getTypKlawiatury() + " " + getUkladKlawiatury();
	}

	@Override
	public boolean equals(Object obiekt) {
		if (this == obiekt)
			return true;
		if (obiekt == null || getClass() != obiekt.getClass())
			return false;

		if (!super.equals(obiekt))
			return false;

		PKlawiatura inny = (PKlawiatura) obiekt;

		return Objects.equals(this.typKlawiatury, inny.typKlawiatury)
				&& Objects.equals(this.ukladKlawiatury, inny.ukladKlawiatury);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.typKlawiatury, this.ukladKlawiatury);
	}
}
