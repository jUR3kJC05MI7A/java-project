import java.util.Objects;

public class CProdukt extends CTowar {
	String kategoria;
	String producent;
	String model;
	CData dataProdukcji;

	public CProdukt() {
		super();
		this.kategoria = null;
		this.producent = null;
		this.model = null;
		this.dataProdukcji = new CData();
	}

	public CProdukt(String indentyfikator, CData dataPrzyjecia, int ilosc, int cena, String kategoria,
			String producent, String model, CData dataProdukcji) throws TowarException, DataException {
		super(indentyfikator, dataPrzyjecia, ilosc, cena);
		this.kategoria = kategoria;
		this.producent = producent;
		this.model = model;
		this.dataProdukcji = new CData(dataProdukcji);
	}

	public CProdukt(String produkt) throws TowarException, DataException, ProduktException {
		String regex = ",";
		String[] pomocnicza = produkt.split(regex);

		if (pomocnicza.length != 8) {
			throw new ProduktException("Zbyt malo elementow.");
		}

		setIndentyfikator(pomocnicza[0]);
		setDataPrzyjecia(new CData(pomocnicza[1]));
		setIlosc(Integer.parseInt(pomocnicza[2]));
		setCena(Integer.parseInt(pomocnicza[3]));
		this.kategoria = pomocnicza[4];
		this.producent = pomocnicza[5];
		this.model = pomocnicza[6];
		this.dataProdukcji = new CData(pomocnicza[7]);
	}

	public CProdukt(CProdukt produkt) throws TowarException, DataException {
		super(produkt);
		this.kategoria = produkt.kategoria;
		this.producent = produkt.producent;
		this.model = produkt.model;
		this.dataProdukcji = new CData(produkt.dataProdukcji);
	}

	public String getKategoria() {
		return this.kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getProducent() {
		return this.producent;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public CData getDataProdukcji() {
		return this.dataProdukcji;
	}

	public void setDataProdukcji(CData dataProdukcji) throws DataException {
		this.dataProdukcji = new CData(dataProdukcji);
	}

	@Override
	public String toString() {
		return super.toString() + " " + this.kategoria + " " + this.model + " " + this.dataProdukcji.toString();
	}

	@Override
	public boolean equals(Object obiekt) {
		if (this == obiekt)
			return true;

		if (obiekt == null || getClass() != obiekt.getClass())
			return false;

		if (!super.equals(obiekt))
			return false;

		CProdukt inny = (CProdukt) obiekt;

		return Objects.equals(this.kategoria, inny.kategoria) &&
				Objects.equals(this.producent, inny.producent) &&
				Objects.equals(this.model, inny.model) &&
				Objects.equals(this.dataProdukcji, inny.dataProdukcji);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.kategoria, this.producent, this.model, this.dataProdukcji);
	}
}
