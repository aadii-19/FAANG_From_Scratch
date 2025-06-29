package LinkedList;

public class Remove_Duplicates {
    private Node head;

    public Node removeDuplicates(Node head){
        Node temp = head;
        while(temp!=null && temp.next!=null){
            // checking if the next is same
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
                if(temp.next!=null){
                    temp.next.prev =  temp;
                }
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }
}
