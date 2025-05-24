package example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {
    public static void main(String[] args) {
        String s = "[](){}";

        String[] arr = s.split("");

        Queue<String> queue = new LinkedList<>();

        for(String i : arr){
            queue.offer(i);
        }
        System.out.println(queue);

        int count = 0;

        for(int i = 0; i< s.length(); i++){
            String str = String.join("", queue);
            System.out.println(str);

            if(check(str)){
                count++;
            }
            queue.offer(queue.poll());
        }
        System.out.println(count);
    }
    static boolean check(String str){
        Stack<String> equals = new Stack<>();

        for(int i = 0; i< str.length(); i++){
            String c = String.valueOf(str.charAt(i));

            if( "(".equals(c) || "{".equals(c) || "[".equals(c) ){
                equals.push(c);
            } else {
                if(equals.isEmpty()) {
                    return false;
                }
                String peek = equals.peek();
                if( ("(".equals(peek) && ")".equals(c)) ||
                        ("{".equals(peek) && "}".equals(c))||
                            ("[".equals(peek) && "]".equals(c))){
                    equals.pop();
                } else {
                    return false;
                }
            }
        }
        return equals.isEmpty();
    }
}
