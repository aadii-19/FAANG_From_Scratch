package Arrays;

public class findDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(find(arr));
    }
    public static int find(int[] arr){
        int slow = arr[0];
        int fast = arr[0];
        while(slow!=fast){
            slow = arr[slow];
            fast = arr[arr[fast]];
            if(slow==fast){
                break;
            }
        }
        fast = arr[0];
        while(slow!=fast){
            fast =arr[fast];
            slow = arr[slow];
        }
        return fast;
    }
}
