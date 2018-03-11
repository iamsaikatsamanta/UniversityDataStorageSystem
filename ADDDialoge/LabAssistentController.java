package mainPackage.ADDDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.LabAssistent;
import mainPackage.Data.PersonData;

import java.util.ArrayList;

public class LabAssistentController {
    private ArrayList<String> empid=new ArrayList<>();
    private boolean flag=true;
    @FXML
    private TextField getname,getaddr,getno,getempid,getsal,getlabname;

    public boolean processResults(){
        String name=getname.getText().trim();//Geting The Data from TextField
        String addr=getaddr.getText().trim();
        String phno=getno.getText().trim();
        String empid=getempid.getText();
        String sal=getsal.getText().trim();
        String labname=getlabname.getText().trim();
        calempid();
        for (String anEmpid : this.empid) {//Check EmployId Is Unique of Not
            if (empid.equals(anEmpid)) {
                flag = false;
                break;
            }
        }
        if(flag){
            LabAssistent newItem=new LabAssistent(name,addr,phno,empid,sal,labname);//Create LabAssistant Object
            PersonData.getInstance().addLabAssistents(newItem);//Add Object into ArrayList
            return true;
        }else {
            return false;
        }
    }
    public void update(LabAssistent item){
        getname.setText(item.getName());//Seting The Data Into TextField
        getaddr.setText(item.getAddress());
        getno.setText(item.getNumber());
        getempid.setText(item.getEmpid());
        getempid.setDisable(true);
        getsal.setText(item.getSalary());
        getlabname.setText(item.getLabname());

    }
    public boolean updateResult(LabAssistent item){
        item.setName(getname.getText());//Updating the Result
        item.setAddress(getaddr.getText());
        item.setNumber(getno.getText());
        item.setSalary(getsal.getText());
        item.setLabname(getlabname.getText());

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
