import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            inputStream=new FileInputStream("input.txt");
            outputStream=new FileOutputStream("output.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"UTF8"));
            //PrintWriter out = new PrintWriter(outputStream);
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF8"));
            while(reader.ready()) {
                StringBuffer textBuffer=new StringBuffer();
                textBuffer.append(reader.readLine());
                StringTokenizer tokenizer=new StringTokenizer(textBuffer.toString(), "|");

                if (!tokenizer.hasMoreTokens()) continue;
                String str = tokenizer.nextToken();
                str=FIChecker.checkWithRegExp(str);
                out.write(str+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.write(AgeChecker.checkWithRegExp(str)+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.write(PhoneChecker.checkWithRegExp(str)+" ");
                if (!tokenizer.hasMoreTokens()) continue;
                str = tokenizer.nextToken();
                out.write(MailChecker.checkWithRegExp(str));
                out.write("\n");

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
