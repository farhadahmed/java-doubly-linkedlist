// LinkedList's generic type inherits from the Comparable interface purely
// for the purpose of using the .compareTo() method when removing nodes from
// a LinkedList.
public class DoublyLinkedList <T extends Comparable<T>> implements List<T> {
    private Node<T> head;
    private Node<T> tail;

    // Complexity is O(1) since we can directly access the head node and
    // set its value to be the new node.
    @Override
    public void prependNode(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
        }
    }

    // Complexity is O(1). Since this is a doubly linked list, we can directly
    // access the tail node and set its value to be the new node.
    @Override
    public void appendNode(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPreviousNode(tail);
            tail.setNextNode(newNode);
            tail = newNode;
        }
    }

    // Complexity is O(n) since the search for the node is linear.
    @Override
    public void removeNode(T value) {
        if (head == null) return;

        if (head.getValue().compareTo(value) == 0) {
            head.getNextNode().setPreviousNode(null);
            head = head.getNextNode();
        }
        else if (tail.getValue().compareTo(value) == 0) {
            tail.getPreviousNode().setNextNode(null);
            tail = tail.getPreviousNode();
        }
        else {
            removeNode(value, head, head.getNextNode());
        }
    }

    // This method searches each node except for the head and tail since those
    // nodes were checked in the removeNode(value) method.
    private void removeNode(T value, Node<T> previousNode, Node<T> currentNode) {
        while (currentNode != tail) {
            if (currentNode.getValue().compareTo(value) == 0) {
                previousNode.setNextNode(currentNode.getNextNode());
                currentNode.getNextNode().setPreviousNode(previousNode);
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
    }

    // Complexity is O(n)
    @Override
    public void traverseForward() {
        if (head == null) return;

        Node<T> current = head;

        // Since we overrided Node's toString() method, we can just print
        // each node.
        while (current != null) {
            System.out.println(current);
            current = current.getNextNode();
        }
    }

    // Complexity is O(n)
    @Override
    public void traverseBackward() {
        if (head == null) return;

        Node<T> current = tail;
        // Since we overrided Node's toString() method, we can just print
        // each node.
        while (current != null) {
            System.out.println(current);
            current = current.getPreviousNode();
        }
    }
}
