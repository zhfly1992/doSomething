package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 二叉树的中序遍历--递归，迭代均可
 */
public class Solution21 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root ){
            return result;
        }
        if (root.left == null && root.right == null){
            result.add(root.val);
            return result;
        }
        middleOrder(root,result);
        return result;

    }

    public void  middleOrder(TreeNode node,List<Integer> result){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            result.add(node.val);
            return;
        }

        middleOrder(node.left,result);
        result.add(node.val);
        middleOrder(node.right,result);
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        List<Integer> integers = solution21.inorderTraversal(treeNode1);
        System.out.println(integers);
    }
}
