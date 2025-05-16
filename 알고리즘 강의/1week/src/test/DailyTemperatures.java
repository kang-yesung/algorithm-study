package test;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] temperatures = {73, 74, 75, 71, 69,  72, 76, 73};
        int[] answer = new int[temperatures.length];

        for(int i = 0; i< answer.length; i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int topIndex = stack.pop();
                answer[topIndex] = i - topIndex;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int topIndex = stack.pop();
            answer[topIndex] = 0;
        }
        System.out.println(Arrays.toString(answer));
    }
}
