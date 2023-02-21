//неверная реализация
package _11_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class StackBuff {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();
        try {
            String s = bufferedReader.readLine();
            bufferedReader.close();
            while (true) {
                String str = s.trim();
                if (str.isEmpty()) {
                    System.out.println();
                    continue;
                }
                String[] input = str.split(" ");
                if (input[0].equals("exit")) {
                    System.out.println("bye");
                    break;
                } else {
                    optionFun(input, stack);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void optionFun(String[] st, Deque<Integer> stack) {
        switch (st[0]) {
            case ("push"):
                stack.push(Integer.parseInt(st[1]));
                System.out.println("ok");
                break;
            case ("pop"):
                if (stack.isEmpty()) {
                    System.out.println("error");
                }
                int output = stack.pop();
                System.out.println(output);
                break;
            case ("back"):
                if (stack.isEmpty()) {
                    System.out.println("error");
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
