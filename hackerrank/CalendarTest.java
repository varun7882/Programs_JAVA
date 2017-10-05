package hackerrank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) throws ParseException {
	//Calendar c=Calendar.getInstance();
		//c.setTime();
		//int n=c.get(Calendar.DAY_OF_WEEK);
		//System.out.print(n);
		 String input_date="21/05/2017";
		  SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
		  Date dt1=format1.parse(input_date);
		  DateFormat format2=new SimpleDateFormat("EEEE"); 
		  String finalDay=format2.format(dt1);
		  System.out.println(finalDay);
	}
}
