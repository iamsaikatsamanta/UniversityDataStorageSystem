package mainPackage.Info;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mainPackage.ADDDialoge.AlumniController;
import mainPackage.Data.Alumni;
import mainPackage.Data.PersonData;

import java.io.IOException;
import java.util.Optional;

public class AlumniInfoController {
    @FXML
    private TableView<Alumni> alumniTable;
    @FXML
    private DialogPane AlumniPain;
    public void initialize(){
        alumniTable.setItems((PersonData.getInstance().getAlumni()));
    }
    public void ondel(){ //This Method Will Handel the  Work when User Press Delete Button
        Alumni item=alumniTable.getSelectionModel().getSelectedItem();//Give The Alumni Object witch is Selected
        if(item!=null) {//If item is Non Null It Gives an CONFIRMATION Alert
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Are You Sure To Delete");
            alert.setContentText(item.getName());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK)
                PersonData.getInstance().removeAlumini(item);//Remove The Object That is The The Data Also
        }
    }
    public void onupdate() { //This Method Will Handel the  Work when User Press Update Button
        Dialog<ButtonType> dialog = new Dialog<>();//Dialog Object For Loading A dialog Box Containing Button
        dialog.initOwner(AlumniPain.getScene().getWindow());//Setting The Dialog Owner
        dialog.setTitle("Update");//Setting Dialog Title
        FXMLLoader fxmlLoader = new FXMLLoader();//FXMLLoader Object To Load FXML File
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Alumni.fxml"));//Fxml File Location Setting
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());//Load FXML File
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);//Setting Button
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Alumni item = alumniTable.getSelectionModel().getSelectedItem();//Give The Alumni Object witch is Selected
        if(item!=null){
            AlumniController controller = fxmlLoader.getController();//Creating AlumniController Object
            controller.updateview(item);//Setting The Update View
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update");
            alert.setHeaderText(null);
            Optional<ButtonType> result = dialog.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {//If The Ok Button Is Pressed then
                controller.update(item);//Updating the Result
                alert.setContentText("Update Sucessfull");
                alert.showAndWait();//Showing The Information that Update is Finished
            }
        }

    }
    @FXML
    public void keyPressed(KeyEvent keyevent){ //If User Press DELETE key This Method Will Delete the Selected Item
        Alumni item=alumniTable.getSelectionModel().getSelectedItem();//Give The Alumni Object witch is Selected
        if (item!=null){
            if (keyevent.getCode().equals(KeyCode.DELETE)){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete");
                alert.setHeaderText("Are Yoy Sure To Delete");
                alert.setContentText(item.getName());
                Optional result=alert.showAndWait();
                if (result.isPresent() && (result.get()==ButtonType.OK))
                    PersonData.getInstance().removeAlumini(item);
            }
        }
    }
}

