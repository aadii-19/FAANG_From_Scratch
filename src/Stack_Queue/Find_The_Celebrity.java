package Stack_Queue;

public class Find_The_Celebrity {
    public static void main(String[] args) {

    }

    public static int find(int[][] people){
        int top = 0, bottom = people.length-1;
        while(top<bottom){
            if(people[top][bottom] == 1){
                top+=1;
            }
            else if(people[bottom][top]==1){
                bottom-=1;
            }
            else{
                top+=1;
                bottom-=1;
            }
        }
        if(top>bottom) return -1;
        for(int i=0; i< people.length; i++){
            if(i!=top && people[top][i]==0 && people[i][top]==1){
            }
            else{
                return -1;
            }
        }
        return top;
    }
}
