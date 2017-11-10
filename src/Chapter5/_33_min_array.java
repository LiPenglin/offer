package Chapter5;

import java.util.stream.IntStream;

/**
 * 面试题33：把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class _33_min_array {
	public static void main(String[] args) {
//		int []data = {3,32,321};
//		int []data = {3,5,1,4,2};
		int []data = {3334,3,3333332};
		_33_function f = new _33_function();
		System.out.println(f.print_min(data));
	}
}

class _33_function {
	String print_min(int []data) {
		if (data.length == 0) return "";
		StringBuilder str = new StringBuilder();
		quick_sort(data, 0, data.length - 1);
		IntStream.of(data).forEach(i -> str.append(i));
		return str.toString();
	}
	void quick_sort(int []arr, int start, int end) {
		if (arr.length == 0) return;
		if (start == end) return;
		int index = partition(arr, start, end);
		if (index > start) partition(arr, start, index - 1);
		if (index < end) partition(arr, index + 1, end);
	}
	int partition(int []arr, int start, int end) {
		if (start < 0 || end >= arr.length) return -1;
		int left = start - 1;
		arr[end] = arr[end] + arr[start + end >> 1] - (arr[start + end >> 1] = arr[end]);
		/*
		 * StringBuilder 构造器如果传入的为int，则该值为capacity
		 */
		StringBuilder stra = new StringBuilder();
		StringBuilder strb = new StringBuilder();
		for (int index = start; index < end; index++) {
			stra.append(arr[end]).append(arr[index]); // append int 会自动转为 String
			strb.append(arr[index]).append(arr[end]);
			if (stra.toString().compareTo(strb.toString()) > 0 && ++left != index) {
				arr[index] = arr[index] + arr[left] - (arr[left] = arr[index]);
			}
			stra.delete(0, stra.length()); // 删除 从 start（包括） 开始到end（不包括）
			strb.delete(0, strb.length());
		}
		arr[end] = arr[end] + arr[++left] - (arr[left] = arr[end]);
		return left;
	}
}
