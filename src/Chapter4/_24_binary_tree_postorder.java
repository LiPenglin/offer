package Chapter4;
/**
 * ������24�������������ĺ����������
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
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
		// ������ <= root
		for (int i = start; i < end; i++) {
			if (sequence[i] >= root) {
				mid = i;
				break;
			}
		}
		// ������ >= root
		for (int i = mid; i < end; i++) {
			if (sequence[i] < root) return false;
		}
		return is_BST(sequence, start, mid - 1) && is_BST(sequence, mid, end-1);
	}
}