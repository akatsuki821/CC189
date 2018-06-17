package OtherProblems;

/*
Note: Write a solution with O(n) complexity, since this is what you would be asked to do during a real interview.
Given an array a composed of distinct elements, find the next larger element for each element of the array,
i.e. the first element to the right that is greater than this element, in the order in which they appear in the array,
and return the results as a new array of the same length. If an element does not have a larger element to its right,
put -1 in the appropriate cell of the result array.

Example

For a = [6, 7, 3, 8], the output should be
nextLarger(a) = [7, 8, 8, -1].

In this array, the next larger element for 6 is 7, for 7 is 8, for 3 is 8 (7 is not a valid option since elements
from a can only be compared to elements to their right), and for 8 there is no such element, so we put -1 in the last cell.
 */


import java.util.*;

//单调非递增栈！ 栈里存index比直接存value能保存的信息更多
//https://blog.csdn.net/bxw1992/article/details/77856304
//https://blog.csdn.net/u012067392/article/details/72656472
public class NextLarger {
    public int[] nextLarger(int[] a) {
        int[] result = new int[a.length];
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < a.length) {
            if (stack.isEmpty() || a[stack.peekLast()] >= a[i]) {
                stack.offerLast(i++);
            } else {
                result[stack.pollLast()] = a[i];
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pollLast()] = -1;
        }
        return result;
    }
}
