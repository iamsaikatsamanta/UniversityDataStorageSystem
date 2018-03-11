package mainPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainPackage.Data.PersonData;
import mainPackage.Data.ResourceData;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));//Set The Parent Processes as the Main Window Of the Application
        primaryStage.setTitle("AKCSIT Informatation System");//Seting The Title
        primaryStage.setScene(new Scene(root, 1024, 720));//Setting Screen Resolution
        primaryStage.show();//Showing the Application
    }



    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void stop() throws Exception {//Execute When The Application is Closed
        try {
            PersonData.getInstance().storeStudentData();
            PersonData.getInstance().storeTeacherData();
            PersonData.getInstance().storeNonTeacherData();
            PersonData.getInstance().storeLabassistentData();
            PersonData.getInstance().storeAluminitData();
            ResourceData.getInstance().storeResourceData();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws IOException {//Execute Before The Application Even Run
        try {
            PersonData.getInstance().loadStudentData();
            PersonData.getInstance().loadTeacherData();
            PersonData.getInstance().loadNonTeacherData();
            PersonData.getInstance().loadLabassistantData();
            PersonData.getInstance().loadAluminiData();
            ResourceData.getInstance().loadResourceData();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
//Algorithm:Create the Class With Inheritance Take Input The Data And create object to store the Data and Store The object into ArrayList