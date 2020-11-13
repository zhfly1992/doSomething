package leetcode;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * 奇偶链表
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode begin2;
        //记录下头结点
        ListNode begin1 = head;
        //记录下第二个节点
        if (head.next != null){
            begin2 = head.next;
        }
        else {
            return head;
        }
        //临时节点
        ListNode temp;
        while (head.next != null && head.next.next != null){
            temp = head.next;
            head.next = head.next.next;
            head = head.next;
            temp.next = head.next;
        }
        head.next = begin2;
        return begin1;
    }
}
