package interview;
import java.util.*;
public class ValidSudoku {
	public int isValidSudoku(final List<String> a) {
		int tr[][]=new int [9][9];
		int tc[][]=new int [9][9];
		int ib[][][]=new int [9][9][9];
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				char x=a.get(i).charAt(j);
				if(x!='.')
				{
					int y=Integer.parseInt(Character.toString(x));
					tr[i][y-1]++;
					if(tr[i][y-1]>1)
					{
						return 0;
					}
					tc[j][y-1]++;
					if(tr[j][y-1]>1)
					{
						return 0;
					}
					int r,c;
					r=(i/3);
					r=r*3;
					c=j/3;
					c=c*3;
					ib[r][c][y-1]++;
					if(ib[r][c][y-1]>1)
					{
						return 0;
					}
				}
			}
		}
		return 1;
	}
}
