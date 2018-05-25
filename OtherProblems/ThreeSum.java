package OtherProblems;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!visited.contains(array[i])) {
                List<List<Integer>> temp = twoSum(array, i, target - array[i], visited);
                if (temp != null) {
                    for (List<Integer> list : temp) {
                        List<Integer> tmp = new ArrayList<>(list);
                        tmp.add(array[i]);
                        res.add(tmp);
                    }
                }
                visited.add(array[i]);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] array, int startIndex, int target, Set<Integer> visited) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = startIndex + 1; i < array.length; i++) {
            Integer count = countMap.get(array[i]);
            if (array[i] * 2 == target && count != null && count == 1) {
                res.add(Arrays.asList(array[i], array[i]));
            } else if (countMap.containsKey(target - array[i]) && count == null && !visited.contains(array[i])) {
                res.add(Arrays.asList(target - array[i], array[i]));
            }
            if (count == null) {
                countMap.put(array[i], 1);
            } else {
                countMap.put(array[i], count + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] array = new int[] {3, 4, 0, -1, 2, 0, 5};
        List<List<Integer>> res = solution.allTriples(array, 4);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
