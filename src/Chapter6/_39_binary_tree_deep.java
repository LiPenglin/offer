package Chapter6;

/**
 * 面试题39：二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class _39_binary_tree_deep {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
//		root.left.left.left.left.left = new TreeNode(6);
		System.out.println(new _39_function().tree_depth(root));
	}
}

class _39_function {
	int tree_depth(TreeNode root) {
		/*
		 * 树的深度：
		 * max（子树深度）+ 1
		 */
		if (root == null) return 0;
		int left = tree_depth(root.left);
		int right = tree_depth(root.right);
		return 1 + (left > right ? left : right);
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
