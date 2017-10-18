package Chapter2;

/**
 * 面试题6：重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树。
 */

public class _06_binaryTree {
	public static void main(String[] args) {
		int []pre = {1,2,4,7,3,5,6,8};
		int []in = {4,7,2,1,5,3,8,6};
		int []post = {7, 4, 2, 5, 8, 6, 3, 1}; // 后序遍历
		_06_function f = new _06_function();
		_06_function.TreeNode res1 = f.createTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		_06_function.TreeNode res2 = f.createTreeByINNPost(in, 0, in.length - 1, post, 0, post.length - 1);
		System.out.println("==============前，中===============");
		f.preOrder(res1);
		System.out.println();
		f.inOrder(res1);
		System.out.println();
		f.postOrder(res1);
		System.out.println();
		System.out.println("==============中，后===============");
		f.preOrder(res2);
		System.out.println();
		f.inOrder(res2);
		System.out.println();
		f.postOrder(res2);
	}
}

class _06_function {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			this.data = data;
		}
	}
	TreeNode createTree(int []pre, int pre_start, int pre_end, int []in, int in_start, int in_end) {
	    if(pre_start > pre_end || in_start > in_end) return null;
		
		TreeNode tree_node = new TreeNode(pre[pre_start]);
		
		for (int i = in_start; i <= in_end; i++) {
			if(pre[pre_start] == in[i]) {
				tree_node.left = createTree(pre, pre_start + 1, pre_start + (i - in_start),
						in, in_start, i - 1);
				tree_node.right = createTree(pre, pre_start + (i - in_start) + 1, pre_end,
						in, i + 1, in_end);
			}
		}
		
		return tree_node;
	}
	TreeNode createTreeByINNPost(int []in, int in_start, int in_end, int []post, int post_start, int post_end) {
		if(in_start > in_end || post_start > post_end) return null;
		
		TreeNode tree_node = new TreeNode(post[post_end]);
		
		for (int i = in_end; i >= 0; i--) {
			if(post[post_end] == in[i]) {
				tree_node.left = createTreeByINNPost(in, in_start, i - 1,
						post, post_start, post_end - (in_end - i) - 1);
				tree_node.right = createTreeByINNPost(in, i + 1, in_end,
						post, post_end - (in_end - i), post_end - 1);
			}
		}
		
		return tree_node;
	}
	void preOrder(TreeNode node) {
		if (node != null) {
			System.out.print(node.data + " - ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " - ");
			inOrder(node.right);
		}
	}
	void postOrder(TreeNode node) {
		if(node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " - ");
		}
	}
}
