package employeemanagementsystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue queue = new Queue();
		int choice = 0;
		while (choice != 5) {

			System.out.println("welcome to ***Employee Management System ***");
			System.out.println("1.Enter new employee data\n2.Delete employee data");
			System.out.println("3.Show all employees\n4.Show shortest path\n5.Exit");
			try {
				String input = scan.nextLine().trim();
				choice = Integer.parseInt(input);

				switch (choice) {
				case 1:
					try {
						System.out.println("please Enter employee's ID");

						String IDInput = scan.nextLine().trim();
						int ID = validateID(IDInput);
						duplicateID(queue, ID);

						System.out.println("please Enter employee's name");
						String nameInput = scan.nextLine().trim();
						String name = validateName(nameInput);
						System.out.println("please Enter employee's salary");
						String salaryInput = scan.nextLine().trim();
						int salary = validateSalary(salaryInput);

						queue.enqueue(ID, name, salary);
						System.out.println("employee enqueued: id: " + ID + " name: " + name + " salary:" + salary);

					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					if (queue.isEmpty()) {
						System.out.println("Cannot delete employee, queue is empty");
						break;
					}
					queue.peek();
					queue.dequeue();
					System.out.println("employee deleted");
					break;
				case 3:
					queue.printQueue();
					break;
				case 4:
					Graph g = new Graph(5);
					g.addEdge(1, 2, 5);
					g.addEdge(1, 3, 9);
					g.addEdge(2, 3, 1);
					g.addEdge(2, 4, 4);
					g.addEdge(3, 4, 2);
					Bellman bellmanFord = new Bellman(g);
					try {
						System.out.println("enter source vertex");
						int source = Integer.parseInt(scan.nextLine().trim());
						System.out.println("enter destination vertex");

						int destination = Integer.parseInt(scan.nextLine().trim());
						try {
							bellmanFord.BellmanFord(source, destination);
						} catch (IllegalArgumentException e) {
							System.out.println(e.getMessage());
						}

					} catch (NumberFormatException e) {
						System.out.println("enter  digitss only");
					}
					break;
				case 5:
					System.out.println("program exited");
					break;
				default:
					System.out.println("please enter a number from 1-5");
				}
			} catch (NumberFormatException e) {
				System.out.println("please enter numeric digits only");
				choice = 0;
				continue;
			}
		}
		scan.close();

	}

	public static int validateID(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("error:ID cannot be empty ");
		}
		int ID;
		try {
			ID = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("error:ID must contain digits only");
		}
		if (ID < 0) {
			throw new IllegalArgumentException("error:ID cannot be less than 0 ");

		}
		return ID;
	}

	public static String validateName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("error:name cannot be empty");
		}
		if (name.length() < 2 || name.length() > 50) {
			throw new IllegalArgumentException("valid Name length is between 2-50 charecter");

		}
		for (char c : name.toCharArray()) {
			if (!Character.isLetter(c) && c != ' ') {
				throw new IllegalArgumentException("error:name cannot contain special charecters or number");
			}
		}
		return name;
	}

	public static int validateSalary(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("error:salary cannot be empty");
		}
		int salary;
		try {
			salary = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("error:salary must be a numeric value");
		}
		if (salary < 0) {
			throw new IllegalArgumentException("error:salary cannot be negative");
		}

		return salary;

	}

	public static void duplicateID(Queue queue, int id) {
		Node current = queue.getList().getHead();
		while (current != null) {
			if (current.getID() == id) {
				throw new IllegalArgumentException("ID: cannot be duplicated");
			}
			current = current.next;
		}

	}
}
