package Two_Pointers;

import java.util.*;

public class Three_Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(nums);
        for(List<Integer> l : list){
            System.out.print(l+" ");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> main = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            Set<Integer> seen = new HashSet<>();
            for(int j = i+1; j< nums.length; j++){
                int third = -(nums[i]+nums[j]);
                if(seen.contains(third)){
                    List<Integer> list = Arrays.asList(nums[i],nums[j],third);
                    list.sort(null);
                    main.add(list);
                }
                seen.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(main);
        return ans;
    }

}
/*
15. 3Sum
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
