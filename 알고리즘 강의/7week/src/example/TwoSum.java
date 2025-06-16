package example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int tasrget = 9;

        int[] twosum = twoSum(nums, tasrget);
        System.out.println(Arrays.toString(twosum));
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] idx = new int [2];

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int num = target - nums[i];

            if(map.containsKey(num)){
                if(map.get(num)==i) continue;
                return new int[] {1, map.get(num)};
            }
        }
        return idx;
    }
}
