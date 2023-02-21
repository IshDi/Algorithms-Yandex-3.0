//неверная реализация
package _11_stack;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class StackInput {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void writeLine(String IntToFile) throws IOException {
        bufferedWriter.write(IntToFile);
        bufferedWriter.newLine();
    }

    private static void run() throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();
        String s = bufferedReader.readLine();
        while (true) {
            String str = s.trim();
            String toFile = "";
//            if (str.isEmpty()) {
//                System.out.println();
//                continue;
//            }
            String[] input = str.split(" ");
            if (input[0].equals("exit")) {
                toFile = "bye";
                writeLine(toFile);
                break;
            } else {
                switch (input[0]) {
                    case ("push"):
                        stack.push(Integer.parseInt(input[1]));
                        toFile = "ok";
                        writeLine(toFile);
                        break;
                    case ("pop"):
                        if (stack.isEmpty()) {
                            toFile = "error";
                            writeLine(toFile);
                        }
                        int output = stack.pop();
                        writeLine(output + "");
                        break;
                    case ("back"):
                        if (stack.isEmpty()) {
                            toFile = "error";
                            writeLine(toFile);
                        }
                        int output2 = stack.peek();
                        writeLine(output2 + "");
                        break;
                    case ("size"):
                        int length = stack.size();
                        writeLine(length + "");
                        break;
                    case ("clear"):
                        stack.clear();
                        toFile = "ok";
                        writeLine(toFile);
                        break;
                }
            }
        }
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }
}
