package employee;
import admin.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct extends Base  {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;
    
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate){
        if ((productID.charAt(0)=='P'||productID.charAt(0)=='p')&&checker(productID)){
            this.productID = productID;
        }else {
            System.out.println("Input Error");
        }
        this.customerSSN = customerSSN;
        this.purchaseDate = purchaseDate;
        this.paid = false;   
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
    
    public boolean isPaid (){
        return this.paid ;
    }
    
    public void setPaid(boolean paid){
        this.paid = paid ;
    }
    @Override
    public String lineRepresentation(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.customerSSN + ',' + this.productID+ ',' + this.purchaseDate.format(formatter) + "," + this.paid ;
    }
    @Override
     public String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.customerSSN + "," + this.productID + "," + this.purchaseDate.format(formatter);
    }
}
