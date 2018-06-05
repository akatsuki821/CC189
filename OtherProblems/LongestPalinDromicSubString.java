package OtherProblems;

public class LongestPalinDromicSubString {
    public String longestPalindrome(String s) {
        // Write your solution here
        if (s.isEmpty()) {
            return s;
        }
        char[] arr = s.toCharArray();
        boolean[][] M = new boolean[arr.length][arr.length];
        int longest = 0;
        int start = 0;
        int end = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j < arr.length; j++) {
                if (i == j) {
                    M[i][j] = true;
                } else if (i + 1 == j && arr[i] == arr[j]) {
                    M[i][j] = true;
                } else {
                    if (arr[i] == arr[j]) {
                        M[i][j] |= M[i + 1][j - 1];
                    }
                }
                if (M[i][j] && longest < j - i) {
                    longest = j - i;
                    start = i;
                    end = j;
                }
            }
        }
//        System.out.println(start + " " + end);
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.print(M[i][j] + " ");
//            }
//            System.out.println();
//        }

        return new String(arr, start, end - start + 1);
    }

    public static void main(String[] args) {
        LongestPalinDromicSubString solution = new LongestPalinDromicSubString();
        String test = "abcbcbd";
        System.out.println(solution.longestPalindrome(test));
    }
}
