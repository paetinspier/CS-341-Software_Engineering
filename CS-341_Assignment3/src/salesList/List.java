package salesList;

public class List {
	
	// data members
	private Item head;
	private Item tail;
	private Double sum = 0.0;
	private String list = "";
	private Integer total = 0;
	
	// constructor 
	
	public List() {
		head = null;
		tail = null;
	}
	
	
	// is empty method
	
	public boolean isEmpty() {
		return head == null;
	}
	
	
	// Add item method
	public void add(Double p, Integer q, String n) {
		
		// create an item to add to the list
		Item temp = new Item(p, q, n);
		
		total += q;
		
		sum += p * q; // this adds the price of the item to the total price of the list
		
		list += n + "\t" + "$" + p.toString() + "\t" + q.toString() + "\n"; // this adds all the details about the item to the list
		
		if (isEmpty()) {
			head = temp;
			tail = temp;
		}
		else {
			tail.next = temp;
			tail = temp;
		}
	}
	
	public Double peekPrice() {
		return head.getPrice();
	}
	
	
	public Integer peekQuantity() {
		return head.getQuantity();
	}
	
	
	public String peekName() {
		return head.getName();
	}
	
	public Double getSum() {
		return sum;
	}
	
	public String printList() {
		return list;
	}
	
	public Integer getQuantity() {
		return total;
	}
	

	
	
}
