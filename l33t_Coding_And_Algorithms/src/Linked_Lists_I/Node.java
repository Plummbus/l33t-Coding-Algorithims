package Linked_Lists_I;

public class Node {

	
	private int value;
	private Node next;
	
	public Node() {
		this.value = 0; //primitive values cannot be null
		this.next = null;
	}
	
	public Node(int value) {
		this.value = value;	
		this.next = null;
	}
	
	public Node(int value, Node next) {
		this(value);
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
