package OtherProblems;
/*
Given an array of strings, find if all the strings can be chained to form a circle.
Two string s1 and s2 can be chained, iff the last letter of s1 is identical to the first letter of s2.
 */
public class WordChainCircle {
    public boolean chainCircle(String[] words) {
        if (words == null || words.length == 0) {
            return false;
        }
        return dfs(words, 1);
    }

    private boolean dfs(String[] words, int index) {
        if (index == words.length) {
            return canChain(words[0], words[index - 1]);
        }

        for (int i = index; i < words.length; i++) {
            if (canChain(words[i], words[index - 1])) {
                swap(words, i, index);
                if (dfs(words, index + 1)) {
                    return true;
                }
                swap(words, i, index);
            }
        }
        return false;
    }

    private boolean canChain(String s1, String s2) {
        return s1.charAt(0) == s2.charAt(s2.length() - 1);
    }

    private void swap(String[] arr, int l, int r) {
        String tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
