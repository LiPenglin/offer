package Chapter6;

/**
 * ������44���˿���˳��
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...��������г����5����,
 * �����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���������A,����3,С��,����,��Ƭ5��,
 * ��Oh My God!������˳��.....LL��������,��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����LL����ȥ��������Ʊ����
 * ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�Ϊ�˷������,�������Ϊ��С����0��
 */

public class _44_poker {
	public static void main(String[] args) {
		int []num = {0,0,3,4,7};
		new _44_function().is_continuous(num);
	}
}
class _44_function {
	void is_continuous(int []num) {
		int count = 0;
		for (int i = 1; i < num.length; i++) {
			for (int j = 0; j < num.length - i; j++) {
				if (num[j] > num[j + 1]) 
					num[j] = num[j] + num[j + 1] - (num[j + 1] = num[j]);
			}
		}
		for (int i = 0; i < num.length; i++){
			if (num[i] != 0) break;
			count++;
		}
		int left = num[count], right;
		for (int i = count + 1; i < num.length; i++) {
			right = num[i];
			if (right - left == 0) {
				System.out.println("false.");
				return; 
			} else {
				if (right - left != 1) {
					if (right - left <= count + 1)
						count -= right - left;
					else {
						System.out.println("false.");
						return;
					}
				}
			}
			left = right;
		}
		System.out.println("true.");
		
	}
}
