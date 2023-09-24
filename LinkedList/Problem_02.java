package LinkedList;

// Reverse Nodes in K Group
public class Problem_02 {
    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode ptr = dummy;
        
        while(ptr != null){
          LinkedListNode tracker = ptr;
          for(int i = 0; i < k; i++){
            if(tracker == null)
              break;
            tracker = tracker.next;
          }
          if(tracker == null)
            break;
          LinkedListNode[] reverseK = reverseLinkedList(ptr.next,k);
          LinkedListNode prev = reverseK[0];
          LinkedListNode curr = reverseK[1];
          LinkedListNode lastNodeReversed = ptr.next;
          lastNodeReversed.next = curr;
          ptr.next = prev;
          ptr = lastNodeReversed;
        }
  
        return dummy.next;
      }
  
      public static LinkedListNode[] reverseLinkedList(LinkedListNode head, int k){
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        while(curr != null && k > 0){
          LinkedListNode next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
          k--;
        }
        return new LinkedListNode[]{prev,curr};
      }
}
