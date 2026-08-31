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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int mindis=Integer.MAX_VALUE;
        int first=-1;
        int last=-1;
        int index=1;
        ListNode curr=head.next;
        ListNode prev=head;
        while(curr.next!=null){
         if ((curr.val> prev.val && curr.val>curr.next.val) || (curr.val<prev.val && curr.val<curr.next.val)){
            if(first==-1){
                first=index;
                last=index;
            }
            else {
                mindis=Math.min(mindis,index-last);
                last=index;
            }
         }
         prev=curr;
         curr=curr.next;
         index++;
        }
     if(first==last){
        return new int[]{-1,-1};
     }
     int maxdis=last-first;
     return new int[]{mindis,maxdis};
    }
}