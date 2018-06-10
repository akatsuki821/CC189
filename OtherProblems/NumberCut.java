package OtherProblems;

/*
How to cut/split the number into a minimum number of items such that each item is equal to an integer's square value.
 */

public class NumberCut {
    public int minCut(int n) {
        if (n == 0) {
            return 0;
        }
        int[] M = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            M[i] = i;
            for (int j = 1; j * j <= i; j++) {
                M[i] = Math.min(M[i - j * j], M[i]);
            }
        }
        return M[n];
    }
}
