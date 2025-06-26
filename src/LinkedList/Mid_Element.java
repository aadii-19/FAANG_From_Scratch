package LinkedList;

public class Mid_Element {
    private Node head;
    private int size;
    Mid_Element(){
        this.size = 0;
    }

    public static void main(String[] args) {

    }

    public Node getMid(Node head){
        int len = 0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int mid = (len/2)+1;
        temp = head;
        for(int i=1; i<mid; i++){
            temp = temp.next;
        }
        return temp;
    }

    //Optimal and efficient approach
    public Node getM(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
