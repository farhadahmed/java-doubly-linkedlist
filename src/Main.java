public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.appendNode(15);
        list.appendNode(20);
        list.prependNode(10);
        list.prependNode(5);
        list.appendNode(25);
        list.traverseForward();
        System.out.println("\n\n");
        list.traverseBackward();
        System.out.println("\n\n");
        DoublyLinkedList<String> contacts = new DoublyLinkedList<>();
        contacts.appendNode("Svetlana");
        contacts.appendNode("Tim");
        contacts.prependNode("Moo");
        contacts.prependNode("Kevin");
        contacts.appendNode("Victor");
        contacts.prependNode("Harry");
        contacts.traverseForward();
        System.out.println("\n\n");
        contacts.traverseBackward();

        System.out.println("\n\n");
        contacts.removeNode("Tim");

        contacts.traverseForward();
    }
}
