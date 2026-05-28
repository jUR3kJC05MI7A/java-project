import java.util.Objects;

public final class PMysz extends CPeryferium {
	public static final String[] typySensorow = { "Laserowy", "Optyczny" };
	int dpiMyszy;
	String sensor;
	int liczbaPrzyciskow;

	public PMysz() {
		super();
		this.dpiMyszy = 0;
		this.sensor = null;
		this.liczbaPrzyciskow = 0;
	}

	public PMysz(String indentyfikator, CData dataPrzyjecia, int ilosc, int cena, String kategoria,
			String producent, String model, CData dataProdukcji, String typPeryferium, String interfejs,
			int dpiMyszy, String sensor, int liczbaPrzyciskow)
			throws TowarException, DataException, ProduktException, PeryferiumException {
		super(indentyfikator, dataPrzyjecia, ilosc, cena, kategoria, producent, model, dataProdukcji,
				typPeryferium, interfejs);

		if (sensor.equals(typySensorow[0]) || sensor.equals(typySensorow[1])) {
			this.sensor = sensor;
		} else {
			throw new PeryferiumException();
		}

		this.dpiMyszy = dpiMyszy;
		this.liczbaPrzyciskow = liczbaPrzyciskow;
	}

	public PMysz(String mysz) throws TowarException, DataException, ProduktException, PeryferiumException {
		String regex = ",";
		String[] pomocnicza = mysz.split(regex);

		if (pomocnicza.length != 13) {
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
		setTypPeryferium(pomocnicza[8]);
		setInterfejs(pomocnicza[9]);

		this.dpiMyszy = Integer.parseInt(pomocnicza[10]);

		if (pomocnicza[11].equals(typySensorow[0]) || pomocnicza[11].equals(typySensorow[1])) {
			this.sensor = pomocnicza[11];
		} else {
			throw new PeryferiumException();
		}

		this.liczbaPrzyciskow = Integer.parseInt(pomocnicza[12]);
	}

	public int getDpiMyszy() {
		return this.dpiMyszy;
	}

	public void setDpiMyszy(int dpiMyszy) {
		this.dpiMyszy = dpiMyszy;
	}

	public String getSensor() {
		return this.sensor;
	}

	public void setSensor(String sensor) throws PeryferiumException {
		if (sensor.equals(typySensorow[0]) || sensor.equals(typySensorow[1])) {
			this.sensor = sensor;
		} else {
			throw new PeryferiumException();
		}
	}

	public int getLiczbaPrzyciskow() {
		return this.liczbaPrzyciskow;
	}

	public void setLiczbaPrzyciskow(int liczbaPrzyciskow) {
		this.liczbaPrzyciskow = liczbaPrzyciskow;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getDpiMyszy() + " " + getSensor() + " " + getLiczbaPrzyciskow();
	}

	@Override
	public boolean equals(Object obiekt) {
		if (this == obiekt)
			return true;
		if (obiekt == null || getClass() != obiekt.getClass())
			return false;
		if (!super.equals(obiekt))
			return false;

		PMysz inny = (PMysz) obiekt;

		return Objects.equals(this.dpiMyszy, inny.dpiMyszy)
				&& Objects.equals(this.sensor, inny.sensor)
				&& Objects.equals(this.liczbaPrzyciskow, inny.liczbaPrzyciskow);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.dpiMyszy, this.sensor, this.liczbaPrzyciskow);
	}

}
