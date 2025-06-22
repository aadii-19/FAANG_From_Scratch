package LinkedList;

public class Custom_LL {
    Node head;
    int size;

    Custom_LL(){
        this.size = 0;
    }

    public void addFirst(int val){
        Node temp = new Node(val);
        if(head==null) {
            head = temp;
            return;
        }
        temp.next = head;
        head = temp;
    }

    public void addLast(int val){
        if(head==null){
            addFirst(val);
            return;
        }
        Node new_val = new Node(val);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new_val;
    }

    public void reverse(){
        Node prev = null;
        Node pres = head;
        while(pres!=null){
            Node next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
        }
        head = prev;
    }
    private static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
}
