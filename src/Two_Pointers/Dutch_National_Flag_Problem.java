package Two_Pointers;

import java.util.Arrays;

public class Dutch_National_Flag_Problem {

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length-1, mid = 0;
        while(mid<right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                left+=1;
                mid+=1;
            }
            else if(nums[mid]==1){
                mid+=1;
            }
            else{
                swap(nums,mid,right);
                mid+=1;
                right-=1;
            }
        }
    }
    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
/*
75. Sort Colors
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */