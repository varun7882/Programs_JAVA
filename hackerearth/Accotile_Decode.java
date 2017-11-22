package hackerearth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class Accotile_Decode {
	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	        int T = Integer.parseInt(br.readLine().trim());
	        for(int t_i=0; t_i<T; t_i++)
	        {
	            String s = br.readLine();

	            String out_ = decode(s);
	            System.out.println(out_);
	         }

	         wr.close();
	         br.close();
	    }
	    static String decode(String s){
	        StringBuffer bs=new StringBuffer("");
	        for(int i=s.length()-1;i>=0;i--)
	        {
	            char c=s.charAt(i);
	            int l=bs.length(),m;
	            m=l/2;
	            /*if(l!=0 && l%2==0)
	            {
	                m--;
	            }*/
	            bs.insert(m,c);
	        }
	        return bs.toString();
	    }
}
