package HospitalManagementSystem;

import java.util.Random;
import java.util.Scanner;

public class Appointment {

        String pname,speciality, disease;
        int age;
        Scanner input = new Scanner(System.in);
       int x=generateRandomNumber();
        void new_appointment()
        {

        System.out.print("name:-");
        pname = input.nextLine();

        System.out.print("disease:-");
        disease = input.nextLine();

        System.out.print("suggested docter speciality:-");
        speciality = input.nextLine();

        System.out.print("age:-");
        age = input.nextInt();

        System.out.print("generated appointment Id:-"+x);

    }
    void appointment_info(){
        System.out.println(pname+"\t   "+disease+"\t    "+age+"\t     "+speciality+"\t   "+ x);
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1; // Generates a random number from 0 to 99, so we add 1 to make it 1 to 100
    }
}
