package OtherProblems;

/*
Given an encoded string, return its corresponding decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times.
Note: k is guaranteed to be a positive integer.
Note that your solution should have linear complexity because this is what you will be asked during an interview.
 */

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        decodeStringRecur(s.toCharArray(), result, 0);
        return result.toString();
    }

    private int decodeStringRecur(char[] str, StringBuilder result, int start) {
        if (start >= str.length) {
            return start;
        }

        int p1 = start;
        while (p1 < str.length && str[p1] != ']') {
            if (str[p1] < '0' || str[p1] > '9') {
                result.append(str[p1++]);
            } else {
                int val  = 0;
                while (str[p1] != '[') {
                    val = val * 10 + (str[p1++] - '0');
                }
                StringBuilder tmp = new StringBuilder();
                p1 = decodeStringRecur(str, tmp, p1 + 1);
                for (int i = 0; i < val; i++) {
                    result.append(tmp);
                }
            }
        }
        return p1 < str.length ? p1 + 1 : p1;
    }
}
