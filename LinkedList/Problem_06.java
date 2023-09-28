package LinkedList;

// Reverse nodes in even length groups
public class Problem_06 {
    public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head) {
      
        LinkedListNode prev = head;
        LinkedListNode node = null;
        LinkedListNode nodeNext = null;
        int numNodes = 0, groupLen = 2;
        while(prev.next != null){
          node = prev;
          numNodes = 0;
          for(int i = 0; i < groupLen; i++){
            
            if(node.next == null)
              break;
            node = node.next;
            numNodes++;
          }
          if(numNodes % 2 != 0) {
            prev = node;
          }
          else{
            nodeNext = node.next;
            LinkedListNode curr = prev.next;
            LinkedListNode prevCurr = null;
            int count = 0;
            while(curr != null && count < numNodes){
              LinkedListNode next = curr.next;
              curr.next = prevCurr;
              prevCurr = curr;
              curr = next;
              count++;
            }
            prev.next = prevCurr;
            LinkedListNode temp = prevCurr;
            while(temp.next != null){
              temp = temp.next;
            }
            temp.next = nodeNext;
            prev = temp;
          }
          groupLen++;
        }
        
        return head;
        }
}
