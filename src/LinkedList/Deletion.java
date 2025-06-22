package LinkedList;

public class Deletion {
    private Node head;
    private int size;

    Deletion(){
        this.size = 0;
    }

    public void deleteAtFirst(){
        if(head==null){
            return;
        }
        head = head.next;
    }

    public void deleteAtLast(){
        if(head==null){
            deleteAtFirst();
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteAtIndex(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(index==0){
            deleteAtFirst();
            return;
        }
        if(index==size-1){
            deleteAtLast();
            return;
        }
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    private static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
}
