package Chapter2;

/**
 * 面试题9：菲波那切数列
 * 输入一个整数n，请你输出斐波那契数列的第n项。
 * 1、1、2、3、5、8、13、21、34、
 */
/*
 * 变形题：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class _09_fibonacci {
	public static void main(String[] args) {
		_09_01_function f = new _09_01_function();
		System.out.println(f.fibonacci(9));
	}
}

class _09_01_function {
	int fibonacci(int n) {
		int []result = {0, 1};
		if(n < 2)  return result[n];
		
		int data = 0;
		int data_first = 0;
		int data_second = 1;
		
		for (int i = 2; i <= n; i++) {
			data = data_first + data_second;
			data_first = data_second;
			data_second = data;
		}
		return data;
	}
}
