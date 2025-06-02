package Two_Pointers;

public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums){
        int ptr = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[i-1]){
                nums[ptr++] = nums[i];
            }
        }
//        while(ptr<nums.length){
//            nums[ptr++] = 0;
//        }
        return ptr;
    }
}
