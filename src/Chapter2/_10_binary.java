package Chapter2;

/**
 * ������10����������1�ĸ���
 *����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
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
			// 0 �룬1��1�� 1 ɸѡ
			if((num & one) != 0) count ++;
			one <<= 1;
		}
		return count;
	}
}