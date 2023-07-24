package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class _144_二叉树的前序遍历 {
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
	 public List<Integer> preorderTraversal(TreeNode root) {
		 	List<Integer> list = new ArrayList<>();
		 	TreeNode node = root;
		 	while (node!=null) {
				list.add(node.val);
				if(node.left!=null) {
					node = node.left;
				}
				
			}
		 	
		 	return list;
		 	
	    }
}
