package employee;
import admin.EmployeeUserDatabase;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public abstract class DataBase<T>{
     protected String filename;
     protected ArrayList<T> records =new ArrayList<>() ;
     public DataBase(String filename){
         this.filename=filename;
     }
   public abstract  void readFromFile();
     public abstract T createRecordFrom(String line);
         public ArrayList<T> returnAllRecords() {
        return records;
    }
      public abstract boolean contains(String key);
      public  abstract T getRecord(String key);
         public void insertRecord(T record) {
        records.add(record);
    }
         public abstract void deleteRecord(String key);
         public abstract void saveToFile() throws FileNotFoundException; 
}
