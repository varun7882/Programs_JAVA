package interview;
import java.util.*;
public class Sudoku {
int s[][]= new int[9][9];
	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
	
		for(int i=0;i<a.size();i++)
		{
			ArrayList<Character> b=a.get(i);
			for(int j=0;j<b.size();j++)
			{
				char x=b.get(j);
				if(x=='.')
				{
					s[i][j]=-1;
				}
				else
				{
					s[i][j]=Integer.parseInt(""+x);
				}
			}
		}
		/*	for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
				System.out.print(s[i][j]+" ");
				}
				System.out.println();
			}*/
		fillsudoku(a);
	}
	
	void fillsudoku(ArrayList<ArrayList<Character>> a)
	{
		
		
		if(isDone())
		{
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					a.get(i).set(j,String.valueOf(s[i][j]).charAt(0));
				}
			}
		
		}
		else
		{
			int R=-1,C=-1;
			for(int i=0;i<9;i++)
			{
				for(int j=0;j<9;j++)
				{
					if(s[i][j]==-1)
					{
						R=i;
						C=j;
						break;
					}
				}
			}
			for(int k=1;k<=9;k++)
			{
				if(isOkay(R,C,k))
				{
					s[R][C]=k;
					fillsudoku(a);
					if(isDone())
					{
						return;
					}
					s[R][C]=-1;
				}
			}
		}
	}
	boolean isDone()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
			if(s[i][j]==-1)
			{
				return false;
			}
			}
		}
		return true;
			
	}
	boolean isOkay(int i,int j,int k)
	{
		int sr=getl3(i);
		int sc=getl3(j);
		for(int ii=sr;ii<sr+3;ii++)
		{
			for(int jj=sc;jj<sc+3;j++)
			{
				if(s[ii][jj]==k)
				{
					return false;
				}
			}
		}
		for(int ii=0;ii<9;ii++)
		{
			if(s[i][ii]==k)return false;
		}
		for(int ii=0;ii<9;ii++)
		{
			if(s[ii][j]==k)return false;
		}
		return true;
	}
	int getl3(int n)
	{
		int x=n/3;
		return x*3;
	}
}
