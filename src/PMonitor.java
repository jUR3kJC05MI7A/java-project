import java.util.Objects;

public final class PMonitor extends CPeryferium {
	final static String[] TYPMONITORA = { "Gamingowy", "Biurkowy", "Graficzny" };
	final static String[] ROZDZIELCZOSC = { "1920x1080", "2560x1440", "3840x2160" };
	String typMonitora;
	String rozdzielczosc;

	public PMonitor() {
		super();
		this.typMonitora = null;
		this.rozdzielczosc = null;
	}

	public PMonitor(String indentyfikator, CData dataPrzyjecia, int ilosc, int cena, String kategoria,
			String producent, String model, CData dataProdukcji, String typPeryferium, String interfejs,
			String typMonitora, String rozdzielczosc)
			throws DataException, TowarException, ProduktException, PeryferiumException {

		super(indentyfikator, dataPrzyjecia, ilosc, cena, kategoria, producent, model, dataProdukcji,
				typPeryferium, interfejs);

		if (typMonitora.equals(TYPMONITORA[0]) || typMonitora.equals(TYPMONITORA[1])
				|| typMonitora.equals(TYPMONITORA[2])) {
			this.typMonitora = typMonitora;
		} else {
			throw new PeryferiumException("Zly typ monitora.");
		}

		if (rozdzielczosc.equals(ROZDZIELCZOSC[0]) || rozdzielczosc.equals(ROZDZIELCZOSC[1])
				|| rozdzielczosc.equals(ROZDZIELCZOSC[2])) {
			this.rozdzielczosc = rozdzielczosc;
		} else {
			throw new PeryferiumException("Zla rozdzielczosc.");
		}
	}

	public PMonitor(String monitor)
			throws DataException, TowarException, ProduktException, PeryferiumException {
		String regex = ",";
		String[] pomocnicza = monitor.split(regex);

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

		if (pomocnicza[10].equals(TYPMONITORA[0]) || pomocnicza[10].equals(TYPMONITORA[1])
				|| pomocnicza[10].equals(TYPMONITORA[2])) {
			this.typMonitora = pomocnicza[10];
		} else {
			throw new PeryferiumException("Zly typ monitora");
		}
		if (pomocnicza[11].equals(ROZDZIELCZOSC[0]) || pomocnicza[11].equals(ROZDZIELCZOSC[1])
				|| pomocnicza[11].equals(ROZDZIELCZOSC[2])) {
			this.rozdzielczosc = pomocnicza[11];
		} else {
			throw new PeryferiumException("Zly rozdzielczosc.");
		}
	}

	public String getTypMonitora() {
		return typMonitora;
	}

	public String getRozdzielczosc() {
		return rozdzielczosc;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getTypMonitora() + " " + getRozdzielczosc();
	}

	@Override
	public boolean equals(Object obiekt) {
		if (this == obiekt)
			return true;
		if (obiekt == null || getClass() != obiekt.getClass())
			return false;

		if (!super.equals(obiekt))
			return false;

		PMonitor inny = (PMonitor) obiekt;

		return Objects.equals(this.typMonitora, inny.typMonitora)
				&& Objects.equals(this.rozdzielczosc, inny.rozdzielczosc);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.typMonitora, this.rozdzielczosc);
	}
}
