package SlidingWindow;

import java.util.HashMap;

//import SlidingWindow.AtMost_K_Distinct;
public class Subarrays_withK_Different_Integers {
    public int subarraysWithKDistinct(int[] nums, int k){
//        AtMost_K_Distinct at = new AtMost_K_Distinct();
//        return at.atMostK("nums",k) - at.atMostK("atmost",k-1);
        // this is how we use a function from another file by first making an instance of that
        return atmost(nums,k) - atmost(nums,k-1);
    }

    private int atmost(int[] nums, int k) {
        int left = 0, right=0, count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left+=1;
            }
            count += right-left+1;
            right+=1;
        }
        return count;
    }
}

/*
992. Subarrays with K Different Integers
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.



Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].


Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
 */
