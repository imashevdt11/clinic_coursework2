package coursework;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static coursework.MainPage.authorization;

public class DoctorPage {

    public static String doctor_checking() throws IOException {

        String[] words;
        FileReader fr = new FileReader("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctor's_data.txt");
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
            System.out.print("""

                    Authorization was successful
                    """);
            System.out.println(doctor());}

        else {
            System.out.println("""

                    You have incorrectly entered your username and/or password, please repeat.
                    """);

            System.out.print("""
                    Choose the next move

                    1 - try again

                    2 - get back to the main page
                    3 - shut down the program: \s""");
            Scanner input_next_move_after_fail = new Scanner(System.in);
            String next_move_after_fail = input_next_move_after_fail.nextLine();
            switch (next_move_after_fail) {
                case "1" -> System.out.println(doctor_checking());
                case "2" -> System.out.println(authorization());
                case "3" -> System.out.println("Goodbye! See you later.");
                default -> System.out.println("" + doctor_checking());
            }
        }
        return "";
    }

    public static String doctor() throws IOException {

        System.out.print("""

                Enter the number of menu

                1 - add
                2 - assignments
                3 - completed assignments
                4 - delete
                5 - give an assignment
                6 - patients
                7 - search

                8 - get back to the main page
                9 - shut down the program: \s""");

        Scanner input_the_number_of_menu = new Scanner(System.in);
        String number_of_menu = input_the_number_of_menu.nextLine();

        switch (number_of_menu) {

            case "1" -> {

                Scanner input = new Scanner(System.in);

                System.out.print("Patient's first name: ");
                String first_name = input.nextLine();

                System.out.print("Patient's last name: ");
                String last_name = input.nextLine();

                System.out.print("Patient's date of birth (day.month.year): ");
                String date_of_birth = input.nextLine();

                System.out.print("Patient's weight: ");
                String weight = input.nextLine();

                System.out.print("Patient's height: ");
                String height = input.nextLine();

                System.out.print("Patient's blood type: ");
                String blood_type = input.nextLine();

                System.out.print("Diagnosis: ");
                String diagnosis = input.nextLine();

                System.out.print("Treatment period: ");
                String treatment = input.nextLine();

                System.out.print("Treatment Instruction: ");
                String instruction = input.nextLine();

                Scanner input2 = new Scanner(System.in);
                System.out.print("Procedure: ");
                String procedure = input2.nextLine();

                System.out.print("Timeline of procedure: ");
                String timeline = input2.nextLine();

                String txt_path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patient's_data.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(txt_path, true));
                bw.write("\n" + first_name + last_name);
                bw.close();

                FileInputStream file = new FileInputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx");

                XSSFWorkbook xwb = new XSSFWorkbook(file);

//      first
                XSSFSheet sheet = xwb.getSheet("Patients");
                int lastRow1 = sheet.getLastRowNum();

                Row row = sheet.createRow(++lastRow1);
                row.createCell(0).setCellValue(first_name + " " + last_name);

//      second
                xwb.createSheet(first_name + " " + last_name);
                XSSFSheet sheet2 = xwb.getSheet(first_name + " " + last_name);

                Row row2_1 = sheet2.createRow(0);
                row2_1.createCell(0).setCellValue("Name");
                row2_1.createCell(1).setCellValue("Date of Birth");
                row2_1.createCell(2).setCellValue("Weight");
                row2_1.createCell(3).setCellValue("Height");
                row2_1.createCell(4).setCellValue("Blood Type");
                row2_1.createCell(5).setCellValue("Date of admission");

                Date date = new Date();
                Row row2_2 = sheet2.createRow(1);
                row2_2.createCell(0).setCellValue(first_name + " " + last_name);
                row2_2.createCell(1).setCellValue(date_of_birth);
                row2_2.createCell(2).setCellValue(weight);
                row2_2.createCell(3).setCellValue(height);
                row2_2.createCell(4).setCellValue(blood_type);
                row2_2.createCell(5).setCellValue(String.valueOf(date));
                file.close();

//      third
                FileInputStream file3 = new FileInputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\medical_histories.xlsx");

                XSSFWorkbook xwb3 = new XSSFWorkbook(file3);

                xwb3.createSheet(first_name + " " + last_name);
                XSSFSheet sheet3 = xwb3.getSheet(first_name + " " + last_name);

                Row row3_1 = sheet3.createRow(0);
                row3_1.createCell(0).setCellValue("The recording is done:");
                row3_1.createCell(1).setCellValue("Diagnosis");
                row3_1.createCell(2).setCellValue("Treatment Period");
                row3_1.createCell(3).setCellValue("Treatment Instruction");


                Date date3 = new Date();
                Row row3_2 = sheet3.createRow(1);
                row3_2.createCell(0).setCellValue(String.valueOf(date3));
                row3_2.createCell(1).setCellValue(diagnosis);
                row3_2.createCell(2).setCellValue(treatment);
                row3_2.createCell(3).setCellValue(instruction);
                file3.close();

//      fourth
                FileInputStream file4 = new FileInputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\procedures.xlsx");

                XSSFWorkbook xwb4 = new XSSFWorkbook(file4);

                xwb4.createSheet(first_name + " " + last_name);
                XSSFSheet sheet4 = xwb4.getSheet(first_name + " " + last_name);

                Row row4_1 = sheet4.createRow(0);
                row4_1.createCell(0).setCellValue("Procedure");
                row4_1.createCell(1).setCellValue("Timeline");

                Row row4_2 = sheet4.createRow(1);
                row4_2.createCell(0).setCellValue(procedure);
                row4_2.createCell(1).setCellValue(timeline);
                file4.close();

                FileOutputStream output_file = new FileOutputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx");
                xwb.write(output_file);
                output_file.close();

                FileOutputStream output_file3 = new FileOutputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\medical_histories.xlsx");
                xwb3.write(output_file3);
                output_file3.close();

                FileOutputStream output_file4 = new FileOutputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\procedures.xlsx");
                xwb4.write(output_file4);
                output_file4.close();

                System.out.println("""

                        The data has been successfully saved""");
                System.out.println(next_step());}

            case "2" -> {

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

                System.out.println(next_step());
            }

            case "4" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx";

                Scanner input = new Scanner(System.in);

                System.out.print("Patient's first name: ");
                String name = input.nextLine();

                System.out.print("Patient's last name: ");
                String last_name = input.nextLine();

                File file = new File("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patient's_data.txt");

                File temp = File.createTempFile("patient's_data", ".txt", file.getParentFile());

                String charset = "UTF-8";

                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));

                PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));

                for (String line; (line = reader.readLine()) != null;) {

                    line = line.replace(name + last_name, "");
                    writer.println(line);
                }
                reader.close();
                writer.close();

                file.delete();

                temp.renameTo(file);

                FileInputStream fis = new FileInputStream(path);
                XSSFWorkbook xwb = new XSSFWorkbook(fis);
                XSSFSheet sheet = xwb.getSheet("Patients");

                for (Row row : sheet) {

                    for (Cell cell : row) {

                        if (cell.getCellType() == CellType.STRING) {

                            if (cell.getRichStringCellValue().getString().trim().equals(name + " " + last_name)) {

                                sheet.removeRow(cell.getRow());
                            }
                        }
                    }
                }
                xwb.removeSheetAt(xwb.getSheetIndex(name + " " + last_name));

                FileOutputStream fos = new FileOutputStream(path);
                xwb.write(fos);
                fos.close();

                String path2 = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\medical_histories.xlsx";

                FileInputStream fis2 = new FileInputStream(path2);
                XSSFWorkbook xwb2 = new XSSFWorkbook(fis2);

                xwb2.removeSheetAt(xwb2.getSheetIndex(name + " " + last_name));

                FileOutputStream fos2 = new FileOutputStream(path2);
                xwb2.write(fos2);
                fos2.close();

                String path3 = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\procedures.xlsx";

                FileInputStream fis3 = new FileInputStream(path3);
                XSSFWorkbook xwb3 = new XSSFWorkbook(fis3);

                xwb3.removeSheetAt(xwb3.getSheetIndex(name + " " + last_name));

                FileOutputStream fos3 = new FileOutputStream(path3);
                xwb3.write(fos3);
                fos3.close();

                System.out.println(next_step());}

            case "5" -> {

                Scanner input = new Scanner(System.in);
                System.out.print("Assignment: ");
                String assignment = input.nextLine();

                Date date = new Date();

                FileInputStream file = new FileInputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assignments.xlsx");
                XSSFWorkbook xwb = new XSSFWorkbook(file);
                XSSFSheet sheet = xwb.getSheet("Assignments");
                int lastRow = sheet.getLastRowNum();

                Row row = sheet.createRow(++lastRow);
                row.createCell(0).setCellValue(assignment);
                row.createCell(1).setCellValue(String.valueOf(date));
                file.close();

                FileOutputStream output_file =new FileOutputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assignments.xlsx");
                xwb.write(output_file);
                output_file.close();
                System.out.println("""

                        The data has been successfully saved""");
                System.out.println(next_step());}

            case "6" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\patients.xlsx";

                FileInputStream fis = new FileInputStream(path);
                XSSFWorkbook xwb = new XSSFWorkbook(fis);
                XSSFSheet sheet = xwb.getSheet("Patients");
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

                int totalRows = sheet.getLastRowNum();
                System.out.println("Total number of patients: " + totalRows);
                System.out.println(next_step());
            }

            case "7" -> {

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
                                    System.out.print("Do you want to see patient's medical history or personal information? (0 - no / 1 - yes): ");
                                    String choose_step = input.nextLine();

                                    if (Objects.equals(choose_step, "1")) {

                                        System.out.println("""
                                                
                                                Enter the number of menu
                                                
                                                1 - medical history
                                                2 - personal information: \s""");
                                        String choose_step2 = input.nextLine();

                                        switch (choose_step2){

                                            case "1" -> {

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

                                            case "2" -> {
                                                XSSFSheet personal_sheet2 = xwb.getSheet(name);

                                                FormulaEvaluator formulaEvaluator = xwb.getCreationHelper().createFormulaEvaluator();

                                                for (Row row2 : personal_sheet2) {

                                                    for (Cell cell2 : row2) {

                                                        switch (formulaEvaluator.evaluateInCell(cell2).getCellType()) {

                                                            case NUMERIC -> System.out.print(cell2.getNumericCellValue() + "\t\t");
                                                            case STRING -> System.out.print(cell2.getStringCellValue() + "\t\t");
                                                        }
                                                    }
                                                    System.out.println();}}

                                            default -> System.out.println(next_step());
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

            case "8" -> System.out.println(authorization());

            case "9" -> System.out.println("Goodbye! See you later.");

            default -> System.out.println(doctor());
        }
        return "";}

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

            case "2" -> System.out.println(doctor());

            case "3" -> System.out.println("Goodbye! See you later");

            default -> System.out.println(doctor() + "");}

        return "";}
}
