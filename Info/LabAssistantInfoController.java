package mainPackage.Info;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mainPackage.Data.PersonData;

public class LabAssistantInfoController {
        @FXML
        private TextField geteid;
        @FXML
        private Label getname,getaddr,getno,getempid,getsal,getlabname;
        private boolean flag=true;
        public void okpressed(){
            String regno=geteid.getText();
            for(int i = 0; i< PersonData.getInstance().getLabAssistents().size(); i++){
                if(regno.equals(PersonData.getInstance().getLabAssistents().get(i).getEmpid())){
                    getname.setText(PersonData.getInstance().getLabAssistents().get(i).getName());
                    getaddr.setText(PersonData.getInstance().getLabAssistents().get(i).getAddress());
                    getno.setText(PersonData.getInstance().getLabAssistents().get(i).getNumber());
                    getempid.setText(PersonData.getInstance().getLabAssistents().get(i).getEmpid());
                    getsal.setText(PersonData.getInstance().getLabAssistents().get(i).getSalary());
                    getlabname.setText(PersonData.getInstance().getLabAssistents().get(i).getLabname());
                    flag=false;
                }
            }
            if (flag){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Teacher Data Not Found");
                alert.show();
            }
        }
}
