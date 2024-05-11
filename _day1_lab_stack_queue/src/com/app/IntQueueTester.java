package com.app;

import java.util.Scanner;

import collections.IQueue;
import collections.QueueImpl;

public class IntQueueTester {

	static String options = "\t 1. Add element in Queue \n\t 2. Remove Element \n\t 3. Peek "
			+ "\n\t 4. Exit";

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Size of the Queue...");
			IQueue<Integer> intQueue = new QueueImpl<Integer>(sc.nextInt());
			boolean exit = false;
			while(!exit) {
				try {
					System.out.println(options);
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter an integer to push on Queue..");
						intQueue.add(sc.nextInt());
						break;
					case 2:
						System.out.println("Popped element : "+intQueue.remove());
						break;
					case 3:
						System.out.println("Peek : "+intQueue.peek());
						break;
					case 4:
						System.out.println("Exiting....");
						exit=true;
						break;

					default:
						System.out.println("Invalid input try again...");
						break;
					}
					
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}finally {
					sc.nextLine();
				}
				
				
				
			}

		}
	}

}
