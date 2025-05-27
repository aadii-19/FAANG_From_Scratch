package Arrays;

public class missingNumber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        System.out.println(findMissing(arr));
    }

    private static int findMissing(int[] arr) {
        int sum = 0;
        for(int i =0; i<arr.length; i++){
            sum += arr[i];
        }
        int n = arr.length;
        int numTotal = ((arr.length+1)*(n+2))/2;
        return numTotal - sum;
    }
}
