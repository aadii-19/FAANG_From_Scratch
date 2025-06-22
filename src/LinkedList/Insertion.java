package LinkedList;

public class Insertion {
    private Node head;
    private int size;

    Insertion(){
        this.size = 0;
    }
    // We will do the insertion in LinkedList
    // 1. At first
    // 2. At last
    // 3. At index
    // 4. At value

    // 1.
    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtLast(int val){
        Node node = new Node(val);
        if(head==null){
            insertAtFirst(val);
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public void insertAtIndex(int index, int val){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if(index==0){
            insertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
//        while(index>1){
//            temp = temp.next;
//            index--;
//        }
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    private static class Node{
        Node next;
        int val;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
}
