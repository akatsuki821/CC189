package OtherProblems;

import java.util.*;

/*
Given a number of different denominations of coins, get all the possible ways to pay a
target number of cents.
coins is not null and not empty, no duplicate integers, sorted by descending order
 */

public class CombinationOfCoins {
    public static List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> res = new ArrayList<>();
        Integer[] coinComb = new Integer[coins.length]; //Here needs to use Integer array rather than int array
        combination(target, coins, 0, coinComb, res);
        return res;
    }

    private static void combination(int target, int[] coins, int index, Integer[] coinComb, List<List<Integer>> res) {
        //base case 1: get a solution
        if (target == 0 && index == coins.length) {
            res.add(new ArrayList<>(Arrays.asList(coinComb)));
            return;
        }
        //base case 2: not a solution, just return
        if (target < 0 || index == coins.length) {
            return;
        }

        for (int i = 0; i <= target / coins[index]; i++) {
            coinComb[index] = i;
            combination(target - coins[index] * i, coins, index + 1, coinComb, res);
        }
    }

    public static void main(String[] args) {
        int target = 125;
        int[] coins = new int[] {25, 10, 5, 1};
        List<List<Integer>> coinComb = combinations(target, coins);
        for (List<Integer> l : coinComb) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
