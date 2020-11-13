package leetcode;



/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 重排链表----成绩不错
 * 执行用时：
 * 1 ms，在所有 Java 提交中击败了100.00%的用户
 * 内存消耗：
 * 40.3 MB，在所有 Java 提交中击败了99.91%的用户
 */
public class Solution33 {
      public void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        int length = 0;
        ListNode count = head;
        ListNode temp = head;
        while(count != null){
            length++;
            count = count.next;
        }
        ListNode[] nodes = new ListNode[length];
        for (int i = 0;i < length;i++){
            nodes[i] = temp;
            temp = temp.next;
        }
        // 控制下标位置
        int i = 0;
        ListNode current = nodes[0];
        // 计数(处理的节点数)
        int m = 1;
        while (m < length){
            if (i < length/2){
                current.next = nodes[length - 1 - i];
                current = current.next;
                i = length - i - 1;
                m++;
            }
            else{
                current.next = nodes[length - i];
                current = current.next;
                i = length - i;
                m++;
            }
        }
        current.next = null;
        head = nodes[0];
    }
}
