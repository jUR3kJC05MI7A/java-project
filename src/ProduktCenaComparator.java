import java.util.Comparator;

public class ProduktCenaComparator implements Comparator<CTowar> {
	@Override
	public int compare(CTowar towar1, CTowar towar2) {
		return Integer.compare(towar1.getCena(), towar2.getCena());
	}
}
