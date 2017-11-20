package Chapter5;

import java.util.stream.IntStream;

public class _36_array_reversed {
	public static void main(String[] args) {
//		int []arr = {8, 6, 9, 4, 2, 1, 3, 7, 5};
		int []arr = {7, 5, 6, 4};
		_36_function f = new _36_function();
		System.out.println(f.merge(arr, 0, arr.length - 1));
		IntStream.of(arr).forEach(System.out::print);
	}
}

class _36_function {
	int merge(int []arr, int left, int right) {
		if (left >= right) return 0;
		int count = 0;
		int l_count = merge(arr, left, (left + right) / 2);
		int r_count = merge(arr, (left + right) / 2 + 1, right);
		int []tmp = new int[right-left + 1];
		int mid = (left + right) / 2;
		int i = mid;
		int j = right;
		int k = right-left;
		while (i >= left && j > mid) {
			if (arr[i] > arr[j]) {
				count = count + j - mid;
			}
			tmp[k--] = arr[i] > arr[j] ? arr[i--] : arr[j--];
		}
		while(i < left && j > mid) tmp[k--] = arr[j--];
		while(j <= mid && i >= left) tmp[k--] = arr[i--];
		
		i = left;
		j = 0;
		while (i <= right) arr[i++] = tmp[j++];
		return l_count + r_count + count;
	}
	// ¹é²¢ÅÅÐò
	void merge_sort(int []arr, int left, int right) {
		if (left >= right) return;
		System.out.println(left + "/" + right);
		merge_sort(arr, left, (left + right) / 2);
		merge_sort(arr, (left + right) / 2 + 1, right);
		int []tmp = new int[right-left + 1];
		int mid = (left + right) / 2;
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid || j <= right) {
			if (i > mid){
				while(j <= right) tmp[k++] = arr[j++];
				break;
			}
			if (j > right) {
				while(i <= mid) tmp[k++] = arr[i++];
				break;
			}
			tmp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
		}
		i = left;
		j = 0;
		while (i <= right) arr[i++] = tmp[j++];
	}
}
