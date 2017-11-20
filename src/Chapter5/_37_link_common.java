package Chapter5;

public class _37_link_common {

}
class _37_function {
	Node first_common(Node head1, Node head2) {
		if (head1 == null || head2 == null) return null;
		int n = 100;
		int top1 = 0;
		int top2 = 0;
		Node []stack1 = new Node[n];
		Node []stack2 = new Node[n];
		
		Node p1 = head1;
		Node p2 = head2;
		while(p1 != null) {
			stack1[top1++] = p1;
			p1 = p1.next;
		}
		while(p2 != null) {
			stack2[top2++] = p2;
			p2 = p2.next;
		}
		while(top1 >= 1 && top2 >= 1) {
			// 非第一个
			if (stack1[--top1] != stack2[--top2]) return stack1[++top1];
		}
		// 第一个
		return stack1[top1];
	}
}
class Node {
	int data;
	Node next;
	Node random;
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.random = null;
	}
}