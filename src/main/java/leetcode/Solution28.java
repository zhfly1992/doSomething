package leetcode;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/submissions/
 * 两两交换链表中的节点  重点理解递归
 */
public class Solution28 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //设置一个临时节点放在链表头
        ListNode priorTemp = new ListNode(0);
        priorTemp.next = head;
        //交换用临时节点
        ListNode swaptemp;
        //返回的新链表头结点
        ListNode newHead = head.next;



        while (priorTemp.next != null && priorTemp.next.next != null) {
            swaptemp = priorTemp.next;
            priorTemp.next = priorTemp.next.next;
            swaptemp.next = priorTemp.next.next;
            priorTemp.next.next = swaptemp;
            priorTemp = swaptemp;
        }
        return newHead;
    }
}
