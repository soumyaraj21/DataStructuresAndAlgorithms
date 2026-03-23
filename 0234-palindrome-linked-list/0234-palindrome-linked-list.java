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
    public boolean isPalindrome(ListNode head) {
      if(head==null && head.next==null){
        return true;
      }  
      ListNode slow=head;
      ListNode fast=head;
      while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
      }
    ListNode prev=null;
    ListNode curr=slow;
    while(curr!=null){
        ListNode next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    ListNode first=head;
    ListNode second=prev;
    while(second!=null){
        if(first.val!=second.val){
            return false;
        }
        first=first.next;
        second=second.next;
    }
    return true;
    }
}