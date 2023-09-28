package LinkedList;

// Delete middle node in LinkedList
public class Problem_08 {
    public LinkedListNode deleteMiddle(LinkedListNode head) {
        LinkedListNode prev = null;
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null && prev.next != null){
            prev.next = prev.next.next;
            return head;
        }
        return null;   
    }
}
