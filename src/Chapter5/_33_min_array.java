package Chapter5;

import java.util.stream.IntStream;

/**
 * ������33���������ų���С����
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
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
		 * StringBuilder ��������������Ϊint�����ֵΪcapacity
		 */
		StringBuilder stra = new StringBuilder();
		StringBuilder strb = new StringBuilder();
		for (int index = start; index < end; index++) {
			stra.append(arr[end]).append(arr[index]); // append int ���Զ�תΪ String
			strb.append(arr[index]).append(arr[end]);
			if (stra.toString().compareTo(strb.toString()) > 0 && ++left != index) {
				arr[index] = arr[index] + arr[left] - (arr[left] = arr[index]);
			}
			stra.delete(0, stra.length()); // ɾ�� �� start�������� ��ʼ��end����������
			strb.delete(0, strb.length());
		}
		arr[end] = arr[end] + arr[++left] - (arr[left] = arr[end]);
		return left;
	}
}
