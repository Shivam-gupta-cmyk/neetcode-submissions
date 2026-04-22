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

    public ListNode mergeTwoSortedLists(ListNode ls1, ListNode ls2){
        List<ListNode> ls = new ArrayList<>();
        while(ls1!=null){
            ListNode temp = ls1.next;
            ls1.next = null;
            ls.add(ls1);
            ls1 = temp;
        }
        while(ls2!=null){
            ListNode temp = ls2.next;
            ls2.next = null;
            ls.add(ls2);
            ls2 = temp;
        }
        ls.sort((a, b) -> a.val - b.val);
        ListNode head = ls.get(0);
        for(int i=0;i<ls.size()-1;i++){
            ls.get(i).next = ls.get(i+1);
        }
        return head;

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode resNode = mergeTwoSortedLists(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++){
            resNode = mergeTwoSortedLists(resNode, lists[i]);
        }
        return resNode;
    }
}
