package example;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {1,2,3};

        dfs(new ArrayList<>(),0, result, nums);

        System.out.println(result);
    }

    static void dfs(ArrayList list, int start, List<List<Integer>> result, int[] nums){
        result.add(new ArrayList<>(list));

        for(int i = start; i <nums.length; i++){
            list.add(nums[i]);
            dfs(list, i+1,result, nums);
            list.remove(list.size()-1);
        }
    }
}
