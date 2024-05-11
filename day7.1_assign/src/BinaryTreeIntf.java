import java.util.List;

public interface BinaryTreeIntf {
	public List<Integer> PreOrder();
	public List<Integer> PostOrder();
	public List<Integer> InOrder();

	// Count number of nodes in a binary tree.
	int GetNodesCount();

	// Find height of a binary tree.
	int Height();

	// Count frequency of an element in a binary tree
	int FindFrequency(int element);

	// Count number of leaf nodes in a binary tree
	int CountLeafNodes();

	// Convert tree into mirror image.
	BinaryTreeNode MakeMirror();
	
	//level order traversal using queue
	int[] LevelOrderTraversal();
	
}
