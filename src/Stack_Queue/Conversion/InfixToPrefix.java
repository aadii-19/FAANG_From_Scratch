package Stack_Queue.Conversion;

import java.util.Stack;

import static Stack_Queue.Conversion.InfixToPostFix.priority;

public class InfixToPrefix {
    public static void main(String[] args) {
        String str = "(A+B)*C-D+F";
        System.out.println(convert(str));
    }

    public static String convert(String str) {
        // Inorder to convert Infix to Prefix
        // --> Reverse the whole equation but make the brackets correct
        // --> Now do the Infix to Postfix conversion but now when elements of the same priority comes don't pop them out
        // --> Reverse the equation so obtained and this is the Prefix equivalent
        StringBuilder s = new StringBuilder(str).reverse();
        StringBuilder modified = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                modified.append(')');
            } else if (s.charAt(i) == ')') {
                modified.append('(');
            } else {
                modified.append(s.charAt(i));
            }
        }
        // Now the modified stringBuilder contains the reversed expression
        String postFix = infixToPostfix(modified.toString());

        // Now the string that is returned should be reversed.
        return new StringBuilder(postFix).reverse().toString();
    }

    public static String infixToPostfix(String str){
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            }
            else if(c=='('){
                stack.push(c);
            }
            else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    ans.append(stack.pop());
                }
                stack.pop();
            }
            else{
                if(!stack.isEmpty() && priority(c)<priority(stack.peek())){
                    ans.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}
