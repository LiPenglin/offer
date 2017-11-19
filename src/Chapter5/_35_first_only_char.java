package Chapter5;

import java.util.HashMap;
import java.util.Map.Entry;

public class _35_first_only_char {
	public static void main(String[] args) {
		_35_function f = new _35_function();
		String str = "nihaohello";
		System.out.println(f.first_only_char(str.toCharArray()));
	}
}

class _35_function {
	char first_only_char(char []arr) {
		HashMap<Character, Integer> hash = new HashMap<>();
		for (char c : arr) {
			if (hash.containsKey(c)) hash.put(c, hash.get(c)+1);
			else hash.put(c, 1);
		}
//		for (Entry<Character, Integer> e : hash.entrySet()) {
//			if (e.getValue() == 1) return e.getKey();
//		}
		for (char c : arr) {
			if (hash.get(c) == 1) return c;
		}
		return 0;
	}
}
