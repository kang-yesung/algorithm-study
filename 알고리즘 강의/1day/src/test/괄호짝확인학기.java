package test;

import java.util.Stack;

public class 괄호짝확인학기 {
    public static void main(String[] args) {
        String arr = "()[]{}";

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i< arr.length(); i++) {
            char ch = arr.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()){
                    System.out.println(false);
                    return;
                }
                char top = stack.peek();
                if((ch== ')' && top =='(')||(ch=='}') && top =='{'|| (ch==']'&&top=='[')){
                    stack.pop();
                } else {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty());

    }
}
