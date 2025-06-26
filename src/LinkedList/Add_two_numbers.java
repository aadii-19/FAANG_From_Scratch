package LinkedList;

public class Add_two_numbers {
    private Node head;
    private int size;

    // if given a num like 512 then it is represented as 2->1->5 and the other num is also represented in a reversed fashion so give their sum also in the same format;
    public static void main(String[] args) {
        Add_two_numbers list1 = new Add_two_numbers();
        Add_two_numbers list2 = new Add_two_numbers();
        list1.insert(3);
        list1.insert(8);
        list1.insert(7);
        list2.insert(5);
        list2.insert(2);
        list2.insert(4);
        list2.insert(1);
    }

    Add_two_numbers() {
        this.size = 0;
    }

    private Node sum(Add_two_numbers list1, Add_two_numbers list2) {
        Node head1 = list1.head;
        Node head2 = list2.head;
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.val + head2.val + carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = node;
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            int sum = head1.val + carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = node;
            head1 = head1.next;
        }
        while (head2 != null) {
            int sum = head2.val + carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = node;
            head2 = head2.next;
        }
        if (carry != 0) {
            Node node = new Node(carry);
            temp.next = node;
            temp = node;
        }
        return dummy.next;
    }


    //    public Node addList(Add_two_numbers list1, Add_two_numbers list2){
//        int a = getSum(list1,list2);
//        Add_two_numbers temp = new Add_two_numbers();
//        Node head = new Node(a/10);
//        Node temp_var = head;
//        a /=10;
//        while(a>0){
//            Node node = new Node(a/10);
//            temp_var.next = node;
//            temp_var = node;
//        }
//        return head;
//    }
//    public int getSum(Add_two_numbers list1, Add_two_numbers list2){
//        int a = getNum(list1);
//        int b = getNum(list2);
//        return a+b;
//    }
//    public int getNum(Add_two_numbers list) {
//        int temp = 0;
//        Node temp_node = head;
//        while (temp_node != null) {
//            temp = temp * 10 + temp_node.val;
//            temp_node = temp_node.next;
//        }
//        int actual = 0;
//        while (temp > 0) {
//            actual = (actual * 10) + (temp % 10);
//            temp /= 10;
//        }
//        return actual;
//    }
//
    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
