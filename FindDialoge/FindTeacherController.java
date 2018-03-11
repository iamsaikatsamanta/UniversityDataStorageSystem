package mainPackage.FindDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.PersonData;
import mainPackage.Data.Teacher;


public class FindTeacherController {
    @FXML
    private TextField getempid;
    public Teacher processResult(){//Finding The Employee ID And Return the Object If Found Other wise Return Null
        String empid=getempid.getText();
        for(int i = 0; i< PersonData.getInstance().getTeachers().size(); i++){
            if(empid.equals(PersonData.getInstance().getTeachers().get(i).getEmpid())){
                return PersonData.getInstance().getTeachers().get(i);

            }
        }
        return null;
    }

}
