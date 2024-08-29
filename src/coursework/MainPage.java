package coursework;

import java.util.*;
import java.io.*;

import static coursework.MainDoctorPage.main_doctor_checking;
import static coursework.AssistantPage.assistant_checking;
import static coursework.PatientPage.patient_checking;
import static coursework.DoctorPage.doctor_checking;

public class MainPage {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello!");
        authorization();
    }
    public static String authorization() throws IOException {
        System.out.print("""
                
                Enter the number of your account type
                
                1 - Main Doctor
                1 - Assistant
                2 - Patient
                3 - Doctor
                
                5 - shut down the program: \s""");

        Scanner input_type_of_account = new Scanner(System.in);
        String type_of_account = input_type_of_account.nextLine();
        switch (type_of_account) {
            case "1" -> System.out.println(assistant_checking());
            case "2" -> System.out.println(doctor_checking());
            case "3" -> System.out.println(main_doctor_checking());
            case "4" -> System.out.println(patient_checking());
            case "5" -> System.out.println("Goodbye! See you later.");
            default -> {
                System.out.println("""
                        
                        Sorry, but we didn't find this type of account, please repeat.
                        """);
                System.out.println(authorization());
            }
        }
        return "";
    }
}
