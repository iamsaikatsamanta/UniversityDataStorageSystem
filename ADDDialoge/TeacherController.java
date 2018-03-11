package mainPackage.ADDDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.PersonData;
import mainPackage.Data.Teacher;

import java.util.ArrayList;

public class TeacherController {
    private boolean flag=true;
    private ArrayList<String> empid;
    @FXML
    private TextField getname,getaddr,getno,getempid,getsal,getspecal;//TextField Object

    public boolean processResults(){
        String name=getname.getText().trim();//Geting The Data from TextField
        String addr=getaddr.getText().trim();
        String phno=getno.getText().trim();
        String empid=getempid.getText();
        String sal=getsal.getText().trim();
        String specal=getspecal.getText().trim();
        if(empid.isEmpty()) //Compare Employee ID is Empty or Not
            return false;
        calempid();
        for (String anEmpid : this.empid) { //Check EmployId Is Unique of Not
            if (empid.equals(anEmpid)) {
                flag = false;
                break;
            }
        }
        if(flag){
            Teacher newItem=new Teacher(name,addr,phno,empid,sal,specal);//Create Teacher Object
            PersonData.getInstance().addTeacher(newItem); //Add Object into ArrayList
            return true;
        }else {
            return false;
        }
    }
    public void update(Teacher item){
        getname.setText(item.getName());//Setting The Data Into TextField
        getaddr.setText(item.getAddress());
        getno.setText(item.getNumber());
        getempid.setText(item.getEmpid());
        getempid.setDisable(true);
        getsal.setText(item.getSalary());
        getspecal.setText(item.getSpeality());

    }
    public boolean updateResult(Teacher item){
        item.setName(getname.getText());//Updating the Result
        item.setAddress(getaddr.getText());
        item.setNumber(getno.getText());
        item.setSalary(getsal.getText());
        item.setSpeality(getspecal.getText());
        return true;
    }
    private void calempid(){ //Geting Employee ID of Teacher,LabAssistant & Non Teaching Stuff
        empid=new ArrayList<>();
        for (int i=0;i<PersonData.getInstance().getTeachers().size();i++)
            empid.add(PersonData.getInstance().getTeachers().get(i).getEmpid());
        for (int i=0;i<PersonData.getInstance().getEmploys().size();i++)
            empid.add(PersonData.getInstance().getEmploys().get(i).getEmpid());
        for (int i=0;i<PersonData.getInstance().getLabAssistents().size();i++)
            empid.add(PersonData.getInstance().getLabAssistents().get(i).getEmpid());
    }
}
