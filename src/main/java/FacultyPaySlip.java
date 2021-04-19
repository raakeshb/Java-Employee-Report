/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raake
 */
public class FacultyPaySlip extends EmployeePaySlip {

    public double hours;
    public char empltype;

    public FacultyPaySlip(Employee e) {
        super(e);
    }

    public FacultyPaySlip(Employee e, double hours) {
        super(e);
        this.hours = hours;
    }

    public FacultyPaySlip(double hours, char empltype, Employee e) {
        super(e);
        this.hours = hours;
        this.empltype = empltype;
    }

    public FacultyPaySlip() {
    }

    @Override
    public double Grosssal() {
        double monthly = 0;
        if (empltype == 'M') {
            monthly = (hours * 175) + 1500;
        } else if (empltype == 'B') {
            monthly = (hours * 100) + 600;
        }
        return monthly;
    }

    @Override
    public String toString() {
        return "FacultyPaySlip{" + "hours=" + hours + ", empltype=" + empltype + '}';
    }

}
