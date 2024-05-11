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
				newNode.next = head;
				head = newNode;
			} else {
				prev.next = newNode;
				newNode.next = cur;
			}

		}

	}

	public void insertUsingCur(T e) {
		SinglyListNode<T> newNode = new SinglyListNode<>(e);
		if (head == null)
			head = newNode;
		else {
			SinglyListNode<T> cur = head;
			if (head.data.compareTo(e) > -1) {
				newNode.next = head;
				head = newNode;
				return;
			}

			while (cur.next != null) {
				if (cur.next.data.compareTo(e) > -1) {
					newNode.next = cur.next;
					cur.next = newNode;
					return;
				}
				cur = cur.next;
			}
			if (cur.next == null) {
				cur.next = newNode;
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

	public static <C extends Comparable<C>> SortedSinglyLinkedList<C> merge(SortedSinglyLinkedList<C> list1,
			SortedSinglyLinkedList<C> list2) {

		SortedSinglyLinkedList<C> list = new SortedSinglyLinkedList<>();
		SinglyListNode<C> cur1 = list1.head;
		SinglyListNode<C> cur2 = list2.head;
		SinglyListNode<C> cur = list.head;
		while (cur1 != null && cur2 != null) {
			if (cur1.data.compareTo(cur2.data) > -1) {
//				list.addAtRear(cur2.data);
				if (list.head == null) {
					list.head = new SinglyListNode<C>(cur2.data);
					cur = list.head;
				} else {
					cur.next = new SinglyListNode<C>(cur2.data);
					cur = cur.next;
				}

				cur2 = cur2.next;
			} else {
//				list.addAtRear(cur1.data);
				if (list.head == null) {
					list.head = new SinglyListNode<C>(cur1.data);
					cur = list.head;
				} else {
					cur.next = new SinglyListNode<C>(cur1.data);
					cur = cur.next;
				}
				cur1 = cur1.next;
			}
		}
		while (cur1 == null && cur2 != null) {
//			list.addAtRear(cur2.data);

			if (list.head == null) {
				list.head = new SinglyListNode<C>(cur2.data);
				cur = list.head;
			} else {
				cur.next = new SinglyListNode<C>(cur2.data);
				cur = cur.next;
			}

			cur2 = cur2.next;
		}
		while (cur1 != null && cur2 == null) {
//			list.addAtRear(cur1.data);

			if (list.head == null) {
				list.head = new SinglyListNode<C>(cur1.data);
				cur = list.head;
			} else {
				cur.next = new SinglyListNode<C>(cur1.data);
				cur = cur.next;
			}

			cur1 = cur1.next;
		}

		return list;
	}

}
