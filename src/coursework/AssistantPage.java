package coursework;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.lang.*;


import static coursework.MainPage.authorization;

public class AssistantPage {

    public static String assistant_checking() throws IOException {

        String[] words;
        FileReader fr = new FileReader("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assistant's_data.txt");
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
            System.out.println(assistant());}

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
                case "1" -> System.out.println(assistant_checking());
                case "2" -> System.out.println(authorization());
                case "3" -> System.out.println("Goodbye! See you later.");
                default -> System.out.println("" + assistant_checking());
            }
        }
        return "";}

    public static String assistant() throws IOException {

        System.out.print("""
                
                Enter the number of menu
                
                1 - assignments
                2 - complete an assignment
                3 - completed assignments
                4 - procedures
                5 - search
                
                6 - get back to the main page
                7 - shut down the program: \s""");

        Scanner input_number_of_menu = new Scanner(System.in);
        String number_of_menu = input_number_of_menu.nextLine();

        switch (number_of_menu) {

            case "1" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assignments.xlsx";

                FileInputStream fis = new FileInputStream(path);
                XSSFWorkbook xwb = new XSSFWorkbook(fis);
                XSSFSheet sheet = xwb.getSheet("Assignments");
                FormulaEvaluator formulaEvaluator = xwb.getCreationHelper().createFormulaEvaluator();

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

                            case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t\t");
                            case STRING -> System.out.print(cell.getStringCellValue() + "\t\t");
                        }
                    }

                    System.out.println();
                }

                System.out.println(next_step());}

            case "2" -> {

                Scanner input = new Scanner(System.in);

                System.out.print("Assignment: ");
                String assignment = input.nextLine();

                Date date = new Date();

                System.out.print("Your first name and last name: ");
                String name = input.nextLine();

                FileInputStream file = new FileInputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assignments.xlsx");
                XSSFWorkbook xwb = new XSSFWorkbook(file);
                XSSFSheet sheet = xwb.getSheet("Completed Assignments");
                int lastRow = sheet.getLastRowNum();

                Row row = sheet.createRow(++lastRow);
                row.createCell(0).setCellValue(assignment);
                row.createCell(1).setCellValue(String.valueOf(date));
                row.createCell(2).setCellValue(name);
                file.close();

                FileOutputStream output_file =new FileOutputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assignments.xlsx");
                xwb.write(output_file);
                output_file.close();
                System.out.println("""

                        The data has been successfully saved""");
                System.out.println(next_step());}

            case "3" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assignments.xlsx";

                FileInputStream fis = new FileInputStream(path);
                XSSFWorkbook xwb = new XSSFWorkbook(fis);
                XSSFSheet sheet = xwb.getSheet("Completed Assignments");
                FormulaEvaluator formulaEvaluator = xwb.getCreationHelper().createFormulaEvaluator();

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

                            case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t\t");
                            case STRING -> System.out.print(cell.getStringCellValue() + "\t\t");
                        }
                    }
                        System.out.println();
                }

                    System.out.println(next_step());}

            case "4" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\procedures.xlsx";

                FileInputStream fis = new FileInputStream(path);
                XSSFWorkbook xwb = new XSSFWorkbook(fis);

                System.out.print("Patient's first name and last name: ");
                Scanner input = new Scanner(System.in);
                String name = input.nextLine();

                XSSFSheet sheet = xwb.getSheet(name);
                FormulaEvaluator formulaEvaluator = xwb.getCreationHelper().createFormulaEvaluator();

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {

                            case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t\t");
                            case STRING -> System.out.print(cell.getStringCellValue() + "\t\t");
                        }
                    }
                    System.out.println();
                }

                System.out.println(next_step());}

            case "5" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx";

                Scanner input = new Scanner(System.in);

                System.out.print("Patient's first name and last name: ");
                String name = input.nextLine();

                InputStream is = new FileInputStream(path);

                XSSFWorkbook xwb = new XSSFWorkbook(is);
                XSSFSheet sheet = xwb.getSheet("Patients");

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        if (cell.getCellType() == CellType.STRING) {

                            if (cell.getRichStringCellValue().getString().trim().equals(name)) {

                                String message = cell + "'s information is recorded in the database";

                                if (message.length() > 43) {

                                    System.out.println(message);
                                    System.out.print("Do you want to see patient's personal information? (0 - no / 1 - yes): ");
                                    String choose_step = input.nextLine();

                                    if (Objects.equals(choose_step, "1")) {

                                        XSSFSheet personal_sheet = xwb.getSheet(name);

                                        FormulaEvaluator formulaEvaluator = xwb.getCreationHelper().createFormulaEvaluator();

                                        for (Row row2 : personal_sheet) {

                                            for (Cell cell2 : row2) {

                                                switch (formulaEvaluator.evaluateInCell(cell2).getCellType()) {

                                                    case NUMERIC -> System.out.print(cell2.getNumericCellValue() + "\t\t");
                                                    case STRING -> System.out.print(cell2.getStringCellValue() + "\t\t");
                                                }
                                            }
                                            System.out.println();
                                        }
                                    }
                                    else {System.out.println(next_step());}
                                }
                            }
                        }
                    }
                }
                System.out.println(next_step());
            }

            case "6" -> System.out.println(authorization());

            case "7" -> System.out.println("Goodbye! See you later.");

            default -> System.out.println(assistant());}

        return "";}

    public static String next_step() throws IOException {

        System.out.print("""

                        Choose next step
                        
                        1 - get back to the main page
                        2 - get back to the main menu
                        3 - shut down the program: \s""");

        Scanner input_next_move = new Scanner(System.in);
        String next_move = input_next_move.nextLine();

        switch (next_move) {

            case "1" -> System.out.println(authorization());

            case "2" -> System.out.println(assistant());

            case "3" -> System.out.println("Goodbye! See you later");

            default -> System.out.println(assistant() + "");}

        return "";}
}