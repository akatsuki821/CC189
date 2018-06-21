package OtherProblems;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String initial = "1";
        int count = 1;
        while (count < n) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < initial.length()) {
                int cnt = 1;
                if (i < initial.length() - 1 && initial.charAt(i) == initial.charAt(i + 1)) {
                    while (i < initial.length() - 1 && initial.charAt(i) == initial.charAt(i + 1)) {
                        cnt++;
                        i++;
                    }
                    sb.append(cnt + "");
                } else {
                    sb.append("1");
                }
                sb.append(initial.charAt(i));
                i++;
            }
            initial = sb.toString();
            count++;
        }
        return initial;
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();
        System.out.println(solution.countAndSay(6));
    }
}
