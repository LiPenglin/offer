package Chapter4;
/**
 * 面试题22：栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class _22_stack_push_pop {
	public static void main(String[] args) {
		_22_function f = new _22_function();
		 int []push_order = {1, 2, 3, 4, 5};
	     int []pop_order = {4, 5, 3, 2, 1};
//		 int []pop_order = {4, 3, 5, 1, 2};
	     System.out.println(f.is_pop_order(push_order, pop_order));
	}
}

class _22_function {
	boolean is_pop_order(int []push_order, int []pop_order) {
		
		if (push_order.length != pop_order.length) return false;
		if (push_order.length < 2 || pop_order.length < 2) return push_order[0] == pop_order[0];
		
		boolean res = false;
		
		int []assi_stack = new int[push_order.length];
		int assi_top = 0;
		
		int push_index = 0;
		int pop_index = 0;
		
		assi_stack[assi_top++] = push_order[push_index++];
		
		while (assi_top > 0 || push_index < push_order.length){
			if (assi_stack[assi_top - 1] == pop_order[pop_index]) {
				assi_top--;
				pop_index++;
			} else if (push_index < push_order.length)
				while (push_index < push_order.length) {
					if (pop_order[pop_index] != push_order[push_index])
						assi_stack[assi_top++] = push_order[push_index++];
					else {
						assi_stack[assi_top++] = push_order[push_index++];
						break;
					}
				}
			else break;
		}
		
		if (pop_index >= pop_order.length) res = true;
		
		return res;
	}
}
