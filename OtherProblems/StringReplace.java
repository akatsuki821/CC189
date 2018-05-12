package OtherProblems;

/*
replace the string s pattern in 'input' with string pattern t
*/


import java.util.*;

public class StringReplace {
    public String replace(String input, String s, String t) {
        // Write your solution here

        char[] arrInput = input.toCharArray();
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Set<Integer> occurence = checkOccurence(arrInput, arrS);
        String res;
        if (arrS.length >= arrT.length) {
            res = shortReplace(arrInput, arrS, arrT, occurence);
        } else {
            res = longReplace(arrInput, arrS, arrT, occurence);
        }
        return res;
    }

    private String shortReplace(char[] input, char[] s, char[] t, Set<Integer> occurence) {
        int slow = 0;
        int fast = 0;
        while (fast < input.length) {
            if (!occurence.contains(fast)) {
                input[slow++] = input[fast++];
            } else {
                replacement(input, t, slow);
                slow += t.length;
                fast += s.length;
            }
        }
        return new String(input, 0, slow);
    }

    private String longReplace(char[] input, char[] s, char[] t, Set<Integer> occurence) {
        int size = occurence.size();
        int totalLength = input.length + (t.length - s.length) * size;
        char[] res = new char[totalLength];
        int fast = input.length - 1;
        int slow = res.length - 1;
        while (fast >= 0) {
            if (!occurence.contains(fast - s.length + 1)) {
                res[slow--] = input[fast--];
            } else {
                replacement(res, t, slow - t.length + 1);
                slow -= t.length;
                fast -= s.length;
            }
        }
        return new String(res);
    }

    private void replacement(char[] input, char[] t, int start) {
        for (int i = 0; i < t.length; i++) {
            input[start + i] = t[i];
        }
    }

    private Set<Integer> checkOccurence(char[] input, char[] s) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i <= input.length - s.length; i++) {
            int index = 0;
            while (index < s.length && input[i + index] == s[index]) {
                index++;
            }
            if (index == s.length) {
                res.add(i);
                i += index - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringReplace stringReplace = new StringReplace();
        String input = "aaa";
        String s = "aa";
        String t = "bbb";
        String res = stringReplace.replace(input, s, t);
        System.out.println(res);
    }
}
