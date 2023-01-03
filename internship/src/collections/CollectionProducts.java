package collections;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CollectionProducts {
    public static void main(String[] args) {
        String filePath = "src/resources/products-input.txt";
        Map<Integer, String> productsMap = readFile (filePath);
        display (productsMap);
        String outputFilePath = "src/resources/products-output.txt";
        write(productsMap, outputFilePath);
    }

    private static void write(Map<Integer, String> productsMap, String outputFilePath) {
        File file = new File (outputFilePath);
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter (new FileWriter (file));
            for(Map.Entry<Integer, String> entry : productsMap.entrySet()){
                bw.write( entry.getKey() + "|" + entry.getValue() );
                bw.newLine();
            }
            bw.flush ();
        }catch (IOException ex){
            ex.printStackTrace ();
        } finally {
            try{bw.close ();
        }catch (Exception ex){}}}

    private static void display(Map<Integer, String> productsMap) {
        productsMap.keySet().forEach(key-> System.out.println(key + " = " + productsMap.get(key)));
    }

    private static Map<Integer, String> readFile(String filePath) {
            Map<Integer, String> lines = new HashMap<> ();
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
                String[] lineSplit = line.split("\\|");
                Integer cod = Integer.parseInt(lineSplit[0]);
                String productName = lineSplit[1];
                lines.put(cod, productName);
                lines.put(6,"portocale");
                lines.put(7,"suc");
                lines.put(8,"cadouri");
                lines.put(9,"globuri");
                lines.put(10,"iepurasi");
                lines.put(10,"fructe");
            }
            return lines;
        }
}