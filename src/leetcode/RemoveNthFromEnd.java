package leetcode;

public class RemoveNthFromEnd {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int count = 0;
		ListNode node = head;
		
		while (node != null) {
			count++;
			node = node.next;
		}
		
		ListNode node1 = node = head;
		for (int i = 0; i < count - n; ++i) {
			node1 = node;
			node = node.next;
		}
		
		
		if (node == node1 && node == head)
			return head.next;
		else {
			node1.next = node.next;
			node.next = null;
		}
		
		return head;
    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		
		ListNode n6 = removeNthFromEnd(n1, 2);
		
		printList(n6);
	}

	private static void printList(ListNode n6) {
		ListNode node = n6;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
