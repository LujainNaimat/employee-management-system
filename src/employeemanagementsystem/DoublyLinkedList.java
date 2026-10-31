package employeemanagementsystem;


public class DoublyLinkedList {
	private Node head;
	
	private Node tail;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return head == null && tail == null;

	}

	public void insertAtFirst(int ID, String name, int salary) {
		Node node = new Node(ID, name, salary);
		if (isEmpty()) {
			head = node;
			tail = node;
			return;
		}
		node.next = head;
		head.previous = node;
		head = node;

	}

	public void insertAtLast(int ID, String name, int salary) {
		Node node = new Node(ID, name, salary);
		if (isEmpty()) {
			head = node;
			tail = node;
			return;
		}
		node.previous = tail;
		tail.next = node;
		tail = node;

	}

	public void DeleteFirst() {
		if (isEmpty()) {
			return;
		}
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}
		head = head.next;
		head.previous = null;

	}

	public void deleteLast() {
		if (isEmpty()) {
			return;
		}
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}
		tail = tail.previous;
		tail.next = null;

	}

	public void print() {
		Node current = head;
		while (current != null) {
			System.out.println("The employee name  is: " + current.getName() + " salary: " + current.getSalary() + " ID : "
					 + current.getID());
			current = current.next;
		}
	}
	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}


	
}


