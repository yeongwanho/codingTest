package tread.codingtest;

public class jv140107 {
    public static void main(String[] args) {
        int k = 1;
        int d = 1;
        long answer = 0;
        int[][] result = new int[d + 1][d + 1];
        for(int i = 0 ; i <= d ; i+=k){
            int Y = (int) Math.sqrt( Math.pow(d,2) - Math.pow(i,2)) ;
            answer += 1 + Y/k;
        }
        System.out.println(answer);
    }
}
