package _15_town;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Town {
    private int index;
    private int value;

    public Town(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Town> stack = new ArrayDeque<>();

        int count = Integer.parseInt(scanner.nextLine());
        String[] costs = scanner.nextLine().trim().split(" ");

        String[] total = new String[count];

        for (int i = 0; i < total.length; i++) {
            if (!stack.isEmpty()) {
                while (stack.peek().getValue() > Integer.parseInt(costs[i])) {
                    int forArray = stack.pop().getIndex();
                    total[forArray] = Integer.toString(i);
                    if (stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(new Town(i, Integer.parseInt(costs[i])));
            }
            if (stack.isEmpty()) {
                stack.push(new Town(i, Integer.parseInt(costs[i])));
            }
            if (stack.peek().getValue() <= Integer.parseInt(costs[i])) {
                stack.push(new Town(i, Integer.parseInt(costs[i])));
            }
            if (i == (total.length - 1) && !stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    int forArray = stack.pop().getIndex();
                    total[forArray] = Integer.toString(-1);
                    stack.pop();
                }
            }
        }
        String totalString = String.join(" ", total);
        System.out.println(totalString);
    }
}
