package interview;
import java.util.*;
public class Genparen {
	ArrayList<String> ans= new ArrayList<String>();
	int n;
	public ArrayList<String> generateParenthesis(int a) {
		n=a;
		ArrayList<Character> tmp= new ArrayList<Character>();
		getans(0,tmp,0,0);
		
		Collections.sort(ans, new Comparator<String>()
		{

			@Override
			public int compare(String o1, String o2) {
				char x,y;
				for(int i=0;i<o1.length();i++)
				{
					x=o1.charAt(i);
					y=o2.charAt(i);
					if(x!=y)
					{
						if(x=='(')
						{
							return 1;
						}
						else
						{
							return -1;
						}
					}
				}
				return 0;
			}

			
			
		});
		return ans;
	}
	void getans(int i,ArrayList<Character> tmp,int op,int cl)
	{
		StringBuilder st= new StringBuilder();
		if(cl==n)
		{
			for(int j=0;j<tmp.size();j++)
			{
				char x=tmp.get(j);
				st.append(x);

			}
			String xx= st.toString();
			
			ans.add(xx);
		}
		else
		{
			if(op<n)
			{
				tmp.add('(');
				getans(i+1,tmp,op+1,cl);
				//tmp.remove(tmp.size()-1);
			}
			if(op>cl)
			{
				tmp.add(')');
				getans(i+1,tmp,op,cl+1);
				//tmp.remove(tmp.size()-1);
			}
		}
	}
}
