package 二叉树;

import java.util.Stack;

/*
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 */



public class _450_删除二叉搜索树中的节点 {
	
	public static TreeNode deleteNode1(TreeNode root, int key) {
		if(root == null) return null;
		//查找节点
		Stack<PTreeNode> stack = new Stack<>();
		
		PTreeNode pNode = new PTreeNode(null, root);
		stack.push(pNode);
		PTreeNode searchNode = null;
		while (!stack.isEmpty()) {
			PTreeNode node = stack.pop();
			if(node.node.val == key) {
				searchNode = node;
				break;
			}
			
			if(node.node.right!= null) {
				stack.push(new PTreeNode(node.node, node.node.right));
			}
			if(node.node.left!= null) {
				stack.push(new PTreeNode(node.node, node.node.left));
			}
		}
		
		if(searchNode == null) return root;
		//叶子节点直接删除
		if(searchNode.node.left == null && searchNode.node.right == null) {
			if(searchNode.parent != null) {
				if(searchNode.parent.left == searchNode.node) {
					searchNode.parent.left = null;
				}else {
					searchNode.parent.right = null;
				}
			}else {
				return null;
			}
		}else if (searchNode.node.left == null) {
			TreeNode node = searchNode.node.right;
			TreeNode parent = searchNode.node;
			while (node.left!= null) {
				parent = node;
				node = node.left;
				
			}
			searchNode.node.val = node.val;
			if(parent == searchNode.node) {
				parent.right = null;
			}else {
				parent.left = null;
			}
			
		}else {
			TreeNode node = searchNode.node.left;
			TreeNode parent = searchNode.node;
			while (node.right!= null) {
				parent = node;
				node = node.right;
				
			}
			searchNode.node.val = node.val;
			if(parent == searchNode.node) {
				parent.left = null;
			}else {
				parent.right = null;
			}
		}
		return root;
    }
	
	
	public static TreeNode deleteNode10(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) {
            cur = cur.left;
        } else if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }

	public static TreeNode deleteNode(TreeNode root, int key) {
		TreeNode cur = root,curParent = null;
		while (cur != null && cur.val != key) {
			curParent = cur;
			if(cur.val > key) {
				cur = cur.left;
			}else {
				cur = cur.right;
			}
			
		}
		
		if (cur == null) {
			return root;
		}
		
		if(cur.left == null && cur.right == null) {
			cur = null;
		}else if (cur.right == null) {
			cur = cur.left;
		}else if (cur.left == null) {
			cur = cur.right;
		}else {
			TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
		}
		
		if(curParent == null) {
			return cur;
		}else {
			if(curParent.left != null && curParent.left.val == key) {
				curParent.left = cur;
			}else {
				curParent.right = cur;
			}
			
			return root;
		}
		
		
	}

	public static void main(String[] args) {
//		TreeNode node0 = new TreeNode(5);
//		TreeNode node1 = new TreeNode(3);
//		TreeNode node2 = new TreeNode(7);
//		TreeNode node3 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node5 = new TreeNode(6);
//		TreeNode node6 = new TreeNode(8);
//		TreeNode node7 = new TreeNode(1);
//		TreeNode node8 = new TreeNode(9);
//		
//		node0.left = node1;
//		node0.right = node2;
//		node1.left = node3;
//		node1.right = node4;
//		node2.left = node5;
//		node2.right = node6;
//		node3.left = node7;
//		node6.right = node8;
//		deleteNode(node0,7);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node6;
		
		deleteNode(node1,0);
		
	}
	
}
