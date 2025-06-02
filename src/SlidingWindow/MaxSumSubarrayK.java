package SlidingWindow;

public class MaxSumSubarrayK {

    // Function to find the maximum sum of a subarray of size K
    public static int maxSumSubarray(int[] arr, int k) {
        // 👉 Write your logic here
        // Sliding Window works for even negative when for fixed size k
        int sum = 0;
        for(int i=0; i<k; i++){
            sum+= arr[i];
        }
        int maxSum = sum;
        for(int right=k; right<arr.length; right++){
            sum += arr[right] - arr[right-k];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum; // Replace with actual result
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;

        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " = " + result);
    }
}

