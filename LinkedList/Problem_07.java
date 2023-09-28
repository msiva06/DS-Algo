package LinkedList;

//Swap node in pairs
public class Problem_07 {
    public static LinkedListNode swapPairs(LinkedListNode head) {

        LinkedListNode dummy = new LinkedListNode(-1);
        dummy.next = head;
        LinkedListNode prev = dummy;
        int numNodes = 0;
        LinkedListNode node = null;
        while(prev.next != null){
          node = prev;
          numNodes = 0;
          for(int i = 0; i < 2; i++){
            if(node.next == null)
              break;
            node = node.next;
            numNodes++;
          }
          if(numNodes % 2 != 0){
            prev = node;
          }
          else{
            LinkedListNode curr = prev.next;
            LinkedListNode nodeNext = node.next;
            LinkedListNode prevCurr = null;
            int count = 0;
            while(count < numNodes){
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
            temp.next = curr;
            prev = temp;
          }
        }
    
        return dummy.next;
      }
}
