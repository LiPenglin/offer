package Chapter4;
/**
 * ������22��ջ��ѹ�롢��������
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
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
