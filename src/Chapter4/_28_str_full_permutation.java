package Chapter4;
/**
 * 面试题28：字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class _28_str_full_permutation {
	public static void main(String[] args) {
		_28_function f = new _28_function();
		f.permutation("abc".toCharArray(), 0);
	}
}

class _28_function {
	/*
	 * 1. 分
	 * 2. 只求first有多少种
	 */
	void permutation(char []str, int border) {
		if (border >= str.length - 1) {
			System.out.println(str);
		} else 
			for (int i = border; i < str.length; i++) {
				str[i] = (char) (str[i] + str[border] - (str[border] = str[i]));
				permutation(str, border + 1);
				str[i] = (char) (str[i] + str[border] - (str[border] = str[i]));
			}
	}
}