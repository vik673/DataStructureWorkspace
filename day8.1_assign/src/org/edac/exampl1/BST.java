package org.edac.exampl1;

import java.util.ArrayList;
import java.util.List;

public class BST {
	TreeNode root;

	public BST() {
		root = null;
	}

	public void Insert(int elem) {
		TreeNode newNode = new TreeNode(elem);
		if (root == null) {
			root = newNode;
			return;
		}
		TreeNode curr = root;
		TreeNode prev = null;
		while (curr != null) {
			if (elem < curr.data) {
				prev = curr;
				curr = curr.lChild;
			} else {
				prev = curr;
				curr = curr.rChild;
			}
		}
		if (elem < prev.data) {
			prev.lChild = newNode;
		} else {
			prev.rChild = newNode;
		}
	}

	public void Delete(int elem) {
		TreeNode curr = root;
		TreeNode prev = null;
		while (curr != null) {
			if (curr.data == elem) {
				break;
			} else if (elem < curr.data) {
				prev = curr;
				curr = curr.lChild;
			} else {
				prev = curr;
				curr = curr.rChild;
			}
		}
		if (curr != null) {
			if (curr.lChild == null && curr.rChild == null) {
				if (curr == root) {
					root = null;
					return;
				}
				if (prev.lChild == curr) {
					prev.lChild = null;
				} else {
					prev.rChild = null;
				}
			} else {
				prev = curr;
				TreeNode prev2 = curr;
				if (curr.rChild != null) {
					curr = curr.rChild;
					while (curr.lChild != null) {
						prev2 = curr;
						curr = curr.lChild;
					}
					prev.data = curr.data;
					prev2.lChild = null;
				} else {
					curr = curr.lChild;
					while (curr.rChild != null) {
						prev2 = curr;
						curr = curr.rChild;
					}
					prev.data = curr.data;
					prev2.rChild = null;
				}
			}
		} else {
			throw new RuntimeException("Element not found...!!");
		}
	}

	public boolean SearchBST(int elem) {
		TreeNode curr = root;
		while (curr != null) {
			if (curr.data == elem) {
				return true;
			} else if (elem < curr.data) {
				curr = curr.lChild;
			} else {
				curr = curr.rChild;
			}
		}
		return false;
	}

	private List<Integer> PreOrderHelper(TreeNode root, List<Integer> array) {
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

	public List<Integer> PreOrder() {
		List<Integer> array = new ArrayList<>();
		return PreOrderHelper(root, array);
	}

	public int[] BuildBinarySearchTree() {
		int[] element = new int[4];
		element[0] = 1;
		element[1] = 2;
		element[2] = 4;
		element[3] = 3;
		element[4] = 4;
		element[5] = 5;

		root = new TreeNode(5);
		root.lChild = new TreeNode(2);
		root.rChild = new TreeNode(10);
		root.lChild.lChild = new TreeNode(1);
		root.rChild.rChild = new TreeNode(20);
		root.rChild.lChild = new TreeNode(9);

		return element;
	}
}