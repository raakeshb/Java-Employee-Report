/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raake
 */
public class NonFacultyPaySlip extends EmployeePaySlip {

    public double hours;
    public double Monthsal;

    public NonFacultyPaySlip(Employee e) {
        super(e);
    }

    public NonFacultyPaySlip(double hours, double Monthsal, Employee e) {
        super(e);
        this.hours = hours;
        this.Monthsal = Monthsal;
    }

    public NonFacultyPaySlip() {
    }

    @Override
    public String toString() {
        return "NonFacultyPaySlip{" + "hours=" + hours + ", Monthsal=" + Monthsal + '}';
    }

    @Override
    public double Grosssal() {
        double monthly = 0;
        double employeehrrate = 0;
        if (hours < 160) {
            employeehrrate = Monthsal / 160;
            monthly = this.hours * employeehrrate;
        } else if (hours == 160) {
            monthly = Monthsal;
        } else if (hours > 160) {
            employeehrrate = Monthsal / 160;
            monthly = ((employeehrrate * 2) * (hours - 160)) + Monthsal;

        }

        return monthly;
    }

}
