package mainPackage.ADDDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.Alumni;
import mainPackage.Data.PersonData;

public class AlumniController {
    @FXML
    private TextField getname,getaddr,getno,getemail,getyear;
    public boolean processResults(){
        String name=getname.getText().trim();//Geting The Data from TextField
        String addr=getaddr.getText().trim();
        String phno=getno.getText().trim();
        String email=getemail.getText().trim();
        String year=getyear.getText().trim();
        Alumni newItem=new Alumni(name,addr,phno,email,year);
        PersonData.getInstance().addAlumini(newItem);
        return true;

    }
    public void updateview(Alumni item){
        getname.setText(item.getName());//Setting The Data Into TextField
        getaddr.setText(item.getAddress());
        getno.setText(item.getNumber());
        getemail.setText(item.getEmail());
        getyear.setText(item.getPassingyear());
    }
    public void update(Alumni item){
        item.setName(getname.getText());//Updating The Results
        item.setAddress(getaddr.getText());
        item.setNumber(getno.getText());
        item.setEmail(getemail.getText());
        item.setPassingyear(getyear.getText());
    }

}
