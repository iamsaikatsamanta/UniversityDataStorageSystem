package mainPackage.Info;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainPackage.Data.PersonData;

public class TeacherInfoController {
    @FXML
    private TextField geteid;
    @FXML
    private  Label getname,getaddr,getno,getempid,getsal,getspecal;//Label Object
    private boolean flag=true;
    public void okpressed(){
        String regno=geteid.getText();
        for(int i = 0; i< PersonData.getInstance().getTeachers().size(); i++){//Finding The Teacher Record Based on Employee Id
            if(regno.equals(PersonData.getInstance().getTeachers().get(i).getEmpid())){//If Found Then Set the Label With the Data
                getname.setText(PersonData.getInstance().getTeachers().get(i).getName());
                getaddr.setText(PersonData.getInstance().getTeachers().get(i).getAddress());
                getno.setText(PersonData.getInstance().getTeachers().get(i).getNumber());
                getempid.setText(PersonData.getInstance().getTeachers().get(i).getEmpid());
                getsal.setText(PersonData.getInstance().getTeachers().get(i).getSalary());
                getspecal.setText(PersonData.getInstance().getTeachers().get(i).getSpeality());
                flag=false;
            }
        }
        if (flag){//If not Found Show an Informative Alert that Data is Not Found
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Teacher Data Not Found");
            alert.show();
        }
    }
}
