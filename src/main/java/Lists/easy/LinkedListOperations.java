package Lists.easy;

public class LinkedListOperations {

    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node create(int data) {

        Node new_node = new Node(data);
        return new_node;
    }

    public void insert(int data) {

        if(this.head == null) { // Emplty List
            this.head = create(data);
            return;
        }

        Node current = this.head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = create(data);

    }

    public void printList() {

        if(this.head == null)
            return; 

        Node current = this.head;

        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public boolean deleteNode(int data) {

        //Empty List
        if(this.head == null)
            return false;

        // Only One Element in the list
        if(this.head.next == null) {

            if(this.head.data == data) {
                this.head = null;
                return true;
            }
            else
                return false;

        }

        Node prev = this.head;
        Node current = this.head;

        // When head node itself holds value to be deleted
        if(this.head.data == data) {
            this.head = this.head.next;
            return true;
        }

        // When node other than head holds the data
        while(current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        if(current != null) {
            prev.next = current.next;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        LinkedListOperations list = new LinkedListOperations();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.printList();

        list.deleteNode(1);
        list.deleteNode(2);
        list.deleteNode(3);
        list.deleteNode(4);
        list.deleteNode(5);

        list.printList();
    }
}
