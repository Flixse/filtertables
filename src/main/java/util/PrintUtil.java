package util;

public class PrintUtil {
    public static void printBeginningLines(){
        System.out.println("Please be sure that your table is correct");
        System.out.println("the tableToBeFiltered.csv can contain column names, be sure that these are unique");
        System.out.println("If it doesn't contain column names, you will be prompted to give the number of the column");
        System.out.println("the tableToBeFiltered.csv file should contain your list that you want to filter");
        System.out.println("the filterValues.csv file should contain the ids you want to remove from the tableToBeFiltered.csv");
        System.out.println("the filterValues.csv file should NOT contain any column name");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Input is needed in next steps");
    }

    public static void printEndingAfterErrorLines(){
        System.out.println("Closing application");
        System.out.println("Please make sure your table is correct");
    }
}
