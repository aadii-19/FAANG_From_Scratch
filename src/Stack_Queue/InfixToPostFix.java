package Stack_Queue;

import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)";
        System.out.println(convert(str));
    }

    public static String convert(String str){
        StringBuilder st = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') ||(ch>='0' && ch<='9')){
                st.append(ch);
            }
            // If the ch is opening bracket then push
            else if(ch=='('){
                stack.push(ch);
            }
            // If closing bracket then pop and append to answer until opening bracket
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='(') {
                    st.append(stack.pop());
                    // Now removing the opening bracket also
                }
                stack.pop();
            }
            // Now only operators are left
            else{
                // Even if it's equal we are popping out
                while(!stack.isEmpty() && priority(ch)<=priority(stack.peek())){
                    st.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        // adding the remaining after the equation is reached
        while(!stack.isEmpty()){
            st.append(stack.pop());
        }
        return st.toString();
    }

    public static int priority(char ch){
        if(ch=='+' || ch=='-'){
            return 1;
        }
        else if(ch=='*' || ch== '/'){
            return 2;
        }
        else if(ch=='^'){
            return 3;
        }
        else{
            return 0;
        }
    }
}
