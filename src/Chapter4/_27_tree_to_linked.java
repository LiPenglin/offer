package Chapter4;
/**
 * ������27��������������˫������
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class _27_tree_to_linked {
	public static void main(String[] args) {
		TreeNodeIII TreeNodeIII = new TreeNodeIII(10);
        TreeNodeIII.left= new TreeNodeIII(6);
        TreeNodeIII.right= new TreeNodeIII(14);
        TreeNodeIII.left.left= new TreeNodeIII(4);
        TreeNodeIII.left.right= new TreeNodeIII(8);
        TreeNodeIII.right.left= new TreeNodeIII(12);
        TreeNodeIII.right.right= new TreeNodeIII(16);
        _27_function f = new _27_function();
        TreeNodeIII pResult= f.convert_tree(TreeNodeIII);
        while(pResult!=null){
            System.out.print(pResult.data+"��");
            pResult=pResult.right;
        }
	}
}

class _27_function {
	TreeNodeIII convert_tree(TreeNodeIII root) {
		/*
		 * �������ݹ飬���᷵�ص�last_in_linked = null
		 * ������⴫��ַ
		 */
		TreeNodeIII last_in_linked = null;
		last_in_linked = convert(root, last_in_linked);
		while (last_in_linked.left != null) {
			last_in_linked = last_in_linked.left;
		}
		return last_in_linked;
	}
	TreeNodeIII convert(TreeNodeIII root, TreeNodeIII last_in_linked) {
		if (root == null) return null;
		if (root.left != null) last_in_linked =  convert(root.left, last_in_linked); // Ҫ�����Ǹ���ַ�Ķ���
		root.left = last_in_linked;
		if (last_in_linked != null) last_in_linked.right = root;
		last_in_linked = root;
		if (root.right != null) last_in_linked = convert(root.right, last_in_linked);
		return last_in_linked;
	}
}

class TreeNodeIII {
	int data;
	TreeNodeIII left;
	TreeNodeIII right;

	public TreeNodeIII(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}