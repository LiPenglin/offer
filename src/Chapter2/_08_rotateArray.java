package Chapter2;

/**
 * 面试题8：旋转数组的最小值
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */

public class _08_rotateArray {
	public static void main(String[] args) {
		_08_function f = new _08_function();
//		int[] arr = {3,4,5,1,2};
		int[] arr = {1,0,1,1,1}; 
		System.out.println(f.min(arr));
	}
}

class _08_function {
	int min(int []arr) {
		int length = arr.length;
		int left = 0;
		int right = length - 1;
		int mid = left;
		// 左边的序列大于右边的序列
		while(arr[left] >= arr[right]) { // 如果arr[left] < arr[right], 即数组已经有序
			if (right - left == 1) {
				mid = right;
				break;
			}
			//arr[left] 恒大于 arr[right]
			mid = (left + right) / 2;
			/*
			 * 如果，left，right，mid 为 index 的三个值相等，
			 * 那么，只能把arr 扫一遍了
			 */
			if (arr[mid] == arr[left] && arr[mid] == arr[right]) return get_min(arr);
			if (arr[mid] >= arr[left]) left = mid;
			else if (arr[mid] <= arr[right]) right = mid;
		}
		return arr[right];
	}
	int get_min(int []arr) {
        int min = 0x7fffffff;
        for (int a : arr) {
        	min = a < min ? a : min;
        }
        return min;
    }
}
