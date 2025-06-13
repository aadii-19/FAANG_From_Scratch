package Stack_Queue.Conversion;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String str = "*+PQ-MN";
        System.out.println(preToInfix(str));
    }

    public static String preToInfix(String str){
        StringBuilder ans = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(int i=str.length()-1 ; i>=0; i--){
            if(Character.isLetterOrDigit(str.charAt(i))){
                stack.push(String.valueOf(str.charAt(i)));
            }
            else{
                String c = stack.pop();
                String d = stack.pop();
                stack.push('('+c+String.valueOf(str.charAt(i))+d+')');
            }
        }
        return stack.pop();
    }
}
