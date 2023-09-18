package FastAndSlowPointers;

import TwoPointers.LinkedListNode;

// LinkedList cycle
public class Problem_02 {
    public static boolean detectCycle(LinkedListNode head) {
    
    LinkedListNode slow = head;
    LinkedListNode fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
      if(slow == fast)
        return true;
    }

    return false;
  }
}
