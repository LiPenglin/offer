package Chapter2;

import java.util.Scanner;  
/**
 * 面试题3：二维数组中的查找
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/*
 * 思路：
 * 查找，两个搜索方向，找到既可以递增又可以递减的起始点
 */
public class _03_array {  
    public static void main(String []args) {  
        Scanner cin = new Scanner(System.in);  
        int [][]arr = {  
            {1,2,8,9},  
            {2,4,9,12},  
            {4,7,10,13},  
            {6,8,11,15}  
        };  
        int target = cin.nextInt();  
        _03_function f = new _03_function();
        f.findNumber(arr, target);
    }  
    
}

class _03_function {
	public void findNumber(int[][] matrix, int target) {
    	boolean flag = false;
    	int columns = matrix[0].length;
    	int row = matrix.length - 1;
    	int column = 0;
    	while(row >= 0 && column < columns) {
    		if(target == matrix[row][column]) {
    			flag = true;
    			break;
    		} else if (target < matrix[row][column]) {
    			row--;
    		} else {
    			column++;
    		}
    	}
    	if (flag) {
    		System.out.println("true");
    	} else {
    		System.out.println("false");
    	}
    }
}