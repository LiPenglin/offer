package Chapter4;

import java.util.Map;
import java.util.HashMap;

public class _26_linked_copy {
	public static void main(String[] args) {
		_26_function f = new _26_function();
		Node randomListNode1 = new Node(1);
        Node randomListNode2 = new Node(2);
        Node randomListNode3 = new Node(3);
        Node randomListNode4 = new Node(4);
        Node randomListNode5 = new Node(5);
        randomListNode1.next=randomListNode2;
        randomListNode2.next=randomListNode3;
        randomListNode3.next=randomListNode4;
        randomListNode4.next=randomListNode5;
        randomListNode1.random=randomListNode3;
        randomListNode2.random=randomListNode4;
        randomListNode3.random=null;
        randomListNode4.random=randomListNode2;
        randomListNode5.random=null;
        
        Node pResult = f.linked_clone(randomListNode1);
        Node pResult2 = pResult;
        while(pResult!=null){
            System.out.print(pResult.data+"、");
            pResult=pResult.next;
        }
        System.out.println();
        while(pResult2!=null){
            if(pResult2.random==null){
                System.out.print("#、");
            }else{
                System.out.print(pResult2.random.data+"、");
            }
            pResult2=pResult2.next;
        }
	}
}

class _26_function {
	public Node linked_clone(Node head) {
		Node node = head;
		Map<Node, Node> map = new HashMap<Node, Node>();
		Node new_head = new Node(node.data);
		Node new_node = new_head;
		map.put(node, new_node);
		
		// node 是next
		node = node.next;
		
		while (node != null) {
			new_node.next = new Node(node.data);
			new_node = new_node.next;
			map.put(node, new_node);
			node = node.next;
		}
		node = head;
		while (node != null) {
			if (node.random != null)
				map.get(node).random = map.get(node.random); // node.random 对应的哪个 新的节点
			node = node.next;
		}
		
		return new_head;
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
	public Node() {
		
	}
}