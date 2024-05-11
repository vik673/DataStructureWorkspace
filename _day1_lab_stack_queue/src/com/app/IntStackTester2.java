package com.app;

import java.util.Scanner;

import collections.StackImpl;

public class IntStackTester2 {

	static String options = "\t 1. Push element in stack \n\t 2. Pop Element \n\t 3. Peek "
			+ "\n\t 4. Show all \n\t 5. Status \n\t 6. Exit";

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Size of the stack...");
			StackImpl<Integer> intStack = new StackImpl<>(sc.nextInt());
			boolean exit = false;
			while(!exit) {
				try {
					System.out.println(options);
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter an integer to push on stack..");
						intStack.push(sc.nextInt());
						break;
					case 2:
						System.out.println("Popped element : "+intStack.pop());
						break;
					case 3:
						System.out.println("Peek : "+intStack.peek());
						break;
					case 4:
						intStack.showAll();
						break;
					case 5:
						System.out.println("Is empty : "+intStack.isEmpty());
						System.out.println("Is full : "+intStack.isFull());
						break;
					case 6:
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
					System.out.println("Press Enter to continue...");
					sc.nextLine();
				}
				
				
				
			}

		}
	}

}
