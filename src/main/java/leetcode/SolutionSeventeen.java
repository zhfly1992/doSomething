package leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/binary-tree-paths/submissions/
 * 二叉树的所有路径
 */
public class SolutionSeventeen {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null){
            return  result;
        }

        if (root.left == null && root.right == null){
             result.add(String.valueOf(root.val));
             return result;
        }

        allTrace(root,result,"");
        return result;

    }

    public void allTrace(TreeNode node,List<String> allTrace,String trace){
        if (node !=null){
            StringBuffer temp = new StringBuffer(trace);
            temp.append(node.val);
            if (node.left == null && node.right == null){
                allTrace.add(temp.toString());
                return;
            }
            else{
                temp.append("->");
                allTrace(node.left,allTrace,temp.toString());
                allTrace(node.right,allTrace,temp.toString());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1  = new TreeNode(1);
        TreeNode node2  = new TreeNode(2);
        TreeNode node3  = new TreeNode(3);
        TreeNode node5  = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        SolutionSeventeen solution = new SolutionSeventeen();
        List<String> strings = solution.binaryTreePaths(node1);
        System.out.println("123");
        StringBuffer test = new StringBuffer();
        test.append(48);
        System.out.println(test.length());
    }
}
