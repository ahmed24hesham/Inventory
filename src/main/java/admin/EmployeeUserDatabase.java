package admin;
import java.io.PrintWriter;
import admin.*;
import employee.DataBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeUserDatabase extends DataBase<EmployeeUser>{
    public EmployeeUserDatabase(String filename){
        super(filename);
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
       public EmployeeUser createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new EmployeeUser(parts[0].trim(),parts[1].trim(),parts[2].trim(),parts[3].trim(),parts[4].trim());
    }
       public boolean contains(String key){
      for(int i=0;i<records.size();i++){
     if(records.get(i).getSearchKey().compareTo(key)==0)
         return true;
      }
      return false;
    }
       public EmployeeUser getRecord(String key) {
         for(int i=0;i<records.size();i++){
     if(records.get(i).getSearchKey().compareTo(key)==0)
         return records.get(i);
      }
      return null;
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