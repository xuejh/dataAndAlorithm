package 链表;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * @author putao
 *
 */
public class _237_删除链表中的节点 {
	
	
	
	public class ListNode {
	      int val;
		  ListNode next;
		  ListNode(int x) { val = x; }
	 }
	
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
	
}
