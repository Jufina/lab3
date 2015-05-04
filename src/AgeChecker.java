import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgeChecker {

    public static String checkWithRegExp(String userAgeString) {
        Pattern p = Pattern.compile("(\\d)");
        Matcher m = p.matcher(userAgeString);
        String resultAge;
        StringBuffer buf = new StringBuffer("");
        while (m.find()) {
            buf.append(m.group());
        }
        resultAge = buf.toString();
        if (resultAge.length() > 2) {
            resultAge = "";
        }
        return resultAge;
    }
}
