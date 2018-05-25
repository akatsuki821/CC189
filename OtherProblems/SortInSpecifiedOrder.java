package OtherProblems;

import java.util.*;

public class SortInSpecifiedOrder {
    public int[] sortSpecial(int[] A1, int[] A2) {
        // Write your solution here
        if (A1.length <= 1) {
            return A1;
        }
        //step 1: seperate the A1 into to segements
        int mid = separate(A1, A2);
        //step 2: rearrange the first segement and sort the second segment
        return null;
    }

    private int separate(int[] A1, int[] A2) {
        if (A2.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A2.length; i++) {
            set.add(A2[i]);
        }

        int left = 0;
        int right = A1.length - 1;
        while (left <= right) {
            if (set.contains(A1[left])) {
                left++;
            } else if (set.contains(A1[right])) {
                swap(A1, left++, right);
            } else {
                right--;
            }
        }
        return left == 0 ? 0 : left - 1;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
