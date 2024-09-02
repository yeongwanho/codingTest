package tread.codingtest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class jv138476 {
    public static void main(String[] args) {
        int k = 6;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int[] tangerine = {1, 3, 2, 5, 100, 5, 2, 3};
        int[] list = new int[tangerine.length + 1];

        for (int i = 0; i < tangerine.length; i++) {
            int num = tangerine[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> integers = map.keySet();

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list[count] = entry.getValue();
            count++;
        }
        Arrays.sort(list);
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != 0) {
                answer++;
                if (k - list[i] > 0) {
                    k -= list[i];
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
