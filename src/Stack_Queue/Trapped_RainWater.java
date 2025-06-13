package Stack_Queue;

public class Trapped_RainWater {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(find(heights));
    }

    public static int find(int[] arr){
        // First find the leftMax and rightMax
        // For that we will create a LeftPrefixMax and RightPrefixMax which will store the max at that particular
        // index from left to right(left prefix) and right to left (right prefix)
        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        int[] rightMax = new int[arr.length];
        rightMax[arr.length-1] = arr[arr.length-1];
        int total = 0;
        // Finding the leftMax
        for(int i=1; i<arr.length; i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i]);
        }
        // Finding the rightMax
        for(int i=rightMax.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }
        // Now finding the total_water
        for(int i=0; i<arr.length; i++){
            if(arr[i]<leftMax[i] && arr[i]<rightMax[i]){
                total += Math.min(leftMax[i],rightMax[i]) - arr[i];
            }
        }
        return total;
    }
}
/*
42. Trapping Rain Water
Solved
Hard
Topics
premium lock icon
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */
