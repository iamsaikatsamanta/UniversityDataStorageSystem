package mainPackage.Data;

public final class Teacher extends Employ {
    private String Speality;

    public Teacher(String name, String address, String number, String empid, String salary, String speality) {
        super(name, address, number, empid, salary);
        Speality = speality;
    }

    public String getSpeality() {
        return Speality;
    }

    public void setSpeality(String speality) {
        Speality = speality;
    }
}
