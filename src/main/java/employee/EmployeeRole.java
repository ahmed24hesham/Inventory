package employee;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class EmployeeRole {
    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;
    public EmployeeRole() {
        productsDatabase = new ProductDatabase("data/Products.txt");
        customerProductDatabase = new CustomerProductDatabase("data/CustomersProducts.txt");
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();
    }
    public void addProduct(String id, String name, String manufacturer, String supplier, int quantity) throws FileNotFoundException{
                Product p=new Product(id,name,manufacturer,supplier,quantity,0);
        productsDatabase.insertRecord(p);
        productsDatabase.saveToFile();
        System.out.println("Product added");
    }

    public void addProduct(String id, String name, String manufacturer, String supplier, int quantity,float price) throws FileNotFoundException{
        Product p=new Product(id,name,manufacturer,supplier,quantity,price);
        productsDatabase.insertRecord(p);
        productsDatabase.saveToFile();
        System.out.println("Product added");
            }
    public Product[] getListOfProducts(){
        int size=productsDatabase.returnAllRecords().size();
        Product []pp=new Product[size];
 for(int i=0;i<size;i++)
 pp[i]=productsDatabase.returnAllRecords().get(i);
                return pp;
    
    }
    public CustomerProduct[]getListOfPurchasingOperations(){
           int size=customerProductDatabase.returnAllRecords().size();
        CustomerProduct []cp=new CustomerProduct[size];
 for(int i=0;i<size;i++)
 cp[i]=customerProductDatabase.returnAllRecords().get(i);
                return cp;
    }
    public boolean purchaseProduct(String customerSSN, String productID , LocalDate purchaseDate) throws FileNotFoundException{
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        String s = purchaseDate.format(formatter);
     CustomerProduct cp1=new CustomerProduct(customerSSN,productID ,purchaseDate);
     Product pp=productsDatabase.getRecord(productID);
     if(pp==null){
   return false;
     }
     if(customerProductDatabase.getRecord(cp1.getSearchKey())!=null)
         return false;
          int quantity=pp.getQuantity();
     if (quantity==0||!pp.checker(productID)) {
//        System.out.println("Product not fount");
        return false;
    }
     else{
         quantity-=1;
         pp.setQuantity(quantity);
                  customerProductDatabase.insertRecord(cp1);
          customerProductDatabase.saveToFile();
         productsDatabase.deleteRecord(pp.getSearchKey());
         productsDatabase.insertRecord(pp);
         productsDatabase.saveToFile();
//         customerProductDatabase.insertRecord(cp1);
//          customerProductDatabase.saveToFile();
             System.out.println("Purchase recorded successfully");
          return true;
     }
    }
    public double returnProduct(String customerSSN, String productID,LocalDate purchaseDate ,LocalDate returnDate) throws FileNotFoundException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        CustomerProduct cpp=customerProductDatabase.getRecord(customerSSN + "," + productID + "," + purchaseDate.format(formatter));
        
        Product pp=productsDatabase.getRecord(productID);
        if(cpp==null)return-1;
        LocalDate expire=cpp.getPurchaseDate().plusWeeks(2);
        if( (!returnDate.isBefore(purchaseDate) ) && (!returnDate.isAfter(expire))&&pp!=null){
            int quantity=pp.getQuantity();
            quantity++;
            pp.setQuantity(quantity);
            productsDatabase.deleteRecord(productID);
            productsDatabase.insertRecord(pp);
            productsDatabase.saveToFile();
//              productsDatabase.deleteRecord(productID);
            customerProductDatabase.deleteRecord(cpp.getSearchKey());
            customerProductDatabase.saveToFile();
          return pp.getPrice();
        }
        else{
        System.out.println("Expired");
          return -1;
        }
    }
    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) throws FileNotFoundException{
       int sizearr=customerProductDatabase.records.size();
       for(int i=0;i<sizearr;i++){
           CustomerProduct cp=customerProductDatabase.returnAllRecords().get(i);
       if(cp.getPurchaseDate().equals(purchaseDate) && cp.getCustomerSSN().equals(customerSSN)){
           if(cp.isPaid()==false){
       cp.setPaid(true);
       customerProductDatabase.deleteRecord(cp.getSearchKey());
        customerProductDatabase.insertRecord(cp);
       customerProductDatabase.saveToFile();
       
       return true;
           }
           else{
               System.out.println("Already Paid");
               return false;
           }
       }
       }
        System.out.println("there is no one matching ");
       return false;
    }
    public void logout() throws FileNotFoundException{
    productsDatabase.saveToFile();
    customerProductDatabase.saveToFile();
    }
    
}
