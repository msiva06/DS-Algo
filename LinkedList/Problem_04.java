package LinkedList;

public class Problem_04 {
    public static LinkedListNode reorderList(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
        }
        LinkedListNode reverse = reverse(slow);
        LinkedListNode curr = head;
        LinkedListNode first = head;
        LinkedListNode rev = reverse;
        while(rev.next != null){
          curr = curr.next;
          first.next = rev;
          rev = rev.next;
          first.next.next = curr;
          first = first.next.next;
        }
        
        return head;
      }
      public static LinkedListNode reverse(LinkedListNode head) {
    
            LinkedListNode prev = null;
            LinkedListNode curr = head;
            while(curr != null){
                LinkedListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            
            return prev;
        }
}
