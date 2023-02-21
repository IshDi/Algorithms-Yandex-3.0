package _11_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Stack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();

        while (true) {
            String str = scanner.nextLine().trim();
            if (str.isEmpty()) {
                System.out.println();
                continue;
            }
            String[] input = str.split(" ");
            if (input[0].equals("exit")) {
                System.out.println("bye");
                break;
            } else {
                switch (input[0]) {
                    case ("push"):
                        stack.push(Integer.parseInt(input[1]));
                        System.out.println("ok");
                        break;
                    case ("pop"):
                        if (stack.isEmpty()) {
                            System.out.println("error");
                            continue;
                        }
                        int output = stack.pop();
                        System.out.println(output);
                        break;
                    case ("back"):
                        if (stack.isEmpty()) {
                            System.out.println("error");
                            continue;
                        }
                        int output2 = stack.peek();
                        System.out.println(output2);
                        break;
                    case ("size"):
                        int length = stack.size();
                        System.out.println(length);
                        break;
                    case ("clear"):
                        stack.clear();
                        System.out.println("ok");
                        break;
                }
            }
        }
    }
}
