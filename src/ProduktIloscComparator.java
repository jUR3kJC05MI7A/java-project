import java.util.Comparator;

public class ProduktIloscComparator implements Comparator<CTowar> {
	@Override
	public int compare(CTowar towar1, CTowar towar2) {
		return Integer.compare(towar1.getIlosc(), towar2.getIlosc());
	}
}
