import java.util.Objects;

public final class CData implements Comparable<CData> {
	/* dwa numery dla lutego */
	final private static int[] DNIWMIESIACACH = { 31, 28, 29, 30 };

	private int dni;

	private static final int EPOCHROK = 1582;
	private static final int EPOCHDZIEN = 1;
	private static final int EPOCHMIESIAC = 1;

	private int dzien, miesiac, rok;

	private static final String[] NAZWYMIESIECY = { "Styczen", "Luty", "Marzec", "Kwiecien", "Maj", "Czerwiec",
			"Lipiec",
			"Sierpien", "Wrzesien", "Pazdziernik", "Listopad", "Grudzien" };
	private static final String[] NAZWYDNI = { "Niedziela", "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek",
			"Sobota" };

	public CData() {
		this.dni = 0;
		this.dzien = EPOCHDZIEN;
		this.miesiac = EPOCHMIESIAC;
		this.rok = EPOCHROK;
	}

	public CData(int dzien, int miesiac, int rok) throws DataException {
		ustawDate(dzien, miesiac, rok);
	}

	public CData(String s_data) throws DataException {
		String regex = "\\.";

		String[] data = s_data.split(regex);

		if (data.length != 3)
			throw new DataException();

		int dzien = Integer.parseInt(data[0]);
		int miesiac = Integer.parseInt(data[1]);
		int rok = Integer.parseInt(data[2]);

		if (rok < EPOCHROK || miesiac < 1 || miesiac > 12)
			throw new DataException();

		boolean flagaPrzestepny = czyPrzestepny(rok);

		if ((miesiac == 1 || miesiac == 3 || miesiac == 5 || miesiac == 7 || miesiac == 8 || miesiac == 10
				|| miesiac == 12) && (dzien < 1 || dzien > 31))
			throw new DataException();

		if ((miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) && (dzien < 1 || dzien > 30))
			throw new DataException();

		if ((miesiac == 2 && flagaPrzestepny == true) && (dzien > 29 || dzien < 1))
			throw new DataException();

		if ((miesiac == 2 && flagaPrzestepny == false) && (dzien > 28 || dzien < 1))
			throw new DataException();

		int lataPelne = rok - EPOCHROK;

		int lataPrzestepne = liczyLataPrzestepnePrzed(rok) - liczyLataPrzestepnePrzed(EPOCHROK);

		int iloscLatNiePrzetepnych = lataPelne - lataPrzestepne;

		int iloscDni = lataPrzestepne * 366 + iloscLatNiePrzetepnych * 365;

		int sumaTest = 0;

		for (int i = 1; i < miesiac; i++) {
			if (flagaPrzestepny && i == 2)
				sumaTest += DNIWMIESIACACH[2];
			else if (i == 2)
				sumaTest += DNIWMIESIACACH[1];

			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
				sumaTest += DNIWMIESIACACH[0];
			else if (i != 2)
				sumaTest += DNIWMIESIACACH[3];
		}

		iloscDni += sumaTest + dzien;

		this.dni = iloscDni;
		this.dzien = dzien;
		this.miesiac = miesiac;
		this.rok = rok;

	}

	public CData(CData data) throws DataException {
		this.dni = data.dni;
		this.dzien = data.dzien;
		this.miesiac = data.miesiac;
		this.rok = data.rok;
	}

	private boolean czyPrzestepny(int rok) {
		return ((rok % 4 == 0) && (rok % 100 != 0 || rok % 400 == 0));
	}

	private int liczyLataPrzestepnePrzed(int rok) {
		int a = (int) Math.floor((rok - 1) / 4);
		int b = (int) Math.floor((rok - 1) / 100);
		int c = (int) Math.floor((rok - 1) / 400);

		return a - b + c;
	}

	public String algSakumoto() {
		int[] przesunieciaDlaMiesiecy = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };

		int rok = this.rok;

		if (this.miesiac < 3)
			rok -= 1;

		int miesiac = this.miesiac - 1;

		int index = (rok + liczyLataPrzestepnePrzed(rok) + przesunieciaDlaMiesiecy[miesiac] + this.dzien) % 7;

		return NAZWYDNI[index];
	}

	public int getDni() {
		return this.dni;
	}

	public int getDzien() {
		return this.dzien;
	}

	public String getNazwaDnia() {
		return algSakumoto();
	}

	public int getMiesiac() {
		return this.miesiac;
	}

	public String getNazwaMiesiaca() {
		return NAZWYMIESIECY[this.miesiac - 1];
	}

	public int getRok() {
		return this.rok;
	}

	private void ustawDate(int dzien, int miesiac, int rok) throws DataException {

		if (rok < EPOCHROK || miesiac < 1 || miesiac > 12)
			throw new DataException();

		boolean flagaPrzestepny = czyPrzestepny(rok);

		if ((miesiac == 1 || miesiac == 3 || miesiac == 5 || miesiac == 7 || miesiac == 8 || miesiac == 10
				|| miesiac == 12) && (dzien < 1 || dzien > 31))
			throw new DataException();

		if ((miesiac == 4 || miesiac == 6 || miesiac == 9 || miesiac == 11) && (dzien < 1 || dzien > 30))
			throw new DataException();

		if ((miesiac == 2 && flagaPrzestepny == true) && (dzien > 29 || dzien < 1))
			throw new DataException();

		if ((miesiac == 2 && flagaPrzestepny == false) && (dzien > 28 || dzien < 1))
			throw new DataException();

		int lataPelne = rok - EPOCHROK;
		int lataPrzestepne = liczyLataPrzestepnePrzed(rok) - liczyLataPrzestepnePrzed(EPOCHROK);

		int iloscLatNiePrzetepnych = lataPelne - lataPrzestepne;

		int iloscDni = lataPrzestepne * 366 + iloscLatNiePrzetepnych * 365;

		int sumaTest = 0;

		for (int i = 1; i < miesiac; i++) {
			if (flagaPrzestepny && i == 2)
				sumaTest += DNIWMIESIACACH[2];
			else if (i == 2)
				sumaTest += DNIWMIESIACACH[1];

			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
				sumaTest += DNIWMIESIACACH[0];
			else if (i != 2)
				sumaTest += DNIWMIESIACACH[3];
		}

		iloscDni += sumaTest + dzien;

		this.dni = iloscDni;

		this.dzien = dzien;
		this.miesiac = miesiac;
		this.rok = rok;
	}

	public void do_przyszlosci(int dni) {
		this.dni += dni;

		int nowyRok = EPOCHROK;
		int pozostaleDni = this.dni;
		int dniWRoku;

		while (true) {
			dniWRoku = czyPrzestepny(nowyRok) ? 366 : 365;

			if (pozostaleDni > dniWRoku) {
				pozostaleDni -= dniWRoku;
				nowyRok++;
			} else
				break;
		}
		this.rok = nowyRok;

		boolean flagCzyPrzestepny = czyPrzestepny(nowyRok);

		int noweMiesiace = 0;

		for (int i = 1; i <= 12; i++) {
			if (i == 2 && flagCzyPrzestepny) {
				if (pozostaleDni > DNIWMIESIACACH[2]) {
					pozostaleDni -= DNIWMIESIACACH[2];
					noweMiesiace++;
				} else
					break;
			} else if (i == 2) {
				if (pozostaleDni > DNIWMIESIACACH[1]) {
					pozostaleDni -= DNIWMIESIACACH[1];
					noweMiesiace++;
				} else
					break;
			}
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				if (pozostaleDni > DNIWMIESIACACH[0]) {
					pozostaleDni -= DNIWMIESIACACH[0];
					noweMiesiace++;
				} else
					break;
			} else if (i != 2)
				if (pozostaleDni > DNIWMIESIACACH[3]) {
					pozostaleDni -= DNIWMIESIACACH[3];
					noweMiesiace++;
				} else
					break;
		}

		this.miesiac = noweMiesiace + 1;
		this.dzien = (int) pozostaleDni;
	}

	public void w_przeszlosc(int dni) {
		this.dni -= dni;

		int nowyRok = EPOCHROK;
		int pozostaleDni = this.dni;
		int dniWRoku;

		while (true) {
			dniWRoku = czyPrzestepny(nowyRok) ? 366 : 365;

			if (pozostaleDni > dniWRoku) {
				pozostaleDni -= dniWRoku;
				nowyRok++;
			} else
				break;
		}
		this.rok = nowyRok;

		boolean flagCzyPrzestepny = czyPrzestepny(nowyRok);

		int noweMiesiace = 0;

		for (int i = 1; i <= 12; i++) {
			if (i == 2 && flagCzyPrzestepny) {
				if (pozostaleDni > DNIWMIESIACACH[2]) {
					pozostaleDni -= DNIWMIESIACACH[2];
					noweMiesiace++;
				} else
					break;
			} else if (i == 2) {
				if (pozostaleDni > DNIWMIESIACACH[1]) {
					pozostaleDni -= DNIWMIESIACACH[1];
					noweMiesiace++;
				} else
					break;
			}
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				if (pozostaleDni > DNIWMIESIACACH[0]) {
					pozostaleDni -= DNIWMIESIACACH[0];
					noweMiesiace++;
				} else
					break;
			} else if (i != 2)
				if (pozostaleDni > DNIWMIESIACACH[3]) {
					pozostaleDni -= DNIWMIESIACACH[3];
					noweMiesiace++;
				} else
					break;
		}
		this.miesiac = noweMiesiace + 1;
		this.dzien = (int) pozostaleDni;
	}

	public void jutro() throws DataException {
		do_przyszlosci(1);
	}

	public void wczoraj() throws DataException {
		w_przeszlosc(1);
	}

	public void zaTydzien() throws DataException {
		do_przyszlosci(7);
	}

	public void tydzienTemu() throws DataException {
		w_przeszlosc(7);
	}

	// Obiekt ktory wywoluje funkcje ma pierwszenstwo.
	public boolean porownajDaty(CData data) {
		if (this.dni > data.dni)
			return true;
		else
			return false;
	}

	public int roznicaDat(CData data1) {
		return this.dni - data1.dni;
	}

	@Override
	public String toString() {
		return this.dzien + "." + this.miesiac + "." + this.rok + " " + this.dni + " ";
	}

	@Override
	public int compareTo(CData data) {
		return Integer.compare(this.dni, data.dni);
	}

	@Override
	public boolean equals(Object obiekt) {
		if (this == obiekt)
			return true;

		if (obiekt == null || getClass() != obiekt.getClass())
			return false;

		CData inny = (CData) obiekt;

		return this.dni == inny.dni && this.dzien == inny.dzien && this.miesiac == inny.miesiac
				&& this.rok == inny.rok;
	}

	@Override
	public int hashCode() {
		return this.dni;
	}

	public static boolean porownajDaty(CData data1, CData data2) {
		return data1.dni > data2.dni;
	}

	public static int roznicaDat(CData data1, CData data2) {
		return data1.dni - data2.dni;
	}

	public static int[] dataWielkanocy(int rok) {
		int[] dataWielkiejnocy = new int[3];
		int d = 225 - 11 * (rok % 19);

		if (d > 50)
			while (d > 51)
				d -= 30;
		if (d > 48)
			d--;
		int e = (rok + (rok / 4) + d + 1) % 7;

		int q = d + 7 - e;

		if (q < 32) {
			dataWielkiejnocy[0] = q - 30;
			dataWielkiejnocy[1] = 3;
			dataWielkiejnocy[2] = rok;
		}

		if (q > 31) {
			dataWielkiejnocy[0] = q - 31;
			dataWielkiejnocy[1] = 4;
			dataWielkiejnocy[2] = rok;
		}
		return dataWielkiejnocy;
	}
}
