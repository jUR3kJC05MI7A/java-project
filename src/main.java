import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		try {
			CMagazyn m = new CMagazyn();

			System.out.println(
					"===============================================================================");

			System.out.println("Wczytywanie produktow z pliku oraz wyswietlenie stanu magazynu:");
			m.wczytajzPliku("produkty.csv");
			m.dodajzBuforaDoMagazynu();
			m.wyswietlMagazyn();

			System.out.println(
					"===============================================================================");

			System.out.println("Sprzedaz pojedynczych produktow:");
			m.sprzedajPojedynczyTowar("00001");
			m.sprzedajPojedynczyTowar("00005");
			m.wyswietlMagazyn();

			System.out.println(
					"===============================================================================");

			System.out.println("Sprzedaz produktow z pliku: ");

			m.sprzedajZPliku("sprzedaz.csv");
			m.wyswietlMagazyn();

			System.out.println(
					"===============================================================================");

			System.out.println("Przyjecie produktow z pliku: ");

			System.out.println("Przyjecie oraz uzupelnienie towaru z pliku:");
			m.przyjecieZPliku("przyjecieTowaru.csv");
			m.wyswietlMagazyn();

			System.out.println(
					"=============================================================================");

			System.out.println("Sortowanie towaru po cenie: ");
			m.sortujPoCenie();
			m.wyswietlMagazyn();

			System.out.println(
					"==========================================================================");

			System.out.println("Sortowanie towaru po ilosci: ");
			m.sortujPoIlosci();
			m.wyswietlMagazyn();

			System.out.println(
					"===========================================================================");

			System.out.println("Sortowanie towaru po dacie przyjecia: ");
			m.sortujPoDaciePrzyjecia();
			m.wyswietlMagazyn();

			// System.out.println("Sortowanie towaru po dacie produkcji: ");

			// m.sortujPoDacieProdukcji();
			// m.wyswietlMagazyn();

			System.out.println(
					"==================================================================================");
			System.out.println("Zapis do pliku.");
			m.zapiszDoPliku("nowy.txt");

		} catch (DataException e) {
			System.out.println("Zly format daty: " + e.getMessage());
		} catch (PeryferiumException e) {
			System.out.println("Blad w peryferium: " + e.getMessage());
		} catch (ProduktException e) {
			System.out.println("Blad w produkcie: " + e.getMessage());
		} catch (TowarException e) {
			System.out.println("Blad w towarze: " + e.getMessage());
		}
	}
}
