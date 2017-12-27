package Chapter6;

/**
 * ������41-��Ŀ2����ΪS��������������
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * �������:
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
 */

public class _41_positive_sequence {
	public static void main(String[] args) {
		new _41_functionI().find_sequence(15);
	}
}

class _41_functionI {
	/*
	 * �������
	 */
	void find_sequence(int key) {
		int begin = 1;
		int end = 2;
		while(begin <= end && end <= key + 1 >> 1) {
			int tmp = sum(begin, end);
			if (tmp < key) end++;
			else if (tmp > key) begin++;
			else System.out.println(key + "/ " + begin++ + " ~ " + end++);
		}
	}
	int sum(int begin, int end) {
		int sum = 0;
		for (int i = begin; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
}
