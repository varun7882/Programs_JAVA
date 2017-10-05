package crackingthecodinginterview;
import java.util.*;
public class Contacts {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        TrieNode root= new TrieNode('*');
	        for(int a0 = 0; a0 < n; a0++){
	            String op = in.next();
	            String contact = in.next();
	            if(op.equals("add"))
	            {
	            	TrieNode.addContact(root, contact);
	            }
	            else
	            {
	            	System.out.println(TrieNode.findContact(root, contact));
	            }
	        }
	    }
}
class TrieNode
{
	Map<Character,TrieNode> mp;
	int ch;
	char c;
	boolean isWord;
	TrieNode(Character c)
	{
		mp= new HashMap<Character, TrieNode>();
		this.c=c;
		ch=0;
		isWord=false;
	}
	static void addContact(TrieNode root,String con)
	{
		int i=0;
		TrieNode t=root;
		while(i<con.length())
		{
			if(t.mp.containsKey(con.charAt(i)))
			{
				t.ch++;
				t=t.mp.get(con.charAt(i));
				i++;
			}
			else
			{
				break;
			}
		}
		if(i==con.length())return;
		while(i<con.length())
		{
			t.ch++;
			t.mp.put(con.charAt(i), new TrieNode(con.charAt(i)));
			t=t.mp.get(con.charAt(i));
			i++;
		}
		t.isWord=true;
	}
	static int findContact(TrieNode root,String con)
	{
		int i=0,ans=0;
		TrieNode t=root;
		while(i<con.length())
		{
			if(t.mp.containsKey(con.charAt(i)))
			{
				t=t.mp.get(con.charAt(i));
				i++;
			}
			else
			{
				break;
			}
		}
		if(i!=con.length())return 0;
		ans=t.ch;
		if(t.isWord)ans++;
		return ans;
	}
}
