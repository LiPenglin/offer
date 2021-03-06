package Chapter6;

/**
 * 面试题41：和为S的两个数
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
 * 对应每个测试案例，输出两个数，小的先输出。
 */

public class _41_sum {
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7,8,9};
		new _41_function().find_x_add_y_equal_s(arr, 10);
	}
}

class _41_function {
	void find_x_add_y_equal_s(int []arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		int sum = arr[left] + arr[right];
		while(left < right) {
			if (sum < key) left++;
			else if (sum > key) right--;
			else System.out.println(sum + "/ " + arr[left++] + "/ " + arr[right--]);
			sum  = arr[left] + arr[right];
		}
	}
}
