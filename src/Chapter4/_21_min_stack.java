package Chapter4;
/**
 * 面试题21：包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class _21_min_stack {

	public static void main(String[] args) {
		_21_function f = new _21_function();
		f.push(3);
		System.out.println(f.top() + "/" + f.peek());
		f.push(4);
		System.out.println(f.top() + "/" + f.peek());
		f.push(2);
		System.out.println(f.top() + "/" + f.peek());
		f.push(1);
		System.out.println(f.top() + "/" + f.peek());
		f.pop();
		System.out.println(f.top() + "/" + f.peek());
		f.pop();
		System.out.println(f.top() + "/" + f.peek());
		f.pop();
		System.out.println(f.top() + "/" + f.peek());
		f.push(0);
		System.out.println(f.top() + "/" + f.peek());
		
		
		
	}

}

class _21_function {
	int []data_stack = new int[100];
	int data_top = 0;
	int []assi_stack = new int[100];
	int assi_top = 0;
	void push(int data) {
		data_stack[data_top++] = data;
		
		if (assi_top <= 0 || data < assi_stack[assi_top-1]) {
			assi_stack[assi_top++] = data;
		} else {
			assi_stack[assi_top] = assi_stack[assi_top++-1];
		}
	}
	int pop() {
		assi_top--;
		return data_stack[--data_top];
	}
	int top() {
		return assi_stack[assi_top-1];
	}
	int peek() {
		return data_stack[data_top-1];
	}
}
