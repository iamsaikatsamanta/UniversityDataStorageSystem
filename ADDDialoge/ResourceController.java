package mainPackage.ADDDialoge;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import mainPackage.Data.ResourceData;
import mainPackage.Data.Resource;

public class ResourceController {
    @FXML
    private TextField getname,getquantity;//Text Field Variable
    public boolean processResults(){
        String name=getname.getText().trim();//Trim for taking the Space Also
        String quty=getquantity.getText().trim();
        Resource item=new Resource(name,quty);
        ResourceData.getInstance().addRecorce(item);
        return true;
    }
    public void updateview(Resource item){
        getname.setText(item.getName());//Setting The Data Into TextField
        getquantity.setText(item.getQuantity());
    }
    public void update(Resource item){
        item.setName(getname.getText());//Updating the Result
        item.setQuantity(getquantity.getText());
    }
}
