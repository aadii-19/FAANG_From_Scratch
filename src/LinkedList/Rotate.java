package LinkedList;

public class Rotate {
//    private Node head;
    public static void main(String[] args) {

    }

    public Node rotate(Node head,int k){
        if(head==null || head.next==null) return head;
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        k = k%count;
        if(k==0) return head;
        temp = head;
        while(k>0){
            while(temp!=null && temp.next!=null && temp.next.next!=null){
                temp = temp.next;
            }
            Node new_head = temp.next;
            if(new_head!=null) new_head.next = head;
            temp.next = null;
            head = new_head;
            temp = head;
            k--;
        }
        return head;
    }
}
