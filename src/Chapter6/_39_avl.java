package Chapter6;

/**
 * 面试题39：二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class _39_avl {
	public static void main(String[] args) {
		TreeNodeI root = new TreeNodeI(1);
		root.left = new TreeNodeI(2);
		root.right = new TreeNodeI(2);
		root.left.left = new TreeNodeI(3);
		root.left.left.left = new TreeNodeI(4);
		System.out.println(new _39_functionI().is_avl(root));
	}
}

class _39_functionI {
	int max = 0x7fffffff;
	// 左右子树 深度差 <= 1
	boolean is_avl(TreeNodeI root) {
		return is_balanced(root) == max ? false : true;
	}
	int is_balanced(TreeNodeI root) {
		if (root == null) return 0;
		int left;
		int right;
		if ((left = is_balanced(root.left)) != max
				&& (right = is_balanced(root.right)) != max) {
				int diff = left - right;
				if (diff <= 1 && diff >= -1) return  1 + (left > right ? left : right);
			}
		return max;
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
