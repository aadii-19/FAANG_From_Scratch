package Recursion;

import java.util.ArrayList;

public class SubSequence_SumK {
    public static void main(String[] args) {
        // print all the subsequence whose sum is equal to k
        int[] arr = {1,2,3,5};
        int k = 5;
        subSequence1(arr,0,new ArrayList<>(),k);
        System.out.println(subCount(arr,0,k,0));
//        solution(arr,0,k,new ArrayList<>(),0);
    }

    public static void subSequence(int[] arr, int i, ArrayList<Integer> list, int k){
        if(i== arr.length){
            int sum = 0;
            for(int integer : list){
                sum+=integer;
            }
            if(sum==k){
                System.out.println(list);
            }
            return;
        }

        // add
        list.add(arr[i]);
        subSequence(arr,i+1,list,k);
        list.remove(list.size()-1);
        subSequence(arr,i+1,list,k);
    }

    public static void solution(int[] arr,int i, int k, ArrayList<Integer> list, int sum){
        if(i==arr.length){
            if(sum==k){
                System.out.println(list);
            }
            return;
        }
        list.add(arr[i]);
        solution(arr,i+1,k,list,sum+arr[i]);   // since we are taking that's why we are adding it to sum
        list.remove(list.size()-1);
        solution(arr,i+1,k,list,sum);   // here we are not taking so not adding it to sum
    }

    // when you want only one subsequence to be printed

    public static boolean subSequence1(int[] arr, int i, ArrayList<Integer> list, int k){
        if(i== arr.length){
            int sum = 0;
            for(int integer : list){
                sum+=integer;
            }
            if(sum==k){
                System.out.println(list);
                return true; // really important for the recursive call to know the condition has been satisfied
            }
            return false;   // by just keeping the return here it only checks the first subsequence and if it's not equal to k then nothing is printed
        }

        // add
        list.add(arr[i]);
        if(subSequence1(arr,i+1,list,k)) {
            return true;
        }
        list.remove(list.size()-1);
        if(subSequence1(arr,i+1,list,k)){
            return true;
        }
        return false;
    }

    public static int subCount(int[] arr, int i, int k, int sum){
        // returns the count of the no of subsequences satisfying the condition
        if(i==arr.length){
            if(sum==k){
                return 1;
            }
            return 0;
        }
        return subCount(arr,i+1,k,sum+arr[i]) + subCount(arr,i+1,k,sum);
    }
}
