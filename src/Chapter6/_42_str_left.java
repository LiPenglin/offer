package Chapter6;

/**
 * ������42-��Ŀ2���ַ�������ת
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * ����һ���������ַ�����S���������ѭ������Kλ���������������磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 * �ǲ��Ǻܼ򵥣�OK���㶨����
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
