package test;
import java.util.HashMap;

public class 완주하지못한선수{
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        HashMap<String, Integer> map = new HashMap<>();

        for (String name : participant){
            map.put(name, map.getOrDefault(name, 0 )+1);
        }
        for (String name : completion){
            map.put(name, map.get(name)-1);
        }
        for (String name : map.keySet()){
            if(map.get(name) !=0){
            }
        }
    }
}
