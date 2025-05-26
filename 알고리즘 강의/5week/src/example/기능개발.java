package example;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] t = new int[speeds.length];

        int n = speeds.length;
        for (int i = 0; i < n; i++) {
            int a = progresses[i];
            int day = 0;
            while (a < 100) {
                a += speeds[i];
                day++;
            }
            t[i] = day;
        }

        List<Integer> save = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i : t) {
            queue.offer(i);
        }

        int count = 1;
        int time = queue.poll();

        while (!queue.isEmpty()) {
            if (time < queue.peek()) {
                save.add(count);
                time = queue.poll();
                count = 1;
            }
            if (time > queue.peek()) {
                queue.poll();
                count++;
            }
            if (queue.isEmpty()) {
                save.add(count);
            }
        }

        int[] arr = new int[save.size()];

        for (int i = 0; i < save.size(); i++) {
            arr[i] = save.get(i);
        }

        System.out.println(Arrays.toString(arr));
    }
}
