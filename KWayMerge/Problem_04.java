package KWayMerge;


import java.util.List;

public class Problem_04 {
    public static LinkedListNode mergeKLists(List<LinkedListNode> lists) {
        
		int step = 1;
		if(lists.size() > 0){
			while(step < lists.size()){
				for(int i = 0; i < lists.size() - step; i+= step * 2){
					lists.get(i).head = mergeList(lists.get(i).head,lists.get(i+step).head);
				}
				step *= 2;
			}
			return lists.get(0).head;
		}
		return null;
	}

	public static LinkedListNode mergeList(LinkedListNode head1, LinkedListNode head2){
		LinkedListNode l1 = head1;
		LinkedListNode l2 = head2;
		LinkedListNode dummy = new LinkedListNode(-1);
		LinkedListNode prev = dummy;
		while(l1 != null && l2 != null){
			if(l1.data >= l2.data){
				prev.next = l2;
				l2 = l2.next;
			}
			else{
				prev.next = l1;
				l1 = l1.next;
			}
			prev = prev.next;
		}
		if(l1 == null){
			prev.next = l2;
		}
		if(l2 == null){
			prev.next = l1;
		}
		return dummy.next;
	}
}
