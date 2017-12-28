package Chapter6;

/**
 * 面试题40：数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

public class _40_once_in_arr {
	public static void main(String[] args) {
		_40_function f = new _40_function();
		int[] arr={2,4,3,6,3,2,5,5};
		f.get_once_num(arr);
	}
}

class _40_function {
	void get_once_num(int []arr) {
		int num = 0;
		for (int a : arr) num ^= a;
		
		// 找到 相异位置
		int len = 0;
		while ((num & 1) == 0) {
			len ++;
			num = num >> 1;
		}
		int x = 0, y = 0;
		
		// 分组
		for (int a : arr) {
			if ((a >> len & 1) == 0) x^=a;
			else y^=a;
		}
		System.out.println(x + "/ " + y);
	}
}