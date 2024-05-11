package tester;

import java.util.*;

import com.app.core.Queue;

public class TestQueue {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("\n**** Queue ****");
			Queue queueObj = null;
			System.out.println("default stack ? : (y/n)");
			if(sc.next().equalsIgnoreCase("y")) {
				queueObj = new Queue();
			}
			else {
				System.out.print("Enter size : ");
				queueObj = new Queue(sc.nextInt());
			}
			boolean exit = false;
			while(!exit) {
				System.out.print("1. Add\n2. Delete\n3. Display\n4. sExit\nChoice : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.print("Enter Element : ");
						queueObj.addQ(sc.nextInt());
						System.out.println("added..!!!");
						break;
					case 2:
						int elem = queueObj.deleteQ();
						System.out.println("Deleted element : "+elem);
						break;
					case 3:
						System.out.println("Queue : ");
						queueObj.showQueue();
						break;
					case 4:
						exit = true;
						System.out.println("Thank You...!!!");
						break;
					default:
						System.out.println("Enter correct choice...");
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}
		}
	}
}
