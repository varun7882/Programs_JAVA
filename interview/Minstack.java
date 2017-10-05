package interview;

import java.util.Stack;

public class Minstack {
	Stack<Integer> s;
	Stack<Integer> ms;
	int min=Integer.MAX_VALUE;
	Minstack()
	{
	s= new Stack<Integer>();
	ms=new Stack<Integer>();
	}
	   public void push(int x)
	   {
	        if(min>=x)
	        {
	        	min=x;
	        	ms.push(x);
	        }
	        s.push(x);
	    }

	    public void pop() {
	    	if(!s.empty())
	    	{
	    	int pms=ms.peek();
	    	int ps=s.peek();
	    	if(ps==pms)
	    	{
	    		ms.pop();
	    	}
	    	s.pop();
	    	}
	    }

	    public int top() {
	    	if(s.empty())
	    	{
	    		return -1;
	    	}
	        return s.peek();
	    }

	    public int getMin() {
	    	if(s.empty())
	    	{
	    		return -1;
	    	}
	        return ms.peek();
	        
	    }
}
