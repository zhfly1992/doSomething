package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表
 */
public class Solution36 {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 1){
            return true;
        }
        for (int i = 0; i < list.size()/2;i ++){
            if (!list.get(i).equals(list.get(list.size() - i - 1))){
                return false;
            }
        }
        return true;
    }
}
