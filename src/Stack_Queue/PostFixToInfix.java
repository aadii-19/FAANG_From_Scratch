package Stack_Queue;

import java.util.Stack;

public class PostFixToInfix {
    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        System.out.println(postToInfix(str));
    }
    public static String postToInfix(String str){
        StringBuilder modified = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));   // Here the character is changed into String
            }
            else{
                String e = stack.pop();
                String d = stack.pop();
                stack.push("("+d+String.valueOf(c)+e+")");
            }
        }
        // Now the stack will have only one element and that when popped out will give the infix equation
        return stack.pop();
    }
}
