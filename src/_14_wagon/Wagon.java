package _14_wagon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Wagon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stackWagon = new ArrayDeque<>();

        int count = Integer.parseInt(scanner.nextLine());
        String[] wagons = scanner.nextLine().trim().split(" ");

        int index = 1;

        for (String wagon : wagons) {
            int element = Integer.parseInt(wagon);
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    if (stack.peek() == index) {
                        stackWagon.push(stack.pop());
                        index++;
                    } else {
                        break;
                    }
                }
            }
            if (element != index) {
                stack.push(element);
            } else {
                stackWagon.push(element);
                index++;
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == index) {
                stackWagon.push(stack.pop());
                index++;
            } else {
                break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
