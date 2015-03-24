
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FIChecker {
           public static void main(String[] args){ 
               System.out.println("Results of checking:");
               System.out.println(checkWithRegExp("АБС"));
               System.out.println(checkWithRegExp("дмитрийМАтрохин"));
               System.out.println(checkWithRegExp("дмитрийМатрохиН"));
               System.out.println(checkWithRegExp("А А"));
               System.out.println(checkWithRegExp("ЮлияКотеева"));
               System.out.println(checkWithRegExp("юЛия моТеева"));
               System.out.println(checkWithRegExp("юлиямотеевА"));
               } 
         
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
                           aName = aName.toLowerCase();
                           aName = aName.substring(0, 1).toUpperCase() + aName.substring(1);
                       }
                       String cutName;
                       cutName=userNameString.substring(aName.length());
                       Pattern pb = Pattern.compile("^([А-Я][а-я]{1,19}[А-Яа-я])$");
                       Matcher mb = pb.matcher(cutName);
                       while (mb.find()) {
                           bName += mb.group();
                           bName = bName.toLowerCase();
                           bName = bName.substring(0, 1).toUpperCase() + bName.substring(1);
                       }
                       if(!bName.equals(""))
                       {resultName=aName+" "+bName;}

                   }
                   else {
                       Pattern p3 = Pattern.compile("([А-Яа-я]{3,21})");
                       Matcher m3 = p3.matcher(userNameString);
                       while (m3.find()) {
                           String PartName = "";
                           PartName += m3.group();
                           PartName = PartName.toLowerCase();
                           PartName = PartName.substring(0, 1).toUpperCase() + PartName.substring(1);
                           resultName += PartName+" ";
                       }
                   }
               }
               else {
                   resultName=userNameString;
               }
               System.out.print(userNameString+" - ");
               return resultName;
               //return m.matches();
               }

}
