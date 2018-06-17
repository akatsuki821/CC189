package OtherProblems;

import java.util.*;

public class ThirdMax {
    public int thirdMax(int[] nums) {
        int[] max = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max[0] || nums[i] == max[1] || nums[i] == max[2]) {
                continue;
            }
            if (nums[i] > max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = nums[i];
            } else if (nums[i] > max[1] && nums[i] < max[0]) {
                max[2] = max[1];
                max[1] = nums[i];
            } else if (nums[i] > max[2] && nums[i] < max[1]) {
                max[2] = nums[i];
            }
        }
        return max[2];
    }

    public static void main(String[] args) {
        ThirdMax solution = new ThirdMax();
        int[] nums = new int[] {1, 2};
        //System.out.println(solution.thirdMax(nums));
        String test = "A man, a plan, a canal: Panama";
        System.out.println(test.toLowerCase().replaceAll("[^a-zA-Z0-9]",""));

    }
}
