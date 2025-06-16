package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        List<List<Integer>> res = new ArrayList<>();
        recur(arr,0,res,new ArrayList<>(),7);
        System.out.println(res);
    }

    public static List<List<Integer>> recur(int[] arr, int i,List<List<Integer>> res, List<Integer> list,int target){
        if(target==0){
            res.add(new ArrayList<>(list));
            return res;
        }
        if(target<0 || i==arr.length){
            return res;
        }
        list.add(arr[i]);
        recur(arr,i,res,list,target-arr[i]);
        list.remove(list.size()-1);
        recur(arr,i+1,res,list,target);
        return res;
    }
}
