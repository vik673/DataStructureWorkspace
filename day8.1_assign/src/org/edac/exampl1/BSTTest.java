package org.edac.exampl1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTTest {

	@Test
	void test() {
		BST bst = new BST();
		bst.Insert(5);
		bst.Insert(2);
		bst.Insert(1);
		bst.Insert(3);
		bst.Insert(10);
		bst.Insert(9);
		bst.Insert(20);
		
		assertTrue(bst.SearchBST(3));
		assertFalse(bst.SearchBST(11));

	}
	@Test
	void test2() {
		BST bst = new BST();
		
		bst.Insert(10);

		System.out.println(bst.PreOrder());
		System.out.println("\n-------------------------");
		
		assertThrows(RuntimeException.class, ()->{
			bst.Delete(5);
		});
		assertFalse(bst.SearchBST(5));
		System.out.println(bst.PreOrder());

	}
	@Test
	void test3() {
		BST bst = new BST();
		bst.Insert(5);
		bst.Insert(2);
		bst.Insert(1);
		bst.Insert(3);
		bst.Insert(10);
		bst.Insert(7);
		bst.Insert(6);
		bst.Insert(8);
		bst.Insert(9);
		bst.Insert(20);
		bst.Insert(15);
		bst.Insert(12);
		bst.Insert(18);
		bst.Insert(25);
		

		System.out.println(bst.PreOrder());
		System.out.println("\n-------------------------");
		
		assertThrows(RuntimeException.class, ()->{
			bst.Delete(5);
		});
		assertFalse(bst.SearchBST(5));
		System.out.println(bst.PreOrder());

	}

}
