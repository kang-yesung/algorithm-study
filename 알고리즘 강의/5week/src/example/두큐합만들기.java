package example;

import java.util.*;

public class 두큐합만들기 {
    public static void main(String[] args) {

        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        int count = solution(queue1, queue2);
        System.out.println(count);
    }

    static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            qu1.offer(queue1[i]);
            sum1 += queue1[i];
            qu2.offer(queue2[i]);
            sum2 += queue2[i];
        }

        long total = sum1 + sum2;
        if (total % 2 != 0) return -1;


        int count = 0;
        int maxCount = queue1.length * 3;


        while (count <= maxCount) {
            if (sum1 == sum2) return count;

            if (sum1 > sum2) {
                int value = qu1.poll();
                sum1 -= value;
                sum2 += value;
                qu2.offer(value);
            } else {
                int value = qu2.poll();
                sum1 += value;
                sum2 -= value;
                qu1.offer(value);
            }

            count++;

        }
        return -1;
    }
}