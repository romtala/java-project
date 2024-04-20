package HospitalManagementSystem;
import java.io.*;
import java.util.*;
import java.util.Calendar;

public class facility { String fac_name;
void add_faci()
{
    Scanner input = new Scanner(System.in);

    System.out.print("facility:-");
    fac_name = input.nextLine();
}

void show_faci()
{
    System.out.println(fac_name);
}
}
