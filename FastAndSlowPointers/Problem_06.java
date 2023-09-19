package FastAndSlowPointers;

import TwoPointers.LinkedListNode;

// Palindrome LinkedList
public class Problem_06 {

    public static boolean palindrome(LinkedListNode head) {

        // Replace this placeholder return statement with your code
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
        }
        LinkedListNode midReverse = reverse(slow);
        boolean change = compare(head,midReverse);
        midReverse = reverse(midReverse);
        return change;
      }

      public static boolean compare(LinkedListNode firstHalf,LinkedListNode secondHalf){
        while(firstHalf != null && secondHalf != null){
          if(firstHalf.data != secondHalf.data)
            return false;
          firstHalf = firstHalf.next;
          secondHalf = secondHalf.next;
        }
        return true;
      }

      public static LinkedListNode reverse(LinkedListNode head){
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        while(curr != null){
          LinkedListNode newNode = curr.next;
          curr.next = prev;
          prev = curr;
          curr = newNode;
        }
        return prev;
      }
}
