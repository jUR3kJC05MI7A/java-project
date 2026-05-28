import java.util.Comparator;

public class ProduktDataProdukcjiComparator implements Comparator<CProdukt> {
	@Override
	public int compare(CProdukt produkt1, CProdukt produkt2) {
		return produkt1.getDataProdukcji().compareTo(produkt2.getDataProdukcji());
	}
}
