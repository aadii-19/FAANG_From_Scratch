package LinkedList;

public class Array_to_LinkedList {
    private Node head;
    private int size;

    Array_to_LinkedList(){
        this.size = 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Array_to_LinkedList list = new Array_to_LinkedList();
        list.convert(arr);
    }

    public void convert(int[] arr){
        // First Assign head to arr[0]
        head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i< arr.length; i++){
            Node element = new Node(arr[i]);
            temp.next = element;
            temp = element;
        }
        display(head);
        System.out.println(count(head));
    }

    public boolean isPresent(int val){
        Node temp = head;
        while(temp!=null) {
            if (temp.value == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int count(Node head){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count+=1;
            temp = temp.next;
        }
        return count;
    }

    private void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+"-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

     private static class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
}
