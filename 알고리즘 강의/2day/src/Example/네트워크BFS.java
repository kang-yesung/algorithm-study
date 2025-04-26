package Example;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크BFS {
    public static void main(String[] args) {
        int answer = 0;
        int[][] computers = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int n = 3;
        boolean[] visited = new boolean[n];

        for(int i = 0; i<n; i++){
            if (!visited[i]){
                bfs(i, visited, computers);
                answer++;
            }

    }
        System.out.println(answer);

}

    private static void bfs(int curVertex, boolean[] visited, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curVertex);
        visited[curVertex] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next=0; next<visited.length; next++){
                if(computers[current][next]==1 && !visited[next]){
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
