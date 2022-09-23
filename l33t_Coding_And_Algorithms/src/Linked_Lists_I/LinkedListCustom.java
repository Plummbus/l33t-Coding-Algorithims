package Linked_Lists_I;

public class LinkedListCustom {

	
	private Node head;
	
	public LinkedListCustom(Node head) {
		this.head = head;
	}
	
	public Node returnHead() {
		return this.head;
	}
	
	public void setHead(Node newNode) {
		this.head = newNode;
	}
	
	public Node insertAtFront(int value) {
		Node newNode = new Node(value);
		Node tempHolder = returnHead();
		setHead(newNode);
		this.head.setNext(tempHolder);
		return this.head;
	}
	
	public boolean contains(int target) {
		boolean isFound = false;
		
		if (this.head == null) {
			return false;
		} else {
			Node currentNode = this.head;
			while (currentNode != null) {
				System.out.println("Current node val: " + currentNode.getValue());
				if (currentNode.getValue() == target) {
					isFound = true;
					break;
				} 
				currentNode = currentNode.getNext();
			}
		}
		
		return isFound;
	}
	
	//this deleted the whole linked list
	//make sure to set new head's next to old head's next
	public Node removeAtFront() {
		Node removedHead = this.head;
		setHead(this.head.getNext());
		removedHead.setNext(null);		//so the returned node doesn't point to the LL
		return removedHead;
	}
	
	public int returnFrontVal() {
		try {
			return this.head.getValue();
		} catch (NullPointerException e) {
			System.out.println("Cannot return a value because head is null.");
		}
		return 0;	//dummy value
		
	}
	
	public int listLength() {
		int length = 0;
		Node currentNode = this.head;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		
		return length;
	}
	
	//display
	//min
	
	public int minValue() {
		int min = 0;
		Node currentNode = this.head;
		if (currentNode != null) {
			min = currentNode.getValue();
		}
		while (currentNode != null) {
			if (currentNode.getValue() < min) {
				min = currentNode.getValue();
			}
			currentNode = currentNode.getNext();
		}
		
		return min;
	}
	
	public int maxValue() {
		int max = 0;
		Node currentNode = this.head;
		if (currentNode != null) {
			max = currentNode.getValue();
		}
		while (currentNode != null) {
			if (currentNode.getValue() > max) {
				max = currentNode.getValue();
			}
			currentNode = currentNode.getNext();
		}
		
		return max;
	}
	
	
	//average
	public int averageValue() {
		int count = 0;
		int sum = 0;
		Node currentNode = this.head;
		
		while (currentNode != null) {
			count++;
			sum += currentNode.getValue();
			currentNode = currentNode.getNext();
		}
		
		return sum / count;
	}
	
	
	public void displayList() {
		int count = 0;
		Node currentNode = this.head;
		
		if (currentNode == null) {
			System.out.println("LL is empty, no nodes or values present.");
		} else {
			while (currentNode != null) {
				count++;
				String message = String.format("Current Node - Node: %d; Value: %d", count, currentNode.getValue());
				currentNode = currentNode.getNext();
				
				System.out.println(message);
			}
		}
		
		
	}
	
	public int lastValue() {
		
		Node currentNode = this.head;
	
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		
		return currentNode.getValue();
	}
	
	
	public void removeBack() {
		
		Node currentNode = this.head;
		
		//in a LL of 1 node, the only node is both the head and the back
		if (currentNode.getNext() == null) {
			this.setHead(null);
		} else {
			while (currentNode.getNext() != null) {
				if (currentNode.getNext().getNext() == null) {
					currentNode.setNext(null);
				} else {
					currentNode = currentNode.getNext();
				}
			}
		}		
	}
	
	public void addBack(int val) {
		
		Node newNode = new Node(val);
		Node currentNode = this.head;
		
		if (currentNode == null) {
			this.setHead(newNode);
		} else {
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}
	}
	
	public void moveMinToFront() {
		
		Node minNode;
		Node previous;
		Node originalHead = this.head;
		
	}
	
	
}
