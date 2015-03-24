
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class FIChecker {
           public static void main(String[] args){ 
                   System.out.println("Results of checking:"); 
                   System.out.println(checkWithRegExp("АБС"));
                   System.out.println(checkWithRegExp("Дмитрий Матрохин"));
                   System.out.println(checkWithRegExp("А А"));
                   System.out.println(checkWithRegExp("ДмитрийМатрохин"));
               } 
         
           public static boolean checkWithRegExp(String userNameString){ 
                   Pattern p = Pattern.compile("^[А-Я][а-я]{2,20}[ ][А-Я][а-я]{2,20}$");
                   Matcher m = p.matcher(userNameString); 
                   return m.matches(); 
               }

}
