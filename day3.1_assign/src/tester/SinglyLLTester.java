package tester;
import java.util.*;

import com.app.core.SinglyLinkedList;

public class SinglyLLTester {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("---singly linked list---");
			list.AddAtFront(10);
			list.AddAtPos(30, 2);
			list.AddAtRear(40);
			list.AddAtFront(5);
			list.AddAtPos(60, 2);
			
			for(int i : list.GetAllElements()) {
				System.out.print(i+" | ");
			}
		}
	}
}
