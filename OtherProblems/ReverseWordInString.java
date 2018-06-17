package OtherProblems;

public class ReverseWordInString {
    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] arr = s.toCharArray();
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            if (arr[end] != ' ' && end < arr.length - 1) {
                end++;
            } else if (arr[end] == ' ' || end == arr.length - 1) {
                if (end == arr.length - 1) {
                    System.out.println(start + " " + end);
                    reverse(arr, start, end);
                    end++;
                } else {
                    reverse(arr, start, end - 1);
                    end++;
                    start = end;
                }
            }
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l++, r--);
        }
    }

    private void swap(char[] arr, int l, int r) {
        char tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        ReverseWordInString solution = new ReverseWordInString();
        String input = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(input));
    }
}
