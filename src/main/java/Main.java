import org.apache.commons.lang3.StringUtils;
import util.ListUtil;
import util.PrintUtil;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintUtil.printBeginningLines();
        boolean closeApplication = false;
        Scanner input = new Scanner(System.in);
        boolean mainListContainsColumns = false;
        int position = -1;
        while(true){
            System.out.println("Does your list contain column names? (yes/no)");
            String input1 = input.nextLine();
            if(StringUtils.equalsIgnoreCase(input1, "yes")){
                mainListContainsColumns = true;
                break;
            } else if (StringUtils.equalsIgnoreCase(input1, "no")) {
                System.out.println("Please fill in the number of the column that you want to filter");
                System.out.println("Example : the first column will be column '1'");
                String input2 = input.nextLine();
                position = Integer.parseInt(input2);
                System.out.println("The table will be filtered on column " + position);
                position--;
                break;
            }
            System.out.println("Please type 'yes' or 'no'");
        }
        List<String[]> mainTable = ListUtil.readData("src/main/resources/tableToBeFiltered.csv");
        if(mainListContainsColumns){
            System.out.println("On what column do you want to filter?");
            String[] columns =  ListUtil.readFirstColumnLine(mainTable);
            System.out.println("pick on of next columns : " + Arrays.toString(columns));
            while(true) {
                boolean inputFound = false;
                String input2 = input.nextLine();
                for(int i = 0; i < columns.length; i ++){
                    if(StringUtils.equalsIgnoreCase(columns[i], input2)){
                        if(inputFound){
                            //Input already found, close the program and use correct data
                            closeApplication = true;
                            inputFound = false;
                            System.out.println("Column name found multiple times, please be sure to import correct data.");
                            break;
                        }else {
                            position = i;
                            inputFound = true;
                        }
                    }
                }

                if(!inputFound && !closeApplication){
                    System.out.println("please retype the column name");
                    System.out.println("pick on of next columns : " + Arrays.toString(columns));
                } else if (inputFound) {
                    System.out.println("The list will be filtered on column with name '" + columns[position] + "'");
                    break;
                } else {
                    break;
                }
            }
        }

        if(!closeApplication){
            List<String[]> toBeRemovedList = ListUtil.readData("src/main/resources/filterValues.csv");
            List<String> toBeRemovedListFiltered = ListUtil.filterListByPlaceOfStringArray(0, toBeRemovedList);
            final int finalPosition = position;
            List<String[]> filteredList = mainTable.stream()
                    .filter(l -> !toBeRemovedListFiltered.contains(l[finalPosition]))
                    .collect(Collectors.toList());
            ListUtil.writeDataFromListOfArrayOfStrings(filteredList);
        }else{
            PrintUtil.printEndingAfterErrorLines();
        }

    }

}
