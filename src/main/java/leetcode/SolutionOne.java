package leetcode;

/**
 * 并查集算法
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
class SolutionOne {
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = find(parent,parent[index]);
            index = parent[index];
        }
        return index;
    }

    public static void main(String[] args){
        String[] aa = new String[4];
        aa[1] = "a==b";
        aa[2] = "b==c";
        aa[3] = "c==d";
        aa[0] = "a==d";
        SolutionOne solution= new SolutionOne();
        boolean equationsPossible = solution.equationsPossible(aa);
        System.out.println(equationsPossible);
    }
}

