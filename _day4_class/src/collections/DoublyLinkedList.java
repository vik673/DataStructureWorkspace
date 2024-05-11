package collections;

public class DoublyLinkedList<T> implements ILinkedList<T> {

	private DoublyListNode<T> head;
	private DoublyListNode<T> tail;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	@Override
	public void addAtFront(T e) {
		DoublyListNode<T> newNode = new DoublyListNode<>(e);
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	@Override
	public void addAtRear(T e) {
		DoublyListNode<T> newNode = new DoublyListNode<>(e);
		if (tail == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;

	}

	@Override
	public Object[] getAllElements() {
		Object[] elements = new Object[getNodeCount()];
		DoublyListNode<T> cur = head;
		int i = 0;
		while (cur != null) {
			elements[i] = cur.data;
			cur = cur.next;
			i++;
		}

		return elements;
	}

	@Override
	public T removeAtRear() {
		if (tail == null)
			throw new RuntimeException("Empty List!!");
		T e = tail.data;
		if (tail == head)
			tail = head = null;
		else {
			tail = tail.prev;
			tail.next = null;
		}
		return e;
	}

	@Override
	public T removeAtFront() {
		if (tail == null)
			throw new RuntimeException("Empty List!!");
		T e = head.data;
		if (head == tail)
			head = tail = null;
		else {
			head = head.next;
			head.prev = null;
		}
		return e;
	}

	@Override
	public void delete(T e) {
		DoublyListNode<T> cur = head;
		if (head == null)
			throw new RuntimeException("Empty List!!");
		while (cur != null && !cur.data.equals(e)) {
			cur = cur.next;
		}
		if (cur == null)
			return;
		if (cur == head && head == tail)
			head = tail = null;
		if (cur == head) {
			head = head.next;
			head.prev = null;
			return;
		}

		if (cur == tail) {
			tail = tail.prev;
			tail.next = null;
			return;
		}
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;

	}

	public void deleteUsingTail(T e) {
		DoublyListNode<T> cur = tail;
		if (tail == null)
			throw new RuntimeException("Empty List!!");
		while (cur != null && !cur.data.equals(e)) {
			cur = cur.prev;
		}
		if (cur == null)
			return;
		if (cur == head && head == tail) {
			head = tail = null;
			return;
		}	
		if (cur == head) {
			head = head.next;
			head.prev = null;
			return;
		}

		if (cur == tail) {
			tail = tail.prev;
			tail.next = null;
			return;
		}
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;

	}

	public int getNodeCount() {
		int count = 0;
		DoublyListNode<T> cur = head;
		while (cur != null) {
			cur = cur.next;
			count++;
		}

		return count;
	}

	public Object[] getInReverseOrder() {
		Object[] elements = new Object[getNodeCount()];
		return elements;
	}

	@Override
	public int countFrequency(T e) {
		int count = 0;

		DoublyListNode<T> cur = head;
		while (cur != null) {
			if (cur.data.equals(e))
				count++;
			cur = cur.next;
		}

		return count;
	}

}
