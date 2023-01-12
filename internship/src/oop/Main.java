package oop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String file = "src/resources/employee.txt";
        List<String> employee = readFileEmploye(file);
        displayEmployee(employee);
        HashSet<String> employeeSet1 = sortEmployee(file);
        displaySortEmployee(employeeSet1);
        List<Integer> sum = sumSalariu(file);
        displaySum(sum);
        Map<Integer, String> upSalariu = upd(file);
        displaySalariu(upSalariu);
    }

    private static void displaySalariu(Map<Integer, String> upSalariu) {
        upSalariu.keySet().forEach(key-> System.out.println(key + " = " + upSalariu.get(key)));
    }

    private static Map<Integer, String> upd(String file) {
        Map<Integer, String> lines = new HashMap<> ();
        File file1 = new File (file);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (file1);
        } catch (FileNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        Scanner scanner = new Scanner (fileInputStream);
        while (scanner.hasNext ()) {
            String line = scanner.nextLine();
            String[] lineSplit = line.split("\\|");
            Integer cod = Integer.parseInt(lineSplit[0]);
            String salariu = lineSplit[4];
            lines.put(cod, salariu);
            lines.put(1,"1000");
        }
        return lines;

    }

    private static void displaySum(List<Integer> mapSum) {
        int sum = mapSum.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        System.out.println("------------------------");
    }

    private static List<Integer> sumSalariu(String file){
        List<Integer> lines = new ArrayList<>();
        File file1 = new File(file);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineSplit = line.split("\\|");
            Integer salariu = Integer.parseInt(lineSplit[4]);
            lines.add(salariu);
        }
        return lines;
    }
    private static void displaySortEmployee(HashSet<String> employeeSet1) {
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(employeeSet1);
        myTreeSet.forEach(System.out::println);
        System.out.println("------------------------");
    }

    private static HashSet<String> sortEmployee(String file) {
        HashSet<String> hashSet = new HashSet<> ();
        File file1 = new File (file);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (file1);
        } catch (FileNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        Scanner scanner = new Scanner (fileInputStream);
        while (scanner.hasNext ()) {
            String line = scanner.nextLine ();
            String[] lineSplit = line.split ("\\|");
            String nume = lineSplit[2];
            hashSet.add(nume);
        }
        return hashSet;
    }

    private static void displayEmployee(List<String> employee) {
        employee.forEach (System.out::println);
        System.out.println("......................");
    }

    private static List<String> readFileEmploye(String file) {
        List<String> lines = new ArrayList<>();
        File file1 = new File (file);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream (file1);
        } catch (FileNotFoundException e) {
            System.out.println (e.getMessage ());
        }
        Scanner scanner = new Scanner (fileInputStream);
        while (scanner.hasNext ()) {
            lines.add (scanner.nextLine ());
        }
        return lines;
    }
}
