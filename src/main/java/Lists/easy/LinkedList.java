package Lists.easy;

/**
 * Date : 18/05/2021
 * Linked List
 */
public class LinkedList {

    Node head;

    static class Node{

        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }

    }

    static LinkedList insert(LinkedList list, int data) {

        Node next_node = new Node(data);
        next_node.next = null;

        // Empty List
        if( list.head == null)  list.head = next_node;
        else {

            Node current = list.head;
            while(current.next != null){
                current = current.next;
            }

            current.next = next_node;

        }

        return list;

    }

    static void printList(LinkedList list) {
        System.out.println();
        Node head = list.head;

        if(head == null)
            return;
        else {

            Node current = list.head;
            while (current.next != null) {
                System.out.print(current.data+" => ");
                current = current.next;
            }
            System.out.print(current.data);
        }
    }

    static LinkedList reverseList(LinkedList list) {

        if(list.head == null)
            return list;

        Node prev = null;
        Node current = list.head;
        Node next_node = null;

        while (current != null) {
             next_node = current.next;
             current.next = prev;
             prev = current;
             current = next_node;
        }
        list.head = prev;

        return list;
    }

    // Driver code
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();

        //
        // ******INSERTION******
        //

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);
        reverseList(list);
        printList(list);
        }


}
