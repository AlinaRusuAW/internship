package string;

import java.io.*;

public class Exemple {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            File file = new File ("text.txt");
//            if (! file.exists ())
//                File.createTempFile ();
            PrintWriter printWriter = new PrintWriter (file);
            printWriter.println ("text");
            printWriter.println ("text2");
            printWriter.println ("text3");
            printWriter.close ();

            bufferedReader = new BufferedReader (new FileReader ("text.txt"));
            String line;
            while ((line = bufferedReader.readLine ()) != null){
                System.out.println (line);
            }
        } catch (IOException e) {
            System.out.println ("Error: " + e);
        } finally {
            try{
            bufferedReader.close ();
            }catch (IOException e) {
                    System.out.println ("Error: " + e);
                }
            }
    }
}
