/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raake
 */
public abstract class EmployeePaySlip {

    protected Employee e;

    public EmployeePaySlip(Employee e) {
        this.e = e;
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }

    public EmployeePaySlip() {
    }

    public abstract double Grosssal();

    public double Deductions() {
        double gross = Grosssal();
        double healthfee = 0;
        double incometax = 0;
        if (gross > 3000.00) {
            healthfee = 33.00;
            incometax = (0.25 * gross) + healthfee;
        } else if (gross <= 3000.00 && gross >= 2500.00) {
            healthfee = 19.20;
            incometax = (0.25 * gross) + healthfee;
        } else if (gross < 2500.00) {
            incometax = 19.20;
            return incometax;
        }

        return incometax;
    }

    public double netsalary() {
        double netsalary;
        double deductions = Deductions();
        double gross = Grosssal();
        netsalary = gross - deductions;
        return netsalary;
    }

    public String[] printslip() {
        String emptye = "Not Initialised";
        if (this.e.emptype == 'f' || this.e.emptype == 'F') {
            emptye = "Faculty";
        } else if (this.e.emptype == 'n' || this.e.emptype == 'N') {
            emptye = "Non-Faculty";
        }

        String[] sendprint = {"Employee Name: " + this.e.Firstname + " " + this.e.LastName, "Employee Id: " + Integer.toString(this.e.id), emptye, "Gross Salary: " + Double.toString(Grosssal()), "Deductions: " + Double.toString(Deductions()), "NetSalary: " + Double.toString(netsalary())};

        return sendprint;
    }

    @Override
    public String toString() {
        return "EmployeePaySlip{" + "e=" + e + '}';
    }

}
