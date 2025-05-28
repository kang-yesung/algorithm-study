package example;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"", ""};

        HashMap<String, List<String>> map = new HashMap<>();

        for(String i : strs){
            char[] str = i.toCharArray();
            Arrays.sort(str);
            String key = Arrays.toString(str);

            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(i);
        }

        System.out.println(map);

    }
}
