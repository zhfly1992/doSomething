package leetcode;

/**
 * 不同的二叉搜索树
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
class SolutionEleven {
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n;i++){

            for (int j = 1;j <= i;j++){
                g[i] += g[j-1] * g[i-j];
            }
        }
        return g[n];
    }


    public static void main(String[] args) {
        SolutionEleven solution = new SolutionEleven();

        System.out.println(solution.numTrees(3));


    }
}