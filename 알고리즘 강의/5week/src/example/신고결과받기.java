package example;

import java.util.*;

public class 신고결과받기 {
    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        Set<String> set = new HashSet<>(Arrays.asList(report));
        Map<String, Integer> map = new HashMap<>();

        int k = 2;

        int[] arr = new int[id_list.length];

        for(int i = 0; i< id_list.length; i++ ){
            map.put(id_list[i], 0);
        }

        for(String i : set){
            String key = i.split(" ")[1];
            map.put(key, map.get(key)+1);
        }

        for(String i : set){
            String[] str = i.split(" ");
            if(map.get(str[1]) >=k){
                for(int j = 0; j< id_list.length; j++){
                    if(str[0].equals(id_list[j])){
                        arr[j]++;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
