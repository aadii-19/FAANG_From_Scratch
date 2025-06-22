package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_Two {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> solution(int[] arr, int target){
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        helper(arr,target,0,res,new ArrayList<>());
        return res;
    }

    public static void helper(int[] arr, int target, int start, List<List<Integer>> res, List<Integer> list){
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(arr[start]>target){
            return;
        }
        if(target<0 || start==arr.length) return;
        for(int i=start; i<arr.length; i++){
            list.add(arr[i]);
            helper(arr,target,i+1,res,list);
            list.remove(list.size()-1);
        }
    }
}
