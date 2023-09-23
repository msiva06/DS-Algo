package LinkedList;

// Reverse LinkedList(In place)
public class Problem_01 {
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
