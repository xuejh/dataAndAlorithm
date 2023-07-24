package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode-cn.com/problems/invert-binary-tree
 */

public class _226_翻转二叉树 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	    }
	}
	
	
//	public TreeNode invertTree(TreeNode root) {
//		if(root == null) return null;
//		TreeNode left = root.left;
//		root.left = root.right;
//		root.right = left;
//		invertTree(root.left);
//		invertTree(root.right);
//		return root;
//    }
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if(node.left!=null) {
				queue.offer(node.left);
			}
			if(node.right!=null) {
				queue.offer(node.right);
			}
		}
		return root;
    }
	
}
