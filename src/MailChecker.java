import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailChecker {
    public static void main(String[] args){
        System.out.println("Results of checking:");
        System.out.println(checkWithRegExp("wef@@mail.ru"));
        System.out.println(checkWithRegExp("wef@mail.ruf"));
        System.out.println(checkWithRegExp("example@@yandex..ru"));
        System.out.println(checkWithRegExp("ex123ample@yandexru"));
        System.out.println(checkWithRegExp("ex123ampleyandex..ru"));
    }

    public static String checkWithRegExp(String userMailString){
        Pattern p = Pattern.compile("[a-z\\d]*[@][a-z\\d]*[.][a-z]{2,3}");
        Matcher m = p.matcher(userMailString);
        String resultMail;
        String leftMail="";
        String rightBefPoi="";
        String rightAftPoi="";
        if(m.matches())
        {
            resultMail=userMailString;
        }
        else {
            Pattern pl = Pattern.compile("^([a-z\\d]*[@])");
            Matcher ml = pl.matcher(userMailString);
            if(ml.find())
            {
                leftMail+=ml.group();
            }


            Pattern prb = Pattern.compile("[@]([a-z\\d]*)[.]*[a-z\\d]{2,3}$");
            Matcher mrb = prb.matcher(userMailString);
            if(mrb.find())
            {
                rightBefPoi+=mrb.group(1);
            }


            Pattern pra = Pattern.compile("([.][a-z\\d]{2,3}$)");
            Matcher mra = pra.matcher(userMailString);
            if(mra.find())
            {
                rightAftPoi+=mra.group();
            }
            if(rightAftPoi.equals("") || rightBefPoi.equals("") || leftMail.equals(""))
            {resultMail="";}
            else
            {resultMail=leftMail+rightBefPoi+rightAftPoi;}

        }
        System.out.print(userMailString+" - ");
        return resultMail;
    }
}
