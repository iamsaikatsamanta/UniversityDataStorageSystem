package mainPackage.Data;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty name=new SimpleStringProperty("");
    private SimpleStringProperty Address=new SimpleStringProperty("");
    private SimpleStringProperty number=new SimpleStringProperty("");

    public Person(String name, String address, String number) {
        this.name.set(name);
        this.Address.set(address);
        this.number.set(number);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return Address.get();
    }

    public SimpleStringProperty addressProperty() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }
}
