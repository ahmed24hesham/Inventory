package employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProductDatabase extends DataBase<CustomerProduct> {
    public CustomerProductDatabase(String filename){
        super(filename);
    }
    
     public CustomerProduct createRecordFrom(String line){
         try {
            String[] parts = line.split(",");
            if (parts.length < 4) return null;

            String customerSSN = parts[0];
            String productID = parts[1];
            LocalDate purchaseDate = LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            boolean paid = Boolean.parseBoolean(parts[3]);

            CustomerProduct record = new CustomerProduct(customerSSN, productID, purchaseDate);
            record.setPaid(paid);
            return record;

        } catch (Exception e) {
            System.err.println("Error parsing line: " + line);
            return null;
        }
    }
    @Override
      public CustomerProduct getRecord(String key) {
          
         for(int i=0;i<records.size();i++){
     if(records.get(i).getSearchKey().split(",")[1].compareTo(key)==0)
         return records.get(i);
      }
      return null;
       }
     }

