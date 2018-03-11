package mainPackage.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListController {

    private ObservableList<String>  list1= FXCollections.observableArrayList();
    private ObservableList<String>  list2= FXCollections.observableArrayList();
    private ObservableList<String>  list3= FXCollections.observableArrayList();


    private static ListController listController =new ListController();
    private ListController() {

        list1.add("Person's Informatation");
        list1.add("Rescorce Iformatation");
        list2.add("Student");
        list2.add("Teacher");
        list2.add("Non-Teaching Stuff");
        list2.add("LabAssistent");
        list2.add("Alumni");
        list3.add("B.Tech");
        list3.add("M.Tech");
        list3.add("MCA");
        list3.add("PHD");

    }

    public ObservableList<String> getList1() {
        return list1;
    }


    public ObservableList<String> getList2() {
        return list2;
    }

    public ObservableList<String> getList3() {
        return list3;
    }

    public static ListController getListController() {
        return listController;
    }

}
