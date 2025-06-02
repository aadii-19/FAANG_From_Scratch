package Two_Pointers;

public class Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums){
        int left =0, right = nums.length-1;
        int[] res = new int[nums.length];
        int resIndex = res.length-1;
        while(left<=right){
            if(nums[left]*nums[left]>nums[right]*nums[right]){
                res[resIndex--] = nums[left]*nums[left];
                left++;
            }
            else{
                res[resIndex--] = nums[right]*nums[right];
                right--;
            }
        }
        return res;
    }
}
