package utl;

import java.util.regex.Pattern;

public class Check {
	public static boolean checkString(String text) {

		boolean res = true;

		Pattern pattern = Pattern.compile("^[0-9]+$|-[0-9]+$");
		res = pattern.matcher(text).matches();

		return res;
	}
}
