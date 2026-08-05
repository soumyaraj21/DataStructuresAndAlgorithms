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
    public ListNode mergeKLists(ListNode[] lists) {
      PriorityQueue<ListNode> minheap=new PriorityQueue<>((a,b)->a.val-b.val);
      for(ListNode head:lists){
        if(head!=null){
            minheap.offer(head);
        }
        }
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        while(!minheap.isEmpty()){
            ListNode node=minheap.poll();
            current.next=node;
            current=current.next;
            if(node.next!=null){
                minheap.offer(node.next);
            }
        }
        return dummy.next;
    }
}