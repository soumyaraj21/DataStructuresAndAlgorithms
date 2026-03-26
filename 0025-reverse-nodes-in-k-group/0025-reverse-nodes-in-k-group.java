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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int count=0;
        while(temp!=null && count<k){
            temp=temp.next;
            count++;
        }
    if(count<k){
        return head;
    }
    ListNode prev=null;
    ListNode curr=head;
    ListNode next=null;
    count=0;
    while(curr!=null && count<k){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        count++;
    }
    if(next!=null){
        head.next=reverseKGroup(next,k);
    }
    return prev;
    }
}