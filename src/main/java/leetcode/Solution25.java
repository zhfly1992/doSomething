package leetcode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
 * 二叉树的广度优先遍历
 */
public class Solution25 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node poll = queue.poll();
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (i != n){
                    poll.next = queue.peek();
                }else{
                    poll.next = null;
                }
            }
        }
        return root;
    }
}
