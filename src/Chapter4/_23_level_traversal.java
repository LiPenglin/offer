package Chapter4;
/**
 * 面试题23：从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class _23_level_traversal {
	public static void main(String[] args) {
		TreeNodeI t1 = new TreeNodeI(1);
        t1.left=new TreeNodeI(2);
        t1.right=new TreeNodeI(3);
        t1.left.left=new TreeNodeI(4);
        t1.left.right=new TreeNodeI(5);
        t1.right.left=new TreeNodeI(6);
        t1.right.right=new TreeNodeI(7);
        
        _23_function f = new _23_function();
        f.traversal(t1);
	}
}

class _23_function {
	void traversal(TreeNodeI root) {
		int front = 0;
		int tail = 0;
		int count = 100; // bug 没做满队列判断
		int storage = 0;
		TreeNodeI []queue = new TreeNodeI[count];
		
		queue[front++%count] = root;
		storage++;
		
		while(storage-- > 0) {
			TreeNodeI tmp = queue[tail++%count];
			System.out.println(tmp.data);
			if (tmp.left != null) {
				queue[front++%count] = tmp.left;
				storage++;
			}
			if (tmp.right != null) {
				queue[front++%count] = tmp.right;
				storage++;
			}
		}
	}
}

class TreeNodeI {
	int data;
	TreeNodeI left;
	TreeNodeI right;
	public TreeNodeI(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
