package Chapter2;

import java.util.Scanner;  
/**
 * ������3����ά�����еĲ���
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */

/*
 * ˼·��
 * ���ң��������������ҵ��ȿ��Ե����ֿ��Եݼ�����ʼ��
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