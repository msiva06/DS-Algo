// Populating next right pointers in each node
public class Problem_03 {
    public static EduTreeNode<Integer> populateNextPointers(EduTreeNode<Integer> root) {
		// Queue<EduTreeNode<Integer>> queue = new LinkedList<>();
		// if(root == null)
		// 	return root;
		// queue.offer(root);
		// while(!queue.isEmpty()){
		// 	int size = queue.size();
		// 	for(int i = 0; i < size; i++){
		// 		EduTreeNode<Integer> node = queue.poll();
		// 		if(i != size-1){
		// 			node.next = queue.peek();
		// 		}
		// 		else{
		// 			node.next = null;
		// 		}
		// 		if(node.left != null)
		// 			queue.offer(node.left);
		// 		if(node.right != null)
		// 			queue.offer(node.right);
		// 	}
		// }
		// return root;
        EduTreeNode<Integer> leftMost = root;
		while(leftMost.left != null){
			EduTreeNode<Integer> curr = leftMost;
			while(curr != null){
				if(curr.left != null)
					curr.left.next = curr.right;
				if(curr.next != null){
					curr.right.next = curr.next.left;
				}
				curr = curr.next;
			}
			leftMost = leftMost.left;
			
		}
		return root;
	}
}
