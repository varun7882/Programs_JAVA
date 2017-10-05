package hackerrank;

import java.text.NumberFormat;
import java.util.Locale;

public class Currency {
public static void main(String[] args) {
	String s=NumberFormat.getCurrencyInstance(Locale.FRANCE).format(13);
	System.out.print(s);
}
}
