import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            inputStream=new FileInputStream("input.txt");
            outputStream=new FileOutputStream("output.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter out = new PrintWriter(outputStream);

            while(reader.ready()) {
                StringBuffer textBuffer=new StringBuffer();
                textBuffer.append(reader.readLine());
                StringTokenizer tokenizer=new StringTokenizer(textBuffer.toString(), "|");

                if (!tokenizer.hasMoreTokens()) continue;
                String str = tokenizer.nextToken();
                str=FIChecker.checkWithRegExp(str);
                out.print(str+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.print(AgeChecker.checkWithRegExp(str)+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.print(PhoneChecker.checkWithRegExp(str)+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.println(MailChecker.checkWithRegExp(str));

            }
            out.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
}
