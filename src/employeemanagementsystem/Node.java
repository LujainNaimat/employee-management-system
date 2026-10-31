package employeemanagementsystem;

public class Node {
	Node next;
	Node previous;
	private int ID;
	private String name;
	private int salary;

	public Node(int ID, String name, int salary) {
		this.ID = ID;
		this.name = name;
		this.salary = salary;
		this.next = null;
		this.previous = null;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
