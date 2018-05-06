package Chap1_String;
import java.util.*;

/*
Given two strings, write a method to decide if one is a permutation of the other
1. Sort both strings and compare, time = O(n log n)
2. Check the letter count for each string, should have same pattern (letter count), time = O(n), space = O(n)
*/

public class CheckPermutation {
    public static boolean checkPermutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private static String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static boolean checkPermutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] occurrence = new int[255];
        for (int i = 0 ; i < s.length(); i++) {
            occurrence[s.charAt(i)]++;
        }
        for (int i = 0 ; i < s.length(); i++) {
            occurrence[t.charAt(i)]--;
            if (occurrence[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "xiaochen";
        String t = "cenhxaoi";
        System.out.println(checkPermutation(s, t));
        System.out.println(checkPermutation2(s, t));
    }
}
