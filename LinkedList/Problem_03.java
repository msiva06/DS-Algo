package LinkedList;

// Reverse LinkedList II
public class Problem_03 {
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
      
        LinkedListNode curr = head;
        LinkedListNode lpn = null;
        LinkedListNode rpn = null;
        LinkedListNode right_end = null;
        LinkedListNode reverse = null;
        int count = 1;
        while(curr != null && count < left){
          lpn = curr;
          curr = curr.next;
          count++;
        }
        if(curr != null){
          rpn = curr;
          while(rpn != null && count <= right){
            right_end = rpn ;
            rpn = right_end.next;
            count++;
          }
          if(right_end != null){
            reverse = reverseL(curr,left,right);
          }
          if(lpn != null){
            lpn.next = reverse;
          }
          if(rpn != null){
            LinkedListNode temp = reverse;
            while(temp.next != null){
              temp = temp.next;
            }
            temp.next = rpn;
          }
          
        }
        if(lpn != null)
            return head;
        return reverse;
      }
    
      public static LinkedListNode reverseL(LinkedListNode head,int left,int right){
        LinkedListNode curr = head;
        LinkedListNode prev = null;
        while(right >= left){
          LinkedListNode next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
          right--;
        }
        return prev;
      }
}
