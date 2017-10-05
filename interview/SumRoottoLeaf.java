package interview;
import java.math.*;
public class SumRoottoLeaf {
	int ans=0;
	BigInteger c= new BigInteger("0");
	BigInteger m= new BigInteger("1003");
	public int sumNumbers(TreeNode a) {
		if(a==null)return 0;
		StringBuffer s= new StringBuffer();
		getAns(a,s);
		ans=c.intValue();
		return ans;
	}
	void getAns(TreeNode t,StringBuffer s)
	{
		if(t==null)return;
		if(t.left==null && t.right==null)
		{
			s.append(t.val);
			BigInteger tmp= new BigInteger(s.toString());
			c=c.add(tmp);
			c=c.mod(m);
			s.deleteCharAt(s.length()-1);
			return;
		}
		s.append(t.val);
		getAns(t.left,s);
		getAns(t.right,s);
		s.deleteCharAt(s.length()-1);
	}
}
