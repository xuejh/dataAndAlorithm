package 链表;

public class _83_删除排序链表中的重复元素 {
	
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode tmp = head;
		while (tmp!=null && tmp.next != null) {
			if(tmp.val  == tmp.next.val) {
				tmp.next = tmp.next.next;
			}else {
				tmp = tmp.next;
			}
			
		}
		return head;
    }
	
	
	public static void main(String[] args) {
		
		 ListNode node1 = new ListNode(1);
		 ListNode node2 = new ListNode(1);
		 ListNode node3 = new ListNode(2);
		
		 node1.next = node2;
		 node2.next = node3;
		 node3.next = null;
		
		 printNode(node1);
		 
		ListNode tmp = deleteDuplicates(node1);
		
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
