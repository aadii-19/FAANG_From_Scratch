package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> res = permutation(arr);
        System.out.println(res);
    }

    public static List<List<Integer>> permutation(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        helper(arr,new boolean[arr.length],res,new ArrayList<>());
        return res;
    }

    public static void helper(int[] arr, boolean[] found, List<List<Integer>> res, List<Integer> list){
        if(list.size()==arr.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!found[i]){
                found[i] = true;
                list.add(arr[i]);
                helper(arr,found,res,list);
                list.remove(list.size()-1);
                found[i] = false;
            }
        }
    }

    public static void helper(int[] arr, int start, List<List<Integer>> res){
        if(start==arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i : arr){
                list.add(i);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<arr.length; i++){
            swap(i,start,arr);
            helper(arr,start+1,res);
            swap(i,start,arr);
        }
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
