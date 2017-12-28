package Chapter6;

import java.util.HashMap;
import java.util.Map.Entry;

public class _43_dice {
	public static void main(String[] args) {
		int n = 2;
		int s = 6;
		_43_function f = new _43_function(n, s);
		f.permutation(new int[n], 0);
		f.result();
	}
}

class _43_function {
	int n;
	int s;
	HashMap<Integer, Integer> map;
	
	public _43_function(int n, int s) {
		this.n = n;
		this.s = s;
		this.map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= 6; i++) {
			map.put(i, 0);
		}
	}
	
	void permutation(int []arr, int index) {
		
		if (index == arr.length) {
			int sum = 0;
			for (int i : arr){
				sum += i;
			}
			if (sum == this.s){
				for (int i : arr) {
					this.map.put(i, this.map.get(i)+1);
					System.out.print(i + "/");
				}
				System.out.println();
			}
			return;
		}
		
		for (int j = 1; j <= 6; j++) {
			arr[index] = j;
			permutation(arr, index+1);
		}
		
	}
	
	void result() {
		double total = Math.pow(6, this.n);
		for (Entry<Integer, Integer> e : this.map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue() + "/" + total);
		}
	}
}
