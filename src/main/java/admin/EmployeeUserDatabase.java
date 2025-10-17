package admin;
import java.io.PrintWriter;
import admin.*;
import employee.DataBase;
import java.io.File;
import java.io.FileNotFoundException;
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
       public void deleteRecord(String key){
           for(int i=0;i<records.size();i++){
     if(records.get(i).getSearchKey().compareTo(key)==0){
         records.remove(i);
         return;
     }
      }
           System.out.println("Not found");
       }
   
       public void saveToFile() throws FileNotFoundException  {
    PrintWriter pr = new PrintWriter(filename);
    for (int i = 0; i < records.size(); i++) {
        pr.println(records.get(i).lineRepresentation());
    }
    pr.close();
}

       
}
