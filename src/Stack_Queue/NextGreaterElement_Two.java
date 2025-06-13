package Stack_Queue;

import java.util.Arrays;

public class NextGreaterElement_Two {
    public static void main(String[] args) {
        int[] arr = {2,10,12,1,11};
        System.out.println(Arrays.toString(nge(arr)));
    }
    public static int[] nge(int[] arr){
        int[] ans = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            ans[i] = -1;   // If there is no greater element then this will take care of putting -1;
            for(int j=1; j<arr.length;j++){
                int index = (i+j)% arr.length;
                if(arr[index]>arr[i]){
                    ans[i] = arr[index];
                    break;
                }
            }
        }
        return ans;
    }

    public static class NextGreatestElement {
    }
}
