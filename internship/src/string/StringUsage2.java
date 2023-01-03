package string;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringUsage2 {
    public static void main(String[] args) {
        String filePath = "src/resources/input.txt";
        List<String> text = readFile(filePath);
        display(text);
        String outputFilePath = "src/resources/output.txt";
        String outputFilePathNew = "src/resources/output-new.txt";
        writeStringToNewFile(outputFilePath);
        //write(outputFilePathNew);
    }

    private static void write(String content, String outputFilePath) {
        File file = new File(outputFilePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeStringToNewFile(String outputFilePath) {

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


    private static void display(List<String> text) {
        text.forEach (System.out::println);
    }

}
