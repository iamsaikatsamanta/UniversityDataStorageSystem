package mainPackage.ADDDialoge;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import mainPackage.Data.ListController;
import mainPackage.Data.PersonData;
import mainPackage.Data.Student;

import java.util.List;

public class StudentController {
    private boolean flag=true;
    @FXML
    private TextField getname,getaddr,getno,getregno,getyear,getproname; //TextField Object
    @FXML
    private ComboBox<String> getCourse; //ComboBox Object
    public void initialize(){
        getCourse.setItems(ListController.getListController().getList3());//Set ComboBox List
        getyear.setDisable(true);
        getproname.setDisable(true);
    }
    @FXML
    public void handel(){
        String item=getCourse.getSelectionModel().getSelectedItem();//Geting The Selected Item in ComboBoc
        if(item.equals("PHD")) {
            initialize();
            getyear.clear();
            getproname.setDisable(false);
        }else{
            initialize();
            getproname.clear();
            getyear.setDisable(false);
        }

    }
    public boolean processResults(){
        String name=getname.getText().trim();//Geting The Data from TextField
        String addr=getaddr.getText().trim();
        String phno=getno.getText().trim();
        String regno=getregno.getText();
        String course= getCourse.getSelectionModel().getSelectedItem();
        String year=getyear.getText().trim()+" ";
        String proname=getproname.getText().trim()+" ";
        if (regno.isEmpty()) //Registration No Non Empty Check
            return false;
        for(int i=0;i<PersonData.getInstance().getStudents().size();i++){ //Registration No Validation Check at the time of Insert
            if(regno.equals(PersonData.getInstance().getStudents().get(i).getRegno())){
                flag=false;
                break;
            }
        }
        if(flag){
            Student newItem=new Student(name,addr,phno,regno,course,year,proname); //Create Student Object
            PersonData.getInstance().addStudent(newItem);//Add Object into ArrayList
            return true;
        }else {
            return false;
        }
    }
    public void update(Student item){
        getname.setText(item.getName());//Seting The Data Into TextField
        getaddr.setText(item.getAddress());
        getno.setText(item.getNumber());
        getregno.setText(item.getRegno());
        getregno.setDisable(true);
        getCourse.setValue(item.getCourse());
        if(getCourse.getSelectionModel().getSelectedItem().equals("PHD"))
            getproname.setDisable(false);
        else
            getyear.setDisable(false);
        getyear.setText(item.getYear());
        getproname.setText(item.getProject());
    }
    public boolean updateResult(Student item){
        item.setName(getname.getText());//Updating The Result
        item.setAddress(getaddr.getText());
        item.setNumber(getno.getText());
        item.setCourse(getCourse.getSelectionModel().getSelectedItem());
        item.setYear(getyear.getText());
        item.setProject(getproname.getText());
        return true;
    }

}
