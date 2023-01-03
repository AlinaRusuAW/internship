package collections;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionsUsage {
    public static void main(String[] args) throws Exception {
        String filePath = "src/resources/employee-input.txt";
        List<String> employee = readFile (filePath);
        HashSet<String> employeeSet = extra (filePath);
        display(employeeSet);
        display1 (employee);
        sort(employee);
        Map<String, Integer> dateMap = readFile1(filePath);
        String outputFilePath = "src/resources/employee-final.txt";
        write(dateMap, outputFilePath);
    }

    private static Map<String, Integer> readFile1(String filePath) throws Exception {
        Map<String, Integer> lines = new HashMap<> ();
        File file = new File (filePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (file);
        } catch (FileNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        Scanner scanner = new Scanner (fileInputStream);
        while (scanner.hasNext ()) {
            String line = scanner.nextLine ();
            String[] lineSplit = line.split ("\\|");
            String nume = lineSplit[0];
            String prenume = lineSplit[1];
            String dat = lineSplit[2];
           // Date d = new SimpleDateFormat("dd/mm/yyyy").parse(dat);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            LocalDate d1 = LocalDate.parse (formatter.format (dat));
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(d1, LocalDate.parse (formatter.format (currentDate))).getYears();
            lines.put (nume, age);
        }
        return lines;
    }

    private static void write(Map<String, Integer> dateMap, String outputFilePath) {
        File file = new File (outputFilePath);
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter (new FileWriter (file));
            for(Map.Entry<String, Integer> entry : dateMap.entrySet()){
                bw.write( entry.getKey() + "|" + entry.getValue() );
                bw.newLine();
            }
            bw.flush ();
        }catch (IOException ex){
            ex.printStackTrace ();
        } finally {
            try{bw.close ();
            }catch (Exception ex){}}
    }

    private static HashSet<String> extra(String filePath) {
        HashSet<String> name = new HashSet<> ();
        File file = new File (filePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (file);
        } catch (FileNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        Scanner scanner = new Scanner (fileInputStream);
        while (scanner.hasNext ()) {
            String line = scanner.nextLine ();
            String[] lineSplit = line.split ("\\|");
            String nume = lineSplit[1];
            name.add (nume);
        }
        return name;
    }
    private static void display(HashSet<String> employeeSet) {
        employeeSet.forEach (System.out::println);
        System.out.println("------------------------");
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

        private static void display1(List<String> employee) {
            employee.forEach (System.out::println);
            System.out.println("------------------------");
        }

        private static void sort(List<String> employee){
            List<String> sortEmployee = employee.stream ().sorted ().collect(Collectors.toList());
            sortEmployee.forEach (System.out::println);
            System.out.println("------------------------");
        }

}