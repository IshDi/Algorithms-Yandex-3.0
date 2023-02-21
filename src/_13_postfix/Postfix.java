package _13_postfix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Postfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        String[] elements = scanner.nextLine().trim().split(" ");
        for (String el : elements) {
            if (el.equals("+")) {
                int x2 = stack.pop();
                int x1 = stack.pop();
                stack.push(x1 + x2);
            } else if (el.equals("-")) {
                int x2 = stack.pop();
                int x1 = stack.pop();
                stack.push(x1 - x2);
            } else if (el.equals("*")) {
                int x2 = stack.pop();
                int x1 = stack.pop();
                stack.push(x1 * x2);
            } else {
                stack.push(Integer.parseInt(el));
            }
        }
        System.out.println(stack.pop());
    }
}
