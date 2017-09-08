package leetcode;

/*
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
    	
    	ListNode ln1 = head;
    	ListNode ln2 = head;
    	
    	while (ln1 != null) {
    		if (ln1.val == val) {
    			if (ln1 == head) {
    				head = head.next;
    			} else {
    				ln2.next = ln1.next;
    			}
    		} else {
    			ln2 = ln1;
    		}
    		ln1 = ln1.next;
    	}
    	
		return head;
    }
}
