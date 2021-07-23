public class LinkedList {

    Node head = null;

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void insert(LinkedList list, int data) {

        if (list.head == null) {
            Node node = new Node(data);
            list.head = node;
            return;
        }
        Node new_node = new Node(data);

        Node current = list.head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new_node;

        Exception exp = new Exception();
        exp.getStackTrace().toString();

    }

    public void print(LinkedList list) {


        Node current = list.head;

        if (current == null)
            return;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
    }

    public void computeMiddleElement(LinkedList list) {

        Node slow_ptr = head;
        Node fast_ptr = head.next;

        if (fast_ptr == null) //one ele
            print(list);

        while (fast_ptr != null && fast_ptr.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }

        System.out.println("Middle Element " + slow_ptr.next.data);
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insert(list, 1);
        list.insert(list, 2);
        list.insert(list, 3);
        list.insert(list, 4);
        list.insert(list, 5);
        list.insert(list, 6);
        list.print(list);

        list.computeMiddleElement(list);

    }
}
