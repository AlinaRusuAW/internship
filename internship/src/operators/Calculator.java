package operators;

import java.util.Scanner;
import static java.lang.Math.pow;

public class Calculator {
    public static void main(String[] args){
                char operator;
                Double a, b, c;
                Scanner input = new Scanner(System.in);
                System.out.println("Alegeti operatorul: +, -, *, /, ^ ");
                operator = input.next().charAt(0);
                System.out.println("Introduceti numarul a: ");
                a = input.nextDouble ();
                System.out.println("Introduceti numarul b: ");
                b = input.nextDouble ();
                switch (operator) {
                    case '+':
                        c = a + b;
                        System.out.println(a + " + " + b + " = " + c);
                        break;
                    case '-':
                        c = a - b;
                        System.out.println(a + " - " + b + " = " + c);
                        break;
                    case '*':
                        c = a * b;
                        System.out.println(a + " * " + b + " = " + c);
                        break;
                    case '/':
                        c = a / b;
                        System.out.println(a + " / " + b + " = " + c);
                        break;
                    case '^':
                        c = pow (a,b);
                        System.out.println(a + " ^ " + b + " = " + c);
                        break;
                    default:
                        System.out.println("Operator nevalid!");
                        break;
                }
            }
}