package Recursion;

import java.util.ArrayList;
import java.util.List;

public class N_Queen {
    public static void main(String[] args) {
        List<List<String>> res = solveQueen(4);
        for(List<String> ros : res){
            for(String r : ros){
                System.out.println(r);
            }
            System.out.println();
        }
    }

    public static List<List<String>> solveQueen(int n){
        boolean[][] queen = new boolean[n][n];
        List<List<String>> res = solve(queen,0);
        return res;
    }

    public static List<List<String>> solve(boolean[][] queen, int col){
        if(col==queen[0].length){
            List<List<String>> base = new ArrayList<>();
            base.add(convertString(queen));
            return base;
        }
        List<List<String>> res = new ArrayList<>();
        for(int row=0; row<queen.length; row++){
            if(isSafe(queen,row,col)){
                queen[row][col] = true;
                res.addAll(solve(queen,col+1));
                queen[row][col] = false;
            }
        }
        return res;
    }

    public static boolean isSafe(boolean[][] queen, int row, int col){
        int dup_row = row;
        int dup_col = col;
        while(col>=0){
            if(queen[row][col]){
                return false;
            }
            col--;
        }
        col = dup_col;
        while(row>=0 && col>=0){
            if(queen[row][col]){
                return false;
            }
            row--;
            col--;
        }
        row = dup_row;
        col = dup_col;
        while(row<queen.length && col>=0){
            if(queen[row][col]){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    public static List<String> convertString(boolean[][] queen){
        List<String> res = new ArrayList<>();
        for(boolean[] bool : queen){
            StringBuilder str = new StringBuilder();
            for(boolean i : bool){
                str.append(i ? 'Q' : '.');
            }
            res.add(str.toString());
        }
        return res;
    }
}
