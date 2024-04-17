package HospitalManagementSystem;
import java.io.*;
import java.util.*;
import java.util.Calendar;
public class patient {
    String pid, pname, disease, gender, admit_status;
    int age;

    void new_patient() {
        Scanner input = new Scanner(System.in);

        System.out.print("id:-");
        pid = input.nextLine();

        System.out.print("name:-");
        pname = input.nextLine();

        System.out.print("disease:-");
        disease = input.nextLine();

        System.out.print("sex:-");
        gender = input.nextLine();

        System.out.print("admit_status:-");
        admit_status = input.nextLine();

        System.out.print("age:-");
        age = input.nextInt();

    }

    void patient_info() {
        System.out.println(pid + "\t" + pname + " \t" + disease + "     \t" + gender + "      \t" + admit_status + "\t" + age);
    }
}