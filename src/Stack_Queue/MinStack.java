package Stack_Queue;

import java.util.Stack;

public class MinStack {
    // Implement a stack that does the regular functions of a stack but also retrieves the minElement in O(1) time.
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack(){
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if(min.isEmpty() || val<=min.peek()){
            min.push(val);
        }
    }

    public int pop(){
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        return stack.pop();
    }

    public int getMin(){
        return min.peek();
    }

}
