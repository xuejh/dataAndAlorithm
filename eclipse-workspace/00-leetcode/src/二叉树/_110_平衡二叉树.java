package 二叉树;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class _110_平衡二叉树 {
	
	
	public int getTreeNodeHeight(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		
		return Math.max(getTreeNodeHeight(node.left), getTreeNodeHeight(node.right)) + 1;
	}
	
	public Boolean isBalance(TreeNode node) {
		if(node == null) {
			return true;
		}
		int left = 0;
		if(node.left!=null) {
			left = getTreeNodeHeight(node.left);
		}
		int right = 0;
		if(node.right!=null) {
			right = getTreeNodeHeight(node.right);
		}
		
		int num = Math.abs(left - right);
		if(num > 1) {
			return false;
		}
		return true;
	}
	
	public boolean isBalanced(TreeNode root) {
		
		if(root == null) {
			return true;
		}
		
		Boolean flag = true;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			flag = isBalance(node);
			if(!flag) {
				return false;
			}
			if(node.left != null) {
				stack.push(node.left);
			}
			if(node.right!=null) {
				stack.push(node.right);
			}
		}
		
		return flag;
    }
	
}
