package OtherProblems;

import java.util.*;

public class NearestGreater {
    public int[] nearestGreater(int[] a) {
        int[] index1 = nearestRight(a);
        int[] index2 = nearestLeft(a);
        int[] res = new int[a.length];
        for (int i = 0; i < index1.length; i++) {
            if (index1[i] != -1 && index2[i] != -1) {
                res[i] = Math.min(index1[i], index2[i]);
            } else {
                res[i] = index1[i] == -1 ? index2[i] : index1[i];
            }

        }
        return res;
    }

    public int[] nearestGreater2(int[] a) { // wrong
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[a.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < a.length; i++) {
            while (!stack.isEmpty() && a[stack.peekLast()] < a[i]) {
                int j = stack.pollLast();
                if (res[j] == -1 || i - j < j - res[j]) {
                    res[j] = i;
                }
            }
            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                if (a[i] != a[stack.peekLast()]) {
                    res[i] = stack.peekLast();
                } else {
                    res[i] = res[stack.peekLast()];
                }
            }
        }
        return res;
    }

    private int[] nearestRight(int[] a) {
        int[] result = new int[a.length];
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < a.length) {
            if (stack.isEmpty() || a[stack.peekLast()] >= a[i]) {
                stack.offer(i++);
            } else {
                result[stack.pollLast()] = i;
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pollLast()] = -1;
        }
        return result;
    }

    private int[] nearestLeft(int[] a) {
        int[] result = new int[a.length];
        Deque<Integer> stack = new LinkedList<>();
        int i = a.length - 1;
        while (i >= 0) {
            if (stack.isEmpty() || a[stack.peekLast()] >= a[i]) {
                stack.offer(i--);
            } else {
                result[stack.pollLast()] = i;
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pollLast()] = -1;
        }
        return result;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NearestGreater solution = new NearestGreater();
        int[] a = new int[] {1, 4, 2, 1, 7, 6};
        print(solution.nearestGreater(a));
        print(solution.nearestGreater2(a));
    }
}
