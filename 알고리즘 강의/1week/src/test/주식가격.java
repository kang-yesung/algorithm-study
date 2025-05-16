package test;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int [] prices = {1, 2, 3, 2, 3};
        int [] answer = new int [prices.length];

        for (int i = 0; i< answer.length; i++){
            while (!stack.isEmpty() && prices[i]< prices[stack.peek()]){
                int topIndex = stack.pop();
                answer[topIndex] = i -topIndex;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            int topIndex = stack.pop();
            answer[topIndex] = prices.length - 1 -topIndex;
        }

        System.out.println(Arrays.toString(answer));
    }
}
