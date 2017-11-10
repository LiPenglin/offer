package Chapter5;

import java.util.TreeSet;

/**
 * ������30����С��K����
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 */
public class _30_min_k_number {
	public static void main(String[] args) {
		int []arr = {4,5,1,6,2,7,3,8};
		_30_function f = new _30_function();
		int k = 4;
		f.get_least_num(arr, k);
	}
}

class _30_function {
	void get_least_num(int []arr, int k) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0, j = 0; i < arr.length; i++) {
			if (++j <= k) set.add(arr[i]);
			else {
				int last = set.last();
				if (arr[i] < last) {
					set.remove(last);
					set.add(arr[i]);
				}
			}
		}
		set.stream().forEach(System.out::println);
	}
}