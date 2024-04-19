package HospitalManagementSystem;

import java.util.Scanner;

public class Appointment {

        String pid, phonenumber,pname,speciality, disease, gender, admit_status;
        int age;
        Scanner input = new Scanner(System.in);

        void new_appointment()
        {
        System.out.print("phone number:-");
        phonenumber = input.nextLine();

        System.out.print("name:-");
        pname = input.nextLine();

        System.out.print("disease:-");
        disease = input.nextLine();

        System.out.print("suggest docter speciality:-");
        speciality = input.nextLine();

        System.out.print("sex:-");
        gender = input.nextLine();

        System.out.print("admit_status:-");
        admit_status = input.nextLine();

        System.out.print("age:-");
        age = input.nextInt();

    }
    void appointment_info(){
        System.out.println(phonenumber+"\t"+pname+"\t"+disease+"\t"+speciality+"\t"+gender+"\t"+admit_status+"\t"+age+"\t");
    }

}
