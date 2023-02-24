// эффективное решение, но без собственной структуры
package _16_queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class QueueFile {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/_16_queue/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/_16_queue/output.txt"));
        Queue<Integer> queue = new LinkedList<>();

        while (bufferedReader.ready()) {
            String[] input = bufferedReader.readLine().trim().split(" ");
            switch (input[0]) {
                case ("size"):
                    bufferedWriter.write(Integer.toString(queue.size()));
                    bufferedWriter.newLine();
                    break;
                case ("push"):
                    queue.offer(Integer.parseInt(input[1]));
                    bufferedWriter.write("ok");
                    bufferedWriter.newLine();
                    break;
                case ("pop"):
                    if (queue.isEmpty()) {
                        bufferedWriter.write("error");
                        bufferedWriter.newLine();
                        continue;
                    }
                    bufferedWriter.write(Integer.toString(queue.poll()));
                    bufferedWriter.newLine();
                    break;
                case ("front"):
                    if (queue.isEmpty()) {
                        bufferedWriter.write("error");
                        bufferedWriter.newLine();
                        continue;
                    }
                    bufferedWriter.write(Integer.toString(queue.peek()));
                    bufferedWriter.newLine();
                    break;
                case ("clear"):
                    queue.clear();
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
