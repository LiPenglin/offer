package Chapter2;

import java.util.Stack;

/**
 * ������5����β��ͷ��ӡ����
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */

/*
 * 1. �ݹ�
 * 2. ��
 */

public class _05_link {
	public static void main(String[] args) {
		// ����
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
	// ��
	void listReverseByRecursion(ListNode pHead) {
		if (pHead != null) {
			if (pHead.next != null) listReverseByRecursion(pHead.next);
			System.out.print(pHead.data + "\0");
		}
	}
	// ջ
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
		System.out.println("----�ݹ� ");
		listReverseByStack(pHead.next);
		System.out.println("--stack");
	}
}
