package java_reg_exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher replace
 *
 * @author ����
 *
 */
public class RegExpTest3 {
	private static String REGEX = "dog";
	private static String INPUT = "The dog says meow. All dogs say meow.";
	private static String REPLACE = "cat";

	public static void main(String[] args) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(INPUT);
		INPUT = m.replaceAll(REPLACE);//�滻
		System.out.println(INPUT);
	}
}