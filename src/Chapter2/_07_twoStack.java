package Chapter2;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

/*
 * 思路：
 * 一个stack 用来 offer
 * 一个stack 用poll
 */

public class _07_twoStack {
	public static void main(String[] args) {
		_07_function f = new _07_function();
		f.offer(4);
		f.offer(6);
		System.out.println(f.poll());
		f.offer(10);
		f.offer(14);
		System.out.println(f.poll());
		System.out.println(f.poll());
		f.offer(16);
		System.out.println(f.poll());
		System.out.println(f.poll());
	}
}

class _07_function {
	private Stack<Integer> offer_stack = new Stack<Integer>();
	private Stack<Integer> poll_stack = new Stack<Integer>();
	
	void offer(Integer value) {
		offer_stack.push(value);
	}
	
	Integer poll() {
//		if (poll_stack.isEmpty()) {
//			if(offer_stack.isEmpty()) {
//				return null;
//			} else {
//				while (!offer_stack.isEmpty()) {
//					poll_stack.push(offer_stack.pop());
//				}
//				return poll_stack.pop();
//			}
//		} else {
//			return poll_stack.pop();
//		}
		if (poll_stack.isEmpty() && offer_stack.isEmpty()) {
			return null;
		}
		if (poll_stack.isEmpty())
			while (!offer_stack.isEmpty()) poll_stack.push(offer_stack.pop());
		return poll_stack.pop();
	}
	
}