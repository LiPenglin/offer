package Chapter3;
/**
 * 面试题11：数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */ 
public class _11_power {
	public static void main(String[] args) {
		_11_function function = new _11_function();
		System.out.println(function.power(2, 10));
	}
}

class _11_function {
	double Min = 0.00000001;
	double power(double base, int exponent) {
		if (base < Min && base > -Min) return 0.0;
		if (exponent < 0) return 1.0/power_by_unsigned_exponent(base, -exponent);
		else if (exponent == 0) return 1.0;
		else return power_by_unsigned_exponent(base, exponent);
	}
	double power_by_unsigned_exponent(double base, int exponent) {
//		double ans = base;
//		for (int i = 1; i < exponent; i++) ans *= base;
//		return ans;
		/*
		 * a 的 n 次幂 
		 * 1. n为偶数
		 * 2. n为奇数
		 */
		if (exponent == 1) return base;
		double ans = base;
		ans = power_by_unsigned_exponent(ans, exponent >> 1);
		return (exponent & 0x1) == 0 ? ans*ans : ans*ans*base;
	}
}
