package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class _102_二叉树的层序遍历 {
	
	private List<List<Integer>> lists = new ArrayList<>();
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return lists;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
    }
}
