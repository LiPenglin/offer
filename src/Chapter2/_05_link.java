package Chapter2;

import java.util.Stack;

/**
 * 面试题5：从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */

/*
 * 1. 递归
 * 2. 堆
 */

public class _05_link {
	public static void main(String[] args) {
		// 链表
		Integer []arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		_05_function f = new _05_function();
		f.run(arr);
	}
	
}

class _05_function {
	static class ListNode {
		Integer data;
		public ListNode next;
	}
	ListNode getListNode() {
		return new ListNode();
	}
	// 堆
	void listReverseByRecursion(ListNode pHead) {
		if (pHead != null) {
			if (pHead.next != null) listReverseByRecursion(pHead.next);
			System.out.print(pHead.data + "\0");
		}
	}
	// 栈
	void listReverseByStack(ListNode pHead) {
		Stack<Integer> stack = new Stack<Integer>();
		while(pHead != null) {
			stack.push(pHead.data);
			pHead = pHead.next;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + "\0");
		}
	}
	// run
	void run(Integer []arr) {
		ListNode pHead = getListNode();
		pHead.next = null;
		ListNode pNode = pHead;
		for (int i : arr) {
			ListNode pNew = getListNode();
			pNew.data = i;
			pNew.next = null;
			
			pNode.next = pNew;
			pNode = pNode.next;
		}
		
		listReverseByRecursion(pHead.next);
		System.out.println("----递归 ");
		listReverseByStack(pHead.next);
		System.out.println("--stack");
	}
}
