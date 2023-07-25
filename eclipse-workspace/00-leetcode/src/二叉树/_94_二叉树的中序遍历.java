package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _94_二叉树的中序遍历 {
	
//	private void inorder(TreeNode root) {
//		if(root == null) return;
//		inorder(root.left);
//		list.add(root.val);
//		inorder(root.right);
//	}
//	private List<Integer> list = new LinkedList<>();
//	
//	public List<Integer> inorderTraversal(TreeNode root) {
//		inorder(root);
//		return list;
//    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		
		Stack<TreeNode> stack = new Stack<>();
		
		
		while (!stack.isEmpty()|| root!=null) {

			
			if(root != null) {
				stack.push(root);
				root = root.left;
				
			}else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
				
			}
			
		}
		
		return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
