package collections;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CollectionsUsage {
    public static void main(String[] args) {
        String filePath ="src/resources/employee-input.txt";
        List<String> employee = readFile (filePath);
        display(employee);
        sort(employee);
        extra(employee);
    }

    private static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<> ();
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

        private static void display(List<String> employee) {
            employee.forEach (System.out::println);
            System.out.println("------------------------");
        }

        private static void sort(List<String> employee){
            List<String> sortEmployee = employee.stream ().sorted ().collect(Collectors.toList());
            sortEmployee.forEach (System.out::println);
            System.out.println("------------------------");
        }

        private static void extra(List<String> employee){
            System.out.println (employee.contains ("Alina"));
            System.out.println("------------------------");
        }



       /* ArrayList<String> arrayList = new ArrayList<String> ();
        Scanner scanner = new Scanner ("src/resources/employee-input.txt");
        while (scanner.hasNextLine ()) {
            arrayList.add (scanner.nextLine ());
        }
        scanner.close ();*/


   /*     ArrayList<String> arrayList = new ArrayList<String> ();
        try(BufferedReader bufferedReader = new BufferedReader (new FileReader ("src/resources/employee-input.txt"))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                arrayList.add(line);
                System.out.println (line);
            }
        } catch (IOException e){
            e.printStackTrace ();
        }*/

       /* try{
            FileInputStream file = new FileInputStream ("C:/Users/Lenovo/IdeaProjects/internship/src/resources/employee-input.txt");
            int a = 0;
            while ((a = file.read ()) != 0){
                System.out.println ((char) a);
            }
            file.close ();
        } catch (Exception e){
            System.out.println (e);
        } // se citeste cite un singur caracter in rind
*/

}

