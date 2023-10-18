package mandatoryHomeWork.week12.Day3;

import mandatoryHomeWork.week11.day6.ListNode;
import mandatoryHomeWork.week11.day6.SingleLinkedList;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LC_143_ReorderList {

    /*
        1. create a map, iterate thru the given list and add it to the map
        2. keep a size variable and increment during iteration while adding in map
        3. if list is empty or less than 2 then return
        4. keep two pointers at the left and right most of the list
            iterate from the left to right till middle
                keep the head.next in a temp variable
                the point the currentnode.next to last node from the list, get it from the map
                now, point the currentNode.next.next  to the temp node
                move the pointer to the temp node for next iteration
        5. finally if the left and right is same (middle) point the current node  to the middle vaule and
                point the next of it to null
           else
                point the current node to null
     */


    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public void reorderList(ListNode head) {
        {
            ListNode currentNode = head;
            if (head == null || head.next == null) return;
            HashMap<Integer, ListNode> map = new HashMap<>();
            int size = 0;

            while (currentNode != null) {
                map.put(size++, currentNode);
                currentNode = currentNode.next;
            }

            int left = 0;
            int right = size-1;
            currentNode = head;

            while (left < right) {
                ListNode next = currentNode.next;
                currentNode.next = map.get(right);
                map.get(right).next = next;
                currentNode = next;
                left++;
                right--;
            }
            if (left != right) {
                currentNode.next = null;
            } else {
                map.get(left + 1).next = map.get(left);
                map.get(left).next = null;
            }
        }
    }
        @Test
        public void testData () {
            SingleLinkedList list = new SingleLinkedList();
            ListNode add = list.add(new int[]{1, 2, 3, 4});
            reorderList(add);

        }
    }
