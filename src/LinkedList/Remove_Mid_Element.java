package LinkedList;

import LinkedList.CRUD_CLI.LinkedList;

public class Remove_Mid_Element {
    private Node head;
    private int size;
    public Remove_Mid_Element(){
        this.size = 0;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtFirst(10);
        list.insertAtLast(20);
        list.insertAtLast(30);
        list.insertAtLast(40);
        list.insertAtLast(50);
        list.display();

    }

    public Node removeMid(Node head){
        if(head==null || head.next==null) return null;
        Node slow = head;
        Node fast = head.next.next;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
