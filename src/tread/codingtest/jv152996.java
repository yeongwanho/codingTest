package tread.codingtest;

import java.util.Arrays;

public class jv152996 {
    public static void main(String[] args) {
        int[] weights = {2, 77, 360, 100, 270,100000};
        Arrays.sort(weights);
        long answer = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                if (weights[i] == weights[j]) {
                    answer++;
                    continue;
                }
                if (weights[i] * 2 == weights[j]) {
                    answer++;
                    continue;
                }
                int lcm = lcm(weights[i], weights[j]);
                if (lcm / weights[i] ==4 && (lcm / weights[j] == 2 ||lcm/ weights[j] == 3)) {
                    answer++;
                }else if (lcm / weights[i] ==3 && (lcm / weights[j] == 2 ||lcm/ weights[j] == 4)){
                    answer++;
                } else if (lcm / weights[i] ==2 && (lcm / weights[j] == 4 ||lcm/ weights[j] == 3)) {
                    answer++;
                }

            }
        }
        System.out.println(answer);
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
