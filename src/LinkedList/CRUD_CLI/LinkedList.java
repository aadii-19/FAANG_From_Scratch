package LinkedList.CRUD_CLI;

public class LinkedList {
    private Node head;
    private int size;

    // Creating an Object
    LinkedList(){
        this.size = 0;
    }

    // Insertion
    public void insertAtFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void insertAtLast(int val){
        if(head==null){
            insertAtFirst(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }

    public void insertAtIndex(int index, int val){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
        else if(index==0){
            insertAtFirst(val);
            return;
        }
        else if(index==size){
            insertAtLast(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        for(int i=1; i<index; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // Deletion
    public void deleteAtFirst() throws Exception{
        if(head==null){
            throw new Exception("List is empty");
        }
        head = head.next;
    }

    public void deleteAtLast() throws Exception{
        if(head==null){
            deleteAtFirst();
            return;
        }
        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void deleteAtIndex(int index) throws Exception{
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
        else if(index==0){
            deleteAtFirst();
            return;
        }
        else if(index==size){
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

    // Display
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+"-> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // getSize
    public int getSize(){
        return size;
    }

    //reverse
    public void reverse(){
        head = reverseHead();
    }
    private Node reverseHead(){
        Node prev = null;
        Node pres = head;
        while(pres!=null){
            Node next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
        }
        return prev;
    }

    // update
    public void update(int index, int val){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        temp.val = val;
    }

    //isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    //searching
    public int search(int val){
        int index = 0;
        Node temp = head;
        while(temp!=null){
            if(temp.val==val){
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    //get
    public int get(int index) throws Exception{
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException("Invalid Index!");
        }
        else if(index==0){
            return head.val;
        }
        Node temp = head;
        for(int i=1; i<=index; i++){
            temp = temp.next;
        }
        return temp.val;
    }

    //convert
    public void convert(int[] arr){
        head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next = node;
            temp = node;
        }
    }

    //merge
    public LinkedList Merge(LinkedList first, LinkedList second){
        Node head1 = first.head;
        Node head2 = second.head;
        LinkedList temp = new LinkedList();
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.insertAtLast(head1.val);
                head1 = head1.next;
            }
            else{
                temp.insertAtLast(head2.val);
                head2 = head2.next;
            }
        }
        while(head1!=null){
            temp.insertAtLast(head1.val);
            head1 = head1.next;
        }
        while(head2!=null){
            temp.insertAtLast(head2.val);
            head2 = head2.next;
        }
        return temp;
    }

    // Clearing
    public void clear(){
        head = null;
        size = 0;
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
