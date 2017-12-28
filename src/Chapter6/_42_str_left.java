package Chapter6;

/**
 * 面试题42-题目2：字符串左旋转
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */

public class _42_str_left {
	public static void main(String[] args) {
		char []str = "abcXYZdef".toCharArray();
		new _42_functionI().swap(str, 3);
	}
}

class _42_functionI {
	void reverse(char []str, int begin, int end) {
		for(int i = 0; i <= (end - begin) / 2; i++) 
			str[begin + i] = (char) (str[begin + i] + str[end - i] - (str[end - i] = str[begin + i]));
	}
	void swap(char []str, int loc) {
		reverse(str, 0, loc-1); 
		System.out.println(String.valueOf(str));
		reverse(str, loc, str.length - 1);
		System.out.println(String.valueOf(str));
		reverse(str, 0, str.length - 1);
		System.out.println(String.valueOf(str));
	}
}
