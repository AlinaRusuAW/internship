package string;

import java.util.Arrays;
import java.util.Comparator;

public class StringUsage {
    public static void main(String[] args) {
        String a = "Java intrenship";
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
    }
}
