package 链表;

public class _203_移除链表元素 {
	
	 public static ListNode removeElements(ListNode head, int val) {
		 
		 ListNode tmp = new ListNode();
		 tmp.next = head;
		 ListNode tmp1 = tmp;
		 while (tmp1 != null &&tmp1.next!=null) {
			if(tmp1.next.val == val) {
				tmp1.next = tmp1.next.next;
			}else {
				tmp1 = tmp1.next;
			}
			
		}
		 
		 return tmp.next;
	 }
	 
	 public static void main(String[] args) {
		
		 ListNode node1 = new ListNode(1);
		 ListNode node2 = new ListNode(2);
		 ListNode node3 = new ListNode(6);
		 ListNode node4 = new ListNode(3);
		 ListNode node5 = new ListNode(4);
		 ListNode node6 = new ListNode(5);
		 ListNode node7 = new ListNode(6);
		 node1.next = node2;
		 node2.next = node3;
		 node3.next = node4;
		 node4.next = node5;
		 node5.next = node6;
		 node6.next = node7;
		 node7.next = null;
		
		 printNode(node1);
		 
		ListNode tmp = removeElements(node1, 6);
		
		printNode(tmp);
	}
	 
	public static void printNode(ListNode head) {
		
		ListNode tmp = head;
		 while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.next;
		}
		 System.out.println();
	} 
}
