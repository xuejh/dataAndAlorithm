package 自己练习;

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
	
	public static void postOrderIteration2(TreeNode head) { 
		if (head == null) {
			return;
		}
		TreeNode cur = head;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(head);
		while (!stack.isEmpty()) {
			TreeNode peek = stack.peek();
			if (peek.left != null && peek.left != cur && peek.right != cur) {
				stack.push(peek.left);
			} else if (peek.right != null && peek.right != cur) {
				stack.push(peek.right);
			} else {
				System.out.print(stack.pop().val + " ");
				cur = peek;
			}
		}
	}

	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(10);
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(15);
		TreeNode node3 = new TreeNode(79);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(80);
		TreeNode node6 = new TreeNode(90);
		
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		
		postOrderIteration2(node0);
	}
}
