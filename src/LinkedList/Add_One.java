package LinkedList;
//import LinkedList.Node;

public class Add_One {
    private Node head;
    public static void main(String[] args) {

    }

    public Node addOne(Node head){
        Node prev = null;
        Node pres = head;
        while(pres!=null){
            Node next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
        }
        Node temp = prev;
        return temp;
    }
}
