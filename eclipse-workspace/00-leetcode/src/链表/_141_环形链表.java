package 链表;

public class _141_环形链表 {
	
	class ListNode {
		
	
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	
	public boolean hasCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        if(fast != null && fast.next != null) {
        	if(fast == slow) {
        		return true;
        	}
        	
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        return false;
    }
	
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;
		
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
        	if(fast == slow) {
        		return true;
        	}
        	
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        return false;
    }
}
