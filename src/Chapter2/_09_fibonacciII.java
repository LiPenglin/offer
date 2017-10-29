package Chapter2;

/*
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 */

public class _09_fibonacciII {
	public static void main(String[] args) {
		_09_functionII f = new _09_functionII();
		System.out.println(f.dp(2));
	}
}

class _09_functionII {
	int dp(int n) {
		/*
		 * �ݹ飺
		 * 	 int ways = 1;
	     *   for (int i = 1; i < n; i++) {
	     *       ways += JumpFloorII(n-i);
	     *   }
	     *   return ways;
		 */
		if(n == 1) return n; // n = 1��dp = 1
		
		int []dp = new int[n + 1]; // dp����
		
		for(int i = 1; i <= n; i++) dp[i] =  1;
		
		for (int i = 2; i <= n; i++) { // fn = fn + f n-1 + f n-2 + f 1
			for (int j = i - 1; j >= 1; j--) {
				dp[i] += dp[j];
			}
		}
		return dp[n];
	}
}
