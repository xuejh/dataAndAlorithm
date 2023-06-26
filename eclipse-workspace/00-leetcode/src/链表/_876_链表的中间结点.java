package 链表;

public class _876_链表的中间结点 {
	
	 public ListNode middleNode(ListNode head) {
		 	ListNode slow = head;
		 	ListNode fast = head.next;
		 	while(fast !=null) {
		 		slow = slow.next;
		 		fast = fast.next;
		 		if(fast!=null) {
		 			fast = fast.next;
		 		}
		 	}
		 	return slow;
	    }
}
