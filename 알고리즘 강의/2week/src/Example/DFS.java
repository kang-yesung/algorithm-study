package Example;

import java.util.*;

public class DFS {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public  static void dfs (int curVertex){
        visited.put(curVertex, true);

            for(int nextVertex : graph.get(curVertex)){
              if(!visited.containsKey(nextVertex)){
                  dfs(nextVertex);
              }
            }

    }

    public static void main(String[] args) {
        makeGraph();
        dfs(0);
    }

    private static void makeGraph() {
    }

}

