package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Nearest_Smallest {
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        System.out.println(Arrays.toString(findNearest(arr)));
    }
    public static int[] findNearest(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< arr.length; i++){
//            ans[i] = -1;
            while(!stack.isEmpty() && arr[i]<=stack.peek()){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
}
