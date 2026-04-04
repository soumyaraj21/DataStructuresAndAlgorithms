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
        if(head==null || head.next==null){
            return head;
        }
        int length=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            length++;
        }
            temp.next=head;
            k=k%length;
            int steps=length-k;
            ListNode newTail=head;
            for(int i=0;i<steps-1;i++){
                newTail=newTail.next;
            }
           ListNode newHead=newTail.next;
            newTail.next=null;
            return newHead;
        }
}