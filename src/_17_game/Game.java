package _17_game;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> gamer1 = new LinkedList<>();
        Queue<Integer> gamer2 = new LinkedList<>();

        int count = 0;

        String[] inputString1 = scanner.nextLine().trim().split(" ");
        String[] inputString2 = scanner.nextLine().trim().split(" ");

        for (int i = 0; i < inputString1.length; i++) {
            gamer1.offer(Integer.parseInt(inputString1[i]));
        }
        for (int i = 0; i < inputString2.length; i++) {
            gamer2.offer(Integer.parseInt(inputString2[i]));
        }

        while (true) {
            if (gamer1.isEmpty()) {
                System.out.println("second " + count);
                break;
            }
            if (gamer2.isEmpty()) {
                System.out.println("first " + count);
                break;
            }
            if (count >= 1_000_000) {
                System.out.println("botva");
                break;
            }
            int card1 = gamer1.poll();
            int card2 = gamer2.poll();
            if ((card1 == 0 && card2 == 9)) {
                gamer1.offer(card1);
                gamer1.offer(card2);
            } else if ((card1 == 9 && card2 == 0)) {
                gamer2.offer(card1);
                gamer2.offer(card2);
            } else if (card1 > card2) {
                gamer1.offer(card1);
                gamer1.offer(card2);
            } else {
                gamer2.offer(card1);
                gamer2.offer(card2);
            }
            count++;
        }
    }
}
