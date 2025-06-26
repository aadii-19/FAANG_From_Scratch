package LinkedList;

import java.util.ArrayList;

public class Odd_and_Even {
    private Node head;
    private int size;

    Odd_and_Even() {
        this.size = 0;
    }

    public Node oddEven(Odd_and_Even list) {
        if (list == null || list.head == null) {
            return null; // Nothing to do on an empty list
        }

        Node temp = list.head;
        ArrayList<Integer> arrayList = new ArrayList<>();
        // Storing the odd index First
        while (temp != null && temp.next != null) {
            arrayList.add(temp.val);               // --> O(n/2)
            temp = temp.next.next;
        }
        // Due to temp.next!=null condition the last element tends to be missed so have additional check
        if (temp != null) {
            arrayList.add(temp.val);
        }

        temp = list.head.next;
        while (temp != null && temp.next != null) {
            arrayList.add(temp.val);               // --> O(n/2)
            temp = temp.next.next;
        }
        // Due to temp.next!=null condition the last element tends to be missed so have additional check
        if (temp != null) {
            arrayList.add(temp.val);
        }
        Node dummy = new Node(-1);
        Node temp_node = dummy;
        for (int i = 0; i < arrayList.size(); i++) {
            Node node = new Node(arrayList.get(i));
            temp_node.next = node;
            temp_node = node;
        }
        return dummy.next;
    }

   public Node oddEvenSol(Odd_and_Even list){
        Node dummy = new Node(-1);
        Node odd = list.head;
        Node even = list.head.next;
        Node connect = list.head.next;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = even.next;

            even.next = odd.next;
            even = odd.next;
        }
        odd.next = connect;
        return dummy.next;
   }
}
