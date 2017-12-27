package Chapter6;

/**
 * 面试题38：数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */

public class _38_data_in_sorted_times {
	public static void main(String[] args) {
		_38_function f = new _38_function();
		int[] arr={1,3,3,3,3,3,4,5};
		int key = 3;
		int left = 0;
		int right = arr.length - 1;
		int count = 1 + f.get_max(arr, key, left, right) - f.get_min(arr, key, left, right);
		System.out.println(count);
	}
}

class _38_function {
	public int get_min(int []arr, int key, int left, int right) {
		int start = left;
		int end = right;
		if (left > right) return -1;
		int mid = (left + right) / 2;
		if (arr[mid] == key) 
			if (mid-1 >= 0 && arr[mid-1] != key) return mid; 
			else end = mid - 1;
		else if (arr[mid] > key) end = mid - 1;
		else start = mid + 1;
		return get_min(arr, key, start, end);
	}
	public int get_max(int []arr, int key, int left, int right) {
		int start = left;
		int end = right;
		if (left > right) return -1;
		int mid = (left + right) / 2;
		if (arr[mid] == key) 
			if (mid + 1 <= right && arr[mid+1] != key) return mid;
			else start = mid + 1;
		else if (arr[mid] > key) end = mid - 1;
		else start = mid + 1;
		return get_max(arr, key, start, end);
	}
}
