package Chapter3;

/*
 * 面试题12：打印 1 到最大的 n 位数
 */
public class _12_printn {
	public static void main(String[] args) {
//		_12_function f = new _12_function();
//		f.print_to_max_n(2);
		_12_functionII f = new _12_functionII();
		f.print_max_to_n(2);
	}
}

class _12_function {
	void print_to_max_n(int n) {
		char []number = new char[n];
		for (int i = 0; i < n; i++) {
			number[i] = '0';
		}
		while(!increment(number)) print_number(number);
	}
	void print_number(char []number) {
		boolean is_begin = true;
		for (char c : number) {
			if (c != '0' && is_begin) is_begin = false; // 第一个非零
			if (!is_begin) System.err.print(c);
		}
		System.err.println();
	}
	boolean increment(char []number) {
		boolean is_over_flow = false;
		int take_over = 0;
		int length = number.length;
		
		for (int i = length - 1; i >= 0; i--) {
			int n = number[i] - '0' + take_over; // 初值，进位
			if (i == length - 1) n++; // 加
			if (n >= 10) { // 处理进位
				if (i == 0) is_over_flow = true;
				else {
					n -= 10;
					take_over = 1;
					number[i] = (char) (n + '0');
				}
			} else {
				number[i] = (char) (n + '0');
				break; // 完成 自加1
			}
			
		}
		return is_over_flow;
	}
}

class _12_functionII {
	void print_max_to_n(int n) {
		char []number = new char[n];
		print_max(number, 0);
	}
	void print_number(char []number) {
		boolean is_begin = true;
		for (char c : number) {
			if (c != '0' && is_begin) is_begin = false; 
			if (!is_begin) System.err.print(c);
		}
		if (!is_begin) System.err.println();
	}
	void print_max(char []number, int index) {
		if (index == number.length) {
			print_number(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index] = (char) (i + '0');
			print_max(number, index + 1);
		}
	}
}