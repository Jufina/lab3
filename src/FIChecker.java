
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIChecker {
      public static String checkWithRegExp(String userNameString){
                   Pattern p = Pattern.compile("^[А-Я][а-я]{2,20}[ ][А-Я][а-я]{2,20}$");
                   Matcher m = p.matcher(userNameString);
               String resultName="";

               if(!m.matches()) {
                   Pattern ppro = Pattern.compile("^[А-Яа-я]{2,20}[ ][А-Яа-я]{2,20}$");
                   Matcher mpro = ppro.matcher(userNameString);
                   if(!mpro.matches()) {
                       String aName="", bName="";
                       Pattern pa = Pattern.compile("^([А-Яа-я][а-я]{2,20})");
                       Matcher ma = pa.matcher(userNameString);
                       while (ma.find()) {
                           aName += ma.group();
                           aName = aName.toLowerCase(Locale.getDefault());
                           aName = aName.substring(0, 1).toUpperCase(Locale.getDefault()) + aName.substring(1);
                       }
                       String cutName;
                       cutName=userNameString.substring(aName.length());
                       Pattern pb = Pattern.compile("^([А-Я][а-я]{1,19}[А-Яа-я])$");
                       Matcher mb = pb.matcher(cutName);
                       while (mb.find()) {
                           bName += mb.group();
                           bName = bName.toLowerCase(Locale.getDefault());
                           bName = bName.substring(0, 1).toUpperCase(Locale.getDefault()) + bName.substring(1);
                       }
                       if(!bName.equals(""))
                       {resultName=aName+" "+bName;}

                   }
                   else {
                       Pattern p3 = Pattern.compile("([А-Яа-я]{3,21})");
                       Matcher m3 = p3.matcher(userNameString);
                       StringBuffer bufRes = new StringBuffer();

                       while (m3.find()) {
                           StringBuffer bufPart = new StringBuffer();
                           String PartName = "";
                           bufPart.append(m3.group());
                           PartName=bufPart.toString();
                           PartName = PartName.toLowerCase(Locale.getDefault());
                           PartName = PartName.substring(0, 1).toUpperCase(Locale.getDefault()) + PartName.substring(1);
                           bufRes.append(PartName);
                           bufRes.append(" ");
                       }
                       resultName = bufRes.toString();
                   }
               }
               else {
                   resultName=userNameString;
               }

               return resultName;

               }

}
