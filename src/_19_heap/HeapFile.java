// превышение лимита по времени
package _19_heap;

import java.io.*;
import java.util.Arrays;

public class HeapFile {
    private int[] arr;
    private int size;
    private int count;

    public HeapFile(int size) {
        this.arr = new int[size];
        this.size = size;
        this.count = 0;
    }

    public void insert(int k) {
        if (size == count) {
            size *= 2;
            int[] arrNew = new int[size];
            for (int j = 0; j < size/2; j++) {
                arrNew[j] = arr[j];
            }
            arr = arrNew;
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] == 0) {
                arr[i] = k;
                break;
            }
        }
        count++;
    }

    public int extract() {
        if (size / 2 >= count) {
            size /= 2;
            int[] arrNew = new int[size];
            int counter = 0;
            for (int k = 0; k < size * 2; k++) {
                if (arr[k] == 0) {
                    counter++;
                    continue;
                }
                arrNew[k - counter] = arr[k];
            }
            arr = arrNew;
        }

        for(int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if(arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int value = arr[size - 1];
        arr[size - 1] = 0;
        count--;
        return value;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) throws IOException  {
        HeapFile heap = new HeapFile(10);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/_19_heap/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/_19_heap/output.txt"));

        String countString = bufferedReader.readLine().trim();
        int count = Integer.parseInt(countString);
        int index = 1;

        while (index <= count) {
            String[] input = bufferedReader.readLine().trim().split(" ");
            switch (input[0]) {
                case ("0"):
                    heap.insert(Integer.parseInt(input[1]));
                    break;
                case ("1"):
                    bufferedWriter.write(Integer.toString(heap.extract()));
                    bufferedWriter.newLine();
                    break;
            }
            index++;
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
