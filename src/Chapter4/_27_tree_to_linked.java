package Chapter4;
/**
 * 面试题27：二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
            System.out.print(pResult.data+"、");
            pResult=pResult.right;
        }
	}
}

class _27_function {
	TreeNodeIII convert_tree(TreeNodeIII root) {
		/*
		 * 深入理解递归，最后会返回到last_in_linked = null
		 * 深入理解传地址
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
		if (root.left != null) last_in_linked =  convert(root.left, last_in_linked); // 要操作那个地址的对象
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