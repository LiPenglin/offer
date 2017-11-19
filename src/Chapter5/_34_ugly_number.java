package Chapter5;

import java.util.stream.IntStream;

public class _34_ugly_number {
	public static void main(String[] args) {
		_34_function f = new _34_function();
		int []arr = f.ugly_number(10);
		IntStream.of(arr).forEach(System.out::println);
	}
}

class _34_function {
	
	int []ugly_number(int count) {
		int []ans = new int[count];
		
		ans[0] = 1;
		// ÄÜx [2,3,5] µÄugly number µÄindex
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		for (int next = 1; next < count; next++) {
			ans[next] = min(ans[i2]*2, ans[i3]*3, ans[i5]*5);
			while(ans[i2]*2 <= ans[next]) i2++;
			while(ans[i3]*3 <= ans[next]) i3++;
			while(ans[i5]*5 <= ans[next]) i5++;
		}
		return ans;
	}
	
	int min(int a, int b, int c) {
		a = a < b ? a : b;
		return a < c ? a : c;
	}
}
