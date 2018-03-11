package mainPackage.FindDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.Employ;
import mainPackage.Data.PersonData;

public class FindEmployController {
        @FXML
        private TextField getempid;
        public Employ processResult(){ //Finding The Employee ID And Return the Object If Found Other wise Return Null
            String empid=getempid.getText();
            for(int i = 0; i< PersonData.getInstance().getEmploys().size(); i++){
                if(empid.equals(PersonData.getInstance().getEmploys().get(i).getEmpid())){
                    return PersonData.getInstance().getEmploys().get(i);

                }
            }
            return null;
        }

}
