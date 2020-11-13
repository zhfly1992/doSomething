package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution24 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0;i < pPath.size() && i < qPath.size(); i++){
            if (pPath.get(i).val == qPath.get(i).val){
                ancestor = pPath.get(i);
            }
        }
        return ancestor;
    }


    public List<TreeNode> getPath(TreeNode root,TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node.val != target.val){
            path.add(node);
            if (node.val < target.val){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        path.add(node);
        return path;
    }
}
