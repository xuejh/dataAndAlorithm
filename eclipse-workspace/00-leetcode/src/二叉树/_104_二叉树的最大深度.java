package 二叉树;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {
	
	
	
	
	public int maxDepth(TreeNode root) {
		
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 1; i <= size; i++) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right!=null) {
					queue.offer(node.right);
				}
			}
			depth ++;
		}
		
		return depth;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
