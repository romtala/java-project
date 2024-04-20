package HospitalManagementSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Calendar;

public class HospitalManagement {
    public static void main(String args[]) throws IOException {
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Calendar calendar = Calendar.getInstance();
        //System.out.println("--------------------------------------------------------------------------------");
        int count1 = 4, count2 = 4, count3 = 4, count4 = 0, count5 = 4;


        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.println("            *** Welcome to Hospital Management System Project in Java ***");
        System.out.println("------------------------------------------------------------------------------------------------");

        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));

        System.out.println("\t\t\t\t\t\t                          Time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

        doctor[] d = new doctor[25];
        facility[] f = new facility[20];
        patient[] p = new patient[100];
        staff[] s = new staff[100];
        Appointment[] a = new Appointment[100];
        int i;
        for (i = 0; i < 25; i++) a[i] = new Appointment();
        for (i = 0; i < 25; i++) d[i] = new doctor();
        for (i = 0; i < 100; i++) p[i] = new patient();
        for (i = 0; i < 100; i++) s[i] = new staff();
        for (i = 0; i < 20; i++) f[i] = new facility();

        d[0].dname = "Dr.Ghanendra";
        d[1].dname = "Dr.Vikram";
        d[0].specilist = "NeuroSurgeon";
        d[1].specilist = "    Physician";
        d[0].appoint = "5-11PM";
        d[1].appoint = "    10-3AM";
        d[0].doc_qual = "     MBBS,MD";
        d[1].doc_qual = "     MBBS,MD";

        d[2].dname = "Dr.Rekha";
        d[3].dname = "Dr.Pramod";
        d[2].specilist = "    oncologist";/*oncogonist -cancer specialist*/
        d[3].specilist = "    Orthologist";
        d[2].appoint = "    8-2AM";
        d[3].appoint = "10-4PM";
        d[2].doc_qual = "     MBBS,MS";
        d[3].doc_qual = "     MBBS,MS";

        p[0].pid = "12";
        p[1].pid = "13";
        p[0].pname = "Pankaj";
        p[1].pname = "Sumit";
        p[0].disease = "Cancer";
        p[1].disease = "Cold";
        p[0].gender = "    Male";
        p[1].gender = "    Male";
        p[0].admit_status = "y";
        p[1].admit_status = "y";
        p[0].age = 30;
        p[1].age = 23;

        p[2].pid = "14";
        p[3].pid = "15";
        p[2].pname = "Alok";
        p[3].pname = "Ravi";
        p[2].disease = "Maleria";
        p[3].disease = "Diabetes";
        p[2].gender = " Male";
        p[3].gender = "Male";
        p[2].admit_status = "y";
        p[3].admit_status = "y";
        p[2].age = 45;
        p[3].age = 25;

        s[0].sid = "22";
        s[1].sid = "23";
        s[0].sname = "Prakash";
        s[1].sname = "Komal";
        s[0].desg = "Worker";
        s[1].desg = "Nurse";
        s[0].sex = "Male";
        s[1].sex = "Female";
        s[0].salary = 5000;
        s[1].salary = 2000;

        s[2].sid = "24";
        s[3].sid = "25";
        s[2].sname = "Raju";
        s[3].sname = "Rani";
        s[2].desg = "Worker";
        s[3].desg = "Nurse";
        s[2].sex = "Male";
        s[3].sex = "Female";
        s[2].salary = 5000;
        s[3].salary = 20000;

        f[0].fac_name = "Ambulance";
        f[1].fac_name = "Admit Facility ";
        f[2].fac_name = "Canteen";
        f[3].fac_name = "ventilator facility";
        //f[4]fac_name="A/C rooms";

        Scanner input = new Scanner(System.in);

        int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1, s7 = 1;

        while (status == 1)
        {
            status = 1;
            s1 = 1;
            s2 = 1;
            s3 = 1;
            s4 = 1;
            s5 = 1;
            s6 = 1;
            System.out.println("                                   MAIN MENU");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("| 0.Exit | 1.Doctors | 2. Patients  | 3. Staff | 4. Appointment| 5. Facility |");
            System.out.println("+----------------------------------------------------------------------------+");
            System.out.println("Enter a number before all the items in menu to enter into it.");

            choice = input.nextInt();
            switch (choice)
            {
                case 0:
                {
                    System.out.println("Thank You For Using Hospital management system..");
                    return;
                }
                case 1: {
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                      **DOCTOR SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s1 == 1)
                    {
                        System.out.println("choose the number before the item to enter to it\n0.Main Menu\n1.Add New Entry\n2.Existing Doctors List");
                        c1 = input.nextInt();
                        switch (c1)
                        {
                            case 0:
                            {
                                s1 = 0;
                                break;
                            }
                            case 1:
                            {
                                d[count1].new_doctor();
                                count1++;
                                break;
                            }
                            case 2:
                            {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println(" Name\t       Specilist    \t Timing  \t Qualification ");
                                System.out.println("--------------------------------------------------------------------------------");
                                for (j = 0; j < count1; j++) {
                                    d[j].doctor_info();
                                }
                                break;
                            }
                            default: {
                                System.out.println(" You Have Enter Wrong Choice!!!");
                            }
                        }
                        if (s1 == 0) break;
                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        s1 = input.nextInt();
                        if (s1 == 0) break;

                    }
                    break;
                }
                    case 2:
                    {
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("                     **PATIENT SECTION**");
                        System.out.println("--------------------------------------------------------------------------------");

                        while (s2 == 1)
                        {
                            System.out.println("choose the number before the item to enter to it\n0.Main Menu\n1.Add New Entry\n2.Existing Patients List");
                            int c2 = input.nextInt();
                            switch (c2)
                            {
                                case 0:
                                {
                                    s2 = 0;
                                    break;
                                }
                                case 1:
                                {
                                    p[count2].new_patient();
                                    count2++;
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.println("id \t Name \t Disease \t    Gender \t Admit Status \t Age");
                                    System.out.println("--------------------------------------------------------------------------------");
                                    for (j = 0; j < count2; j++) {
                                        p[j].patient_info();
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println(" You Have Enter Wrong Choice!!!");
                                }
                            }
                            if (s2 == 0) break;
                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");

                            s2 = input.nextInt();
                            if (s2 == 0) break;
                            else if (s3 == 1) continue;
                            else {
                                System.out.println("invalid input.");
                            }

                        }
                        break;
                    }
                        case 3: {
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.println("          **STAFF SECTION**");
                            System.out.println("--------------------------------------------------------------------------------");

                            while (s3 == 1)
                            {
                                System.out.println("choose the number before the item to enter to it\n0.main menu \n1.Add new staff\n2.Create file of existing staff");
                                int c3 = input.nextInt();
                                int l;
                                switch (c3)
                                {
                                    case 0:
                                    {
                                        s3 = 0;
                                        break;
                                    }
                                    case 1: {

                                        s[count3].new_staff();
                                        count3++;
                                        break;
                                    }
                                    case 2:
                                    {
                                        System.out.println("Created a new file staff.txt where details of staff details is saved.");
                                        File file = new File("Staff.txt");
                                        try
                                        {
                                            file.createNewFile();
                                            FileWriter filewriter = new FileWriter("Staff.txt");
                                            filewriter.write("ID  Name    Designation  sex  salary\n"
                                                    + s[0].sid + "  " + s[0].sname + "  " + s[0].desg + "  " + s[0].sex + "  " + s[0].salary + "\n"
                                                    + s[1].sid + "  " + s[1].sname + "  " + s[1].desg + "  " + s[1].sex + "  " + s[1].salary + "\n"
                                                    + s[2].sid + "  " + s[2].sname + "  " + s[2].desg + "  " + s[2].sex + "  " + s[2].salary + "\n"
                                                    + s[3].sid + "  " + s[3].sname + "  " + s[3].desg + "  " + s[3].sex + "  " + s[3].salary + "\n");
                                            if (count3 == 4) {
                                                if (s[4].sid != null) {
                                                    filewriter.write(s[4].sid + "  " + s[4].sname + "  " + s[4].desg + "  " + s[4].sex + "  " + s[4].salary + "\n"
                                                    );
                                                }
                                            }

                                            if (count3 == 5)
                                            {
                                                if (s[4].sid != null)
                                                {
                                                    filewriter.write(s[4].sid + "  " + s[4].sname + "  " + s[4].desg + "  " + s[4].sex + "  " + s[4].salary + "\n");
                                                }
                                                if (s[5].sid != null)
                                                {
                                                    filewriter.write(s[5].sid + "  " + s[5].sname + "  " + s[5].desg + "  " + s[5].sex + "  " + s[5].salary + "\n");
                                                }
                                            }
                                            if (count3 == 6) {
                                                if (s[5].sid != null) {
                                                    filewriter.write(s[4].sid + "  " + s[4].sname + "  " + s[4].desg + "  " + s[4].sex + "  " + s[4].salary + "\n");
                                                }
                                                if (s[5].sid != null) {
                                                    filewriter.write(s[5].sid + "  " + s[5].sname + "  " + s[5].desg + "  " + s[5].sex + "  " + s[5].salary + "\n");
                                                }
                                                if (s[6].sid != null) {
                                                    filewriter.write(s[6].sid + "  " + s[6].sname + "  " + s[6].desg + "  " + s[6].sex + "  " + s[6].salary + "\n");
                                                }
                                            }
                                            filewriter.close();
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                        break;
                                    }

                                    default: {
                                        System.out.println(" You Have Enter Wrong Choice!!!");
                                    }
                                }
                                if (s3 == 0) break;
                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                                s3 = input.nextInt();
                                if (s3 == 0) break;
                                else if (s3 == 1) continue;
                                else {
                                    System.out.println("invalid input.");
                                }
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.println("                       **APPOINTMENT SECTION**");
                            System.out.println("--------------------------------------------------------------------------------");

                            while (s4 == 1)
                            {
                                System.out.println("choose the number before the item to enter to it\n0.main menu \n 1.Add Appointment \n 2.Existing Appointments");
                                c1 = input.nextInt();

                                switch (c1)
                                {
                                    case 0:
                                    {
                                        s4 = 0;
                                        break;
                                    }
                                    case 1:
                                    {
                                        a[count4].new_appointment();
                                        count4++;
                                        break;
                                    }
                                    case 2:
                                    {
                                        if(count4>0) {
                                            System.out.println("--------------------------------------------------------------------------------");
                                            System.out.println("  Name        \t disease    age  suggested speciality   appointmentId");
                                            System.out.println("--------------------------------------------------------------------------------");

                                            for (j = 0; j < count4; j++) {
                                                a[j].appointment_info();
                                                System.out.println("Doctor of appointment:-"+name_of_doctor_generator.generateDoctorName());
                                            }

                                        }
                                        else
                                        {
                                            System.out.println("no appointments now.");
                                        }
                                        break;
                                    }
                                    default:
                                    {
                                        System.out.println(" You Have Enter Wrong Choice!!!");
                                    }
                                    break;
                                }
                                if (s4 == 0) break;
                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                                s4 = input.nextInt();
                                if (s4 == 0) break;
                            }
                            break;
                        }
                        case 5: {
                            s5 = 1;

                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.println("          **HOSPITAL FACILITY SECTION**");
                            System.out.println("--------------------------------------------------------------------------------");

                            while (s5 == 1)
                            {
                                System.out.println("choose the number before the item to enter to it\n0.main menu \n1.Add New Facility\n2.Existing Facilities List");
                                c1 = input.nextInt();

                                switch (c1)
                                {
                                    case 0:
                                    {
                                        s5 = 0;
                                        break;
                                    }
                                    case 1:
                                    {
                                        f[count5].add_faci();
                                        count5++;
                                        break;
                                    }
                                    case 2:
                                    {
                                        System.out.println("--------------------------------------------------------------------------------");
                                        System.out.println("Hospital's Facility are:");
                                        System.out.println("--------------------------------------------------------------------------------");

                                        for (j = 0; j < count5; j++)
                                        {
                                            f[j].show_faci();
                                        }
                                        break;
                                    }
                                    default:
                                    {
                                        System.out.println(" You Have Enter Wrong Choice!!!");
                                    }
                                }
                                if (s5 == 0) break;
                                System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                                s5 = input.nextInt();
                                if (s5 == 0) break;
                            }
                            break;
                        }
                        default: {
                            System.out.println(" You Have Enter Wrong Choice!!!");
                        }
                }
            }
        }
    }
 class  name_of_doctor_generator {
    private static final String[] FIRST_NAMES = {
            "Aarav", "Aryan", "Advik", "Dhruv", "Vihaan", "Ishaan", "Reyansh", "Shaurya", "Arjun", "Kabir", "Aadi", "Atharva", "Ahaan", "Rudra",
            "Ananya", "Aarohi", "Saisha",  "Sakshi", "Kavya"
    };

    private static final String[] LAST_NAMES = {
            "Patel", "Shah", "Gupta", "Kumar", "Singh", "Sharma", "Jain", "Mehta", "Trivedi", "Chauhan", "Verma", "Yadav", "Pandey", "Reddy",
            "Mukherjee", "Dutta"
    };

    public static String generateDoctorName() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return "Dr. " + firstName + " " + lastName;
    }
}
