package TwoPointers;

// Remove nth node from End of list
public class Problem_03 {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        
        LinkedListNode left = head;
        LinkedListNode right = head;
        while(n > 0){
            right = right.next;
            n--;
        }
        if(right == null)
            return head.next;
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }
}
