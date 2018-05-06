package Chap1_String;
/*
Given a string, check if it is a permutation of a palindrome(only consider letters, non-letters should be
ignored)
1. record occurrence of each letter, should be even (at most one with odd occurrence)
2. use bit-manipulation to record occurrence
 */

public class PalindromePermutation {
    public static boolean palindromePermutation(String input) {
        int bitVector = occurrence(input);
        return bitVector == 0 || onlyOneBit(bitVector);
    }

    private static int occurrence(String input) {
        String s = input.toLowerCase();
        int bitVector = 0; //int type take 32 bits, use 26 only
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                int mask = 1 << (s.charAt(i) - 'a');
                bitVector ^= mask;
            }
        }
        return bitVector;
    }

    private static boolean onlyOneBit(int bitVector) {
        return ((bitVector & (bitVector - 1)) == 0);
    }

    public static void main(String[] args) {
        String input = "Tact coa";
        System.out.println(palindromePermutation(input));
    }
}
