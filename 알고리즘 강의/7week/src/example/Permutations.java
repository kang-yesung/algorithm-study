package example;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();

        int[] nums = {1,2,3};
        boolean[] visited = new boolean[nums.length];

        dfs(new ArrayList<>(), nums ,result, visited);

        System.out.println(result);
    }
    static void dfs(ArrayList list, int[] nums ,List<List<Integer>> result, boolean[] visited){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i]= true;
            dfs(list, nums, result, visited);

            visited[i] = false;
            list.remove(list.size()-1);
        }

    }
}
