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
        
        //Finding length and tail
        ListNode tail = head;
        int len = 1;
        while (tail.next != null){
            tail = tail.next;
            len++;
        }
        
        //connect tail to head to make a circle
        tail.next = head;
        
        
        //finding new tail positions 
        k = k % len;
        int stepsToNewTail = len - k;
        ListNode newTail = head;
        for(int i = 1; i < stepsToNewTail; i++){
            newTail = newTail.next;
        }
        
        //new head is after the new tail
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}