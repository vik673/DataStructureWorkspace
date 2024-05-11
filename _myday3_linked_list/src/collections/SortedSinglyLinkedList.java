package collections;

public class SortedSinglyLinkedList<T extends Comparable<T>> implements ISortedLinkedList<T> {

	private SinglyListNode<T> head;

	public SortedSinglyLinkedList() {
		head = null;
	}

	@Override
	public void insert(T e) {
		SinglyListNode<T> newNode = new SinglyListNode<>(e);
		if (head == null)
			head = newNode;
		else {
			SinglyListNode<T> cur = head;
			SinglyListNode<T> prev = null;
			while (cur != null && e.compareTo(cur.data) > -1) {
				prev = cur;
				cur = cur.next;
			}
			if (cur == head) {
				newNode.next=head;
				head=newNode;
			}else {
				prev.next=newNode;
				newNode.next=cur;
			}

		}

	}

	@Override
	public Object[] getAllElements() {
		Object[] arr = new Object[getCount()];
		SinglyListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			arr[i] = cur.data;
			i++;
			cur = cur.next;
		}
		return arr;
	}

	int getCount() {
		SinglyListNode<T> cur;
		cur = head;
		int i = 0;
		while (cur != null) {
			cur = cur.next;
			i++;
		}
		return i;
	}

}
