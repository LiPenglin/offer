package Chapter4;

public class _19_tree_mirror {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
        t1.left=new TreeNode(2);
        t1.right=new TreeNode(3);
        t1.left.left=new TreeNode(4);
        t1.left.right=new TreeNode(5);
        t1.right.left=new TreeNode(6);
        t1.right.right=new TreeNode(7);
        
        _19_function f = new _19_function();
        f.mirror(t1);
        f.pre_order(t1);
	}
	
}

class _19_function {
	void mirror(TreeNode node) {
		if (node == null) return;
		if (node.left == null && node.right == null) return;
		
		TreeNode left_node = node.left;
		node.left = node.right;
		node.right = left_node;
		
		if (node.left != null) mirror(node.left);
		if (node.right != null) mirror(node.right);
	}
	void pre_order(TreeNode node) {
		if (node == null) return;
		System.out.println(node.data);
		pre_order(node.left);
		pre_order(node.right);
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}