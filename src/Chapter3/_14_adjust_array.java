package Chapter3;

import java.util.stream.IntStream;

/**
 * ������14����������˳��ʹ����λ��ż����ǰ��
 */

public class _14_adjust_array {
	public static void main(String[] args) {
		_14_function f = new _14_function();
		int []arr = IntStream.range(1, 20).toArray(); //һ���������ϴ���һ��Ԫ������
		f.reorder(arr);
		IntStream.of(arr).forEach(System.out::println);
		
	}
}
class _14_function {
	void reorder(int []arr) {
		if (arr == null || arr.length == 0) return;
		int p_left = -1;
		int p_right = arr.length;
		while (p_left < p_right) {
			while (p_left < p_right && is_large_8(arr[++p_left]));
			while (p_left < p_right && !is_large_8(arr[--p_right]));
			if (p_left < p_right) arr[p_left] = arr[p_left] + arr[p_right] - (arr[p_right] = arr[p_left]);
		}
	}
	boolean is_even(int n) {
		return (n & 1) == 0;
	}
	boolean is_large_8(int n) {
		return (n - 8) > 0; 
	}
}
