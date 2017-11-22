package varun;
import java.util.*;
import java.lang.*;
public class cuboid {
 public static void main(String args[])
 {
	 int n,v,max2,max1,max,temp;
	 Scanner st =new Scanner(System.in);
	 n=st.nextInt();
	temp=n/3;
	max1=(temp*temp*(n-(2*temp))) ;
//	System.out.println(max1+" "+temp);
	temp=(n/3)+1;
	max2=(temp*temp*(n-(2*temp))) ;
	//System.out.println(max2+" "+temp);
	max=Math.max(max1, max2);
	System.out.println(max);
 }
}
