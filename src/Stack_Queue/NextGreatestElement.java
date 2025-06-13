package Stack_Queue;
import java.util.Arrays;
import java.util.Stack;

public class NextGreatestElement {
    public static void main(String[] args) {
        int[] arr = {6,0,8,1,3};
        System.out.println(Arrays.toString(nge(arr)));
    }
    public static int[] nge(int[] nums){
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }
}
