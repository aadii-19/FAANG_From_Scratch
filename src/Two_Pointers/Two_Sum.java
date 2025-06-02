package Two_Pointers;

public class Two_Sum {
    public int[] twoSum(int[] arr, int target){
        // the two pointer approach will only work provided the array is sorted
        // here we assume the array is sorted
        // else use hashmap approach with complement
        int left = 0, right = arr.length-1;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum==target){
                return new int[]{left,right};
            }
            if(sum>target){
                right-=1;
            }
            if(sum<target){
                left+=1;
            }
        }
        return new int[]{-1,-1};
    }
}
