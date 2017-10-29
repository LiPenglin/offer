package Chapter2;

/**
 * ������8����ת�������Сֵ
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
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
		// ��ߵ����д����ұߵ�����
		while(arr[left] >= arr[right]) { // ���arr[left] < arr[right], �������Ѿ�����
			if (right - left == 1) {
				mid = right;
				break;
			}
			//arr[left] ����� arr[right]
			mid = (left + right) / 2;
			/*
			 * �����left��right��mid Ϊ index ������ֵ��ȣ�
			 * ��ô��ֻ�ܰ�arr ɨһ����
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
