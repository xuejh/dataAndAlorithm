package 二叉树;

import java.util.ArrayList;
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
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		while (!stack.isEmpty() || root!=null) {
			if(root!=null) {
				stack.push(root);
				root = root.right;
				if(root!=null) {
					stack.push(root);
				}
			}else {
				TreeNode node = stack.peek();
				if(node.right !=null) {
					stack.push(node.right);
				}
				node = stack.pop();
				list.add(node.val);
			}
			
		}
		
		

		
		return list;
    }
	
}
