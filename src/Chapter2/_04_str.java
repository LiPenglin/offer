package Chapter2;

/**
 * ������4���滻�ַ�
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */

/*
 * ˼·��
 * 1. �滻֮���ַ������С
 * 2. char arr A > char arr B
 */

public class _04_str {
	
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder();
		str.append("hello ");
		str.append("every ");
		str.append("body ");
		_04_function f = new _04_function();
		String ans = f.replace_space(str);
		System.out.println(ans);
	}
}

class _04_function {
	public String replace_space(StringBuilder str) {
		char []char_arr = str.toString().toCharArray();
		int space_count = 0;
		for (char c : char_arr) {
			if (c == ' ') space_count++;
		}
		int len = str.length() + space_count*2; // ָ��2
		char []new_char = new char[len--];
		for (int i = str.length() - 1; i >= 0; i--) { // ָ��1
			if(char_arr[i] == ' ') {
				new_char[len--] = '0';
				new_char[len--] = '2';
				new_char[len--] = '%';
			} else
				new_char[len--] = char_arr[i];
		}
		return String.valueOf(new_char);
	}
}