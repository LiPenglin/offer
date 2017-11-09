package Chapter5;

//import java.util.stream.IntStream;
/**
 * ������29�������г��ִ�������һ�������
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
 * ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class _29_the_over_half_num {
	public static void main(String[] args) {
//		int []arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		int []arr = {1, 1, 0, 0, 3, 3, 3, 3, 3};
		_29_function f = new _29_function();
//		f.quick_sort(arr, 0, arr.length - 1);
//		IntStream.of(arr).forEach(System.out::println);
		System.out.println(f.over_half_num(arr));
	}
}

class _29_function {
	/*
	 * �裺x �ǳ��ִ�������n/2 ����
	 * ����partition ֮���±��� n/2 �����������Ƿ�x
	 */
	int over_half_num(int []arr) {
		int mid = arr.length/2;
		int start = 0;
		int end = arr.length - 1;
		int index = partition(arr, start, end);
		while (index != mid) {
			if (index < mid) index = partition(arr, start = index + 1, end);
			else index = partition(arr, start, end = index - 1);
		}
		if (check_more_than_half(arr, arr[mid])) return -1;
		else return arr[mid];
	}
	int partition(int []arr, int start, int end) {
		if (arr.length == 0 || start < 0 || end >= arr.length) return -1;
		if (start == end) return start;
		int index = (end + start) >> 1;
		arr[index] = arr[index] + arr[end] - (arr[end] = arr[index]);
		int left = start  - 1;
		for (index = start; index < end; index++) {
			if (arr[index] < arr[end] && ++left != index) 
				arr[index] = arr[index] + arr[left] - (arr[left] = arr[index]);
		}
		arr[end] = arr[end] + arr[++left] - (arr[left] = arr[end]);
		return left;
	}
	boolean check_more_than_half(int []arr, int number) {
		int count = 0;
		int length = arr.length;
		for (int i : arr) {
			if (i == number) count++;
		}
		if (count > length >> 1) return false;
		else return true;
		
	}
	void quick_sort(int []arr, int start, int end) { // ��������д���� 
		if (start == end) return;
		int index = partition(arr, start, end);
		if (index > start) quick_sort(arr, start, index - 1);
		if (index < end) quick_sort(arr, index + 1, end);
	}
}

