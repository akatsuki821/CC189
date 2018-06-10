package OtherProblems;

import java.util.*;

/*
Given a string, we can insert at most one empty space between each pair of adjacent letters.
Print all permutations of strings after insertions of empty spaces.
 */
public class SpaceInsertion {
    public List<String> spaceInsertion(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        char[] arr = input.toCharArray();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(arr, 0, sb, result);
        return result;
    }

    private void helper(char[] arr, int index, StringBuilder sb, List<String> result) {
        if (index == arr.length - 1) {
            sb.append(arr[index]);
            result.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(arr[index]);
        sb.append(" ");
        helper(arr, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        helper(arr, index + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        SpaceInsertion solution = new SpaceInsertion();
        String input = "ABC";
        List<String> result = solution.spaceInsertion(input);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
