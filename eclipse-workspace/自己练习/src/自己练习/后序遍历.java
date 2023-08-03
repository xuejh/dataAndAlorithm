package 自己练习;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 后序遍历 {
	public static void postOrderIteration(TreeNode head) {
		if(head == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);
		
		Stack<TreeNode>stack2 = new Stack<>();
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			stack2.push(node);
			if(node.left!=null) {
				stack.push(node.left);
			}
			if(node.right!=null) {
				stack.push(node.right);
			}
		}
		
		while (!stack2.isEmpty()) {
			TreeNode node = stack2.pop();
			System.out.println(node.val);
			
		}
	}
	public  static List<Integer> list;
	
    public static List<Integer> postorderTraversal(TreeNode root) {
    	 list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode p1 = root;
        TreeNode p2 = null;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                 while (p2.right != null && p2.right != p1) {
                     p2 = p2.right;
                 }
                 if (p2.right == null) {
                     p2.right = p1;
                     p1 = p1.left;
                     continue;
                 } else {
                     p2.right = null;
                     postMorris(p1.left);
                 }
            } 
            p1 = p1.right;
        }
        //以根节点为起点的链表
        postMorris(root);
        return list;
    }
    public static void  postMorris(TreeNode root) {
        //翻转链表
        TreeNode reverseNode = reverseList(root);
        //从后往前遍历
        TreeNode cur = reverseNode;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.right;
        }
        //翻转回来
        reverseList(reverseNode);
    }
    public static TreeNode reverseList(TreeNode head) {
        TreeNode cur = head;
        TreeNode pre = null;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(9);
		
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left = node7;
		node3.right = node8;
		
		List<Integer> ls = postorderTraversal(node0);
		System.out.println(ls);
//		Queue<TreeNode> queue = new LinkedList<>();
//		queue.offer(rNode);
//		while (!queue.isEmpty()) {
//			TreeNode node = queue.poll();
//			System.out.println(node.val);
//			if(node.left!=null) {
//				queue.offer(node.left);
//			}
//			if(node.right!=null) {
//				queue.offer(node.right);
//			}
//		}
		
	}
}
