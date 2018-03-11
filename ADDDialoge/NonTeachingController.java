package mainPackage.ADDDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.Employ;
import mainPackage.Data.PersonData;

import java.util.ArrayList;

public class NonTeachingController {
    private ArrayList<String> empid=new ArrayList<>();
    private boolean flag=true;
    @FXML
    private TextField getname,getaddr,getno,getempid,getsal;

    public boolean processResults(){
        String name=getname.getText().trim();//Geting The Data from TextField
        String addr=getaddr.getText().trim();
        String phno=getno.getText().trim();
        String empid=getempid.getText();
        String sal=getsal.getText().trim();
        if (empid.isEmpty())
            return false;
        calempid();
        for (String anEmpid : this.empid) {
            if (empid.equals(anEmpid)) {
                flag = false;
                break;
            }
        }
        if(flag){
            Employ newItem=new Employ(name,addr,phno,empid,sal);//Create Employee Object
            PersonData.getInstance().addEmploy(newItem);//Add Object into ArrayList
            return true;
        }else {
            return false;
        }
    }
    public void update(Employ item){
        getname.setText(item.getName());//Setting The Data Into TextField
        getaddr.setText(item.getAddress());
        getno.setText(item.getNumber());
        getempid.setText(item.getEmpid());
        getempid.setDisable(true);
        getsal.setText(item.getSalary());


    }
    public boolean updateResult(Employ item){

        item.setName(getname.getText());//Updating the Result
        item.setAddress(getaddr.getText());
        item.setNumber(getno.getText());
        item.setSalary(getsal.getText());
        return true;
    }
    private void calempid(){//Geting Employee ID of Teacher,LabAssistant & Non Teaching Stuff
        empid=new ArrayList<>();
        for (int i=0;i<PersonData.getInstance().getTeachers().size();i++)
            empid.add(PersonData.getInstance().getTeachers().get(i).getEmpid());
        for (int i=0;i<PersonData.getInstance().getEmploys().size();i++)
            empid.add(PersonData.getInstance().getEmploys().get(i).getEmpid());
        for (int i=0;i<PersonData.getInstance().getLabAssistents().size();i++)
            empid.add(PersonData.getInstance().getLabAssistents().get(i).getEmpid());
    }
}