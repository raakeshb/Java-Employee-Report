/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raake
 */
public class Employee {

    protected String Firstname;
    protected String LastName;
    protected int id;
    protected char emptype;

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getEmptype() {
        return emptype;
    }

    public void setEmptype(char emptype) {
        this.emptype = emptype;
    }

    public Employee() {
    }

    public Employee(String Firstname, String LastName, int id, char emptype) {
        this.Firstname = Firstname;
        this.LastName = LastName;
        this.id = id;
        this.emptype = emptype;
    }

    @Override
    public String toString() {
        return "Employee{" + "Firstname=" + Firstname + ", LastName=" + LastName + ", id=" + id + ", emptype=" + emptype + '}';
    }

}
