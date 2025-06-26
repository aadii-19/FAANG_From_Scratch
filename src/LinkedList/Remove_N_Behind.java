package LinkedList;
//import LinkedList.Node;

public class Remove_N_Behind {
    private Node head;
    private int size;

    Remove_N_Behind(){
        this.size = 0;
    }

    public static void main(String[] args) {

    }

    public Node Remove(int index, Node head){
        int count = 0;
        Node temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        if(index==count) return head.next;
        int req = count - index;
        temp = head;
        for(int i=1; i<req; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
