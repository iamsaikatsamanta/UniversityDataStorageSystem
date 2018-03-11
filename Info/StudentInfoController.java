package mainPackage.Info;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainPackage.Data.PersonData;


public class StudentInfoController {
    @FXML
    TextField getregno;
    @FXML
    Label getname,getaddr,getno,getregisno,getcourse,getyear,getproname;
    private boolean flag=true;
    public void okpressed(){
        String regno=getregno.getText();
        for(int i=0;i< PersonData.getInstance().getStudents().size();i++){//Finding The Teacher Record Based on Registration No
            if(regno.equals(PersonData.getInstance().getStudents().get(i).getRegno())){//If Found Then Set the Label With the Data
                getname.setText(PersonData.getInstance().getStudents().get(i).getName());
                getaddr.setText(PersonData.getInstance().getStudents().get(i).getAddress());
                getno.setText(PersonData.getInstance().getStudents().get(i).getNumber());
                getregisno.setText(PersonData.getInstance().getStudents().get(i).getRegno());
                getcourse.setText(PersonData.getInstance().getStudents().get(i).getCourse());
                getyear.setText(PersonData.getInstance().getStudents().get(i).getYear());
                getproname.setText(PersonData.getInstance().getStudents().get(i).getProject());
                flag=false;
            }
        }
        if (flag){//If not Found Show an Informative Alert that Data is Not Found
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText("Student Data Not Found");
            alert.show();
        }
    }
}
