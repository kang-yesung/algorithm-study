package Example;

import java.util.LinkedList;
import java.util.Queue;

public class KeysAndRoomsBFS {
    public static void main(String[] args) {
        int[][] rooms = {
                {1, 3},
                {3, 0, 1},
                {2},
                {0}
        };
        boolean[] visited = new boolean[rooms.length];
        int count = 0;

        for (int i=0; i< rooms.length; i++){
            if(!visited[i]){
                dfs(i, visited, rooms);
                count++;
            }
        }
        if(count>1){
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
    public static void dfs(int curVertex, boolean[] visited, int[][] rooms ){
        Queue<Integer>queue = new LinkedList<>();
        queue.add(curVertex);

        visited[curVertex] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : rooms[current]){
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }
    }
}
