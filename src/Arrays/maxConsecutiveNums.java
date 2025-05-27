package Arrays;

public class maxConsecutiveNums {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findOnes(nums));
    }

    private static int findOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int right=0; right<nums.length; right++){
            if(nums[right]==1){
                count += 1;
                max = Math.max(max,count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}
