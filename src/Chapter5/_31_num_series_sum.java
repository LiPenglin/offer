package Chapter5;

import java.util.stream.IntStream;
/**
 * 面试题31：连续子数组的最大和
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class _31_num_series_sum {
	public static void main(String[] args) {
		int []arr = {6,-3,-2,7,-15,1,2,2};
		_31_function f = new _31_function();
		System.out.println(f.dp(arr));
	}
}

class _31_function {
	int dp(int []arr) {
		int length = arr.length;
		int []f = new int[length];
		for (int i = 0; i < length; i++) 
			f[i] = (i == 0 || f[i-1] < 0) ? arr[i] : f[i - 1] + arr[i];
		return IntStream.of(f).max().getAsInt();
	}
}
