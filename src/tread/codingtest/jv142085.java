package tread.codingtest;

import java.util.Collections;
import java.util.PriorityQueue;

public class jv142085 {
//    static int[] enemy;

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int answer = 0;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};

        if (k == enemy.length) {
            System.out.println(enemy.length);
        }

        int count = 0;
        int remain = n;
        int i;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (i = 0; i < enemy.length; i++) {
            int current = enemy[i];
            priorityQueue.add(current);
            remain -= current;

            if (remain < 0) {
                if (count < k) {
                    remain += priorityQueue.poll();
                    count++;
                } else {
                    break;
                }
            }
        }

        answer = i;
        System.out.println(answer);
    }

//    private static int func(int n, int k, int enemyNum, int turn) {
//        if (enemyNum == enemy.length) {
//            return enemy.length;
//        }
//        if (k == 0 && n - enemy[enemyNum] < 0) {
//            return turn;
//        }
//        int checkK = Integer.MAX_VALUE;
//        if (k != 0) {
//            checkK = func(n, k - 1, enemyNum + 1, turn + 1);
//        }
//        int checkN = Integer.MAX_VALUE;
//        if (n - enemy[enemyNum] > 0) {
//            checkN = func(n - enemy[enemyNum], k, enemyNum + 1, turn + 1);
//        }
//
//        return Math.min(checkK, checkN);
//    }


}
