package tread.codingtest;

import java.util.Arrays;

public class jv154538_2 {

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;
        int[] dp = new int[y + 1];
        Arrays.fill(dp, y + 1);
        dp[x] = 0;
        for (int i = x; i < y + 1; i++) {
            if (dp[i] == y + 1) {
                continue;
            }
            if (i + n < y + 1) {
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if (i * 2 < y + 1) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if (i * 3 < y + 1){
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }
        System.out.println(dp[y]== y+1 ? -1 : dp[y]);
    }
}
