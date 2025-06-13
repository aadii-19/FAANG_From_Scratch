package Stack_Queue;

import java.util.ArrayList;
import java.util.Arrays;

public class Asteroid_Collision {
    public static void main(String[] args) {
        int[] asteroid = {10,2,-5};
        System.out.println(Arrays.toString(asteroid(asteroid)));
    }

    public static int[] asteroid(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            if(arr[i]>0){
                list.add(arr[i]);
            }
            else{
                while(!list.isEmpty() && list.get(list.size()-1)>0 && list.get(list.size()-1)<Math.abs(arr[i])){
                    list.remove(list.size()-1);
                }
                if(!list.isEmpty() && list.get(list.size()-1)==Math.abs(arr[i])){
                    list.remove(list.size()-1);
                }
                else if(list.isEmpty() || list.get(list.size()-1)<0){
                    list.add(arr[i]);
                }
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}

/*
735. Asteroid Collision
Solved
Medium
Topics
premium lock icon
Companies
Hint
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.


Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
 */