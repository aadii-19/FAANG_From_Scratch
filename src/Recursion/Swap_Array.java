package Recursion;

import java.util.Arrays;

public class Swap_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        swapArray(arr,0);
        System.out.println(Arrays.toString(arr));
    }

    public static void swapArray(int[] arr, int i){
        if(i>=arr.length/2){
            return;
        }
        swap(arr,i,arr.length-i-1);
        swapArray(arr,i+1);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
