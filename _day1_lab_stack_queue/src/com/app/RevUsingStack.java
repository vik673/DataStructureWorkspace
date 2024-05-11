package com.app;

import java.util.Scanner;

import collections.IStack;
import collections.StackImpl;

public class RevUsingStack {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Enter size of the stack : ");
			int max = sc.nextInt();
			IStack<Integer> stack = new StackImpl<Integer>(max);
			for(int i = 0 ;i< max; i++) {
				System.out.println("Enter the element : ");
				stack.push(sc.nextInt());
			}
			
			for(int i = 0 ; i < max ; i++)
				System.out.println(stack.pop());
		}
	}
	
	
}
