package example;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        int count = dfs(numbers, target, 0, 0);
        System.out.println(count);
    }
    static int dfs(int[] numbers, int target, int sum, int idx){
        if(idx==numbers.length){
            return sum==target ? 1 : 0;

        }
        int count = 0;
        count += dfs(numbers, target, sum+numbers[idx], idx+1);
        count += dfs(numbers, target, sum-numbers[idx], idx+1);

        return count;
    }


}
