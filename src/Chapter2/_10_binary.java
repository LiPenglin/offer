package Chapter2;

/**
 * 面试题10：二进制中1的个数
 *输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class _10_binary {
	public static void main(String[] args) {
		_10_function f = new _10_function();
//		int count = f.counter(-128); // 1000 0000, 0111 1111, 1000 0000 
		int count = f.counter(127);
		System.out.println(count);
	}
}


class _10_function {
	int counter(int num) {
		int count = 0;
		byte one = 1;
		while(one != 0) {
			// 0 与，1或，1与 1 筛选
			if((num & one) != 0) count ++;
			one <<= 1;
		}
		return count;
	}
}