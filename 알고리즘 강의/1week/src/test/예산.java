package test;

import java.util.Arrays;

public class 예산 {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int count = 0;
        int budget = 9;

        Arrays.sort(d);
        for(int i : d){
            if(budget-i >= 0){
                budget -= i;
                count++;
            }
        }


    }
}
