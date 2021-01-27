package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {

    public static List<String[]> readData(String fileName) throws IOException {
        List<String[]> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return content;
    }

    public List<String[]> readDataSingleColumn(String fileName, String columnName) throws IOException {
        List<String[]> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return content;
    }

    public static String[] readFirstColumnLine(List<String[]> list) {
        return list.get(0);
    }

    public static void writeDataFromListOfStrings(List<String> data) throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/filterValues.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        data.forEach(e -> {
            try {
                bufferedWriter.write(e);
                bufferedWriter.newLine();
            } catch (IOException ioE) {
                System.out.println(ioE.getMessage());
            }
        });
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void writeDataFromListOfArrayOfStrings(List<String[]> data) throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/tableFiltered.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        data.forEach(e -> {
            try {
                int length = e.length;
                for (int i = 0; i < length - 1; i++) {
                    bufferedWriter.write(e[i]);
                    bufferedWriter.write(",");
                }

                bufferedWriter.write(e[length - 1]);
                bufferedWriter.newLine();
            } catch (IOException ioE) {
                System.out.println(ioE.getMessage());
            }
        });
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<String> filterListByPlaceOfStringArray(int place, List<String[]> stringArrayList) {
        return stringArrayList.stream()
                .map(s -> s[place])
                .collect(Collectors.toList());
    }
}
