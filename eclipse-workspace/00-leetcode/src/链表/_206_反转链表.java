package 链表;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * @author putao
 *
 */
public class _206_反转链表 {
	
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	
	 
	 public ListNode reverseList3(ListNode head) {
		 if(head == null || head.next == null) {
			 return head;
		 }
		 
			ListNode node = reverseList3(head.next);
			head.next = head;
			head.next = null;
			
			return head;
	    }
	 
	 
	 public ListNode reverseList4(ListNode head) {
		 if(head == null || head.next == null) {
			 return head;
		 }
		 
			ListNode newHead = null;
			while (head.next!=null) {
				ListNode tmp = head.next;
				head.next = newHead;
				newHead = head;
				head = tmp;
			}
			return newHead;
			
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseList(head.next);
		head.next.next= head;
		head.next = null;
		return newHead;
    }
	
	public ListNode reverseList2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = null;
		while(head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		
		return newHead;
    }
}
