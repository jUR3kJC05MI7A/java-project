import java.util.Comparator;

public class ProduktDataPrzyjeciaComparator implements Comparator<CTowar> {
	@Override
	public int compare(CTowar towar1, CTowar towar2) {
		return towar1.getDataPrzyjecia().compareTo(towar2.getDataPrzyjecia());
	}
}
