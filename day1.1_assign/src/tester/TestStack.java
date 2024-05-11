package tester;

import java.util.*;
import com.app.core.Stack;
public class TestStack {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("\n**** STACK ****");
			Stack stackObj = null;
			System.out.println("default stack ? : (y/n)");
			if(sc.next().equalsIgnoreCase("y")) {
				stackObj = new Stack();
			}
			else {
				System.out.print("Enter size : ");
				stackObj = new Stack(sc.nextInt());
			}
			boolean exit = false;
			while(!exit) {
				System.out.print("1. Push\n2. Pop\n3. Display Stack\n4. Exit\nChoice : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Element : ");
						stackObj.push(sc.nextInt());
						System.out.println("added...!!!");
						break;
					case 2:
						int elem = stackObj.pop();
						System.out.println("Poped Element : "+elem);
						break;
					case 3 :
						System.out.println("Stack : ");
						stackObj.showStack();
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
