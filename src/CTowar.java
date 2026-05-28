import java.util.Objects;

public class CTowar implements Comparable<CTowar> {
	private String indentyfikator;
	private CData dataPrzyjecia;
	private int ilosc;
	private int cena;

	public CTowar() {
		this.indentyfikator = null;
		this.dataPrzyjecia = new CData();
		this.ilosc = 0;
		this.cena = 0;
	}

	public CTowar(String indentyfikator, CData dataPrzyjecia, int ilosc, int cena)
			throws DataException, TowarException {
		if (indentyfikator.length() != 5) {
			throw new TowarException("Indentyfikator musi mieć dokladnie 5 znakow.");
		}
		this.indentyfikator = indentyfikator;
		this.dataPrzyjecia = new CData(dataPrzyjecia);
		this.ilosc = ilosc;
		this.cena = cena;
	}

	public CTowar(String towar) throws DataException, TowarException {
		String regex = ",";
		String[] pomocnicza = towar.split(regex);
		if (pomocnicza.length != 4)
			throw new TowarException("Zbyt malo elementow.");
		if (pomocnicza[0].length() != 5)
			throw new TowarException("Indentyfikator musi mieć dokladnie 5 znakow.");
		else
			this.indentyfikator = pomocnicza[0];

		this.dataPrzyjecia = new CData(pomocnicza[1]);
		this.ilosc = Integer.parseInt(pomocnicza[2]);
		this.cena = Integer.parseInt(pomocnicza[3]);
	}

	public CTowar(CTowar towar) throws DataException {
		this.indentyfikator = towar.indentyfikator;
		this.dataPrzyjecia = new CData(towar.dataPrzyjecia);
		this.ilosc = towar.ilosc;
		this.cena = towar.cena;
	}

	public String getIndentyfikator() {
		return this.indentyfikator;
	}

	public void setIndentyfikator(String indentyfikator) throws TowarException {
		if (indentyfikator.length() != 5) {

			throw new TowarException("Indentyfikator musi mieć dokladnie 5 znakow.");

		} else {

			this.indentyfikator = indentyfikator;
		}

	}

	public CData getDataPrzyjecia() {
		return this.dataPrzyjecia;
	}

	public void setDataPrzyjecia(CData data) throws DataException {
		this.dataPrzyjecia = new CData(data);
	}

	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return this.indentyfikator + " " + this.dataPrzyjecia.toString() + " " + this.ilosc + " " + this.cena;
	}

	@Override
	public int compareTo(CTowar towar) {
		return this.indentyfikator.compareTo(towar.indentyfikator);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CTowar towar = (CTowar) o;
		return (towar.indentyfikator.equals(this.indentyfikator));
	}

	@Override
	public int hashCode() {
		if (this.indentyfikator == null) {
			return 0;
		}
		return this.indentyfikator.hashCode();
	}

}
