package operators;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner x = new Scanner (System.in);
        System.out.println("Introduceti numarul a: ");
        Integer a = x.nextInt ();
        Scanner y = new Scanner (System.in);
        System.out.println("Introduceti numarul b: ");
        Integer b = y.nextInt ();
        System.out.println (a+b);
        System.out.println (a-b);
        System.out.println (a*b);
        System.out.println (a/b);
        System.out.println (a^b);
    }
}
