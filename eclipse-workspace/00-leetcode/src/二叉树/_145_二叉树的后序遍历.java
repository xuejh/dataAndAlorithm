package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _145_二叉树的后序遍历 {
	
//	private List<Integer> list = new ArrayList<>();
//	private void postorder(TreeNode root) {
//		if(root == null) return;
//		postorder(root.left);
//		postorder(root.right);
//		list.add(root.val);
//	}
//	public List<Integer> postorderTraversal(TreeNode root) {
//		postorder(root);
//		return list;
//    }
	
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		if(root == null) return list;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(0, node.val);
			if(node.left!=null) {
				stack.push(node.left);
			}
			if(node.right!=null) {
				stack.push(node.right);
			}
			
		}
		return list;
    }
	
}
