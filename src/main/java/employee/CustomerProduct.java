package employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;
    
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate){
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = paid;   
    }
    
    public String getCustomerSSN(){
        return this.customerSSN;
    }
    
    public String getProductID(){
        return this.productID;
    }
    
    public LocalDate getPurchaseDate(){
        return this.purchaseDate;
    }
    
    public String lineRepresentation(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.customerSSN + ',' + this.getCustomerSSN() + ',' + this.purchaseDate.format(formatter) + "," + this.paid ;
    }
    
     public String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.customerSSN + "," + this.productID + "," + this.purchaseDate.format(formatter);
    }
}
