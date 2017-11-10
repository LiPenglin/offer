package Chapter5;
/**
 * ������32����1��n������1���ֵĴ��� ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
 * Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��,���Ƕ��ں�����������û���ˡ�
 * ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
 */
public class _32_count_I {
	public static void main(String[] args) {
		_32_function f = new _32_function();
		System.out.println(f.count_I(13));
	}
}

class _32_function {
	int count_I(int number) {
		int temp = 10; // 10 -> 100 
		int len = String.valueOf(number).length();
		int []data = new int[len];
		int i = len - 1;
		int n = number;
		data[i] = n % 10;
		while ((n = n / 10) > 0) {
			data[--i] = n % 10;
			temp *= 10;
		}
		int count = 0;
		for (int j = 0; j < len; j++) {
			count += number_count(data[j], len-j, number, temp = temp/10);
		}
		return count;
	}
	int number_count(int first, int index, int number, int temp) {
		int count = 0;
		// 10000 - 19999
		if (first == 1) count += (1 + number % temp);
		else if (first > 1) count += temp;
		// ǧ���٣�ʮ����
		System.out.println(first + "/" + (index-1) + "/" + temp/10);
		count += first * (index - 1)*temp/10;
		return count;
	}
}
