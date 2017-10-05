package interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	 public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	        if(node==null)return null;
	        Map<UndirectedGraphNode,UndirectedGraphNode> mp=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
	        Queue<UndirectedGraphNode> q=new ArrayDeque<UndirectedGraphNode>();
	         UndirectedGraphNode cnode=new UndirectedGraphNode(node.label);
	          mp.put(node,cnode);
	        q.offer(node);
	        while(!q.isEmpty())
	        {
	            UndirectedGraphNode onode=q.poll();
	            UndirectedGraphNode conode=mp.get(onode);
	            for(UndirectedGraphNode x:onode.neighbors)
	            {
	                if(!mp.containsKey(x))
	                {
	                     UndirectedGraphNode nx=new UndirectedGraphNode(x.label);
	                     mp.put(x,nx);
	                     q.offer(x);
	                }
	                conode.neighbors.add(mp.get(x));
	            }
	        }
	        return cnode;
	    }
}
class UndirectedGraphNode {
	      int label;
	      List<UndirectedGraphNode> neighbors;
	      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	  };