package mainPackage.Info;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mainPackage.ADDDialoge.ResourceController;
import mainPackage.Data.Resource;
import mainPackage.Data.ResourceData;

import java.io.IOException;
import java.util.Optional;

public class ResourceInfoController {
    @FXML
    TableView<Resource> resourceTable;
    @FXML
    DialogPane resourcePain;

    public void initialize() {
        resourceTable.setItems(ResourceData.getInstance().getRescorces());
    }

    public void ondel() { //This Method Will Handel the  Work when User Press Delete Button
        Resource item = resourceTable.getSelectionModel().getSelectedItem();
        if (item != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Are You Sure To Delete");
            alert.setContentText(item.getName());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK)
                ResourceData.getInstance().removeRecorce(item);
        }
    }

    public void onupdate() { //This Method Will Handel the  Work when User Press Update Button
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(resourcePain.getScene().getWindow());
        dialog.setTitle("Update");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Resource.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Resource item = resourceTable.getSelectionModel().getSelectedItem();
        if (item!=null){
            ResourceController controller = fxmlLoader.getController();
            controller.updateview(item);
            Optional<ButtonType> result = dialog.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                controller.update(item);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update");
                alert.setHeaderText(null);
                alert.setContentText("Update Sucessfull");
                alert.showAndWait();
            }
        }
    }
    @FXML
    public void keyPressed(KeyEvent keyevent){ //If User Press DELETE key This Method Will Delete the Selected Item
        Resource item=resourceTable.getSelectionModel().getSelectedItem();
        if (item!=null){
            if (keyevent.getCode().equals(KeyCode.DELETE)){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete");
                alert.setHeaderText("Are Yoy Sure To Delete");
                alert.setContentText(item.getName());
                Optional result=alert.showAndWait();
                if (result.isPresent() && (result.get()==ButtonType.OK))
                    ResourceData.getInstance().removeRecorce(item);
            }
        }
    }
}
