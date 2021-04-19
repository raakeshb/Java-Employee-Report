/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raake
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.*;

public class Finals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ABC College");
        System.out.println("Payroll System");
        Scanner read = new Scanner(System.in);
        String efname;
        String elname;
        int enumber;
        String department;
        char ecode;
        char emptypecode;
        double hoursworked;
        double monthlynon;
        char menu = 'e';
        int employeecount = 0;
        int facultycount = 0;
        int nonfacultycount = 0;
        while (menu != 'x' && menu != 'X') {
            System.out.println("Enter Employee First Name");
            efname = read.next();
            System.out.println("Enter Employee Last Name");
            elname = read.next();
            System.out.println("Enter Employee Number");
            enumber = read.nextInt();
            employeecount++;
            System.out.println("Enter Employee Department");
            department = read.next();
            System.out.println("Enter Employee Type Code");
            emptypecode = read.next().charAt(0);

            if (emptypecode == 'f' || emptypecode == 'F') {
                facultycount++;
                System.out.println("Please Enter the Faculty Qualification Code");
                ecode = read.next().charAt(0);
                System.out.println("Please Enter Number of Hours Worked");
                hoursworked = read.nextDouble();

                Employee ee = new Employee(efname, elname, enumber, emptypecode);
                EmployeePaySlip emp;
                emp = new FacultyPaySlip(hoursworked, ecode, ee);
                String[] Printer = emp.printslip();

                try {
                    FileWriter file = new FileWriter("employee.txt", true);
                    BufferedWriter output = new BufferedWriter(file);

                    for (int i = 0; i < Printer.length; i++) {
                        output.write(Printer[i]);
                        output.newLine();
                    }
                    output.write("*********************************************");
                    output.newLine();
                    output.close();

                } catch (IOException ex) {
                    System.out.println("Error : " + ex.getMessage());

                }

            } else if (emptypecode == 'n' || emptypecode == 'N') {
                nonfacultycount++;
                System.out.println("Please Enter Your Monthly Salary");
                monthlynon = read.nextDouble();
                System.out.println("Please Enter Number of Hours Worked");
                hoursworked = read.nextDouble();
                EmployeePaySlip emp2;
                Employee ee2 = new Employee(efname, elname, enumber, emptypecode);
                emp2 = new NonFacultyPaySlip(hoursworked, monthlynon, ee2);
                String[] Printer = emp2.printslip();
                try {

                    FileWriter file = new FileWriter("employee.txt", true);
                    BufferedWriter output = new BufferedWriter(file);

                    for (int i = 0; i < Printer.length; i++) {
                        output.write(Printer[i]);
                        output.newLine();
                    }
                    output.write("*********************************************");
                    output.newLine();
                    output.close();

                } catch (IOException ex) {
                    System.out.println("Error : " + ex.getMessage());

                }
            }

            System.out.println("Please Enter x or X to exit the Payroll || Enter c to continue to enter Another Empployee");
            menu = read.next().charAt(0);

        }
        try {

            FileWriter file = new FileWriter("employee.txt", true);
            BufferedWriter output = new BufferedWriter(file);
            DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            output.write("***Report***");
            output.newLine();
            output.write("Date and Time " + date.format(now));
            output.newLine();

            output.write("#################################");
            output.newLine();
            output.write("Total Number of Employees: " + employeecount);
            output.newLine();
            output.write("Total Number of Faculty Count: " + facultycount);
            output.newLine();
            output.write("Total Number of Non-Faculty Count: " + nonfacultycount);
            output.newLine();
            output.write("#################################");
            output.newLine();
            output.close();

        } catch (IOException ex) {
            System.out.println("Error : " + ex.getMessage());

        }

    }

}
