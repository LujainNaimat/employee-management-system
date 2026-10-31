package employeemanagementsystem;

public class Queue {
		private DoublyLinkedList list;

		public Queue() {
			list = new DoublyLinkedList();
		}

		public DoublyLinkedList getList() {
			return list;
		}

		public void setList(DoublyLinkedList list) {
			this.list = list;
		}

		public void enqueue(int ID, String name, int salary) {
			list.insertAtFirst(ID, name, salary);
		}

		public void dequeue() {
			if (isEmpty()) {
				System.out.println("Cannot delete employee, queue is empty");
				return;
			}
			list.deleteLast();
		}

		public void peek() {
			if (isEmpty()) {
				System.out.println("no employee is stored in the list,Queue is Empty");
				return;
			}
			Node peek = list.getTail();
			System.out.println("Employee ID: " + peek.getID() + " Name: " + peek.getName() + " Salary: " + peek.getSalary());

		}

		public void printQueue() {
			if (isEmpty()) {
				System.out.println("no employees yet, queue is empty");
				return;
			}
			list.print();
		}

		public boolean isEmpty() {
			return list.isEmpty();
		}
	}


