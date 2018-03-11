package mainPackage.Data;

public class Employ extends Person {
    private String empid;
    private String salary;

    public Employ(String name, String address, String number, String empid, String salary) {
        super(name, address, number);
        this.empid = empid;
        this.salary = salary;
    }

    public String getEmpid() {
        return empid;
    }

    public String getSalary() {
        return salary;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
