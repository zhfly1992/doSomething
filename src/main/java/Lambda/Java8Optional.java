package Lambda;

import leetcode.TreeNode;

import java.util.Optional;

public class Java8Optional {
    static String strA = " abcd ";
    static String strB = null;





    public static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
//        if (text != null) {
//            System.out.println(text);
//        }
    }

    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    }

    public static void main(String[] args) {
        try {
            TreeNode treeNode = new TreeNode(1);
        //    print(strA);
            Optional<TreeNode> optionalTreeNode = Optional.ofNullable(treeNode);
            System.out.println(optionalTreeNode.isPresent());
            optionalTreeNode.ifPresent(a->a.setVal(2));
            System.out.println(treeNode.getVal());


        }
        catch (Exception e){
            e.printStackTrace();
        }

        

    }
}
