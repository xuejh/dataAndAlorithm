package 二叉树;

import java.util.Stack;

/*
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 */
public class _450_删除二叉搜索树中的节点 {
	
	public static TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;
		//查找节点
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode searchNode = null;
		TreeNode parent = null;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.val == key) {
				searchNode = node;
				parent = node;
				break;
			}
			
			if(node.right!= null) {
				stack.push(node.right);
			}
			if(node.left!= null) {
				stack.push(node.left);
			}
		}
		
		if(searchNode == null) return searchNode;
		//叶子节点直接删除
		if(searchNode.left == null && searchNode.right == null) {
			if(parent != null) {
				if(parent.left == searchNode) {
					parent.left = null;
				}else {
					parent.right = null;
				}
			}else {
				return null;
			}
		}else if (searchNode.left == null) {
			TreeNode node = searchNode.right;
			parent = searchNode;
			while (node.left!= null) {
				parent = node;
				node = node.left;
				
			}
			searchNode.val = node.val;
			if(parent == searchNode) {
				parent.right = null;
			}else {
				parent.left = null;
			}
			
		}else {
			TreeNode node = searchNode.left;
			parent = searchNode;
			while (node.right!= null) {
				parent = node;
				node = node.right;
				
			}
			searchNode.val = node.val;
			if(parent == searchNode) {
				parent.left = null;
			}else {
				parent.right = null;
			}
		}
		return root;
    }
	
	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(7);
		
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		
		deleteNode(node0,3);
	}
	
}
