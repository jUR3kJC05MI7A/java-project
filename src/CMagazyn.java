import java.io.*;
import java.util.ArrayList;

public class CMagazyn {
	private ArrayList<CTowar> bufor;
	private ArrayList<CTowar> magazyn;

	public CMagazyn() {
		bufor = new ArrayList<>();
		magazyn = new ArrayList<>();
	}

	public void wczytajzPliku(String nazwaPliku)
			throws DataException, TowarException, ProduktException, PeryferiumException {
		bufor.clear();

		try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
			String linia;

			while ((linia = br.readLine()) != null) {
				String[] pomocnicza = linia.split(",");
				CTowar towar = null;

				switch (pomocnicza[0]) {
					case "Mysz":
						towar = new PMysz(
								// id
								pomocnicza[1],
								// dataPrzyjecia
								new CData(pomocnicza[2]),
								// ilosc
								Integer.parseInt(pomocnicza[3]),
								// Cena
								Integer.parseInt(pomocnicza[4]),
								// kategoria
								pomocnicza[5],
								// producent
								pomocnicza[6],
								// model
								pomocnicza[7],
								// dataProdukcji
								new CData(pomocnicza[8]),
								// typPeryferium
								pomocnicza[9],
								// interfejs
								pomocnicza[10],
								// dpiMyszy
								Integer.parseInt(pomocnicza[11]),
								// sensor
								pomocnicza[12],
								// liczbaPrzyciskow
								Integer.parseInt(pomocnicza[13]));
						break;
					case "Klawiatura":
						towar = new PKlawiatura(
								// id
								pomocnicza[1],
								// dataPrzyjecia
								new CData(pomocnicza[2]),
								// ilosc
								Integer.parseInt(pomocnicza[3]),
								// Cena
								Integer.parseInt(pomocnicza[4]),
								// kategoria
								pomocnicza[5],
								// producent
								pomocnicza[6],
								// model
								pomocnicza[7],
								// dataProdukcji
								new CData(pomocnicza[8]),
								// typPeryferium
								pomocnicza[9],
								// interfejs
								pomocnicza[10],
								// typKlawiatury
								pomocnicza[11],
								// ukladKlawiatury
								pomocnicza[12]);
						break;
					case "Monitor":
						towar = new PMonitor(
								// id
								pomocnicza[1],
								// dataPrzyjecia
								new CData(pomocnicza[2]),
								// ilosc
								Integer.parseInt(pomocnicza[3]),
								// Cena
								Integer.parseInt(pomocnicza[4]),
								// kategoria
								pomocnicza[5],
								// producent
								pomocnicza[6],
								// model
								pomocnicza[7],
								// dataProdukcji
								new CData(pomocnicza[8]),
								// typPeryferium
								pomocnicza[9],
								// interfejs
								pomocnicza[10],
								// typMonitora
								pomocnicza[11],
								// rozdzielczosc
								pomocnicza[12]);
						break;
					case "default":
						System.out.println("Nieznany typ towaru: " + pomocnicza[0]);
				}
				if (towar != null) {
					bufor.add(towar);
				}
			}
		} catch (IOException e) {
			System.out.println("Blad odczytu pliku " + e.getMessage());
		} catch (DataException e) {
			System.out.println("Zly format daty");
		} catch (PeryferiumException e) {
			System.out.println("Blad w peryferium");
		}
	}

	public void dodajzBuforaDoMagazynu() {
		for (CTowar t : bufor) {
			magazyn.add(t);
		}
		bufor.clear();
	}

	public void dodajTowar(CTowar towar) {
		magazyn.add(towar);
	}

	public void wyswietlMagazyn() {
		for (CTowar t : magazyn) {
			System.out.println(t);
		}
	}

	public void wyswietlBufor() {
		for (CTowar t : bufor) {
			System.out.println(t);
		}
	}

	public void sprzedajPojedynczyTowar(String id) {
		for (CTowar t : magazyn) {
			if (t.getIndentyfikator().equals(id)) {
				if (t.getIlosc() > 0) {
					System.out.println("Sprzedano towar o id:" + id);
					t.setIlosc(t.getIlosc() - 1);
				} else {
					System.out.println("Danego towaru nie ma w magazynie.");
				}
				return;
			}
		}
		System.out.println("Nie znaleziono towaru o id " + id);
	}

	public void sprzedajZPliku(String nazwaPliku) {
		try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
			String linia;

			while ((linia = br.readLine()) != null) {
				String[] pomocnicza = linia.split(",");

				String id = pomocnicza[0];
				int iloscSprzedana = Integer.parseInt(pomocnicza[1]);

				boolean znaleziono = false;

				for (CTowar t : magazyn) {
					if (t.getIndentyfikator().equals(id)) {
						znaleziono = true;

						if (t.getIlosc() >= iloscSprzedana) {
							t.setIlosc(t.getIlosc() - iloscSprzedana);
						} else {
							System.out.println(
									"Brak wystarczajacej ilosc towaru o ID " + id);
						}
						break;
					}
				}
				if (!znaleziono) {
					System.out.println("Nie znaleziono towaru o ID " + id);
				}
			}
		} catch (IOException e) {
			System.out.println("Blad pliku sprzedarzy" + e.getMessage());
		}
	}

	public void przyjecieZPliku(String nazwaPliku)
			throws DataException, TowarException, ProduktException, PeryferiumException {
		try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
			String linia;

			while ((linia = br.readLine()) != null) {
				String[] pomocnicza = linia.split(",");
				CTowar nowyTowar = null;

				switch (pomocnicza[0]) {
					case "Mysz":
						nowyTowar = new PMysz(
								// id
								pomocnicza[1],
								// dataPrzyjecia
								new CData(pomocnicza[2]),
								// ilosc
								Integer.parseInt(pomocnicza[3]),
								// Cena
								Integer.parseInt(pomocnicza[4]),
								// kategoria
								pomocnicza[5],
								// producent
								pomocnicza[6],
								// model
								pomocnicza[7],
								// dataProdukcji
								new CData(pomocnicza[8]),
								// typPeryferium
								pomocnicza[9],
								// interfejs
								pomocnicza[10],
								// dpiMyszy
								Integer.parseInt(pomocnicza[11]),
								// sensor
								pomocnicza[12],
								// liczbaPrzyciskow
								Integer.parseInt(pomocnicza[13]));
						break;
					case "Klawiatura":
						nowyTowar = new PKlawiatura(
								// id
								pomocnicza[1],
								// dataPrzyjecia
								new CData(pomocnicza[2]),
								// ilosc
								Integer.parseInt(pomocnicza[3]),
								// Cena
								Integer.parseInt(pomocnicza[4]),
								// kategoria
								pomocnicza[5],
								// producent
								pomocnicza[6],
								// model
								pomocnicza[7],
								// dataProdukcji
								new CData(pomocnicza[8]),
								// typPeryferium
								pomocnicza[9],
								// interfejs
								pomocnicza[10],
								// typKlawiatury
								pomocnicza[11],
								// ukladKlawiatury
								pomocnicza[12]);
						break;
					case "Monitor":
						nowyTowar = new PMonitor(
								// id
								pomocnicza[1],
								// dataPrzyjecia
								new CData(pomocnicza[2]),
								// ilosc
								Integer.parseInt(pomocnicza[3]),
								// Cena
								Integer.parseInt(pomocnicza[4]),
								// kategoria
								pomocnicza[5],
								// producent
								pomocnicza[6],
								// model
								pomocnicza[7],
								// dataProdukcji
								new CData(pomocnicza[8]),
								// typPeryferium
								pomocnicza[9],
								// interfejs
								pomocnicza[10],
								// typMonitora
								pomocnicza[11],
								// rozdzielczosc
								pomocnicza[12]);
						break;
					case "default":
						System.out.println("Nieznany typ towaru " + pomocnicza[0]);
				}
				if (nowyTowar == null) {
					continue;
				}

				boolean znaleziono = false;

				for (CTowar t : magazyn) {
					if (t.getIndentyfikator().equals(nowyTowar.getIndentyfikator())) {
						t.setIlosc(t.getIlosc() + nowyTowar.getIlosc());
						znaleziono = true;
						break;
					}
				}

				if (!znaleziono) {
					magazyn.add(nowyTowar);
				}
			}
		} catch (IOException e) {
			System.out.println("Blad odczytu pliku " + e.getMessage());
		} catch (DataException e) {
			System.out.println("Zly format daty");
		} catch (PeryferiumException e) {
			System.out.println("Blad w peryferium");
		}
	}

	public void zapiszDoPliku(String nazwaPliku) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(nazwaPliku))) {
			for (CTowar towar : magazyn) {
				bw.write(towar.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("Blad przy zapisie pliku: " + e.getMessage());
		}
	}

	public void sortujPoCenie() {
		magazyn.sort(new ProduktCenaComparator());
	}

	public void sortujPoIlosci() {
		magazyn.sort(new ProduktIloscComparator());
	}

	public void sortujPoDaciePrzyjecia() {
		magazyn.sort(new ProduktDataPrzyjeciaComparator());
	}
}
