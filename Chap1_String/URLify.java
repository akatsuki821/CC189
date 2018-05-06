package Chap1_String;
/*
replace all spaces in a string with '20%'. String has sufficient space at the end
to hold all additional characters. The input string and true length of the string.
 */
public class URLify {
    public static String urlify(String input, int length) {
        char[] arr = input.toCharArray();
        char[] toReplace = {'2', '0', '%'};
        int slow = arr.length - 1;
        int fast = length - 1;
        while (fast >= 0) {
            if (arr[fast] != ' ') {
                arr[slow] = arr[fast];
                slow --;
                fast --;
            } else {
                for (int i = 2; i >= 0; i--) {
                    arr[slow--] = toReplace[i];
                }
                fast--;
            }
        }
        return new String(arr, slow + 1, arr.length - slow - 1);
    }

    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        System.out.println(urlify(input, 13));
    }
}
