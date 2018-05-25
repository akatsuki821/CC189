package Chap1_String;
/*
Given two strings, write a function to check if they are (less than) one edit (replace, insert, remove) away.
 */

public class OneAway {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    private boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    private boolean oneEditInsert(String first, String second) { //first length <= second length
        int firstIdx = 0;
        int secondIdx = 0;
        while (secondIdx < second.length() && firstIdx < first.length()) {
            if (first.charAt(firstIdx) != second.charAt(secondIdx)) {
                if (firstIdx != secondIdx) {
                    return false;
                }
                secondIdx++;
            } else {
                firstIdx++;
                secondIdx++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneAway solution = new OneAway();
        String first = "pale";
        String second = "bble";
        System.out.println(solution.oneEditAway(first, second));
    }
}
