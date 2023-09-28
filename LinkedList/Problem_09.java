package LinkedList;

// Odd Even LinkedList
public class Problem_09 {
    public LinkedListNode oddEvenList(LinkedListNode head) {
        LinkedListNode odd = head;
        if(head == null)
            return null;
        LinkedListNode even = head.next;
        LinkedListNode evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
