package example;

import java.util.*;

public class 소수찾기 {
    static int count = 0;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "011";
        List<String> list =new ArrayList<>();

        boolean[] visited = new boolean[numbers.length()];
        String[] number = numbers.split("");
        dfs(number, list, visited);

        System.out.println(count);
    }

    static void dfs(String[] number, List<String> list, boolean[] visited){

        for(int i = 0; i < number.length; i++){
            if(visited[i]) continue;
            list.add(number[i]);
            visited[i] = true;

            int num = Integer.parseInt(String.join("",list));
            if (!set.contains(num)) {
                set.add(num);
                System.out.println(num);
                if (check(num)) {
                    count++;
                }
            }
            dfs(number, list, visited);

            visited[i] = false;

            list.remove(list.size()-1);
        }
    }

    static boolean check(int num){
        if(num < 2) return false;
        for(int i =2; i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
