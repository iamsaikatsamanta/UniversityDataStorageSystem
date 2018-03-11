package mainPackage.Data;

public final class LabAssistent extends Employ{
    private String labname;

    public LabAssistent(String name, String address, String number, String empid, String salary, String labname) {
        super(name, address, number, empid, salary);
        this.labname = labname;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }
}
