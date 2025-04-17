package az.turing.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil<T> {
    public final String fileName;

    public FileUtil(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(List<T> list) {
        try(ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(fileName))){
            os.writeObject(list);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> readFromFile()  {
        List<T> list=new ArrayList<>();
        File file=new File(fileName);
        if(!file.exists()) return list;

        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fileName))){
           return (List<T>)ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

}
