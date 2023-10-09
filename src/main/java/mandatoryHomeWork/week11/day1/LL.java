package mandatoryHomeWork.week11.day1;


public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    private class Node {

        private int data;
        private Node next;


        public Node(int value) {
            this.data = value;
        }

        public Node(int value, Node node) {
            this.data = value;
            this.next = node;
        }
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "-->");
            currentNode = currentNode.next;
        }
        System.out.println("End");

    }

    public void insertAtEnd(int value) {
        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            insertAtBeginning(value);
            return;
        }
        Node currentNode = head;
        Node newNode = new Node(value);
        // Traverse the list to find the last node
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        if (currentNode.next == null) {
            // Update the last node's next reference to the new node
            currentNode.next = newNode;
            // Update the tail to the new node
            tail = newNode;
        }
        size++;
    }

    public void insertAtIndex(int userIndex, int value) {
        int currentIndex = 0;
        Node currentNode = head;
        Node newNode = new Node(value);
        if (userIndex == 0) {
            insertAtBeginning(value);
            return;
        } else if (userIndex == size() - 1) {
            insertAtEnd(value);
        } else if (userIndex > size) {
            System.out.println("Index " + userIndex + " is out of bounds.");
        } else {
            while (currentNode.next != null) {
                if (currentIndex == userIndex - 1) {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    break;
                }
                currentIndex++;
                currentNode = currentNode.next;
                size++;
            }
        }

    }

    public void deleteFirstIndex() {
        if (head == null) {
            System.out.println("list is empty");
        } else if (head == tail && head != null) {
            head = tail = null;
            size--;
        } else {
            head = head.next;
            size--;
        }

    }

    public void deleteALl() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void deleteLastIndex() {
        if (head == null) {
            System.out.println("Empty list, nothing to delete");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            Node currentNode = head;
            Node previouseNode = null;
            while (currentNode.next != null) {
                previouseNode = currentNode;
                currentNode = currentNode.next;
            }
            tail = previouseNode;
            tail.next = null;
        }
        size--;
    }

    public void removeAllValue(int value) {
        if (head == null) {
            System.out.println("list is empty");
        }
        Node currentNode, previousNode;
        currentNode = head;
        previousNode = null;
        while (currentNode != null) {
            if (currentNode.data == value) {
                currentNode = currentNode.next;
                if (previousNode != null) {
                    previousNode.next = currentNode;
                }else{
                    head = currentNode;
                }
                size--;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.next;

            }
        }
    }
}
