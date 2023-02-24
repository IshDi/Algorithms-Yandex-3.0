// неэффективное решение co Scanner
// один из тестов показал превышение лимита - time-limit-exceeded (1.041s / 34.50Mb)
package _16_queue;

import java.util.Arrays;
import java.util.Scanner;

public class QueueStructure {
    private int[] arr; // массив для хранения
    private int front; // указания на первый элемент
    private int rear; // указывает на последний элемент
    private int capacity; // максимальная емкость
    private int count; // текущий размер

    public QueueStructure(int size)     {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public int dequeue() {
       if (isEmpty()) {
           System.exit(-1);
       }
       int x = arr[front];
       front = (front + 1) % capacity;
       count--;
       return x;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.exit(-1);
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public int peek() {
        if (isEmpty()) {
            System.exit(-1);
        }
        return arr[front];
    }

    public int size() {
        return count;
    }

    public void clear() {
        Arrays.fill(arr, 0);
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == capacity);
    }

    public static void main(String[] args) {
        QueueStructure q = new QueueStructure(200);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] input = scanner.nextLine().trim().split(" ");
            switch (input[0]) {
                case ("size"):
                    System.out.println(q.size());
                    break;
                case ("push"):
                    int el = Integer.parseInt(input[1]);
                    q.enqueue(el);
                    System.out.println("ok");
                    break;
                case ("pop"):
                    if (q.isEmpty()) {
                        System.out.println("error");
                        continue;
                    }
                    System.out.println(q.dequeue());
                    break;
                case ("front"):
                    if (q.isEmpty()) {
                        System.out.println("error");
                        continue;
                    }
                    System.out.println(q.peek());
                    break;
                case ("clear"):
                    q.clear();
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
