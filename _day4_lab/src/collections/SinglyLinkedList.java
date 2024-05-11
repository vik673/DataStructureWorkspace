package collections;

import java.util.HashSet;

public class SinglyLinkedList<T> implements ILinkedList<T> {

	public SinglyListNode<T> head;

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
		if (cur.data.equals(e)) {
			head = head.next;
		}
		while (cur.next != null) {
			if (cur.next.data.equals(e)) {
				cur.next = cur.next.next;
				break;
			}
			cur = cur.next;
		}
	}

	@Override
	public int countFrequency(T e) {
		int count = 0;

		SinglyListNode<T> cur = head;
		while (cur != null) {
			if (cur.data.equals(e))
				count++;
			cur = cur.next;
		}

		return count;
	}

	public void deleteAll(T e) {
		SinglyListNode<T> cur = head;
		SinglyListNode<T> prev = null;
		while (cur != null) {
			if (cur.data.equals(e)) {
				if (cur == head) {
					head = head.next;
				} else {
					prev.next = cur.next;
					cur = prev;
				}
			}
			prev = cur;
			cur = cur.next;
		}

	}

	public void reverse() {
		if (head == null)
			return;
		SinglyListNode<T> cur = head;
		SinglyListNode<T> nxt = cur.next;
		SinglyListNode<T> prev = null;
		while (cur != null) {
			cur.next = prev;
			prev = cur;
			cur = nxt;
			if (nxt != null)
				nxt = nxt.next;
		}
		head = prev;

	}

	public boolean hasLoop() {
		SinglyListNode<T> cur = head;
		int count = 0;
		while (cur != null) {
			SinglyListNode<T> cur2 = head;
			for (int i = 0; i < count - 1; i++) {
				if (cur == cur2)
					return true;
				cur2 = cur2.next;
			}
			count++;
			cur = cur.next;
		}
		return false;
	}

	public boolean hasLoopUsingHashSet() {
		HashSet<SinglyListNode<T>> set = new HashSet<>();

		SinglyListNode<T> cur = head;
		while (cur != null) {
			if (set.contains(cur))
				return true;
			set.add(cur);
			cur = cur.next;
		}
		return false;
	}

	public boolean hasIntersection(SinglyLinkedList<T> list2) {
		SinglyListNode<T> cur1 = this.head;
		SinglyListNode<T> cur2 = list2.head;
		while (cur1.next != null && cur2.next != null) {

			if (cur1 == cur2)
				return true;

			cur2 = cur2.next;
			cur1 = cur1.next;
		}
		if (cur1.next == null)
			while (cur2.next == null) {
				if (cur2 == cur1)
					return true;

				cur2 = cur2.next;
			}
		if (cur2.next == null)
			while (cur1.next == null) {
				if (cur2 == cur1)
					return true;

				cur1 = cur1.next;
			}

		return cur1 == cur2;
	}

}
