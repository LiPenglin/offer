package Chapter5;
/**
 * 面试题32：从1到n整数中1出现的次数 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
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
		// 千，百，十，个
		System.out.println(first + "/" + (index-1) + "/" + temp/10);
		count += first * (index - 1)*temp/10;
		return count;
	}
}
