package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum_Optimal {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSum(nums);
        for(List<Integer> l : res){
            System.out.print(l+", ");
        }
    }
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> main = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue; // we have already found the pairs for that i
            }
            int j = i+1 , k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                    list.sort(null);
                    main.add(list);
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return main;
    }
}
/*
Approach %
--> 1. First Sort the array and in every iteration the i is fixed
--> 2. We apply the two pointer approach here with j and k.
--> 3. If i+j+k = 0 then we have found one valid pair
--> 4. now we don't want to check the repeating and duplicate values
--> 5. while(j<k && nums[j]==nums[j+1] then j++ and similarly for k
--> Now if sum < 0 then we need higher sum so move j++
--> else we need lesser sum so move k--;
 */