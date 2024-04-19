package HospitalManagementSystem;

import java.util.*;
import java.util.Calendar;

public class HospitalManagement {

    public static void main(String args[]) {
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Calendar calendar = Calendar.getInstance();
        //System.out.println("--------------------------------------------------------------------------------");
        int count1 = 4, count2 = 4, count3 = 4, count4 = 4, count5 = 4, count6 = 4, count7 = 0;


        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("            *** Welcome to Hospital Management System Project in Java ***");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));

        System.out.println("\t\t\t\t\t\t                          Time: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

        doctor[] d = new doctor[25];
        patient[] p = new patient[100];
        lab[] l = new lab[20];
        facility[] f = new facility[20];
        medical[] m = new medical[100];
        staff[] s = new staff[100];
        Appointment[] a = new Appointment[100];
        int i;
        for (i = 0; i < 25; i++) {
            a[i] = new Appointment();
        }

        for (i = 0; i < 25; i++) d[i] = new doctor();

        for (i = 0; i < 100; i++) p[i] = new patient();

        for (i = 0; i < 20; i++) l[i] = new lab();

        for (i = 0; i < 20; i++) f[i] = new facility();

        for (i = 0; i < 100; i++) m[i] = new medical();

        for (i = 0; i < 100; i++) s[i] = new staff();


        d[0].did = "21";
        d[1].did = "32";
        d[0].dname = "Dr.Ghanendra";
        d[1].dname = "Dr.Vikram";
        d[0].specilist = "NeuroSurgeon";
        d[1].specilist = "    Physician";
        d[0].appoint = "    5-11AM";
        d[1].appoint = "10-3AM";
        d[0].doc_qual = "MBBS,MD";
        d[1].doc_qual = "MBBS,MD";

        d[2].did = "17";
        d[3].did = "33";
        d[2].dname = "Dr.Rekha";
        d[3].dname = "Dr.Pramod";
        d[2].specilist = "    oncologist";/*oncogonist -cancer specialist*/
        d[3].specilist = "    Orthologist";
        d[2].appoint = "8-2AM";
        d[3].appoint = "    10-4PM";
        d[2].doc_qual = "MBBS,MS";
        d[3].doc_qual = "MBBS,MS";


        p[0].pid = "12";
        p[1].pid = "13";
        p[0].pname = "Pankaj";
        p[1].pname = "Sumit";
        p[0].disease = "Cancer";
        p[1].disease = "Cold";
        p[0].gender = "Male";
        p[1].gender = "Male";
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
        p[2].gender = "Male";
        p[3].gender = "Male";
        p[2].admit_status = "y";
        p[3].admit_status = "y";
        p[2].age = 45;
        p[3].age = 25;


        m[0].med_name = "Corex";
        m[1].med_name = "Nytra";
        m[0].med_comp = "Cino pvt";
        m[1].med_comp = "Ace pvt";
        m[0].exp_date = "9-5-16";
        m[1].exp_date = "4-4-15";
        m[0].med_cost = 55;
        m[1].med_cost = 500;
        m[0].count = 8;
        m[1].count = 5;

        m[2].med_name = "Brufa";
        m[3].med_name = "Pride";
        m[2].med_comp = "Ricket";
        m[3].med_comp = "DDF pvt";
        m[2].exp_date = "12-7-17";
        m[3].exp_date = "12-4-12";
        m[2].med_cost = 50;
        m[3].med_cost = 1100;
        m[2].count = 56;
        m[3].count = 100;


        l[0].facility = "X-ray     ";
        l[1].facility = "CT Scan   ";
        l[0].lab_cost = 800;
        l[1].lab_cost = 1200;

        l[2].facility = "OR Scan   ";
        l[3].facility = "Blood Bank";
        l[2].lab_cost = 500;
        l[3].lab_cost = 50;

        f[0].fac_name = "Ambulance";
        f[1].fac_name = "Admit Facility ";
        f[2].fac_name = "Canteen";
        f[3].fac_name = "Emergency";

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


        Scanner input = new Scanner(System.in);

        int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1,s7=1;

        while (status == 1) {
            status = 1;
            s1 = 1;
            s2 = 1;
            s3 = 1;
            s4 = 1;
            s5 = 1;
            s6 = 1;
            System.out.println("                                   MAIN MENU");
            System.out.println("+------------------------------------------------------------------------------------------------------------+");
            System.out.println("| 0.Exit | 1.Doctors | 2. Patients | 3.Medicines | 4.Laboratories | 5. Facilities | 6. Staff | 7. Appointment|");
            System.out.println("+------------------------------------------------------------------------------------------------------------+");
            System.out.println("Enter a number before all the items in menu to enter into it.");

            choice = input.nextInt();
            switch (choice) {
                case 0: {
                    System.out.println("Thank You For Using Hospital management system..");
                    return;
                }

                case 1: {
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                      **DOCTOR SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s1 == 1) {
                        System.out.println("0.Main Menu\n1.Add New Entry\n2.Existing Doctors List");
                        c1 = input.nextInt();
                        switch (c1) {
                            case 0: {
                                s1 = 0;
                                break;
                            }
                            case 1: {
                                d[count1].new_doctor();
                                count1++;
                                break;
                            }
                            case 2: {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("id \t Name\t       Specilist \t Timing \t Qualification ");
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
                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        if (s1 == 0) break;

                        s1 = input.nextInt();
                        if (s1 == 0) break;
                    }
                    break;
                }

                case 2: {
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                     **PATIENT SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s2 == 1) {
                        System.out.println("0.Main Menu\n1.Add New Entry\n2.Existing Patients List");
                        c1 = input.nextInt();
                        switch (c1) {
                            case 0: {
                                s2 = 0;
                                break;
                            }
                            case 1: {
                                p[count2].new_patient();
                                count2++;
                                break;
                            }

                            case 2: {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("id \t Name \t Disease \t Gender \t Admit Status \t Age");
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

                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        if (s1 == 0) break;
                        s2 = input.nextInt();
                        if (s2 == 0) break;
                    }
                    break;
                }

                case 3: {
                    s3 = 1;

                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                     **MEDICINE SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s3 == 1) {
                        System.out.println("0.main menu \n1.Add New Entry\n2. Existing Medicines List");
                        c1 = input.nextInt();

                        switch (c1) {
                            case 0: {
                                s3 = 0;
                                break;
                            }
                            case 1: {
                                m[count3].new_medi();
                                count3++;
                                break;
                            }

                            case 2: {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("Name \t Company \t Expiry Date \t Cost");
                                System.out.println("--------------------------------------------------------------------------------");

                                for (j = 0; j < count3; j++) {
                                    m[j].find_medi();
                                }
                                break;
                            }
                            default: {
                                System.out.println(" You Have Enter Wrong Choice!!!");
                            }

                        }
                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");

                        if (s3 == 0) break;
                        s3 = input.nextInt();
                        if (s3 == 0) break;

                    }
                    break;
                }

                case 4: {
                    s4 = 1;

                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                    **LABORATORY SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s4 == 1) {
                        System.out.println("0.mainmenu \n1.Add New Entry \n2.Existing Laboratories List");
                        c1 = input.nextInt();

                        switch (c1) {
                            case 0: {
                                s4 = 0;
                                break;
                            }
                            case 1: {
                                l[count4].new_faci();
                                count4++;
                                break;
                            }
                            case 2: {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("Facilities\t\t Cost");
                                System.out.println("--------------------------------------------------------------------------------");

                                for (j = 0; j < count4; j++) {
                                    l[j].faci_list();
                                }
                                break;
                            }
                            default: {
                                System.out.println(" You Have Enter Wrong Choice!!!");
                            }
                        }

                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        if (s4 == 0) {
                            break;
                        }

                        s4 = input.nextInt();
                        if (s4 == 0) {
                            continue;
                        }
                        break;

                    }
                    break;
                }

                case 5: {
                    s5 = 1;

                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("          **HOSPITAL FACILITY SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s5 == 1) {
                        System.out.println("0.main menu \n1.Add New Facility\n2.Existing Facilities List");
                        c1 = input.nextInt();

                        switch (c1) {
                            case 0: {
                                s5 = 0;
                                break;
                            }
                            case 1: {
                                f[count5].add_faci();
                                count5++;
                                break;
                            }
                            case 2: {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("Hospital  Facility are:");
                                System.out.println("--------------------------------------------------------------------------------");

                                for (j = 0; j < count5; j++) {
                                    f[j].show_faci();
                                }
                                break;
                            }
                            default: {
                                System.out.println(" You Have Enter Wrong Choice!!!");
                            }
                        }
                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        if (s5 == 0) break;

                        s5 = input.nextInt();
                        if (s5 == 0) break;

                    }
                    break;
                }


                case 6: {
                    s5 = 1;

                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("          **HOSPITAL FACILITY SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s5 == 1) {
                        System.out.println("0.main menu \n1.Add new staff\n2.Existing staff");
                        c1 = input.nextInt();

                        switch (c1) {
                            case 0: {
                                s5 = 0;
                                break;
                            }
                            case 1: {
                                s[count6].new_staff();
                                count6++;
                                break;
                            }
                            case 2: {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("Staff Facility are:");
                                System.out.println("--------------------------------------------------------------------------------");

                                for (j = 0; j < count5; j++) {
                                    s[j].staff_info();
                                }
                                break;
                            }
                            default: {
                                System.out.println(" You Have Enter Wrong Choice!!!");
                            }
                        }
                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        if (s5 == 0) break;

                        s5 = input.nextInt();
                        if (s5 == 0) break;

                    }
                    break;
                }
                case 7: {
                    s7 = 1;

                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                       **STAFF SECTION**");
                    System.out.println("--------------------------------------------------------------------------------");

                    while (s7 == 1) {

                        System.out.println("0.main menu \n 1.Add Appointment \n 2.Existing Appointments");
                        c1 = input.nextInt();

                        switch (c1) {
                            case 0: {
                                s6 = 0;
                                break;
                            }
                            case 1: {
                                s[count6].new_staff();
                                count6++;
                                break;
                            }
                            case 2: {
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("id \t  Name \t Gender \t Salary");
                                System.out.println("--------------------------------------------------------------------------------");

                                for (j = 0; j < count6; j++) {

                                    a[j].appointment_info();

                                }
                                break;

                            }
                            default: {
                                System.out.println(" You Have Enter Wrong Choice!!!");
                            }
                            break;
                        }

                        System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
                        if (s5 == 0) break;

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

//                        System.out.println("\nReturn to Main Menu Press 0");
//                        s5 = input.nextInt();
//                        if (s5 == 0) break;
//            System.out.println("\nReturn to MAIN MENU Press 1");
//            status = input.nextInt();







//                case 7: {
//                    s5 = 1;
//
//                    System.out.println("--------------------------------------------------------------------------------");
//                    System.out.println("          **BOOK APPOINTMENT**");
//                    System.out.println("--------------------------------------------------------------------------------");
//
//                    while (s5 == 1) {
//                        System.out.println("0.main menu \n1.Add New appointment\n2.Existing Appointment List");
//                        c1 = input.nextInt();
//
//                        switch (c1) {
//                            case 1: {
//                                f[count5].add_faci();
//                                count5++;
//                                break;
//                            }
//                            case 2: {
//                                System.out.println("--------------------------------------------------------------------------------");
//                                System.out.println("Appointments are:");
//                                System.out.println("--------------------------------------------------------------------------------");
//
//                                for (j = 0; j < count5; j++) {
//                                    app[j].show_faci();
//                                }
//                                break;
//                          }


