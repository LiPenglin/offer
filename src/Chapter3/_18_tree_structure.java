package Chapter3;

public class _18_tree_structure {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
        t1.left=new TreeNode(2);
        t1.right=new TreeNode(3);
        t1.left.left=new TreeNode(4);
        t1.left.right=new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left=new TreeNode(4);
        t2.right=new TreeNode(5);
        
        _18_function f = new _18_function();
        System.out.println(f.has_sub_tree(t1, t2));
        
	}
}

class _18_function {
	boolean has_sub_tree(TreeNode root, TreeNode sub_root) {
		
		if (root == null) return false;
		if (sub_root == null) return true;
		
		boolean is_has = false;
		
		if (root.data == sub_root.data) is_has = is_has_tree(root, sub_root);
		if (!is_has) is_has = has_sub_tree(root.left, sub_root);
		if (!is_has) is_has = has_sub_tree(root.right, sub_root);
		
		return is_has;
		
		
	}
	boolean is_has_tree(TreeNode root, TreeNode sub_root) {
		if (root.left == null && sub_root.left != null) return false;
		else if (root.right == null && sub_root.right != null) return false;
		else if (sub_root.left == null || sub_root.right == null) return true;
		else return root.left.data == sub_root.left.data && root.right.data == sub_root.right.data;
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