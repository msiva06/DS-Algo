package LinkedList;

// Swapping Nodes in LinkedList
public class Problem_05 {
    public static LinkedListNode swapNodes(LinkedListNode head, int k) {

        LinkedListNode slow = head;
        LinkedListNode fast = head;
        LinkedListNode curr = head;
        for(int i = 1; i < k; i++){
          curr = curr.next;
        }
        while(k > 0 && fast != null){
          fast = fast.next;
          k--;
        }
        while(fast != null){
          slow = slow.next;
          fast = fast.next;
        }
        System.out.println(slow.data);
        
        
        System.out.println(curr.data);
        int temp = curr.data;
        curr.data = slow.data;
        slow.data = temp;
        return head;
      }
}
