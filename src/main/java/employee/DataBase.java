package employee;
import admin.EmployeeUserDatabase;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import admin.Base;

public abstract class DataBase<T extends Base>{
     protected String filename;
     protected ArrayList<T> records =new ArrayList<>() ;
     public DataBase(String filename){
         this.filename=filename;
     }
    public void readFromFile() {
        records.clear();
        try (Scanner input = new Scanner(new File(filename))) {
            while (input.hasNextLine()) {
                String line = input.nextLine().trim();
                if (!line.isEmpty()) {
                    records.add(createRecordFrom(line));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + filename);
        }
    }
    
     public abstract T createRecordFrom(String line);
         public ArrayList<T> returnAllRecords() {
        return records;
    }
       public boolean contains(String key){
      for(int i=0;i<records.size();i++){
     if(records.get(i).getSearchKey().compareTo(key)==0)
         return true;
      }
      return false;
    } 
       public T getRecord(String key) {
         for(int i=0;i<records.size();i++){
     if(records.get(i).getSearchKey().compareTo(key)==0)
         return records.get(i);
      }
      return null;
       }
         public void insertRecord(T record) {
           if(record==null)
               return;
             if((record.getSearchKey())!=null &&!contains(record.getSearchKey()))
        records.add(record);
             else
                 System.out.println("INPUT ERROR");
    }
     private boolean hasDeletions = false;

public void deleteRecord(String key) {
    for (int i = 0; i < records.size(); i++) {
        if (records.get(i).getSearchKey().equals(key)) {
            records.remove(i);
            hasDeletions = true; 
            System.out.println("Record deleted from memory: " + key);
            return;
        }
    }
    System.out.println("Record not found: " + key);
}
   
  public void saveToFile() throws FileNotFoundException {
    if (hasDeletions) {
        try (PrintWriter pr = new PrintWriter(filename)) {
            for (int i = 0; i < records.size(); i++) {
                pr.println(records.get(i).lineRepresentation());
            }
        }
        hasDeletions = false; 
        System.out.println("File overwritten (deletions were detected)");
    } else {
      
        ArrayList<String> existingRecords = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                existingRecords.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            
        }
        try (PrintWriter pr = new PrintWriter(new FileWriter(filename, true))) {
            int newRecordsCount = 0;
            for (int i = 0; i < records.size(); i++) {
                String recordLine = records.get(i).lineRepresentation();
                if (!existingRecords.contains(recordLine)) {
                    pr.println(recordLine);
                    newRecordsCount++;
                }
            }
            System.out.println("Appended " + newRecordsCount + " new records");
        } catch (IOException e) {
            throw new FileNotFoundException("Error writing to file: " + e.getMessage());
        }
    }
}
}
