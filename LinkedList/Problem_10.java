package LinkedList;

// Maximum Twin sum of LinkedList
public class Problem_10 {
    public int pairSum(LinkedListNode head) {
        int maxPairSum = Integer.MIN_VALUE;
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode reverseHead = reverse(slow);
        LinkedListNode reversePtr = reverseHead;
        LinkedListNode curr = head;
        while(curr != null && reversePtr != null){
            int sum = curr.data + reversePtr.data;
            maxPairSum = Math.max(sum,maxPairSum);
            curr = curr.next;
            reversePtr = reversePtr.next;
        }
        return maxPairSum;
    }
    public LinkedListNode reverse(LinkedListNode head){
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        while(curr != null){
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
