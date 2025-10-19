/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventory_project;

import admin.AdminRole;
import admin.EmployeeUser;
import admin.EmployeeUserDatabase;
import java.io.IOException;
import employee.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Inventory_project {

    public static void main(String[] args) throws IOException {
//       
//        EmployeeUser e1=new EmployeeUser("E11000","ahmed","ahmed@gmail.com","alex","01203064643");
//         System.out.println(e1.lineRepresentation());
//        Product p1 = new Product("P2394","Laptop","Apple","TechSupplier",10,1500);
//        Product p2 = new Product("P23453","mobile","Apple","TechSupplier",10,1500);
//        Product p3 = new Product("P23455","mobile","Apple","TechSupplier",11,1500);
//        ProductDatabase pb = new ProductDatabase("data/Products.txt");
//        
//        CustomerProductDatabase dp = new CustomerProductDatabase("data/CustomersProducts.txt");
//        
//        CustomerProduct pp1 = new  CustomerProduct("111222333", "P2444", LocalDate.of(2005,4,22));
//        CustomerProduct pp2 = new  CustomerProduct("1222223333", "e2394", LocalDate.of(2005,4,24));

//        pp1.setPaid(true);
//        pp2.setPaid(false);
//tablet,Apple,TechSupplier,15,2500.0 
//4415,P23454,19-10-2025,true
   EmployeeRole ahmed_nargs=new EmployeeRole();
//   CustomerProduct[]kk=ahmed_nargs.getListOfPurchasingOperations();
  boolean z=ahmed_nargs.applyPayment("111222333",LocalDate.of(2005,4,22));
//   System.out.println(kk[i].lineRepresentation());
//   for(int i=0;i<kk.length;i++){,
//   System.out.println(kk[i].lineRepresentation());
//   }
//ahmed_nargs.addProduct("p25","tablet" , "Apple", "TechSupplier", 15, 2500);
//System.out.println(ahmed_nargs.purchaseProduct("4415", "P50000004", LocalDate.now()));
//   P23454,mobile,Apple,TechSupplier,11,1500.0
        
//        System.out.println(pp1.lineRepresentation());
////        System.out.println(pp2.lineRepresentation());
//        System.out.println("ffffff");
//        dp.insertRecord(pp1);
//                dp.saveToFile();
//
//        dp.insertRecord(pp2);
//        boolean c= dp.contains("111222333,P2444,22-04-2005");
//        boolean k= dp.contains("1222223333,e2394,24-04-2005");
//        System.out.println(c);
//        System.out.println(k);
//        dp.deleteRecord("111222333,P2444,22-04-2005");
//        c= dp.contains("111222333,P2444,22-04-2005");
//        System.out.println(c);
//        dp.saveToFile();

        
        
        
//        EmployeeUserDatabase b = new EmployeeUserDatabase("data/Employee.txt");
//          b.readFromFile();
//         boolean c= b.contains("E118800");
//         System.out.println(b.getRecord("E3"));
//         EmployeeUser e2=b.createRecordFrom("E4000,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345");
//         EmployeeUser e3=b.createRecordFrom("E3,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345");
//          ArrayList<EmployeeUser> records = b.returnAllRecords();
//          System.out.println(b.contains("E1400"));
//          System.out.println(b.contains("E1000"));
//          b.insertRecord(e2);
//          b.insertRecord(e3);
//          b.saveToFile();
//          AdminRole ad=new AdminRole();
//          ad.addEmployee("E11000","ahmed","ahmed@gmail.com","alex","01203064643");
//          ad.addEmployee("E12000","ahmed","ahmed@gmail.com","alex","01203064643");
//          ad.removeEmployee("E11000");
//        pb.insertRecord(p1);
//        pb.saveToFile();
//                pb.insertRecord(p2);
//        pb.saveToFile();
//                        pb.insertRecord(p3);
//        pb.saveToFile();

//               pb.deleteRecord("P23453");
//               pb.saveToFile();
//               


              
//                b.saveToFile();
//                  ad.addEmployee("E4000","Ahmed","ahmed_1999@gmail.com","Alexandria","01088877345");
//                  ad.removeEmployee("E4000");
//                 

//         ad.removeEmployee("E11000");
    }
}
