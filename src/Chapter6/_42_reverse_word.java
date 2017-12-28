package Chapter6;

public class _42_reverse_word {
	public static void main(String[] args) {
		char []str = "hello world.".toCharArray();
		new _42_function().swap(str);
	}
}

class _42_function {
	void reverse(char []str, int begin, int end) {
		for(int i = 0; i <= (end - begin) / 2; i++) 
			str[begin + i] = (char) (str[begin + i] + str[end - i] - (str[end - i] = str[begin + i]));
	}
	void swap(char []str) {
		reverse(str, 0, str.length - 1);
		int begin = 0, end = 0;
		for (int i = 0; i < str.length; i++) {
			if (i == str.length - 1) {
				reverse(str, begin, end = i);
			}
			if (str[i] == ' ') {
				end = i - 1;
				reverse(str, begin, end);
				begin = i + 1;
			}
		}
		System.out.println(String.valueOf(str));
	}
}