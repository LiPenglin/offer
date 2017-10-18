package Chapter2;

/**
 * ������9���Ʋ���������
 * ����һ������n���������쳲��������еĵ�n�
 * 1��1��2��3��5��8��13��21��34��
 */
/*
 * �����⣺
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * �����������һ��n����̨���ܹ��ж�����������
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
