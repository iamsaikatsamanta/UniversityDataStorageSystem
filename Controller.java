package mainPackage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import mainPackage.ADDDialoge.*;
import mainPackage.Data.*;
import mainPackage.FindDialoge.FindEmployController;
import mainPackage.FindDialoge.FindLabAssistentController;
import mainPackage.FindDialoge.FindStudentController;
import mainPackage.FindDialoge.FindTeacherController;

import java.io.IOException;
import java.util.Optional;

public class Controller {


    @FXML
    private ListView<String> llistview;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Label text;
    @FXML
    private TextArea info;
    @FXML
    private ImageView imageView;
    private boolean flag;


    public void initialize() {
        Image image=new Image("/mainPackage/UCSTA.jpg");//Create Image Object
        imageView.setImage(image);//Set The Image
        imageView.getFitWidth();
        llistview.getItems().setAll(ListController.getListController().getList1());//Set The Left List
        llistview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);//Seting the Selection Mode Into Single
        info.setText("\n\n\n\n\n\n\n" +
                "\t\t\t\tThe A.K.Choudhury School of Information Technology is situated in the Technology Campus," +
                "University of Calcutta,\n\t and is dedicated to Prof. A.K.Choudhury(1923-1987). Started as a Computer " +
                "Centre of the University in 2001,the school emerged as a\n\t full fledged department in 2005. " +
                "The department runs MCA ,B.Tech , M.Tech in Information Technology  and M.Tech in Computer\n\t Science " +
                "and Application (3 year part-time) courses. It has always been an effort of the department impart the " +
                "state of the art training\n\t of the students by the way of establishing ultramodern laboratories and latest " +
                "hardware and software platforms. Syllabi of the department\n\t are constantly updated to meet the requirements of " +
                "the Industry. The department has a strong emphasis on research, lead by the faculties\n\t of the department " +
                ", which provides the students an excellent opportunity to train up the state of the art system sand related " +
                "technologies.\n\t Embedded System Design, VLSI Design , Quantum Computing, Wireless Networks, Network Security ," +
                "Computer Vision, Database System,\n\t Data Warehousing and Bio-Medical Image Processing are some Key research " +
                "areas of the department.     ");


    }
    @FXML
    public void handelclick(){//On Mouse clicked On left List
        try {
            String item=llistview.getSelectionModel().getSelectedItem();//If Person's Information is selected then Option arrive
            if(item.equals(ListController.getListController().getList1().get(0))){
                llistview.getItems().setAll(ListController.getListController().getList2());
                llistview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            }
        }catch (Exception e){
            text.setText("Select The Correct Item");
        }

    }
    @FXML
    public void add() {//Clicking the Add Button
        try {
            String item = llistview.getSelectionModel().getSelectedItem();//Getting The Selected Item form the Left List
            if (item.equals(ListController.getListController().getList1().get(1)))
                recorceItemDialog();//If Student is selected
            else if (item.equals(ListController.getListController().getList2().get(0)))
                studentItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(1)))
                teacherItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(2)))
                nonteachingItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(3)))
                labassistentItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(4)))
                    aluminiItemDialog();
        } catch (Exception e) {
            text.setText("Select The Currect Item");
        }
    }
    @FXML
    public void delete() {//If deleted Button is Pressed
        try {
            String item = llistview.getSelectionModel().getSelectedItem();
            if(item.equals(ListController.getListController().getList1().get(1)))
                uprecorceItemDialog();
            else if(item.equals(ListController.getListController().getList2().get(0)))
                delstudentItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(1)))
                delteacherItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(2)))
                delnonteachingItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(3)))
                dellabassistentItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(4)))
                findAlumini();
        } catch (Exception e) {
            text.setText("Select The Currect Item");
        }

    }
    @FXML
    public void update() {//If Update Button is Pressed
        try {
            String item = llistview.getSelectionModel().getSelectedItem();
            if (item.equals(ListController.getListController().getList1().get(1)))
                uprecorceItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(0)))
                upstudentItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(1)))
                upteacherItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(2)))
                upnonteachingItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(3)))
                uplabassistentItemDialog();
            else if (item.equals(ListController.getListController().getList2().get(4)))
                findAlumini();

        } catch(Exception e){
                text.setText("Select The Currect Item");
            }
    }
    @FXML
    public void getInfo(){//If Get Information  Button is Pressed
        try {
            String item=llistview.getSelectionModel().getSelectedItem();
            if(item.equals(ListController.getListController().getList1().get(1)))
                getResourceInfo();
            else if(item.equals(ListController.getListController().getList2().get(0)))
                studentInfo();
            else if (item.equals(ListController.getListController().getList2().get(1)))
                teacheInfo();
            else if(item.equals(ListController.getListController().getList2().get(2)))
                nonTeachingInfo();
            else if (item.equals(ListController.getListController().getList2().get(3)))
                labassistantInfo();
            else if (item.equals(ListController.getListController().getList2().get(4)))
                alumniInfo();
        }catch (Exception e){
            text.setText("Select The Correct Item");
        }
    }


    private void studentItemDialog() {//Adding A Student Record
        Dialog<ButtonType> dialog = new Dialog<>();//Dialog Object For Loading A dialog Box Containing Button
        dialog.initOwner(mainBorderPane.getScene().getWindow());//Setting The Dialog Owner
        dialog.setTitle("Add New Student Record");//Setting Dialog Title
        FXMLLoader fxmlLoader = new FXMLLoader();//FXMLLoader Object To Load FXML File
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Student.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());//Fxml File Location Setting

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);//Setting Button
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();//Showing the Dialog and Wait for the Event to Happened
        if (result.isPresent() && result.get() == ButtonType.OK) {
            StudentController controller = fxmlLoader.getController();//Creating StudentController Object
            boolean state = controller.processResults();//Getting The result
            if (state)
                text.setText("Record Added Sucessfully");
            else text.setText("Registration Number Must Be Unique or Non-Empty");
        }
    }

    private void teacherItemDialog() {//Adding A Teacher Record Same as Student
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Teacher Record");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Teacher.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            TeacherController controller = fxmlLoader.getController();
            boolean state = controller.processResults();
            if (state)
                text.setText("Record Added Sucessfully");
            else text.setText("Employ Id Must be Unique or Non Empty");
        }
    }

    private void nonteachingItemDialog() {//Adding A Non-Teaching Stuff Record Same as Student
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Stuff Record");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/NonTeaching.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            NonTeachingController controller = fxmlLoader.getController();
            boolean state = controller.processResults();
            if (state)
                text.setText("Record Added Sucessfully");
            else text.setText("Employ Id Must be Unique ");
        }
    }

    private void labassistentItemDialog() {//Adding A LabAssistant Record Same as Student
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Lab Assistent Record");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/LabAssistent.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            LabAssistentController controller = fxmlLoader.getController();
            boolean state = controller.processResults();
            if (state)
                text.setText("Record Added Sucessfully");
            else text.setText("Employ Id Must be Unique ");
        }
    }

    private void aluminiItemDialog() {//Adding A Alumni Record Same as Student
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Alumini Record");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Alumni.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AlumniController controller = fxmlLoader.getController();
            boolean state = controller.processResults();
            if (state)
                text.setText("Record Added Sucessfully");
        }
    }

    private void recorceItemDialog() {//Adding A Resource Record Same as Student
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Resource Record");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Resource.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            ResourceController controller = fxmlLoader.getController();
            boolean state = controller.processResults();
            if (state)
                text.setText("Record Added Sucessfully");
        }
    }

    private void delstudentItemDialog() {//Deleting A Student Record
        Student item = findStudent();//Finding The Correct Student Object
        if (!flag)
            return;
        if (item != null) {//If Object is NOn NULL
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Alert CONFIRMATION Dialog
            alert.setTitle("Delete");
            alert.setHeaderText("Are You Sure To Delete");
            alert.setContentText(item.getName());
            Optional<ButtonType> res = alert.showAndWait();
            if (res.isPresent() && (res.get() == ButtonType.OK)) {
                PersonData.getInstance().removeStudent(item);
                text.setText("Delete Sucessfull");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setContentText("Student Not Found");
            alert.show();
        }
    }

    private void delteacherItemDialog() {//Deleting A Teacher Record
        Teacher item = findTeacher();
        if (!flag)
            return;
        if (item != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Are You Sure To Delete");
            alert.setContentText(item.getName());
            Optional<ButtonType> res = alert.showAndWait();
            if (res.isPresent() && (res.get() == ButtonType.OK)) {
                PersonData.getInstance().removeTeacher(item);
                text.setText("Delete Sucessfull");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setContentText("Teacher Not Found");
            alert.show();
        }
    }

    private void delnonteachingItemDialog() {//Deleting A Non-Teaching Stuff Record
        Employ item = findnonteaching();
        if (!flag)
            return;
        if (item != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Are You Sure To Delete");
            alert.setContentText(item.getName());
            Optional<ButtonType> res = alert.showAndWait();
            if (res.isPresent() && (res.get() == ButtonType.OK)) {
                PersonData.getInstance().removeEmploy(item);
                text.setText("Delete Sucessfull");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setContentText("Non Teaching Stuff Not Found");
            alert.show();
        }
    }

    private void dellabassistentItemDialog() {//Deleting A Lab Assistant Record
        LabAssistent item = findllabAssistant();
        if (!flag)
            return;
        if (item != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete");
            alert.setHeaderText("Are You Sure To Delete");
            alert.setContentText(item.getName());
            Optional<ButtonType> res = alert.showAndWait();
            if (res.isPresent() && (res.get() == ButtonType.OK)) {
                PersonData.getInstance().removeLabAssistents(item);
                text.setText("Delete Sucessfull");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setContentText("Lab Assistent  Not Found");
            alert.show();
        }
    }

    private void upstudentItemDialog() {//Update a Student
        Student item = findStudent();//Finding The Correct Student Object
        if (!flag)
            return;
        if (item != null) {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainBorderPane.getScene().getWindow());
            dialog.setTitle("Update");
            FXMLLoader fxmlLoader1 = new FXMLLoader();
            fxmlLoader1.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Student.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader1.load());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            StudentController controller = fxmlLoader1.getController();
            controller.update(item);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Optional<ButtonType> result1 = dialog.showAndWait();
            if (result1.isPresent() && (result1.get() == ButtonType.OK)) {
                boolean s = controller.updateResult(item);
                if (s)
                    text.setText("Update Sucessfull");
                else
                    text.setText("Registration Number Must Be Unique Or Non Empty");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText(null);
            alert.setContentText("Student Not Found");
            alert.show();
        }
    }

    private void upteacherItemDialog() {//Update a Teacher
        Teacher item = findTeacher();//Finding The Correct Teacher
        if (!flag)
            return;
        if (item != null) {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainBorderPane.getScene().getWindow());
            dialog.setTitle("Update");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/Teacher.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            TeacherController controller = fxmlLoader.getController();
            controller.update(item);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Optional<ButtonType> result1 = dialog.showAndWait();
            if (result1.isPresent() && (result1.get() == ButtonType.OK)) {
                boolean s = controller.updateResult(item);
                if (s)
                    text.setText("Update Sucessfull");
                else
                    text.setText("Employ ID Must be Unique Or Non Empty");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText(null);
            alert.setContentText("Teacher Not Found");
            alert.show();
        }
    }

    private void upnonteachingItemDialog() {//Update a Non-Teaching Stuff
        Employ item = findnonteaching();
        if (!flag)
            return;
        if (item != null) {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainBorderPane.getScene().getWindow());
            dialog.setTitle("Update");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/NonTeaching.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            NonTeachingController controller = fxmlLoader.getController();
            controller.update(item);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Optional<ButtonType> result1 = dialog.showAndWait();
            if (result1.isPresent() && (result1.get() == ButtonType.OK)) {
                boolean s = controller.updateResult(item);
                if (s)
                    text.setText("Update Sucessfull");
                else
                    text.setText("Employ ID Must be Unique Or Non Empty");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText(null);
            alert.setContentText("Non Teaching Stuff  Not Found");
            alert.show();
        }
    }

    private void uplabassistentItemDialog() {////Update a LabAssistant
        LabAssistent item = findllabAssistant();
        if (!flag)
            return;
        if (item != null) {
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(mainBorderPane.getScene().getWindow());
            dialog.setTitle("Update");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/mainPackage/ADDDialoge/LabAssistent.fxml"));
            try {
                dialog.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            LabAssistentController controller = fxmlLoader.getController();
            controller.update(item);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Optional<ButtonType> result1 = dialog.showAndWait();
            if (result1.isPresent() && (result1.get() == ButtonType.OK)) {
                boolean s = controller.updateResult(item);
                if (s)
                    text.setText("Update Sucessfull");
                else
                    text.setText("Employ ID Must be Unique Or Non Empty");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete");
            alert.setHeaderText(null);
            alert.setContentText("Non Teaching Stuff  Not Found");
            alert.show();
        }
    }

    private Student findStudent() {
        flag = true;
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Find");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/FindDialoge/DelStudent.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            FindStudentController controller = fxmlLoader.getController();
            return controller.processResult();
        } else {
            flag = false;
            return null;
        }

    }

    private Teacher findTeacher() {
        flag = true;
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Delete Teacher Record");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/FindDialoge/DelTeacher.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return null;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            FindTeacherController controller = fxmlLoader.getController();
            return controller.processResult();
        } else {
            flag = false;
            return null;
        }
    }

    private Employ findnonteaching() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Find");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/FindDialoge/DelEmploy.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return null;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            FindEmployController controller = fxmlLoader.getController();
            return controller.processResult();
        }else {
            flag=false;
            return null;
        }

    }

    private LabAssistent findllabAssistant() {
        flag = true;
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Find");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/FindDialoge/DelLabAssistent.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return null;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            FindLabAssistentController controller = fxmlLoader.getController();
            return controller.processResult();
        }else {
            flag=false;
            return null;
        }

    }

    private void findAlumini() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Or Update Alumini");
        alert.setHeaderText("You Cannot Update or Delete Alumini From Here");
        alert.setContentText("To Update Or Delete Click On Get Informatation");
        alert.showAndWait();
    }
    private void uprecorceItemDialog(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Or Update Alumini");
        alert.setHeaderText("You Cannot Update or Delete Resource Information From Here");
        alert.setContentText("To Update Or Delete Click On Get Information");
        alert.showAndWait();
    }
    private void getResourceInfo(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Resource Informatation");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/Info/ResourceInfo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        Optional result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
            dialog.close();

    }
    private void studentInfo() {
        Dialog dialog=new Dialog();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Student Information");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/Info/StudentInfo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Optional result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
            dialog.close();
    }
    private void teacheInfo(){
        Dialog dialog=new Dialog();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Teacher Information");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/Info/TeacherInfo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Optional result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
            dialog.close();
    }
    private void nonTeachingInfo(){
        Dialog dialog=new Dialog();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Non-Teaching Stuff Information");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/Info/NonTeachingInfo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Optional result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
            dialog.close();
    }
    private void labassistantInfo(){
        Dialog dialog=new Dialog();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("LabAssistant Information");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/Info/LabAssistantInfo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Optional result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
            dialog.close();
    }
    private void alumniInfo(){
        Dialog dialog=new Dialog();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Alumni Information");
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/mainPackage/Info/AlumniInfo.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        }catch (IOException e){
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        Optional result=dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK)
            dialog.close();
    }
}