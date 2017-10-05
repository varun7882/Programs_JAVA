package interview;
import java.util.*;
public class GasStation {
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
		int ans=-1;
		if(gas.size()==1)return 0;
		for(int i=0;i<gas.size();i++)
		{
			if(checkCir(gas,cost,i))
			{
				return i;
			}
		}
		return ans;
	}
	boolean checkCir(final List<Integer> gas, final List<Integer> cost,int in)
	{
		int tank=0,i=in;
		if(gas.get(i)<cost.get(i))
		{
			return false;
		}
		else
		{
			tank=gas.get(i)-cost.get(i);
		}
		i=(i+1)%gas.size();
		while(i!=in)
		{
			tank=tank+gas.get(i);
			if(tank<cost.get(i))
			{
				return false;
			}
			else
			{
				tank=tank-cost.get(i);
			}
			i=(i+1)%gas.size();
		}
		return true;
	}
}