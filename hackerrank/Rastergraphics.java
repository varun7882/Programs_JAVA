package hackerrank;
import java.util.Scanner;

public class Rastergraphics {

    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int w = in.nextInt();
	        int h = in.nextInt();
	        int circleX = in.nextInt();
	        int circleY = in.nextInt();
	        int r = in.nextInt();
	        int x1 = in.nextInt();
	        int y1 = in.nextInt();
	        int x3 = in.nextInt();
	        int y3 = in.nextInt();
	        Circle c= new Circle(r,circleX,circleY);
	        Square s= new Square(x1, y1, x3, y3);
	        for(int i=0;i<h;i++)
	        {
	        	for(int j=0;j<w;j++)
	        	{
	        		if(c.isInside(j,i))
	        		{
	        			System.out.print("#");
	        		}
                    else if(s.isInside(j,i))
                        {
                        System.out.print("#");
                    }
	        		else
	        		{
	        			System.out.print(".");
	        		}
	        	}
	        	System.out.println();
	        }
	    }
}
class Circle
{
	private double r,cx,cy;
	public Circle(int r,int cx,int cy)
	{
		this.r=r;
		this.cx=cx;
		this.cy=cy;
	}
	boolean isInside(int x,int y)
	{
		double d=Math.sqrt(Math.pow(cx-x, 2)+Math.pow(cy-y,2));
		if(d<=r)
		{
			return true;
		}
		return false;
	}
}
class Square
{
	private double x1,x3,y1,y3,m1,m2;
	public Square(int x,int y,int xx,int yy)
	{
		x1=x;
		y1=y;
		x3=xx;
		y3=yy;
		if(x1==x3)
		{
			m1=1;
			m2=-1;
		}
        else if(y1==y3)
            {
            m1=1;
            m2=-1;
        }
		else
		{
			double m=(y3-y1)/(x3-x1);
			m1=(m-1)/(m+1);
			m2=(1/m1)*(-1);
		}
	}
	boolean isInside(int x,int y)
	{
		double t1,t2,t3,t4;
		t1=(m1*x)-y+y1-(m1*x1);
		t2=(m2*x)-y+y3-(m2*x3);
		t3=(m2*x)-y+y1-(m2*x1);
		t4=(m1*x)-y+y3-(m1*x3);
      // if(t1*t2*t3*t4==0)return true;
		if((t1<0 && t2<0) && (t3>0 && t4>0))return true;
        if((t1>0 && t2>0) && (t3<0 && t4<0))return true;
		return false;
	}
}
