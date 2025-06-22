package Recursion;

import java.util.ArrayList;
import java.util.List;

public class All_Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,};
        List<List<Integer>> res = new ArrayList<>();
        helper(arr,0,res,new ArrayList<>());
        List<List<Integer>> result = new ArrayList<>();
        helper2(arr,0,result,new ArrayList<>());
        System.out.println(res);
        System.out.println(result);
    }

    public static void helper(int[] arr, int start, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));
        // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        for(int i=start; i<arr.length; i++){
            list.add(arr[i]);
            helper(arr,i+1,res,list);
            list.remove(list.size()-1);
        }
    }

    public static void helper2(int[] arr, int start, List<List<Integer>> res, List<Integer> list){
        if(start==arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        // [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
        list.add(arr[start]);
        helper2(arr,start+1,res,list);
        list.remove(list.size()-1);
        helper2(arr,start+1,res,list);
    }
}
