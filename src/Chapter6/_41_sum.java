package Chapter6;

/**
 * ������41����ΪS��������
 * ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ� 
 * ��Ӧÿ�����԰����������������С���������
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
