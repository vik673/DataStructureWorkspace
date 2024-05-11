import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	//@Test
	void testPreOrder() {
		BinaryTree bt = new BinaryTree();
		int[] elems = bt.BuildTreeForPreOrder();
		List<Integer> traversalResult = bt.PreOrder();
		System.out.println("PreOrder() : "+traversalResult);
		System.out.println("\n------------------------------");
		List<Integer> traversalResult2 = bt.InOrder();
		System.out.println("InOrder() : "+traversalResult2);
		System.out.println("\n------------------------------");
		List<Integer> traversalResult3 = bt.PostOrder();
		System.out.println("PostOrder() :"+traversalResult3);


		//System.out.println(Arrays.toString(traversalResult));
		System.out.println("\nbt.GetNodesCount() : "+bt.GetNodesCount());
		
		System.out.println("bt.CountLeafNodes() : "+bt.CountLeafNodes());
		
		System.out.println("bt.FindFrequency(20) : "+bt.FindFrequency(20));
		
		System.out.println("bt.Height() : "+bt.Height());
		
		BinaryTreeNode node = bt.MakeMirror();

	}
	
	@Test
	void testLevelOrderTraversal() {
		BinaryTree bt = new BinaryTree();
		int[] elems = bt.BuildTreeForPreOrder();
		List<Integer> traversalResult2 = bt.InOrder();
		System.out.println("InOrder() : "+traversalResult2);
		System.out.println("\n------------------------------");

		System.out.println(Arrays.asList(bt.LevelOrderTraversal()));
	}

}
