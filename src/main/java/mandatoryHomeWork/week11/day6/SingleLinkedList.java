package mandatoryHomeWork.week11.day6;

public class SingleLinkedList {
    public ListNode head;
    public ListNode tail;
    private int size;

    public SingleLinkedList() {
        this.size = 0;
    }


    public void add(int value) {
        if (head == null)  // we are trying to add the first element
            head = tail = new ListNode(value);
        else {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        size++;
    }

    public ListNode add(int[] value) {
        for (int each : value) add(each);
        return head;
    }

    public void insertAtBeginning(int value) {
        ListNode newListNode = new ListNode(value);
        newListNode.next = head;
        head = newListNode;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void display(ListNode head) {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        ListNode currentListNode = head;
        while (currentListNode != null) {
            System.out.print(currentListNode.data + "-->");
            currentListNode = currentListNode.next;
        }
        System.out.println("End");

    }

    public void display() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }
        ListNode currentListNode = head;
        while (currentListNode != null) {
            System.out.print(currentListNode.data + "-->");
            currentListNode = currentListNode.next;
        }
        System.out.println("End");

    }

    public void insertAtEnd(int value) {
        if (head == null) {
            // If the list is empty, set both head and tail to the new node
            insertAtBeginning(value);
            return;
        }
        ListNode currentListNode = head;
        ListNode newListNode = new ListNode(value);
        // Traverse the list to find the last node
        while (currentListNode.next != null) {
            currentListNode = currentListNode.next;
        }
        if (currentListNode.next == null) {
            // Update the last node's next reference to the new node
            currentListNode.next = newListNode;
            // Update the tail to the new node
            tail = newListNode;
        }
        size++;
    }

    public void insertAtIndex(int userIndex, int value) {
        int currentIndex = 0;
        ListNode currentListNode = head;
        ListNode newListNode = new ListNode(value);
        if (userIndex == 0) {
            insertAtBeginning(value);
            return;
        } else if (userIndex == size() - 1) {
            insertAtEnd(value);
        } else if (userIndex > size) {
            System.out.println("Index " + userIndex + " is out of bounds.");
        } else {
            while (currentListNode.next != null) {
                if (currentIndex == userIndex - 1) {
                    newListNode.next = currentListNode.next;
                    currentListNode.next = newListNode;
                    break;
                }
                currentIndex++;
                currentListNode = currentListNode.next;
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
            ListNode currentListNode = head;
            ListNode previouseListNode = null;
            while (currentListNode.next != null) {
                previouseListNode = currentListNode;
                currentListNode = currentListNode.next;
            }
            tail = previouseListNode;
            tail.next = null;
        }
        size--;
    }

    public void removeAllValue(int value) {
        if (head == null) {
            System.out.println("list is empty");
        }
        ListNode currentListNode, previousListNode;
        currentListNode = head;
        previousListNode = null;
        while (currentListNode != null) {
            if (currentListNode.data == value) {
                currentListNode = currentListNode.next;
                if (previousListNode != null) {
                    previousListNode.next = currentListNode;
                } else {
                    head = currentListNode;
                }
                size--;
            } else {
                previousListNode = currentListNode;
                currentListNode = currentListNode.next;

            }
        }
    }

    public int sizeDynamic(ListNode headValue) {
        int size = 0;
        ListNode currentListNode = head;
        while (currentListNode != null) {
            currentListNode = currentListNode.next;
            size++;
        }
        return size;
    }

    public void middleNode(ListNode headValue) {
        int sizeValue = sizeDynamic(headValue);
        int expectedIndex = 0;
        int currentIndex = 0;

        if (sizeValue % 2 == 0) {
            expectedIndex = (sizeValue / 2) - 1;
        } else {
            expectedIndex = sizeValue / 2;
        }

        ListNode currentListNode = headValue;
        ListNode previousListNode = null;

        while (currentListNode != null) {
            if (currentIndex == expectedIndex) {
                // Update the head of list1 to the middle node
                this.head = currentListNode;
                this.size = sizeValue - expectedIndex;
                return;
            }
            previousListNode = currentListNode;
            currentListNode = currentListNode.next;
            currentIndex++;
        }
    }

    public ListNode middleNode_1() {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;      // Move slow by one step
            fast = fast.next.next; // Move fast by two steps
        }
        return slow;
    }

    public ListNode addSecondListToFirstNodeTail(ListNode node1, ListNode node2) {
        ListNode currentNode = node1;
        ListNode previousNode = null;

        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        currentNode.next = node2;
        return node1;
    }

}
