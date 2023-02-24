// неэффективное решение при LinkedList и ArrayDeque co Scanner
// один из тестов показал превышение лимита - time-limit-exceeded (1.083s / 32.93Mb) и (1.022s / 32.86Mb)
package _16_queue;

import java.util.*;

public class QueueScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        while (true) {
            String[] input = scanner.nextLine().trim().split(" ");
            switch (input[0]) {
                case ("size"):
                    System.out.println(queue.size());
                    break;
                case ("push"):
                    queue.offer(Integer.parseInt(input[1]));
                    System.out.println("ok");
                    break;
                case ("pop"):
                    if (queue.isEmpty()) {
                        System.out.println("error");
                        continue;
                    }
                    System.out.println(queue.poll());
                    break;
                case ("front"):
                    if (queue.isEmpty()) {
                        System.out.println("error");
                        continue;
                    }
                    System.out.println(queue.peek());
                    break;
                case ("clear"):
                    queue.clear();
                    System.out.println("ok");
                    break;
            }
            if (input[0].equals("exit")) {
                System.out.println("bye");
                break;
            }
        }
    }
}
