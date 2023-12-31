package 自己练习;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 中序遍历 {
	
	/*
	 * 作者：golandscape
		链接：https://leetcode.cn/problems/binary-tree-preorder-traversal/solutions/87526/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
		来源：力扣（LeetCode）
		著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	
	public static void inOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur = head;
		
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || cur != null) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				cur = node.right;
			}
		}
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		 	if(root == null) {
		 		return list;
		 	}
		 	
		 	TreeNode cur1 = root;
		 	TreeNode cur2 = null;
		 	while (cur1 != null) {
				cur2 = cur1.left;
				if(cur2 != null) {
					while (cur2.right!=null && cur2.right != cur1) {
						cur2 = cur2.right;
					}
					
					if(cur2.right == null) {
						cur2.right = cur1;
						list.add(cur1.val);
						cur1 = cur1.left;
						continue;
					}else {
						cur2.right = null;
					}
				}else {
					list.add(cur1.val);
				}
				
				cur1 = cur1.right;
			}
		 	
		 	
		 	return list;
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
		
		inOrderIteration(node0);
	}
}
