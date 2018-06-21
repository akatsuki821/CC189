package OtherProblems;

import java.util.*;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        if (num > 10) {
            return null;
        }
        int[] hours = new int[] {1, 2, 4, 8};
        int[] minutes = new int[] {1, 2, 4, 8, 16, 32};
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> hour = generateDigit(hours, i);
            List<Integer> minute = generateDigit(minutes, num - i);
            for (int h : hour) {
                if (h >= 12) {
                    continue;
                }
                for (int m : minute) {
                    if (m >= 60) {
                        continue;
                    }
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        geneateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void geneateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if (count == 0) {
            res.add(sum);
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            geneateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }

    public static void main(String[] args) {
        BinaryWatch solution = new BinaryWatch();
        System.out.println(solution.readBinaryWatch(0));
    }
}
