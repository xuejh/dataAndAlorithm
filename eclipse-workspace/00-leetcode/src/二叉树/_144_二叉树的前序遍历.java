package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _144_二叉树的前序遍历 {

//	 private List<Integer> list = new ArrayList<>();
//	 
//	 private void preorder(TreeNode root) {
//		 if(root == null) return ;
//		 	list.add(root.val);
//		 	preorderTraversal(root.left);
//		 	preorderTraversal(root.right);
//	}
//	 
//	 public List<Integer> preorderTraversal(TreeNode root) {
//		 	preorder(root);
//		 	return list;
//		 	
//	    }
	 public static List<Integer> preorderTraversal(TreeNode root) {
		 	List<Integer> list = new ArrayList<>();
		 	if(root == null) {
		 		return list;
		 	}
		 	Queue<TreeNode> queue = new LinkedList<>();
		 	
		 	queue.offer(root);
		 	while (queue.size()!=0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left!= null) {
					queue.offer(node.left);
				}
				if(node.right!= null) {
					queue.offer(node.right);
				}
			}
		 	
		 	return list;
		 	
	    }
	 
	 public static void main(String[] args) {
		 
		 TreeNode node0 = new TreeNode(1);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(3);
		 TreeNode node3 = new TreeNode(2);
		 node0.left = node1;
		 node0.right = node2;
		 node1.left = node3;
		 
		 
		 System.out.println(preorderTraversal(node0));
	}
}
