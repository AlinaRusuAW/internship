package hello;

import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        Scanner n = new Scanner (System.in);
        System.out.println("Introduceti numele dvs: ");
        String name = n.nextLine ();
        System.out.println("Hello " + name + "!");
    }
}
