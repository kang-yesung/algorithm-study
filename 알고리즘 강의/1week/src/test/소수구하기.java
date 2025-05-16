package test;

public class 소수구하기 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int count = 0;
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int z = j+1; z < nums.length; z++){
                    int sum = nums[i] + nums[j] + nums[z];
                    for( int x = 2; x < Math.sqrt(sum); x++){
                        if(sum % x == 0){
                            break;
                        } else if(x == (int)Math.sqrt(sum)){
                            count ++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
