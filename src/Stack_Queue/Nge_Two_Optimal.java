package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Nge_Two_Optimal {
    public static void main(String[] args) {
        int[] arr = {2,10,12,1,11};
        System.out.println(Arrays.toString(findNge(arr)));
    }

    public static int[] findNge(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        // Here we imagine we are doubling the array so like then we start at index 9 which is
        // 2*n-1 = 9
        for(int i=2* arr.length-1; i>=0; i--){
//            i = i%arr.length;
            // Now if the current element is not lesser than the stack top then keep popping until that condition is met
            while(!stack.isEmpty() && arr[i% arr.length]>=stack.peek()){
                stack.pop();
            }
            if(i< arr.length){
                ans[i%arr.length] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(arr[i% arr.length]);
        }
        return ans;
    }
}
