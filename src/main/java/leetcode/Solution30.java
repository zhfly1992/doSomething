package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 填充每个节点的下一个右侧节点指针-- 队列实现，二叉树的广度优先遍历
 *
 */
public class Solution30 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // 记录当前队列大小（同一层的元素个数）
            int size = queue.size();
            // 遍历这一层所有节点
            for (int i = 0; i < size; i++) {
                // 弹出队列头元素
                Node poll = queue.poll();
                // 如果同一层还有，则链接
                if (i < size - 1) {
                    poll.next = queue.peek();
                }

                // 拓展下一层节点
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }
}
