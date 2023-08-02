package 自己练习;

import java.util.ArrayList;
import java.util.List;

public class 前序遍历 {
	
	
	
	
	
	public static List<Integer> preorderTraversal(TreeNode root) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * 作者：golandscape
	   链接：https://leetcode.cn/problems/binary-tree-preorder-traversal/solutions/87526/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
	   来源：力扣（LeetCode）
	   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 */
	
	public static void preOrderMorris(TreeNode head) {
		if (head == null) {
			return;
		}
		TreeNode cur1 = head;//当前开始遍历的节点
		TreeNode cur2 = null;//记录当前结点的左子树
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {//找到当前左子树的最右侧节点，且这个节点应该在指向根结点之前，否则整个节点又回到了根结点。
					cur2 = cur2.right;
				}
				if (cur2.right == null) {//这个时候如果最右侧这个节点的右指针没有指向根结点，创建连接然后往下一个左子树的根结点进行连接操作。
					cur2.right = cur1;
					System.out.print(cur1.val + " ");
					cur1 = cur1.left;
					continue;
				} else {//当左子树的最右侧节点有指向根结点，此时说明我们已经回到了根结点并重复了之前的操作，同时在回到根结点的时候我们应该已经处理完 左子树的最右侧节点 了，把路断开。
					cur2.right = null;
				}
			} else {
				System.out.print(cur1.val + " ");
			}
			cur1 = cur1.right;//一直往右边走，参考图
		}
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
		
		preorderTraversal(node0);
	}
}
