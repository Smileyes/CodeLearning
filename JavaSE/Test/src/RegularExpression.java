import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		RegularExpression r = new RegularExpression();
		/*
		 * r.s(("a2+3").matches("....")); r.s(("a02vd656c").replaceAll("\\d",
		 * "*")); Pattern p = Pattern.compile("[a-z]{3}"); Matcher m =
		 * p.matcher("abcd"); r.s(m.matches());
		 * r.s(("abd").matches("[a-z]{3}"));
		 */
		/*
		 * r.s("aa".matches("a.")); r.s("aa".matches("aa"));
		 * r.s("aa".matches("ab")); r.s("aaa".matches("a*"));
		 * r.s("aab".matches("a+b")); r.s("abc".matches("a?.."));
		 * r.s("".matches("a?"));
		 * r.s("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"
		 * )); r.s("192".matches("[0-2][0-9][0-9]"));
		 */
		/*
		 * r.s("2563".matches("\\d+")); r.s(" \n".matches("\\s+"));
		 * r.s("2568*&-/\\".matches("\\d+[*&-/+\\\\]+"));
		 * r.s("asdac_56".matches("\\w+"));
		 */
		/*
		 * r.s("hello world".matches("^h.*"));
		 * r.s("hello world".matches("he.*ld$"));
		 * r.s("hello world".matches("h[a-z]{1,4}\\b.*ld$"));
		 * r.s(" \n".matches("^[\\s&&[^\\n]]*\\n$"));
		 */
		/*
		 * r.s("Smileyes@Gmail.com".matches("[\\w[-.]]+@[\\w[-.]]+\\.[\\w[-.]]+")
		 * );
		 * r.s("761698545@qq.com".matches("[\\w[-.]]+@[\\w[-.]]+\\.[\\w[-.]]+"
		 * ));
		 * r.s("Smileyes.Gmail.com".matches("[\\w[-.]]+@[\\w[-.]]+\\.[\\w[-.]]+"
		 * ));
		 */
		/*
		 * Pattern p = Pattern.compile("\\d{3,5}"); String s =
		 * "123-13546-123-99"; Matcher m = p.matcher(s); r.s(m.matches());
		 * m.reset(); r.s(m.find()); r.s(m.find()); r.s(m.group()); r.s(m);
		 * r.s(m.find()); r.s(m.start()); r.s(m.find()); r.s(m.hitEnd());
		 * m.reset(); r.s(m.lookingAt());
		 */

		/*
		 * Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE); Matcher
		 * m = p.matcher("java IloveJava JAVA JaVa jaVA hateJaVA  China");
		 * StringBuffer buf = new StringBuffer(); int i = 0; while(m.find()){
		 * ++i; if(i%2 == 0){ m.appendReplacement(buf, "JAVA"); }else{
		 * m.appendReplacement(buf, "java"); } } m.appendTail(buf); r.s(buf);
		 */
		// 123456
		/*Pattern p = Pattern.compile("([a-z]{1,3})(\\d{1,4})");
		String s = new String("as123-wq1234-ds45-df1234");
		Matcher m = p.matcher(s);
		while (m.find()) {
			r.s(m.group());
			r.s(m.group(1));
			r.s(m.group(2));
		}*/
		Pattern p = Pattern.compile(".{3}(?=a)");
		Matcher m = p.matcher("444a66abc");
		while(m.find()){
			r.s(m.group());
		}
	}
	

	public void s(Object o) {
		System.out.println(o);
	}
}