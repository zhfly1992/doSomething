package leetcode;

import java.util.List;

/**
 * 三角形最小路径之和
 * https://leetcode-cn.com/problems/triangle/
 */
class SolutionTen {
    public int minimumTotal(List<List<Integer>> triangle) {

        int row = triangle.size();
        if (row == 0) {
            return 0;
        }
        if (row == 1) {
            return triangle.get(0).get(0);
        }
        int[][] result = new int[row][row];
        //初始化起始位
        result[0][0] = triangle.get(0).get(0);


        //第i行只有i列
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    result[i][j] = result[i - 1][j] + triangle.get(i).get(0);
                }
                else if (j == i){
                    result[i][j] = result[i-1][j-1] + triangle.get(i).get(j);
                }
                else {
                    int min = result[i - 1][j - 1] < result[i - 1][j] ? result[i - 1][j - 1] : result[i - 1][j];
                    result[i][j] = min + triangle.get(i).get(j);
                }
            }
        }

        int minTotal = result[row -1][0];
        for (int m = 1;m < row;m++){
            minTotal = Math.min(minTotal,result[row -1][m]);
        }

        return minTotal;
    }


}