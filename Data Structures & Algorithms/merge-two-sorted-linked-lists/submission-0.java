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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode ans =null;
        ListNode res = null;
        if(head1.val<=head2.val){
            res=list1;
            ans= head1;
            head1=head1.next;
        }
        else{
            res=list2;
            ans = head2;
            head2=head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                ans.next = head1;
                head1= head1.next;
            }
            else{
                ans.next = head2;
                head2= head2.next;
            }
            ans= ans.next;
        } 
         
        if(head1 == null && head2==null) return ans;
        if(head1==null) ans.next = head2;
        if(head2==null) ans.next = head1;
        return res;
        
    }
}