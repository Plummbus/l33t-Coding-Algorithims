package Linked_Lists_I;

public class testArea {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		
		LinkedListCustom ll = new LinkedListCustom(node1);
		
		System.out.println(ll.returnHead().getValue());
		
		ll.insertAtFront(5);
		
		System.out.println(ll.returnHead().getValue());
		System.out.println(ll.returnHead().getNext().getValue());
		
		ll.insertAtFront(3);
		
		ll.insertAtFront(7);
		
		System.out.println(ll.contains(5));
		System.out.println(ll.contains(1));
		System.out.println(ll.contains(8));	//not present in ll
		
		ll.removeAtFront();
		
		System.out.println(ll.contains(5));
		System.out.println(ll.contains(7));	//removed node
		
		System.out.println("Value of head node: " + ll.returnFrontVal());
		System.out.println("Length of ll: " + ll.listLength());
		
		System.out.println("Min value of ll: " + ll.minValue());
		System.out.println("Max value of ll: " + ll.maxValue());
		System.out.println("Average value of ll: " + ll.averageValue());
		
		ll.displayList();
		
		System.out.println("Last value in ll: " + ll.lastValue());
		
		ll.removeBack();
		ll.displayList();
		
		ll.removeBack();
		ll.displayList();
		ll.removeBack();
		ll.displayList();
		
		ll.addBack(1);
		ll.displayList();
		ll.addBack(13);
		ll.displayList();
	}

}
