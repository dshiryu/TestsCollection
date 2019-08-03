import java.util.LinkedList;

public class KlausurAufgabe1 {
	
	public static boolean testen(LinkedList<Double> list) {
		if (list.isEmpty() || list.size() < 2) return true;
		else if (list.size() > 1) {
			int count = 0;
			for(int i = 1; i < list.size(); i++) {
				if (list.get(i) < list.get(i - 1)) count++;
			}
			if (count == 1) return true;
			else return false;
		}
		else return false;
		
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
