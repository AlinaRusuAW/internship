package string;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StringUsage {
    public static void main(String[] args) {
        String filePath = "src/resources/input.txt";
        List<String> text = readFile(filePath);
//        displayString(text);
        metoda2(text);
        metoda3(text);
        metoda4(text);
        metoda5(text);
        metoda6(text);
        metoda7(text);
        metoda8(text);
       // metoda9(text);
        String outFile = "src/resources/output.txt";
        write(text, outFile);
    }

   /* private static String metoda9(List<String> text) {
        Set<String> set = new HashSet<>();
        for(String i : text){
            if(Collections.frequency(text, i) > 1){
                set.add(i);
            }
        }
        System.out.println(set);
        return set.toString();
    }*/

    private static String metoda8(List<String> text) {
        String max = Arrays.stream (text.toString().split (" ")).max (Comparator.comparingInt (String::length)).orElse (null);
        return max;
    }

    private static String metoda7(List<String> text) {
        String min = Arrays.stream (text.toString().split (" ")).min (Comparator.comparingInt (String::length)).orElse (null);
        return min;
    }

    private static String metoda6(List<String> text) {
        int count = 0;
        if (text.toString().length () != 0) {
            count++;
            for (int i = 0; i < text.toString().length (); i++) {
                if (text.toString().charAt (i) == ' ') {
                    count++;
                }
            }
        }
        String a = "Fraza contine " + count + " cuvinte.";
        return a;
    }

    private static String metoda5(List<String> text) {
        String vowels = "AaEeIiOoUu";
        int cons = 0;
        int vows = 0;
        for (char c : text.toString().toCharArray ()) {
            if (c == ' ') {
                continue;
            }
            if (vowels.indexOf (c) != - 1) {
                vows++;
            } else {
                cons++;
            }
        }
        String a = "Avem " + vows + " vocale si " + cons + " consoane.";
        return a;
    }

    private static String metoda4(List<String> text) {
        String a = String.valueOf(text.toString().length());
       // System.out.println ("Lungimea frazei este: " + a);
        return a;
    }

    private static String metoda3(List<String> text) {
        String a = text.toString().toUpperCase();
        return a;
    }

    private static String metoda2(List<String> text) {
        String a = text.toString().toLowerCase();
        return a;
    }

    private static String displayString(List<String> text) {
        String a = text.toString();
        return a;
    }

    private static void write(List<String> text, String outFile) {
        File file = new File (outFile);
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter (new FileWriter(file));
            bw.write(displayString(text));
            bw.newLine();
            bw.write(metoda2(text));
            bw.newLine();
            bw.write(metoda3(text));
            bw.newLine();
            bw.write("Lungimea frazei este: " + metoda4(text));
            bw.newLine();
            bw.write(metoda5(text));
            bw.newLine();
            bw.write(metoda6(text));
            bw.newLine();
            bw.write("Cel mai scurt cuvint este: " + metoda7(text));
            bw.newLine();
            bw.write("Cel mai lung cuvint este: " + metoda8(text));
            bw.newLine();
         //   bw.write(metoda9(text));
        }catch (IOException ex){
            ex.printStackTrace ();
        } finally {
            try{bw.close ();
            }catch (Exception ex){}}
    }
    private static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        File file = new File (filePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (file);
        } catch (FileNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        Scanner scanner = new Scanner (fileInputStream);
        while (scanner.hasNext ()) {
            lines.add (scanner.nextLine ());
        }
        return lines;
    }
       /* String a = "Java intrenship";
        // String b = a.toUpperCase();
        System.out.println (a.toUpperCase ());
        // String c = a.toLowerCase ();
        System.out.println (a.toLowerCase ());
        System.out.println ("Lungimea frazei este: " + a.length ());

        String vowels = "AaEeIiOoUu";
        int cons = 0;
        int vows = 0;
        for (char c : a.toCharArray ()) {
            if (c == ' ') {
                continue;
            }
            if (vowels.indexOf (c) != - 1) {
                vows++;
            } else {
                cons++;
            }
        }
        System.out.println ("Avem " + vows + " vocale si " + cons + " consoane.");

        int count = 0;
        if (a.length () != 0) {
            count++;
            for (int i = 0; i < a.length (); i++) {
                if (a.charAt (i) == ' ') {
                    count++;
                }
            }
        }
        System.out.println ("Fraza contine " + count + " cuvinte.");

        String min = Arrays.stream (a.split (" ")).min (Comparator.comparingInt (String::length)).orElse (null);
        System.out.println (min);

        String max = Arrays.stream (a.split (" ")).max (Comparator.comparingInt (String::length)).orElse (null);
        System.out.println (max);
    }*/
}