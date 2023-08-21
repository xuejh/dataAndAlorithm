package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */




public class _102_二叉树的层序遍历 {
	
	public static class LevelTreeNode{
		int level;
		TreeNode node;
		public LevelTreeNode(TreeNode node,int level) {
			this.level = level;
			this.node = node;
		}
	}
	
	public static void levelOrder1(TreeNode node) {
		if(node == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			TreeNode node1 = stack.pop();
			System.out.println(node1.val + " ");
			if(node1.right!=null) {
				stack.push(node1.right);
			}
			if(node1.left !=null) {
				stack.push(node1.left);
			}
			
			
		}
	}
	
	
	public static List<List<Integer>> levelOrder2(TreeNode node) {
		List<List<Integer>> lists = new LinkedList<>();
		
		if(node == null) {
			return lists;
		}
		
		
		
		Queue<LevelTreeNode> queue = new LinkedList<>();
		
		LevelTreeNode node0 = new LevelTreeNode(node, 0);
		queue.offer(node0);
		
		int level = 0;
		LinkedList<Integer> list = new LinkedList<>();
		while (!queue.isEmpty()) {
			
			
			LevelTreeNode node1 = queue.poll();
			if(level == node1.level) {
				list.add(node1.node.val);
			}else {
				lists.add(list);
				level ++;
				list = new LinkedList<>();
				list.add(node1.node.val);
			}
		//	System.out.println(node1.node.val + " ");
			if(node1.node.left != null) {
				LevelTreeNode node2 = new LevelTreeNode(node1.node.left, node1.level +1);
				queue.offer(node2);
			}
			if(node1.node.right!=null) {
				LevelTreeNode node2 = new LevelTreeNode(node1.node.right, node1.level +1);
				queue.offer(node2);
			}
			
		}
		
		if(!list.isEmpty()) {
			lists.add(list);
		}
		return lists;
	}
	
	
	
	List<List<Integer>> levels = new ArrayList<List<Integer>>();
	
	public void helper(TreeNode node,int level) {
		if(levels.size() == level) {
			levels.add(new ArrayList<Integer>());
		}
		levels.get(level).add(node.val);
		
		if(node.left != null) {
			helper(node.left, level +1);
		}
		if(node.right != null) {
			helper(node.right, level +1);
		}
	}

	public List<List<Integer>> levelOrder3(TreeNode root) {
		if(root == null) return levels;
		helper(root, 0);
		return levels;
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(root == null) {
			return lists;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			
			int num = queue.size();
			List<Integer> list = new LinkedList<>();
			for(int i=0;i<num;i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
			}
			lists.add(list);
		}
		
		return lists;
	}
	
	
	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(30);
		TreeNode node6 = new TreeNode(40);
		
		node0.left = node1;
		node0.right = node2;
		node2.left = node3;
		node2.right = node4;
		node1.left = node5;
		node1.right = node6;
		
		levelOrder(node0);
	}
}
