package tester;

import com.app.core.Queue;
import com.app.core.Stack;

public class CheckStackQueue {

	public static void main(String[] args) {
		Stack stack = new Stack(5);
		int[] arr = {1, 2, 3, 4};
		stack.revStackCheck(stack, arr);
		Queue queue = new Queue(5);
		queue.revQueueCheck(queue, arr);
	}

}