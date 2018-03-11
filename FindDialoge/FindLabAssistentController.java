package mainPackage.FindDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.LabAssistent;
import mainPackage.Data.PersonData;

public class FindLabAssistentController {//Finding The Employee ID And Return the Object If Found Other wise Return Null
    @FXML
    private TextField getempid;
    public LabAssistent processResult(){
        String empid=getempid.getText();
        for(int i = 0; i< PersonData.getInstance().getLabAssistents().size(); i++){
            if(empid.equals(PersonData.getInstance().getLabAssistents().get(i).getEmpid())){
                return PersonData.getInstance().getLabAssistents().get(i);

            }
        }
        return null;
    }

}
