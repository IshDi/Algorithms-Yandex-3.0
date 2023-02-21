package _12_basket;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Basket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();

        String[] elements = scanner.nextLine().trim().split("");

        if (elements.length % 2 != 0) {
            System.out.println("no");
        } else {
            for (String el : elements) {
                if (stack.size() == 0) {
                    if (el.equals(")") || el.equals("]") || el.equals("}")) {
                        stack.push(el);
                        break;
                    }
                }
                if (el.equals("(")|| el.equals("[") || el.equals("{")) {
                    stack.push(el);
                }
                if (el.equals(")") && (stack.peek().equals("("))) {
                    stack.pop();
                }
                if ((el.equals("]")) && (stack.peek().equals("["))) {
                    stack.pop();
                }
                if ((el.equals("}")) && (stack.peek().equals("{"))) {
                    stack.pop();
                }
            }
            if (stack.size() == 0) {
                System.out.println("yes");
            }
            if (stack.size() > 0) {
                System.out.println("no");
            }
        }
    }
}
