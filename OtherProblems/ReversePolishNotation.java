package OtherProblems;

import java.util.*;

public class ReversePolishNotation {
    public int evalRPN1(String[] tokens) {
        // Write your solution here
        Set<String> operator = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Deque<Integer> stack = new LinkedList<>();
        for (String str : tokens) {
            if (!operator.contains(str)) {
                stack.offerLast(Integer.valueOf(str));
            } else {
                int operand1 = stack.pollLast();
                int operand2 = stack.pollLast();
                switch (str) {
                    case "+":
                        stack.offerLast(operand2 + operand1);
                        break;
                    case "-":
                        stack.offerLast(operand2 - operand1);
                        break;
                    case "*":
                        stack.offerLast(operand2 * operand1);
                        break;
                    case "/":
                        stack.offerLast(operand2 / operand1);
                        break;
                }
            }
        }
        return stack.peekLast();
    }

    public static void main(String[] args) {
        ReversePolishNotation solution = new ReversePolishNotation();
        String[] tokens = new String[] {"4","13","5","/","+"};
        System.out.println(solution.evalRPN1(tokens));
    }
}
