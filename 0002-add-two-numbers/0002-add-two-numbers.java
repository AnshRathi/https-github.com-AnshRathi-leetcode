/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head to make building the list easier
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        // Continue loop as long as there are nodes to process OR a carry remains
        while (l1 != null || l2 != null || carry != 0) {
            // Get values (if list is exhausted, use 0)
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // Calculate sum and new carry
            int sum = carry + x + y;
            carry = sum / 10;
            
            // Create new node with the digit part of the sum
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // Move pointers forward
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }
}