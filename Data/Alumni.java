package mainPackage.Data;

import javafx.beans.property.SimpleStringProperty;

public final class Alumni extends Person {

    private SimpleStringProperty email=new SimpleStringProperty("");
    private SimpleStringProperty passingyear=new SimpleStringProperty("");

    public Alumni(String name, String address, String number, String email, String passingyear) {
        super(name, address, number);
        this.email.set(email);
        this.passingyear.set(passingyear);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassingyear() {
        return passingyear.get();
    }

    public SimpleStringProperty passingyearProperty() {
        return passingyear;
    }

    public void setPassingyear(String passingyear) {
        this.passingyear.set(passingyear);
    }
}
