package Chapter4;

/**
 * 面试题20：顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class _20_print_matrix {
	public static void main(String[] args) {
		 int[][] aI={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	     int[][] aII={{1},{2},{3},{4}};
	     int[][] aIII={{1,2,3,4}};
	     _20_function f = new _20_function();
	     f.print_matrix(aIII);
	}
}

class _20_function {
	void print_matrix(int [][]matrix) {
		int end_x = matrix[0].length - 1;
		int end_y = matrix.length - 1;
		if (end_x == 0){
			for (int j = 0; j < end_y; j++) System.out.println(matrix[j][end_x] + "/");
			return;
		}
		if (end_y == 0){
			for (int i = 0; i < end_x; i++) System.out.print(matrix[end_y][i] + "/");
			return;
		}
		int end = end_x <= end_y ? end_x : end_y;
		for (int start = 0; start <= end/2; start++) {
			for (int i = start; i <= end_x - start; i++) System.out.print(matrix[start][i] + "/");
			System.out.println();
			for (int j = start + 1; j <= end_y -start; j++) System.out.print(matrix[j][end_y-start] + "/");
			System.out.println();
			for (int i = end_x - start - 1; i >= start; i--) System.out.print(matrix[end_x - start][i] + "/");
			System.out.println();
			for (int j = end_y - start - 1; j > start; j--) System.out.print(matrix[j][start] + "/");
			System.out.println();
		}
	}
}
