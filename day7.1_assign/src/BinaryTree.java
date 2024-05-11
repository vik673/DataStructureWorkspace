import java.util.*;


public class BinaryTree implements BinaryTreeIntf {
	BinaryTreeNode root;
	BinaryTreeNode node;
	List<Integer> array;
	int count = 0;
	
	public BinaryTree() {
		root = null;
		array = new ArrayList<>();
	}

	private List<Integer> PreOrderHelper(BinaryTreeNode root, List<Integer>array) {
		// if root is empty then Stop
		if (root == null) {
			return null;
		}
		// Process root node's data.
		array.add(root.data);
		// if root node's left child exists then
		if (root.lChild != null) {
			// PreOrder(root's left child)
			PreOrderHelper(root.lChild, array);
		}
		// if root node's right child exists then
		if (root.rChild != null) {
			// PreOrder(root's right child)
			PreOrderHelper(root.rChild, array);
		}
		return array;
	}

	private List<Integer> InOrderHelper(BinaryTreeNode root, List<Integer>array) {
		// if root is empty then Stop
		if (root == null) {
			return null;
		}
		// if root node's left child exists then
		if (root.lChild != null) {
			// PreOrder(root's left child)
			InOrderHelper(root.lChild, array);
		}
		// Process root node's data.
		array.add(root.data);
		// if root node's right child exists then
		if (root.rChild != null) {
			// PreOrder(root's right child)
			InOrderHelper(root.rChild, array);
		}
		return array;
	}

	private List<Integer> PostOrderHelper(BinaryTreeNode root, List<Integer>array) {
		// if root is empty then Stop
		if (root == null) {
			return null;
		}
		// if root node's left child exists then
		if (root.lChild != null) {
			// PreOrder(root's left child)
			PostOrderHelper(root.lChild, array);
		}
		// if root node's right child exists then
		if (root.rChild != null) {
			// PreOrder(root's right child)
			PostOrderHelper(root.rChild, array);
		}
		// Process root node's data.
		array.add(root.data);
		return array;
	}
	public int GetNodesCountHelper(BinaryTreeNode root) {
		if(root == null)
			return 0;
		return 1 + GetNodesCountHelper(root.lChild) + GetNodesCountHelper(root.rChild);
	}
	
	public int GetHeightHelper(BinaryTreeNode root) {
		if(root == null)
			return 0;
		int lheight = GetHeightHelper(root.lChild);
		int rheight = GetHeightHelper(root.rChild);
		
		if(lheight > rheight)
			return lheight+1;
		return rheight + 1;
	}
	
	public int FindFrequecyHelper(BinaryTreeNode root, int element,int cnt) {
		if(root == null)
			return 0;
		if(root.data == element) {
			System.out.println("root.data : "+root.data);
			count++;
		}
		FindFrequecyHelper(root.lChild, element, cnt);
		FindFrequecyHelper(root.rChild, element, cnt);
		return count;
	}
	
	public int CountLeafNodesHelper(BinaryTreeNode root, int cnt) {
		if(root == null)
			return 0;
		if(root.lChild == null && root.rChild == null)
			count++;
		CountLeafNodesHelper(root.lChild, cnt);
		CountLeafNodesHelper(root.rChild, cnt);
		return count;	
	}
	
	public BinaryTreeNode MakeMirrorHelper(BinaryTreeNode root) {
        if (root == null)
            return root;
 
        BinaryTreeNode left = MakeMirrorHelper(root.lChild);
        BinaryTreeNode right = MakeMirrorHelper(root.rChild);
 
        root.lChild = right;
        root.rChild = left;
 
		return root;
	}
	
	@Override
	public List<Integer> PreOrder() {
		List<Integer> array = new ArrayList<>();
		return PreOrderHelper(root, array);
	}

	@Override
	public List<Integer> InOrder() {
		return InOrderHelper(root, new ArrayList<Integer>());
	}

	@Override
	public List<Integer> PostOrder() {
		return PostOrderHelper(root,  new ArrayList<Integer>());
	}
	
	@Override
	public int GetNodesCount() {
		return GetNodesCountHelper(root);
	}

	@Override
	public int Height() {
		count = 0;
		return GetHeightHelper(root);
	}

	@Override
	public int FindFrequency(int element) {
		count = 0;
		return FindFrequecyHelper(root, element, 0);
	}

	@Override
	public int CountLeafNodes() {
		count=0;
		return CountLeafNodesHelper(root, 0);
	}

	@Override
	public BinaryTreeNode MakeMirror() {
		node = MakeMirrorHelper(root);
		System.out.println( PreOrderHelper(node, new ArrayList<Integer>()));
		return node;
	}
	
	public int[] BuildTreeForPreOrder() {
		int[] element = new int[4];
		element[0] = 1;
		element[1] = 2;
		element[2] = 4;
		element[3] = 3;

		root = new BinaryTreeNode(50);
		root.lChild = new BinaryTreeNode(30);
		root.rChild = new BinaryTreeNode(70);
		root.lChild.lChild = new BinaryTreeNode(20);
		root.lChild.rChild = new BinaryTreeNode(40);
		root.rChild.lChild = new BinaryTreeNode(60);
		
		return element;
	}

	@Override
	public int[] LevelOrderTraversal() {
		int[] result = new int[GetNodesCount()];
		/* If root is empty */
		if(root == null)
			return result;
		
		int count = 0;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		//add root node
		q.add(root);
		
		//while queue is not empty do
		while(q.size() != 0) {
			//remove the node
			BinaryTreeNode node = q.remove();
			
			//process the node
			System.out.print(node.data + ", ");
			result[count++] = node.data;
			
			//check for the left child
			if(node.lChild != null) {
				q.add(node.lChild);
			}
			//check for right child
			if(node.rChild != null) {
				q.add(node.rChild);
			}
		}
		return result;
	}
}