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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Calculate the length and find the current tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Connect tail to head to make it circular
        tail.next = head;

        // 3. Find the new tail: it's at (length - k % length - 1) steps from head
        k = k % length;
        int stepsToNewTail = length - k;
        
        ListNode newTail = tail; // Start from old tail for easier stepping
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 4. Set the new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
