package crackingthecodinginterview;
import java.util.*;
public class Checker implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		int x,y;
		x=o1.score;
		y=o2.score;
		if(x!=y)
		{
			return y-x;
		}
		return o2.name.compareTo(o1.name);
	}


}
class Player
{
	int score;
	String name;
}