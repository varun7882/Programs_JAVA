package interview;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
	RandomListNode ans=null;
	 public RandomListNode copyRandomList(RandomListNode head) {
		 if(head==null)
		 {
			 return null;
		 }
		 Map<RandomListNode ,RandomListNode > m= new HashMap<RandomListNode, RandomListNode>();
		 RandomListNode trav,atrav,natrav=null;
		 trav=head;
		 while(trav!=null)
		 {
			 atrav= new RandomListNode(trav.label);
			 m.put(trav,atrav);
			 if(natrav==null)
			 {
				 ans=atrav=natrav;
			 }
			 else
			 {
				 natrav.next=atrav;
				 natrav=natrav.next;
			 }
			 trav=trav.next;
		 }
		 atrav=ans;
		 trav=head;
		 while(atrav!=null)
		 {
			 atrav.random=m.get(trav.random);
			 atrav=atrav.next;
			 trav=trav.next;
		 }
		 return ans;
	    }
}
class RandomListNode {
	     int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };