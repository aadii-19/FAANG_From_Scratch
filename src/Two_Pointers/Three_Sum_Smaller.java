package Two_Pointers;
import java.util.Arrays;
public class Three_Sum_Smaller {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        System.out.println(threeSumSmaller(nums,target));
    }
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        // Write your code here
        int count = 0;
        for(int i=0; i<nums.length; i++){
            int j = i+1, k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<target){
                    count+=(k-j);   // if the highest k element is itself valid then the elements from
                    // (k-1)(k-2) to (j+1) will also be valid & can be counted so this can be found by
                    // count+= (k-j);
                    j+=1;
                }
                else{
                    k-=1;
                }
            }
        }
        return count;
    }
}

/*
259. 3Sum Smaller
Given an array of n integers nums and an integer target, find the number of index triplets i, j, k such that:

0 <= i < j < k < n

nums[i] + nums[j] + nums[k] < target

Return the number of such triplets.

Example 1:
makefile
Copy
Edit
Input: nums = [-2, 0, 1, 3], target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
             [-2, 0, 1] and [-2, 0, 3]
Example 2:
makefile
Copy
Edit
Input: nums = [], target = 0
Output: 0
Example 3:
makefile
Copy
Edit
Input: nums = [0], target = 0
Output: 0
Constraints:
1 <= nums.length <= 3500

-100 <= nums[i] <= 100

-100 <= target <= 100
 */