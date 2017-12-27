package Chapter6;

/**
 * ������39�������������
 * ����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
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
		 * ������ȣ�
		 * max��������ȣ�+ 1
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
