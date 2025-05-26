package example;

import java.util.*;

public class 주차요금계산 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};

        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Map<String, List<String>> map = new HashMap<>();

        int n = records.length;
        for(int i = 0; i < n; i++){
            String str = records[i].split(" ")[1];
            map.put(str, new LinkedList<>());
        }


        for(int i = 0; i < n; i++){
            String str = records[i].split(" ")[1];
            String s  = records[i];
            map.get(str).add(s);
        }

        for(String key : map.keySet()){
            if(map.get(key).size() %2 !=0){
                map.get(key).add("23:59 " + key + " OUT");
            }
        }

        int[] car = new int[map.size()];
        int count = 0;
        for(String i : map.keySet()){
            car[count] = Integer.parseInt(i);
            count++;
        }


        Arrays.sort(car);
        int[] pay = new int[car.length];


        for(String key : map.keySet()){
            int in = 0;
            int out = 0;
            int k = Integer.parseInt(key);
            for(String value : map.get(key)){
                if(value.contains("IN")){
                    String t = value.split(" ")[0];
                    int H = Integer.parseInt(t.split(":")[0]);
                    int M = Integer.parseInt(t.split(":")[1]);
                    in += H * 60 + M;
                } else if (value.contains("OUT")) {
                    String t = value.split(" ")[0];
                    int H = Integer.parseInt(t.split(":")[0]);
                    int M = Integer.parseInt(t.split(":")[1]);
                    out += H*60 + M;
                }
            }
            System.out.println(key + " " + (out - in));

            for(int i = 0; i < car.length; i++){
                if(k == car[i]){
                    if(fees[0]>=out-in) {
                        pay[i] = fees[1];
                    } else{
                        pay[i] = (int)(Math.ceil(((out-in) - fees[0]) / (double)fees[2]) * fees[3]) + fees[1];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(pay));

    }
}
