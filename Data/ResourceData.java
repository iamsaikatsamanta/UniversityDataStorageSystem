package mainPackage.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ResourceData {
    private static ResourceData instance=new ResourceData();
    private ObservableList<Resource> rescorces;
    private ObservableList<String> resname;
    private String filename="rescorces.txt";
    private ResourceData() {
        rescorces = FXCollections.observableArrayList();
        resname = FXCollections.observableArrayList();
    }
    public void addRecorce(Resource item){
        rescorces.add(item);
        resname.add(item.getName());
    }
    public void removeRecorce(Resource item){
        rescorces.remove(item);
        resname.remove(item.getName());
    }
    public static ResourceData getInstance() {
        return instance;
    }

    public ObservableList<Resource> getRescorces() {
        return rescorces;
    }

    public ObservableList<String> getResname() {
        return resname;
    }
    public void storeResourceData() throws IOException {//Add Resource Record Into File
        Path path= Paths.get(filename);
        BufferedWriter bw=Files.newBufferedWriter(path);
        try {
            Iterator<Resource> iterator;
            iterator = rescorces.iterator();
            while (iterator.hasNext()){
                Resource item=iterator.next();
                bw.write(String.format("%s\t%s",item.getName(),item.getQuantity()));
                bw.newLine();
            }
        }finally {
            if(bw!=null) bw.close();
        }
    }
    public void loadResourceData()throws IOException{//Load Resource Record From File
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");

                String Name =itemPieces[0],qtty=itemPieces[1];
                Resource newAlumini=new Resource(Name,qtty);
                rescorces.add(newAlumini);

            }

        } finally {
            if(br != null) {
                br.close();
                for(int i=0;i<rescorces.size();i++)
                    resname.add(rescorces.get(i).getName());
            }
        }
    }
}
