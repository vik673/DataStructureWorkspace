package tester;


import java.util.*;

import com.app.core.*;
import com.app.core.Queue;

public class Tester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
		    System.out.println("\n\n\t\"---Circular Queue---\"\n");
		    System.out.print("Enter Size : ");
		    CircularQueue qObject = new Queue(sc.nextInt());
		    boolean exit = false;
		    while(!exit){
		        System.out.print("\nMENU"
		        					+"\n1. Add Element"
		        					+ "\n2. Delete Element"
		        					+ "\n3.Traverse"
		        					+ "\nChoice::");
	
		        switch(sc.nextInt()){
		            case 1:
		                if(qObject.isFull()){
		                    System.out.println("\nQueue is Full..!!!");
		                }
		                else{
		                    System.out.println("\nEnter Adding element::");
		                    qObject.add(sc.nextInt());
		                }
		                break;
		            case 2:
		                if(qObject.isEmpty()){
		                    System.out.println("Queue is Empty..!!");
		                }
		                else{
		                    qObject.delete();
		                    System.out.println("\nElement is deleted from Queue...");
		                }
		                break;
		            case 3:
		                if(qObject.isEmpty()){
		                    System.out.println("Queue is Empty..!!");
		                }
		                else{
		                    qObject.traverse();
		                }
		                break;
		            default:
		                System.out.println("Choose Correct Choice!!!");
		        }
		    }	
		}
	}
}
