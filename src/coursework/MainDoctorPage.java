package coursework;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

import static coursework.MainPage.authorization;

public class MainDoctorPage {

    public static String main_doctor_checking() throws IOException {

        String[] words;
        FileReader fr = new FileReader("C:\\Users\\Wharton\\Documents\\Courseworks\\coursework2\\Course Work\\files\\main_doctor's_data.txt");
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
            System.out.println(main_doctor());}

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
            case "1" -> System.out.println(main_doctor_checking());
            case "2" -> System.out.println(authorization());
            case "3" -> System.out.println("Goodbye! See you later.");
            default -> System.out.println("" + main_doctor_checking());
        }
    }
        return "";
}

    public static String main_doctor() throws IOException {

        System.out.print("""

                Enter the number of menu

                1 - add
                2 - assistants
                3 - delete
                4 - doctors
                5 - patients
                6 - search

                9 - get back to the main page
                10 - shut down the program: \s""");

        Scanner input_number_of_menu = new Scanner(System.in);
        String number_of_menu = input_number_of_menu.nextLine();

        switch (number_of_menu) {

            case "1" -> {

                Scanner input = new Scanner(System.in);
                System.out.print("""

                        Enter the type of account

                        1 - assistant
                        2 - doctor: \s""");
                String type_of_account = input.nextLine();

                switch (type_of_account) {

                    case "1" -> {

                        Scanner input1 = new Scanner(System.in);

                        System.out.print("Assistant's first name: ");
                        String first_name = input1.nextLine();

                        System.out.print("Assistant's last name: ");
                        String last_name = input1.nextLine();

                        Scanner input_int = new Scanner(System.in);
                        System.out.print("Assistant's salary: ");
                        int salary = input_int.nextInt();

                        System.out.print("Assistant's age: ");
                        String age = input1.nextLine();

                        String txt_path = "C:\\Users\\Wharton\\Documents\\Courseworks\\coursework2\\Course Work\\files\\assistant's_data.txt";
                        BufferedWriter bw = new BufferedWriter(new FileWriter(txt_path, true));
                        bw.write("\n" + first_name + last_name);
                        bw.close();

                        FileInputStream file = new FileInputStream("C:\\Users\\Wharton\\Documents\\Courseworks\\coursework2\\Course Work\\files\\assistants.xlsx");

                        XSSFWorkbook xwb = new XSSFWorkbook(file);

                        XSSFSheet sheet1 = xwb.getSheet("Assistants");
                        int lastRow1 = sheet1.getLastRowNum();

                        Row row1 = sheet1.createRow(++lastRow1);
                        row1.createCell(0).setCellValue(first_name + " " + last_name);
                        row1.createCell(1).setCellValue(salary);

                        xwb.createSheet(first_name + " " + last_name);
                        XSSFSheet sheet2 = xwb.getSheet(first_name + " " + last_name);

                        Row row2_1 = sheet2.createRow(0);
                        row2_1.createCell(0).setCellValue("Name");
                        row2_1.createCell(1).setCellValue("Age");
                        row2_1.createCell(2).setCellValue("Salary");
                        row2_1.createCell(3).setCellValue("Date Employment");

                        Date date = new Date();
                        Row row2_2 = sheet2.createRow(1);
                        row2_2.createCell(0).setCellValue(first_name + " " + last_name);
                        row2_2.createCell(1).setCellValue(age);
                        row2_2.createCell(2).setCellValue(salary);
                        row2_2.createCell(3).setCellValue(String.valueOf(date));
                        file.close();

                        FileOutputStream output_file = new FileOutputStream("C:\\Users\\Wharton\\Documents\\Courseworks\\coursework2\\Course Work\\files\\patients.xlsx");
                        xwb.write(output_file);
                        output_file.close();

                        System.out.println("""

                        The data has been successfully saved""");
                        System.out.println(next_step());}

                    case "2" -> {

                        Scanner input1 = new Scanner(System.in);

                        System.out.print("Doctor's first name: ");
                        String first_name = input1.nextLine();

                        System.out.print("Doctor's last name: ");
                        String last_name = input1.nextLine();

                        Scanner input_int = new Scanner(System.in);
                        System.out.print("Doctor's salary: ");
                        int salary = input_int.nextInt();

                        System.out.print("Doctor's age: ");
                        String age = input1.nextLine();

                        Scanner input_schedule = new Scanner(System.in);

                        System.out.println("Doctor's schedule (enter the time interval in which the doctor works on this day. For example, 13:00-15:00)");

                        System.out.print("Monday: ");
                        String monday = input_schedule.nextLine();

                        System.out.print("Tuesday: ");
                        String tuesday = input_schedule.nextLine();

                        System.out.print("Wednesday: ");
                        String wednesday = input_schedule.nextLine();

                        System.out.print("Thursday: ");
                        String thursday = input_schedule.nextLine();

                        System.out.print("Friday: ");
                        String friday = input_schedule.nextLine();

                        String txt_path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctor's_data.txt";
                        BufferedWriter bw = new BufferedWriter(new FileWriter(txt_path, true));
                        bw.write("\n" + first_name + last_name);
                        bw.close();

                        FileInputStream file = new FileInputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctors.xlsx");

                        XSSFWorkbook xwb = new XSSFWorkbook(file);

                        XSSFSheet sheet1 = xwb.getSheet("Doctors");
                        int lastRow1 = sheet1.getLastRowNum();

                        Row row1 = sheet1.createRow(++lastRow1);
                        row1.createCell(0).setCellValue(first_name + " " + last_name);
                        row1.createCell(1).setCellValue(salary);

                        xwb.createSheet(first_name + " " + last_name);
                        XSSFSheet sheet2 = xwb.getSheet(first_name + " " + last_name);

                        Row row2_1 = sheet2.createRow(0);
                        row2_1.createCell(0).setCellValue("Name");
                        row2_1.createCell(1).setCellValue("Age");
                        row2_1.createCell(2).setCellValue("Salary");
                        row2_1.createCell(3).setCellValue("Date Employment");

                        Date date = new Date();
                        Row row2_2 = sheet2.createRow(1);
                        row2_2.createCell(0).setCellValue(first_name + " " + last_name);
                        row2_2.createCell(1).setCellValue(age);
                        row2_2.createCell(2).setCellValue(salary);
                        row2_2.createCell(3).setCellValue(String.valueOf(date));
                        file.close();

                        FileInputStream file3 = new FileInputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\d_schedule.xlsx");

                        XSSFWorkbook xwb3 = new XSSFWorkbook(file3);

                        xwb3.createSheet(first_name + " " + last_name);
                        XSSFSheet sheet3 = xwb3.getSheet(first_name + " " + last_name);

                        Row row3_1 = sheet3.createRow(0);
                        row3_1.createCell(0).setCellValue("Monday");
                        row3_1.createCell(1).setCellValue("Tuesday");
                        row3_1.createCell(2).setCellValue("Wednesday");
                        row3_1.createCell(3).setCellValue("Thursday");
                        row3_1.createCell(4).setCellValue("Friday");


                        Row row3_2 = sheet3.createRow(1);
                        row3_2.createCell(0).setCellValue(monday);
                        row3_2.createCell(1).setCellValue(tuesday);
                        row3_2.createCell(2).setCellValue(wednesday);
                        row3_2.createCell(3).setCellValue(thursday);
                        row3_2.createCell(4).setCellValue(friday);
                        file3.close();

                        FileOutputStream output_file = new FileOutputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctors.xlsx");
                        xwb.write(output_file);
                        output_file.close();

                        FileOutputStream output_file3 = new FileOutputStream("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\d_schedule.xlsx");
                        xwb3.write(output_file3);
                        output_file3.close();

                        System.out.println("""

                        The data has been successfully saved""");
                        System.out.println(next_step());}

                    default -> System.out.print(next_step());
                }
            }

            case "2" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assistants.xlsx";

                FileInputStream fis = new FileInputStream(path);
                XSSFWorkbook xwb = new XSSFWorkbook(fis);
                XSSFSheet sheet = xwb.getSheet("Assistants");
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
                System.out.println("Total number of assistants: " + totalRows);
                System.out.println(next_step());}

            case "3" -> {

                Scanner input = new Scanner(System.in);
                System.out.print("""

                        Enter the type of account

                        1 - assistant
                        2 - doctor: \s""");

                String type_of_account = input.nextLine();
                switch (type_of_account) {

                    case "1" -> {

                        String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assistants.xlsx";

                        Scanner input2 = new Scanner(System.in);

                        System.out.print("Assistant's first name: ");
                        String name = input2.nextLine();

                        System.out.print("Assistant's first name: ");
                        String last_name = input2.nextLine();

                        File file = new File("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assistant's_data.txt");

                        File temp = File.createTempFile("assistant's_data", ".txt", file.getParentFile());

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
                        XSSFSheet sheet = xwb.getSheet("Assistants");

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

                        System.out.println(next_step());}

                    case "2" -> {

                        String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctors.xlsx";

                        Scanner input2 = new Scanner(System.in);

                        System.out.print("Doctor's first name: ");
                        String name = input2.nextLine();

                        System.out.print("Doctor's last name: ");
                        String last_name = input2.nextLine();

                        File file = new File("C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctor's_data.txt");

                        File temp = File.createTempFile("doctor's_date", ".txt", file.getParentFile());

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
                        XSSFSheet sheet = xwb.getSheet("Doctors");

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

                        String path2 = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\d_schedule.xlsx";

                        FileInputStream fis2 = new FileInputStream(path2);
                        XSSFWorkbook xwb2 = new XSSFWorkbook(fis2);

                        xwb2.removeSheetAt(xwb2.getSheetIndex(name + " " + last_name));

                        FileOutputStream fos2 = new FileOutputStream(path2);
                        xwb2.write(fos2);
                        fos2.close();

                        System.out.println(next_step());}

                    default -> System.out.print(next_step());
                }
            }

            case "4" -> {

                String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\doctors.xlsx";

                FileInputStream fis = new FileInputStream(path);
                XSSFWorkbook xwb = new XSSFWorkbook(fis);
                XSSFSheet sheet = xwb.getSheet("Doctors");
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
                System.out.println("Total number of doctors: " + totalRows);
                System.out.println(next_step());}

            case "5" -> {

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

            case "6" -> {
                System.out.println("""

                        Enter the type of account

                        1 - assistant
                        2 - doctor
                        3 - patient: \s""");
                Scanner input_type_of_account = new Scanner(System.in);
                String type_of_account = input_type_of_account.nextLine();

                switch (type_of_account){

                    case "1" -> {

                        String path = "C:\\Users\\Wharton\\Documents\\Course Works\\Course Work (Java)\\Course Work\\files\\assistants.xlsx";

                        Scanner input = new Scanner(System.in);

                        System.out.print("Assistant's first name and last name: ");
                        String name = input.nextLine();

                        InputStream is = new FileInputStream(path);

                        XSSFWorkbook xwb = new XSSFWorkbook(is);
                        XSSFSheet sheet = xwb.getSheet("Assistants");

                        for (Row row : sheet) {

                            for (Cell cell : row) {

                                if (cell.getCellType() == CellType.STRING) {

                                    if (cell.getRichStringCellValue().getString().trim().equals(name)) {

                                        String message = cell + "'s information is recorded in the database";

                                        if (message.length() > 43) {

                                            System.out.println(message);
                                            System.out.print("Do you want to see assistant's personal information? (0 - no / 1 - yes): ");
                                            String choose_step = input.nextLine();

                                            if (Objects.equals(choose_step, "1")) {

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

                                            }
                                            else {System.out.println(next_step());}
                                        }
                                    }
                                }
                            }
                        System.out.println(next_step());
                        }

                    case "2" -> {

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

                                        String message = cell + "'s information is recorded in the database";

                                        if (message.length() > 43) {

                                            System.out.println(message);
                                            System.out.print("Do you want to see doctor's schedule or personal information? (0 - no / 1 - yes): ");
                                            String choose_step = input.nextLine();

                                            if (Objects.equals(choose_step, "1")) {

                                                System.out.println("""
                                                
                                                Enter the number of menu
                                                
                                                1 - schedule
                                                2 - personal information: \s""");
                                                String choose_step2 = input.nextLine();

                                                switch (choose_step2){

                                                    case "1" -> {

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

                    case "3" -> {

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

                    default -> System.out.println(next_step());}}

            case "7" -> System.out.println(authorization());

            case "8" -> System.out.println("Goodbye! See you later.");

            default -> System.out.println("""

                    The entered data was not found.
                    """ + main_doctor());}

        return "";}

    public static String next_step() throws IOException {

        System.out.print("""

                        Choose the next step

                        1 - get back to the main page
                        2 - get back to the main menu
                        3 - shut down the program: \s""");

        Scanner input_next_move = new Scanner(System.in);
        String next_move = input_next_move.nextLine();

        switch (next_move){

            case "1" -> System.out.println(authorization());

            case "2" -> System.out.println(main_doctor());

            case "3" -> System.out.println("Goodbye! See you later");

            default -> System.out.println(main_doctor() + "");}

        return "";}
}
