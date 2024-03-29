package FastAndSlowPointers;

import TwoPointers.LinkedListNode;

// Middle of the LinkedList
public class Problem_03 {
    public static LinkedListNode middleNode(LinkedListNode head) {
    
    LinkedListNode slow = head;
    LinkedListNode fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
