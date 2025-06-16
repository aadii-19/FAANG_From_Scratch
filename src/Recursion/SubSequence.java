package Recursion;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        int[] arr = {3,1,4,3,5};
        sub(arr,0,new ArrayList<>());
    }

    // In order for the reverse condition where the empty [] will come first
    // just put the remove above the addition
    public static void sub(int[] arr, int i, ArrayList<Integer> list){
        if(i== arr.length){
            System.out.println(list);
            return;
        }
        // first add
        list.add(arr[i]);
        sub(arr,i+1,list);                                // sub(arr,i+1,list); list.add(arr[i]); for reverse

        // now remove
        list.remove(list.size()-1);
        sub(arr,i+1,list);
    }
}
