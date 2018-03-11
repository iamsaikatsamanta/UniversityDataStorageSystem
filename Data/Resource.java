package mainPackage.Data;

import javafx.beans.property.SimpleStringProperty;

public class Resource {
    private SimpleStringProperty name=new SimpleStringProperty("");
    private SimpleStringProperty quantity=new SimpleStringProperty("");

    public Resource(String name, String quantity) {
        this.name.set(name);
        this.quantity.set(quantity);
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

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }
}
