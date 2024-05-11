package collections;

public class SortedCircularLinkedList<T extends Comparable<T>> implements ISortedLinkedList<T> {

	private DoublyListNode<T> head;

	public SortedCircularLinkedList() {
		head = new DoublyListNode<>();
		head.next = head;
		head.prev = head;
	}

	@Override
	public void insert(T e) {
		DoublyListNode<T> newNode = new DoublyListNode<>(e);
		DoublyListNode<T> cur = head.next;
		if (head.prev != head && head.prev.data.compareTo(e) <= 0) {
			newNode.next = head;
			newNode.prev = head.prev;
			newNode.prev.next = newNode;
			head.prev = newNode;
			return;
		}

		while (cur != head) {
			if (cur.data.compareTo(e) > -1) {
				newNode.next = cur;
				newNode.prev = cur.prev;
				newNode.prev.next = newNode;
				cur.prev = newNode;
				return;
			}
			cur = cur.next;
		}
		newNode.next = head;
		newNode.prev = head.prev;
		newNode.prev.next = newNode;
		head.prev = newNode;
	}

	@Override
	public Object[] getAllElements() {
		Object[] elements = new Object[getNodeCount()];
		DoublyListNode<T> cur = head.next;
		int i = 0;
		while (cur != head) {
			elements[i] = cur.data;
			cur = cur.next;
			i++;
		}

		return elements;
	}
	
	public int getNodeCount() {
		int count = 0;
		DoublyListNode<T> cur = head.next;
		while (cur != head) {
			cur = cur.next;
			count++;
		}

		return count;
	}

}