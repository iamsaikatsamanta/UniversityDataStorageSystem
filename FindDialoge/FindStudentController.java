package mainPackage.FindDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.PersonData;
import mainPackage.Data.Student;

public class FindStudentController {
    @FXML
    private TextField getregno;


    public Student processResult(){//Finding The Registration No And Return the Object If Found Other wise Return Null
        String regno = getregno.getText();
        for(int i=0;i< PersonData.getInstance().getStudents().size();i++){
            if(regno.equals(PersonData.getInstance().getStudents().get(i).getRegno())){
                return PersonData.getInstance().getStudents().get(i);

            }
        }
        return null;
    }

}
