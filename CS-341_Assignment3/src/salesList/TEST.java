package salesList;

public class TEST {

	public static void main(String[] args) {
		List l = new List();
		
		l.add(5.25, 1, "ham");
		l.add(2.25, 2, "bread");
		l.add(5.0, 2, "hotdogs");
		
		
		System.out.println(l.getSum());
		System.out.println(l.printList());
	}

}
