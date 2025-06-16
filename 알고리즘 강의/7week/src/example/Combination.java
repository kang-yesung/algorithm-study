package example;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();

        int n = 4;
        int k = 2;
        boolean[] visited = new boolean[n+1];
        dfs(new ArrayList<>(), n, k,1,  visited, result);

        System.out.println(result);
    }

    static void dfs(ArrayList list, int n, int k, int start, boolean[] visited, List<List<Integer>> result){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <=n; i++){
            list.add(i);
            dfs(list, n, k, i+1, visited, result);
            list.remove(list.size()-1);
        }
    }

}
