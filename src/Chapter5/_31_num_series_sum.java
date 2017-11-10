package Chapter5;

import java.util.stream.IntStream;
/**
 * ������31�����������������
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)����᲻�ᱻ������ס��(�������ĳ���������1)
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
