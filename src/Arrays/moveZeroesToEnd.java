package Arrays;

import java.util.Arrays;

public class moveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0,2,4,0,0,5,5};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] arr){
//        int num = 0;
        int zero = 0;
        int i =0;
        while(i<arr.length){
            if(arr[i]!=0){
                arr[zero] = arr[i];
                zero++;
            }
            i++;
        }
        while(zero< arr.length){
            arr[zero] = 0;
            zero++;
        }
    }
}
