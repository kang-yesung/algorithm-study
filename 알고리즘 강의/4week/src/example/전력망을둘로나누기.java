package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 전력망을둘로나누기 {
    public static void main(String[] args) {
        int [][] wires = {
                {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
//                {1,2,},{2,3},{3,4}
        };
        int n = 9;
//        int n = 4;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i <n; i++){
            int a = check(wires,n ,i);
            result = Math.min(result, a);
        }
        System.out.println(result);
    }
    static int check(int [][] wires, int n, int pass){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int min = 0;
        for(int i =1 ; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0; i <n-1; i++){
            if(i == pass) continue;
            int a = wires[i][0];
            int b= wires[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n+1];

        int x = dfs(graph, visited, 1);

        min = n-x;

        return Math.abs(min-x);
    }
    static int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start){
        visited[start] = true;
        int count = 1;
        for(int next : graph.get(start)) {
            if(!visited[next]){
                count += dfs(graph, visited, next);
            }
        }
        return count;
    }
}
