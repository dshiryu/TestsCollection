import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class KlausurAufgabe2 {

	public static boolean testen(LinkedList<Double> list) {
		int count = 0;
		if (list.size() <= 1) return true;
		boolean k = true;
		
		Iterator<Double> it = list.iterator();
		Double x = it.next();
		Double y = it.next();
		for (;it.hasNext();) {
			if (k == true) {
				if (x > y) {
					count++;
				}
				x = it.next();
				k = false;
			} else {
				if (x < y) {
					count++;
				}
				y = it.next();
				k = true;
			}
		}
			
		if (count > 1) return false;
			
		return true;
		
	}
	
	public static void main(String[] args) {
		LinkedList<Double> t1 = new LinkedList<Double>();
		System.out.println(testen(t1));
		
		LinkedList<Double> t2 = new LinkedList<Double>();
		t2.add(11.);
		System.out.println(testen(t2));
		
		LinkedList<Double> t3 = new LinkedList<Double>();
		t3.add(5.);
		t3.add(2.);
		t3.add(11.);
		System.out.println(testen(t3));
		
		LinkedList<Double> t4 = new LinkedList<Double>();
		t4.add(5.);
		t4.add(2.);
		t4.add(1.);
		t4.add(12.);
		System.out.println(testen(t4));
		
		LinkedList<Double> t5 = new LinkedList<Double>();
		t5.add(6.);
		t5.add(5.);
		t5.add(4.);
		t5.add(1.);
		System.out.println(testen(t5));

	}

}
