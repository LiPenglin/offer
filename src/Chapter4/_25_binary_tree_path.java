package Chapter4;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class _25_binary_tree_path {
	public static void main(String[] args) {
		_25_function f = new _25_function();
		TreeNodeII treeNode25 = new TreeNodeII(10);
        treeNode25.left = new TreeNodeII(5);
        treeNode25.right = new TreeNodeII(12);
        treeNode25.left.left = new TreeNodeII(4);
        treeNode25.left.right = new TreeNodeII(7);
        ArrayList<Integer> list = new ArrayList<Integer>();
        f.pre_order(treeNode25, 15, 0, list);
        f.print_list();
	}
}

class _25_function {
	ArrayList<ArrayList<Integer>> res_list = new ArrayList<ArrayList<Integer>>();
	void pre_order(TreeNodeII root, int target, int temp, ArrayList<Integer> list) {
		if (root == null) return; // һ������
		temp += root.data;
		list.add(root.data);
		if (root.left == null && root.right == null && temp == target) { //Ҷ�ӽ�㣬����
			ArrayList<Integer> ans_list = new ArrayList<Integer>(); // ����һ���µ��ڴ�����
			for (int i : list) ans_list.add(i);
			res_list.add(ans_list);
			for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + "/");
			System.out.println();
		} else if (temp < target) { // ��ʱ����
			pre_order(root.left, target, temp, list);
			pre_order(root.right, target, temp, list);
		} // ����
		list.remove(list.size()-1);
	}
	void print_list() {
		System.out.println("=== array list ===");
		for (ArrayList<Integer> list : res_list) {
			for (int i : list) System.out.print(i + "/");
			System.out.println();
		}
	}
}

class TreeNodeII {
	
	int data;
	TreeNodeII left;
	TreeNodeII right;

	public TreeNodeII(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
}