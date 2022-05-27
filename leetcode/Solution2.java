package leetcode;

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
class Solution2 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val,ListNode next){this.val = val;this.next = next;}
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail;
        ListNode head = tail = null;
        int tag = 0;
        int a1,a2;
        while(l1!=null||l2!=null){
            a1 = l1!=null?l1.val:0;
            a2 = l2!=null?l2.val:0;
            if(head == null){
                head.next = new ListNode((a1+a2+tag)%10);
            }
            else {
                tail.next = new ListNode((a1+a2+tag)%10);
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            tag = (a1+a2+tag)%10;
        }
        if(tag == 1){
            tail.next = new ListNode(1);
        }
        return head;
    }
}