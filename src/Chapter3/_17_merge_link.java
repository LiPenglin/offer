package Chapter3;
/**
 * 面试题17：合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class _17_merge_link {
	public static void main(String[] args) {
		_17_Node node_1 = new _17_Node(1);
		node_1.p_next = new _17_Node(3);
		node_1.p_next.p_next = new _17_Node(5);
		_17_Node node_2 = new _17_Node(2);
		node_2.p_next = new _17_Node(4);
		node_2.p_next.p_next = new _17_Node(6);
		_17_function f = new _17_function();
		_17_Node res = f.merge(node_1, node_2);
		while(res != null) {
			System.out.println(res.data);
			res = res.p_next;
		}
	}
}

class _17_function {
	_17_Node merge(_17_Node node_1, _17_Node node_2) {
		if (node_1 == null) return node_2;
		else if (node_2 == null) return node_1;
		
		_17_Node merge_node = null;
		
		if (node_1.data <= node_2.data) {
			merge_node = node_1;
			merge_node.p_next = merge(node_1.p_next, node_2);
		} else {
			merge_node = node_2;
			merge_node.p_next = merge(node_1, node_2.p_next);
		}
		
		return merge_node;
	}
}
class _17_Node {
	int data;
	_17_Node p_next;
	public _17_Node(int data) {
		this.data = data;
		this.p_next = null;
	}
}