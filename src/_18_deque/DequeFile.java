package _18_deque;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class DequeFile {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/_18_deque/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/_18_deque/output.txt"));
        Deque<Integer> deque = new LinkedList<>();

        while (bufferedReader.ready()) {
            String[] input = bufferedReader.readLine().trim().split(" ");
            switch (input[0]) {
                case ("size"):
                    bufferedWriter.write(Integer.toString(deque.size()));
                    bufferedWriter.newLine();
                    break;
                case ("push_front"):
                    deque.offerFirst(Integer.parseInt(input[1]));
                    bufferedWriter.write("ok");
                    bufferedWriter.newLine();
                    break;
                case ("push_back"):
                    deque.offerLast(Integer.parseInt(input[1]));
                    bufferedWriter.write("ok");
                    bufferedWriter.newLine();
                    break;
                case ("pop_front"):
                    if (deque.isEmpty()) {
                        bufferedWriter.write("error");
                        bufferedWriter.newLine();
                        continue;
                    }
                    bufferedWriter.write(Integer.toString(deque.pollFirst()));
                    bufferedWriter.newLine();
                    break;
                case ("pop_back"):
                    if (deque.isEmpty()) {
                        bufferedWriter.write("error");
                        bufferedWriter.newLine();
                        continue;
                    }
                    bufferedWriter.write(Integer.toString(deque.pollLast()));
                    bufferedWriter.newLine();
                    break;
                case ("front"):
                    if (deque.isEmpty()) {
                        bufferedWriter.write("error");
                        bufferedWriter.newLine();
                        continue;
                    }
                    bufferedWriter.write(Integer.toString(deque.peekFirst()));
                    bufferedWriter.newLine();
                    break;
                case ("back"):
                    if (deque.isEmpty()) {
                        bufferedWriter.write("error");
                        bufferedWriter.newLine();
                        continue;
                    }
                    bufferedWriter.write(Integer.toString(deque.peekLast()));
                    bufferedWriter.newLine();
                    break;
                case ("clear"):
                    deque.clear();
                    bufferedWriter.write("ok");
                    bufferedWriter.newLine();
                    break;
            }
            if (input[0].equals("exit")) {
                bufferedWriter.write("bye");
                break;
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
