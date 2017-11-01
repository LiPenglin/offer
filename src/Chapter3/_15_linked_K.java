package Chapter3;

/**
 * 面试题15：链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class _15_linked_K {
	public static void main(String[] args) {
		_15_function f = new _15_function();
		Node node = new Node(1);
		Node p_node = node;
		
		for (int i = 2; i <= 10; i++) {
			Node new_node = new Node(i);
			p_node.p_next = new_node;
			p_node = new_node;
		}
		p_node = node;
		while(p_node != null) {
			System.out.print(p_node.data + " / ");
			p_node = p_node.p_next;
		}
		System.out.println(" n = 3 ");
		System.out.println(f.find(node, 3).data);
	}
}

class _15_function {
	Node find(Node p_right, int n) {
		if (p_right == null || n - 1 <= 0 ) return p_right;
		Node p_left = p_right;
		for(int i = 0; i < n - 1; i++) {
			if (p_right != null) p_right = p_right.p_next;
			else return p_right;
		}
		while (p_right.p_next != null) { // 移动到最后一个
			p_left = p_left.p_next;
			p_right = p_right.p_next;
		}
		return p_left;
	}
}

class Node {
	int data;
	Node p_next;
	public Node(int data) {
		this.data = data;
		this.p_next = null;
	}
}
