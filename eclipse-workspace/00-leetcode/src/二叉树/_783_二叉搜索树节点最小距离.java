package 二叉树;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.cn/problems/minimum-distance-between-bst-nodes/description/
 */
public class _783_二叉搜索树节点最小距离 {
	
	public List<Integer> inorderTraversal(TreeNode node) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		while (!stack.isEmpty() || node!= null) {
			if(node!=null) {
				stack.push(node);
				node = node.left;
			}else {
				TreeNode node1 = stack.pop();
				list.add(node1.val);
				node = node1.right;
			}
			
		}
		return list;
		
	}
	
	public int minDiffInBST(TreeNode root) {
        //中序排列
		List<Integer> list = inorderTraversal(root);
		Integer min = Integer.MAX_VALUE;
		for (int i = 1; i < list.size(); i++) {
			int num1 = list.get(i-1);
			int num2 = list.get(i);
			int dif = Math.abs(num1-num2);
			min = Math.min(dif, min);
			
		}
		return min;
    }
}
