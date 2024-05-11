package collections;

public class SinglyLinkedList<T> implements ILinkedList<T> {

	private SinglyListNode<T> head;

	public SinglyLinkedList() {
		head = null;

	}

	@Override
	public void addAtFront(T e) {
		SinglyListNode<T> newNode = new SinglyListNode<>(e);
		newNode.next = head;
		head = newNode;
	}

	@Override
	public void addAtRear(T e) {
		SinglyListNode<T> newNode = new SinglyListNode<T>(e);
		if (head == null)
			head = newNode;
		else {
			SinglyListNode<T> cur = head;
			while (cur.next != null)
				cur = cur.next;
			cur.next = newNode;
		}

	}

	@Override
	public Object[] getAllElements() {
		Object[] elements = new Object[getNodeCount()];
		SinglyListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			elements[i] = cur.data;
			cur = cur.next;
			i++;
		}
		return elements;
	}

	int getNodeCount() {
		SinglyListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			cur = cur.next;
			i++;
		}
		return i;
	}

	@Override
	public T removeAtRear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeAtFront() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T e) {
		if (head == null)
			throw new RuntimeException("Empty List");
		SinglyListNode<T> cur = head;
		SinglyListNode<T> prev = null;
		while (cur != null && (!cur.data.equals(e))) {
			// if current node's data is element then
			prev = cur;
			cur = cur.next;
		}
		if (cur == null)
			return;
		if (head == cur) {
			head = cur.next;
			return;
		}
		// set prev node's next to current node's next 
		prev.next=cur.next;

	}

	@Override
	public int countFrequency(T e) {
		// TODO Auto-generated method stub
		return 0;
	}

}
