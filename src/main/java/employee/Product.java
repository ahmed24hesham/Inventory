package employee;
import admin.*;
public class Product extends Base {
private String productID;
private String productName;
private String manufacturerName;
private String supplierName;
private int quantity;
private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        if((productID.charAt(0)=='P'||productID.charAt(0)=='p')&&checker(productID)&&quantity>=0&&price>=0){
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        }
        else{
            System.out.println("INPUT ERROR");
            return;
        }
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;     
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    public void setQuantity(int quantity){
        if(quantity>=0)
        this.quantity=quantity;
        else
            System.out.println("quantity cannot be negative");
    }
@Override
    public String lineRepresentation(){
       return this.productID + "," + this.productName +"," +this.manufacturerName +"," +this.supplierName +","+this.quantity+","+this.price;
    }
@Override
    public String getSearchKey(){
        return this.productID;
    }
    }

