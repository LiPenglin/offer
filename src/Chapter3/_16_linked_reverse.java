package Chapter3;
/**
 *  ������16����ת����
 *  ����һ��������ת�����������������Ԫ�ء�
 *  
 *  ����ָ�룬һ·����ȥ����current Ϊ���һ�����տڣ�����
 *  ���ǣ�0��㣬1���
 */
public class _16_linked_reverse {
	public static void main(String[] args) {
		_16_Node node = new _16_Node(1);
		_16_Node p_node = node;
		
		for (int i = 2; i <= 10; i++) {
			_16_Node new_node = new _16_Node(i);
			p_node.p_next = new_node;
			p_node = new_node;
		}
		
		p_node = node;
		_16_function f = new _16_function();
		
		p_node = f.reverse_link(p_node);
		
		while(p_node != null) {
			System.out.print(p_node.data + " / ");
			p_node = p_node.p_next;
		}
	}
}

class _16_function {
	_16_Node reverse_link(_16_Node current) {
		if (current == null) return current;
		
		_16_Node pre = null;
		_16_Node next = current.p_next;
		
		while (next != null) {
			current.p_next = pre;
			pre = current;
			current = next;
			next = current.p_next;
			if (next == null) current.p_next = pre;
		}
		return current;
		
	}
}

class _16_Node {
	int data;
	_16_Node p_next;
	public _16_Node(int data) {
		this.data = data;
		this.p_next = null;
	}
}