// при использовании стандарной сортировки превышение time-limit-exceeded	2.072s / 33.86Mb
// при использовании Arrays.sort() не происходит превышения
package _19_heap;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {
    private int[] arr;
    private int size;
    private int count;

    public Heap(int size) {
        this.arr = new int[size];
        this.size = size;
        this.count = 0;
    }

    public void insert(int k) {
        if (count == 0) {
            size = 5;
            int[] arrNew = new int[size];
            arr = arrNew;
        } else if (size == count) {
            size *= 2;
            int[] arrNew = new int[size];
            for (int j = 0; j < size / 2; j++) {
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

    public void sort() {
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

        Arrays.sort(arr);

//        for(int i = 0; i < size - 1; i++) {
//            for (int j = i + 1; j < size; j++) {
//                if(arr[i] > arr[j]) {
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
    }

    public int extract(int index) {
        int value = arr[index];
        arr[index] = 0;
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

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(5);
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int index = 1;
        boolean status = false;
        int counter = 0;

        while (index <= count) {
            String[] input = scanner.nextLine().trim().split(" ");
            switch (input[0]) {
                case ("0"):
//                    if (heap.getSize() / 2 < heap.getCount()) {
//                        heap.sort();
//                    }
                    status = false;
                    counter = 0;
                    heap.insert(Integer.parseInt(input[1]));
                    break;
                case ("1"):
                    if (status) {
//                        if (heap.getSize() / 2 < heap.getCount()) {
//                            heap.sort();
//                            counter = 0;
//                            System.out.println(heap.extract(heap.getSize() - 1));
//                        } else {
//                            ++counter;
//                            System.out.println(heap.extract(heap.getSize() - 1 - counter));
//                        }
                        ++counter;
                        System.out.println(heap.extract(heap.getSize() - 1 - counter));
                    } else {
                        heap.sort();
                        System.out.println(heap.extract(heap.getSize() - 1));
                    }
                    status = true;
                    break;
            }
            index++;
        }
    }
}
