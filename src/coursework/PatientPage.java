package coursework;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.*;
import java.lang.*;
import java.io.*;

import static coursework.MainPage.authorization;

public class PatientPage {
    public static String patient_checking() throws IOException {

        String[] words;
        FileReader fr = new FileReader("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patient's_data.txt");
        BufferedReader br = new BufferedReader(fr);
        String s;
        Scanner input = new Scanner(System.in);
        System.out.print("""
                
                Login: \s""");
        String login = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        String data = login + password;
        int count = 0;
        while ((s = br.readLine()) != null) {
            words = s.split(" ");
            for (String word : words) {
                if (word.equals(data)) {
                    count++;}}}

        if (count == 1) {
            System.out.println("""
                    
                    Authorization was successful
                    """);
            System.out.println(patient());}
        else {
            System.out.println("""
                    
                    You have incorrectly entered your username and/or password
                    """);

            System.out.print("""
                    Choose the next move
                    
                    1 - try again
                    
                    2 - get back to the main page
                    3 - shut down the program: \s""");
            Scanner input_next_move_after_fail = new Scanner(System.in);
            String next_move_after_fail = input_next_move_after_fail.nextLine();
            switch (next_move_after_fail) {
                case "1" -> System.out.println(patient_checking());
                case "2" -> System.out.println(authorization());
                case "3" -> System.out.println("Goodbye! See you later.");
                default -> System.out.println("" + patient_checking());
            }
        }
        return "";
    }

    public static String patient() throws IOException {

        System.out.print("""
                Enter the number of menu
                
                1 - doctors' schedule
                2 - last date of illness
                3 - medical history
                4 - personal information
                5 - treatment period
                
                6 - get back to main page
                7 - shut down the program: \s""");
        Scanner input_number_of_menu = new Scanner(System.in);
        String number_of_menu = input_number_of_menu.nextLine();
        switch (number_of_menu) {

            case "1" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctors.xlsx";

                Scanner input = new Scanner(System.in);

                System.out.print("Doctor's first name and last name: ");
                String name = input.nextLine();

                InputStream is = new FileInputStream(path);

                XSSFWorkbook xwb = new XSSFWorkbook(is);
                XSSFSheet sheet = xwb.getSheet("Doctors");

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        if (cell.getCellType() == CellType.STRING) {

                            if (cell.getRichStringCellValue().getString().trim().equals(name)) {

                                String message = cell + "'s schedule";

                                if (message.length() > 13) {

                                    System.out.println(message);

                                                String path2 = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\d_schedule.xlsx";

                                                InputStream is2 = new FileInputStream(path2);

                                                XSSFWorkbook xwb2 = new XSSFWorkbook(is2);
                                                XSSFSheet personal_sheet = xwb2.getSheet(name);

                                                FormulaEvaluator formulaEvaluator = xwb2.getCreationHelper().createFormulaEvaluator();

                                                for (Row row2 : personal_sheet) {

                                                    for (Cell cell2 : row2) {

                                                        switch (formulaEvaluator.evaluateInCell(cell2).getCellType()) {

                                                            case NUMERIC -> System.out.print(cell2.getNumericCellValue() + "\t\t");
                                                            case STRING -> System.out.print(cell2.getStringCellValue() + "\t\t");
                                                        }
                                                    }
                                                    System.out.println();}}

                                    else {System.out.println(next_step());}
                                }
                            }
                        }
                    }
                System.out.println(next_step());}

            case "2" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx";

                Scanner input = new Scanner(System.in);

                System.out.print("Your first name and last name: ");
                String name = input.nextLine();

                InputStream is = new FileInputStream(path);

                XSSFWorkbook xwb = new XSSFWorkbook(is);
                XSSFSheet sheet = xwb.getSheet("Patients");

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        if (cell.getCellType() == CellType.STRING) {

                            if (cell.getRichStringCellValue().getString().trim().equals(name)) {

                                String message = String.valueOf(cell);

                                if (message.length() > 2) {

                                    String path2 = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\medical_histories.xlsx";

                                    InputStream is2 = new FileInputStream(path2);

                                    XSSFWorkbook xwb2 = new XSSFWorkbook(is2);
                                    XSSFSheet personal_sheet = xwb2.getSheet(name);

                                    Row row2 = personal_sheet.getRow(personal_sheet.getLastRowNum());
                                    Cell cell2 = row2.getCell(0);
                                    String value = cell2.getStringCellValue();
                                    System.out.println("The last date of your illness: " + value);}

                                else {
                                    System.out.println("Mr(s) " + name + " your medical history is not in database");
                                    System.out.println(next_step());
                                }
                            }
                        }
                    }
                }
                System.out.println(next_step());
            }

            case "3" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx";

                Scanner input = new Scanner(System.in);

                System.out.print("Your first name and last name: ");
                String name = input.nextLine();

                InputStream is = new FileInputStream(path);

                XSSFWorkbook xwb = new XSSFWorkbook(is);
                XSSFSheet sheet = xwb.getSheet("Patients");

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        if (cell.getCellType() == CellType.STRING) {

                            if (cell.getRichStringCellValue().getString().trim().equals(name)) {

                                String message = String.valueOf(cell);

                                if (message.length() > 2) {

                                                String path2 = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\medical_histories.xlsx";

                                                InputStream is2 = new FileInputStream(path2);

                                                XSSFWorkbook xwb2 = new XSSFWorkbook(is2);
                                                XSSFSheet personal_sheet = xwb2.getSheet(name);

                                                FormulaEvaluator formulaEvaluator = xwb2.getCreationHelper().createFormulaEvaluator();

                                                for (Row row2 : personal_sheet) {

                                                    for (Cell cell2 : row2) {

                                                        switch (formulaEvaluator.evaluateInCell(cell2).getCellType()) {

                                                            case NUMERIC -> System.out.print(cell2.getNumericCellValue() + "\t\t");
                                                            case STRING -> System.out.print(cell2.getStringCellValue() + "\t\t");
                                                        }
                                                    }
                                                    System.out.println();}}

                                else {
                                    System.out.println("Mr(s) " + name + " your medical history is not in database");
                                    System.out.println(next_step());}
                        }
                    }
                }
            }
            System.out.println(next_step());}

            case "4" -> {

            String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx";

            Scanner input = new Scanner(System.in);

            System.out.print("Your first name and last name: ");
            String name = input.nextLine();

            InputStream is = new FileInputStream(path);

            XSSFWorkbook xwb = new XSSFWorkbook(is);
            XSSFSheet sheet = xwb.getSheet("Patients");

            for (Row row : sheet) {

                for (Cell cell : row) {

                    if (cell.getCellType() == CellType.STRING) {

                        if (cell.getRichStringCellValue().getString().trim().equals(name)) {

                            String message = String.valueOf(cell);

                            if (message.length() > 2) {

                                XSSFSheet personal_sheet = xwb.getSheet(name);

                                FormulaEvaluator formulaEvaluator = xwb.getCreationHelper().createFormulaEvaluator();

                                for (Row row2 : personal_sheet) {

                                    for (Cell cell2 : row2) {

                                        switch (formulaEvaluator.evaluateInCell(cell2).getCellType()) {

                                            case NUMERIC -> System.out.print(cell2.getNumericCellValue() + "\t\t");
                                            case STRING -> System.out.print(cell2.getStringCellValue() + "\t\t");
                                        }
                                    }
                                    System.out.println();}}

                            else {
                                System.out.println("Mr(s) " + name + " your personal information is not in database");
                                System.out.println(next_step());}
                        }
                    }
                }
            }
            System.out.println(next_step());
            }

            case "5" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx";

                Scanner input = new Scanner(System.in);

                System.out.print("Your first name and last name: ");
                String name = input.nextLine();

                InputStream is = new FileInputStream(path);

                XSSFWorkbook xwb = new XSSFWorkbook(is);
                XSSFSheet sheet = xwb.getSheet("Patients");

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        if (cell.getCellType() == CellType.STRING) {

                            if (cell.getRichStringCellValue().getString().trim().equals(name)) {

                                String message = String.valueOf(cell);

                                if (message.length() > 2) {

                                    String path2 = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\medical_histories.xlsx";

                                    InputStream is2 = new FileInputStream(path2);

                                    XSSFWorkbook xwb2 = new XSSFWorkbook(is2);

                                    XSSFSheet personal_sheet = xwb2.getSheet(name);

                                    Row row2 = personal_sheet.getRow(personal_sheet.getLastRowNum());
                                    Cell cell2 = row2.getCell(2);
                                    String value = cell2.getStringCellValue();
                                    System.out.println("Your treatment period: " + value);}

                                else {
                                    System.out.println("Mr(s) " + name + " information about your treatment period is not in database");
                                    System.out.println(next_step());
                                }
                            }
                        }
                    }
                }
                System.out.println(next_step());
            }

            case "6" -> System.out.println(authorization());

            case "7" -> System.out.println("Goodbye! See you later.");

            default -> System.out.println(patient());
        }
        return "";
    }

    public static String next_step() throws IOException {

        System.out.print("""
                        
                        Choose next step
                        
                        1 - get back to the main page
                        
                        2 - get back to the main menu
                        
                        3 - shut down the program: \s""");
        Scanner input_next_move = new Scanner(System.in);
        String next_move = input_next_move.nextLine();
        switch (next_move){

            case "1" -> System.out.println(authorization());

            case "2" -> System.out.println(patient());

            case "3" -> System.out.println("Goodbye! See you later");

            default -> System.out.println(patient() + "");
        }

        return "";
    }
}
