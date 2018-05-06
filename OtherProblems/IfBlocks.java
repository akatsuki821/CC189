package OtherProblems;


//similar to generate valid pairs of parentheses, here is to generate "if blocks" with valid indentations
/*e.g. if {
            if {
            }
            if{
            }
       }
*/
import java.util.ArrayList;
import java.util.List;

public class IfBlocks {
    public static List<String> ifBlocks(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        helper(n, 0, 0, cur, res);
        return res;
    }

    private static void helper(int n, int left, int right, StringBuilder cur, List<String> res) {
        if (right == n) {
            res.add(format(cur.toString().toCharArray()));
            return;
        }
        if (left < n) {
            cur.append("{");
            helper(n, left + 1, right, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append("}");
            helper(n, left, right + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    private static String format(char[] array) {
        StringBuilder res = new StringBuilder();
        int level = 0;
        for (char ch : array) {
            if (ch == '{') {
                appendSpace(res, level);
                res.append("if {\n");
                level++;
            } else {
                level--;
                appendSpace(res, level);
                res.append("}\n");
            }
        }
        return res.toString();
    }

    private static void appendSpace(StringBuilder res, int level) {
        for (int i = 0; i < level; i++) {
            res.append("  ");
        }
    }

    public static void main(String[] args) {
        List<String> res = ifBlocks(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}


