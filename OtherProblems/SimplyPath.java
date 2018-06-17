package OtherProblems;

public class SimplyPath {
    public String simplifyPath(String path) {
        if (path.charAt(0) != '/') {
            path = "/" + path;
        }
        char[] arr = path.toCharArray();
        int slow = 1;
        int fast = 1;
        while (fast < arr.length) {
            if (arr[fast] == '/' && arr[slow - 1] == '/') {
                fast++;
            } else if (arr[fast] == '.' && arr[fast + 1] == '/') {
                fast += 2;
            } else if (arr[fast] == '.' && arr[fast + 1] == '.') {
                fast += 3;
                slow = moveBack(arr, slow);
            } else {
                arr[slow++] = arr[fast++];
            }
        }
        if (slow > 1 && arr[slow - 1] == '/') {
            slow--;
        }
        return new String(arr, 0, slow);
    }

    private int moveBack(char[] arr, int index) {
        if (index > 1) {
            index--;
        }
        while (index > 1 && arr[index - 1] != '/') {
            index--;
        }

        return index;
    }

    public static void main(String[] args) {
        SimplyPath solution = new SimplyPath();
        String input = "a/../../b/";
        System.out.println(solution.simplifyPath(input));
    }
}
