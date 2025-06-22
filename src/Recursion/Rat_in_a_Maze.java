package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rat_in_a_Maze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        List<String> paths = path(maze);
        System.out.println(paths);  // Output: [DDRDRR, DRDDRR]
    }

    public static List<String> path(int[][] maze){
        ArrayList<String> list = new ArrayList<>();
//        if (maze[0][0] == 0 || maze[maze.length-1][maze[0].length-1] == 0) return list;
        helper(maze, new boolean[maze.length][maze.length], "", 0, 0, list);
//        Collections.sort(list);
        return list;
    }
    public static void helper(int[][] path, boolean[][] visited, String move, int i, int j, List<String> list){
        if (path[i][j] == 0) return;
        if(i==path.length-1 && j==path[0].length-1){
            list.add(move);
            return;
        }
        // Mark as visited
        visited[i][j] = true;
        // Downward
        if(i+1< path.length && !visited[i+1][j] && path[i+1][j]==1){
            helper(path,visited,move+'D',i+1,j,list);
        }
        // Left
        if(j-1>=0 && !visited[i][j-1] && path[i][j-1]==1){
            helper(path,visited,move+'L',i,j-1,list);
        }
        // Right
        if(j+1<path[0].length && !visited[i][j+1] && path[i][j+1]==1){
            helper(path,visited,move+'R',i,j+1,list);
        }
        // Upwards
        if(i-1>=0 && !visited[i-1][j] && path[i-1][j]==1){
            helper(path,visited,move+'U',i-1,j,list);
        }
        //BackTrack
        visited[i][j] = false;
    }
}
