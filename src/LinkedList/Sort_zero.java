package LinkedList;

import LinkedList.Node;
public class Sort_zero {
    private Node head;
    private int size;
    Sort_zero(){
        this.size = 0;
    }
    // This is similar to the Dutch flag problem
    public static void main(String[] args) {

    }

    public Node sortList(Node head){
        // Head is given
        Node temp = head;
        int c1 = 0, c2 = 0, c3 = 0;
        // traverse through the linkedList until
        while(temp!=null){
            if(temp.val==0){
                c1++;
            }
            else if(temp.val==1){
                c2++;
            }
            else{
                c3++;
            }
            temp = temp.next;
        }
        // Now fill the linkedList with values
        temp = head;
        while(c1>0){
            temp.val = 0;
            temp = temp.next;
            c1--;
        }
        while(c2>0){
            temp.val = 1;
            temp = temp.next;
            c2--;
        }
        while(c3>0){
            temp.val = 2;
            temp = temp.next;
            c3--;
        }
        return head;
    }

    // Optimal Approach
    public Node sort(Node head){
        if(head==null || head.next == null) return head;
        Node temp = head;
        Node zeroD = new Node(-1);
        Node oneD = new Node(-1);
        Node twoD = new Node(-1);

        Node zero = zeroD;
        Node one = oneD;
        Node two = twoD;

        while(temp!=null){
            if(temp.val==0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.val==1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        // Now linking the three links
        zero.next = oneD.next!=null ? oneD.next : twoD.next;  // Join the ending of zero to the starting of the One
        one.next = twoD.next;
        two.next = null;

        return zeroD.next;
    }
}
