package Example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        int[][] vertex = {
                {3,6},
                {4,3},
                {3,2},
                {1,3},
                {1,2},
                {2,4},
                {5,2}
        };

        int N = 6;
        boolean[] visited = new boolean[N+1];

        for(int i = 0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int [] i : vertex){
            int a = i[0];
            int b = i[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1, visited, graph);

    }
    public static void bfs(int curVertex, boolean[] visited, List<List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curVertex);
        visited[curVertex] = true;
        int[] distance = new int [visited.length];


        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int nextVertex : graph.get(current)){
                if(!visited[nextVertex]){
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                    distance[nextVertex] = distance[current]+1;
                }
            }
        }
        int maxDistance = 0;
        for(int max : distance){
            maxDistance = Math.max(maxDistance, max);
        }

        int count = 0;
        for(int i : distance){
            if(i == maxDistance){
                count++;
            }
        }
        System.out.println(count);
    }
}
