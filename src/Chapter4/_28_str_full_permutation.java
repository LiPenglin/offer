package Chapter4;
/**
 * ������28���ַ���������
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 */
public class _28_str_full_permutation {
	public static void main(String[] args) {
		_28_function f = new _28_function();
		f.permutation("abc".toCharArray(), 0);
	}
}

class _28_function {
	/*
	 * 1. ��
	 * 2. ֻ��first�ж�����
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