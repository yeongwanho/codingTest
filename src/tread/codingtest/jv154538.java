package tread.codingtest;

import java.util.Arrays;

public class jv154538 {

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;
        int[] dp = new int[y + 1];
        Arrays.fill(dp, y + 1);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == y + 1) {
                continue;
            }

            if (i + n <= y) {
                int i1 = dp[i + n];
                int i2 = dp[i] + 1;
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if (i * 2 <= y) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 <= y) {
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }
        System.out.println(dp[y] == y + 1 ? -1 : dp[y]);
//        return dp[y] == y + 1 ? -1 : dp[y];
    }

    private static int func(int x, int y, int n, int count) {
        if (x > y) {
            return Integer.MAX_VALUE;
        } else if (x == y) {
            return count;
        }
        int answer = Integer.MAX_VALUE;
        int num2 = func(x * 2, y, n, count + 1);
        int num3 = func(x * 3, y, n, count + 1);
        int plus = func(x + n, y, n, count + 1);

        if (num2 != 0) {
            answer = Math.min(answer, num2);
        }
        if (num3 != 0) {
            answer = num3 == -1 ? answer : Math.min(num3,answer);
        }
        if (plus != 0) {
            answer = plus == -1 ? answer : Math.min(plus,answer);
        }
        return answer;
    }
}
