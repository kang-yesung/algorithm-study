package test;

import java.util.Arrays;

public class 전화번호목록 {
    public static void main(String[] args) {
        String[] arr = {"119", "97674223", "1195524421"};
        Arrays.sort(arr);
        boolean bool = true;
        for (int i = 0; i< arr.length-1; i++){
            if(arr[i+1].startsWith(arr[i])){
                bool = false;
            }
        }
        System.out.println(bool);
    }
}
