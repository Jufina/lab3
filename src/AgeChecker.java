import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgeChecker {
    public static void main(String[] args){
        System.out.println("Results of checking:");
        System.out.println(checkWithRegExp("27"));
        System.out.println(checkWithRegExp("245"));
        System.out.println(checkWithRegExp("q2w7y"));
        System.out.println(checkWithRegExp("q27y"));
        System.out.println(checkWithRegExp("2 7"));
        System.out.println(checkWithRegExp("q 2 7"));
        System.out.println(checkWithRegExp("-25"));
    }

    public static String checkWithRegExp(String userAgeString){
        Pattern p = Pattern.compile("(\\d)");
        Matcher m = p.matcher(userAgeString);
        String resultAge="";
        while(m.find()) {
                    resultAge+=m.group();
                }
                if(resultAge.length() >2)
                {resultAge="";}
        System.out.print(userAgeString+" - ");
        return resultAge;
    }
}
