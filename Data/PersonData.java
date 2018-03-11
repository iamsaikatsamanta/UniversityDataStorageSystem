package mainPackage.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class PersonData {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Employ> employs;
    private ArrayList<LabAssistent> labAssistents;
    private ObservableList<Alumni> alumni;
    private static PersonData instance=new PersonData();
    private String stud="students.txt",Emp="Employ.txt",teach="Teacher.txt",labass="Labasstant.txt",alum="Alumini.txt";
    private static BufferedReader br;
    private static BufferedWriter bw;

    private PersonData(){ //Restrict User For Farther Object Creation
        students=new ArrayList<>();
        teachers=new ArrayList<>();
        employs=new ArrayList<>();
        labAssistents=new ArrayList<>();
        alumni = FXCollections.observableArrayList();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public ArrayList<Employ> getEmploys() {
        return employs;
    }
    public ArrayList<LabAssistent> getLabAssistents() { return labAssistents; }
    public ObservableList<Alumni> getAlumni() { return alumni; }
    public static PersonData getInstance() {
        return instance;
    } // For Geting the Private Objet
    public void addStudent(Student item){
        students.add(item);
    }
    public void addTeacher(Teacher item){
        teachers.add(item);
    }
    public void addEmploy(Employ item){ employs.add(item);}
    public void addLabAssistents(LabAssistent item){ labAssistents.add(item);}
    public void addAlumini(Alumni item){
        alumni.add(item);}
    public void removeStudent(Student item){
        students.remove(item);
    }
    public void removeTeacher(Teacher item){
        teachers.remove(item);
    }
    public void removeEmploy(Employ item){ employs.remove(item);}
    public void removeLabAssistents(LabAssistent item){ labAssistents.remove(item);}
    public void removeAlumini(Alumni item){
        alumni.remove(item);}
    public void storeStudentData() throws IOException{ //Add Student Record Into File
        Path path= Paths.get(stud);//Setting The Path Object
        bw= Files.newBufferedWriter(path);//In Files Class newBuffenewBufferedWriter Method Takes Path Object Open the File And Returns BufferedWriter Object to Write the File
        try {
            Iterator<Student> iterator;
            iterator = students.iterator();//Getting Students ArrayList Framework
            while (iterator.hasNext()){
                Student item=iterator.next();//Getting The Next Element
                bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s",item.getName(),item.getAddress(),item.getNumber(),item.getRegno(),item.getCourse(),item.getYear(),item.getProject())); //Write on the File
                bw.newLine();
            }
        }finally {
            if(bw!=null) bw.close();
        }
    }
    public void loadStudentData()throws IOException{//Load Student Record From File
        Path path = Paths.get(stud);//Setting The Path Object
        br = Files.newBufferedReader(path);//In Files Class newBuffenewBufferedReader Method Takes Path Object Open the File And Returns BufferedReader Object to Write the File

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");//

                String Name =itemPieces[0],Address=itemPieces[1],Number=itemPieces[2],Regno=itemPieces[3],Course=itemPieces[4],Year=itemPieces[5],Project=itemPieces[6];
                Student newstudent=new Student(Name,Address,Number,Regno,Course,Year,Project);
                students.add(newstudent);

            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }
    public void storeTeacherData() throws IOException{//Add Teacher Record Into File
        Path path= Paths.get(teach);
        bw= Files.newBufferedWriter(path);
        try {
            Iterator<Teacher> iterator;
            iterator = teachers.iterator();
            while (iterator.hasNext()){
                Teacher item=iterator.next();
                bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",item.getName(),item.getAddress(),item.getNumber(),item.getEmpid(),item.getSalary(),item.getSpeality()));
                bw.newLine();
            }
        }finally {
            if(bw!=null) bw.close();
        }
    }
    public void loadTeacherData()throws IOException{//Load Teacher Record From File
        Path path = Paths.get(teach);
        br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String Name =itemPieces[0],Address=itemPieces[1],Number=itemPieces[2],Empid=itemPieces[3],Sal=itemPieces[4],Specal=itemPieces[5];
                Teacher newteacher=new Teacher(Name,Address,Number,Empid,Sal,Specal);
                teachers.add(newteacher);

            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }
    public void storeNonTeacherData() throws IOException{//Add NonTeacher Record Into File
        Path path= Paths.get(Emp);
        bw= Files.newBufferedWriter(path);
        try {
            Iterator<Employ> iterator;
            iterator = employs.iterator();
            while (iterator.hasNext()){
                Employ item=iterator.next();
                bw.write(String.format("%s\t%s\t%s\t%s\t%s",item.getName(),item.getAddress(),item.getNumber(),item.getEmpid(),item.getSalary()));
                bw.newLine();
            }
        }finally {
            if(bw!=null) bw.close();
        }
    }
    public void loadNonTeacherData()throws IOException{//Load NonTeacher Record From File
        Path path = Paths.get(Emp);
        br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String Name =itemPieces[0],Address=itemPieces[1],Number=itemPieces[2],Empid=itemPieces[3],Sal=itemPieces[4];
                Employ newNonteacher=new Employ(Name,Address,Number,Empid,Sal);
                employs.add(newNonteacher);

            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }
    public void storeLabassistentData() throws IOException{//Add Lab Assistent Record Into File
        Path path= Paths.get(labass);
        bw= Files.newBufferedWriter(path);
        try {
            Iterator<LabAssistent> iterator;
            iterator = labAssistents.iterator();
            while (iterator.hasNext()){
                LabAssistent item=iterator.next();
                bw.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",item.getName(),item.getAddress(),item.getNumber(),item.getEmpid(),item.getSalary(),item.getLabname()));
                bw.newLine();
            }
        }finally {
            if(bw!=null) bw.close();
        }
    }
    public void loadLabassistantData()throws IOException{//Load Lab Assistent Record From File
        Path path = Paths.get(labass);
        br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String Name =itemPieces[0],Address=itemPieces[1],Number=itemPieces[2],Empid=itemPieces[3],Sal=itemPieces[4],labname=itemPieces[5];
                LabAssistent newteacher=new LabAssistent(Name,Address,Number,Empid,Sal,labname);
                labAssistents.add(newteacher);

            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }
    public void storeAluminitData() throws IOException{//Add Alumini Record Into File
        Path path= Paths.get(alum);
        bw= Files.newBufferedWriter(path);
        try {
            Iterator<Alumni> iterator;
            iterator = alumni.iterator();
            while (iterator.hasNext()){
                Alumni item=iterator.next();
                bw.write(String.format("%s\t%s\t%s\t%s\t%s",item.getName(),item.getAddress(),item.getNumber(),item.getEmail(),item.getPassingyear()));
                bw.newLine();
            }
        }finally {
            if(bw!=null) bw.close();
        }
    }
    public void loadAluminiData()throws IOException{//Load Alumini Record From File
        Path path = Paths.get(alum);
        br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String Name =itemPieces[0],Address=itemPieces[1],Number=itemPieces[2],Email=itemPieces[3],Year=itemPieces[4];
                Alumni newAlumni =new Alumni(Name,Address,Number,Email,Year);
                alumni.add(newAlumni);

            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }

}
