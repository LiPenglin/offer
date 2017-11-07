package Chapter4;
/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class _24_binary_tree_postorder {
	public static void main(String[] args) {
		_24_function f = new _24_function();
//		int[] a={5,7,6,9,11,10,8};
//		int []a={7,4,6,5};
//		int []a = {};
		int []a = {4,6,7,5};
		System.out.println(f.is_BST(a, 0, a.length-1));
	}
}

class _24_function {
	boolean is_BST(int []sequence, int start, int end) {
		if (sequence.length == 0) return false;
		if (start >= end) return true;
		int root = sequence[end];
		int mid = end;
		// 左子树 <= root
		for (int i = start; i < end; i++) {
			if (sequence[i] >= root) {
				mid = i;
				break;
			}
		}
		// 右子树 >= root
		for (int i = mid; i < end; i++) {
			if (sequence[i] < root) return false;
		}
		return is_BST(sequence, start, mid - 1) && is_BST(sequence, mid, end-1);
	}
}