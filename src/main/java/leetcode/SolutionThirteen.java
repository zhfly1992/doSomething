package leetcode;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 */
public class SolutionThirteen {

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }



        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //这里其中一个节点为空，说明left和right有一个必然为0，所以可以返回right +1:left + 1;
        if (left == 0 || right == 0){
            return right + left + 1;
        }
        return left > right? right +1:left + 1;
    }



    public static void main(String[] args) {
        SolutionThirteen solution = new SolutionThirteen();
    }
}
