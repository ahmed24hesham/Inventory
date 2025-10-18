/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventory_project;

import admin.AdminRole;
import admin.EmployeeUser;
import admin.EmployeeUserDatabase;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Inventory_project {

    public static void main(String[] args) throws IOException {
       
        EmployeeUser e1=new EmployeeUser("E200","ahmed","ahmed@gmail.com","alex","012030646431");
         System.out.println(e1.lineRepresentation());
        EmployeeUserDatabase b = new EmployeeUserDatabase("data/Employee.txt");
          b.readFromFile();
         boolean c= b.contains("E1200");
         System.out.println(c);
         EmployeeUser e2=b.createRecordFrom("E4000,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345");
         EmployeeUser e3=b.createRecordFrom("E3,Ahmed,ahmed_1999@gmail.com,Alexandria,01088877345");
//          ArrayList<EmployeeUser> records = b.returnAllRecords();
//          System.out.println(b.contains("E1400"));
//          System.out.println(b.contains("E1000"));
//          b.insertRecord(e2);
//          b.insertRecord(e3);
//          b.saveToFile();
          AdminRole ad=new AdminRole();
//               b.deleteRecord("E1000");


              
//                b.saveToFile();
                  ad.addEmployee("E4000","Ahmed","ahmed_1999@gmail.com","Alexandria","01088877345");
                  ad.removeEmployee("E4000");
                 

//         ad.removeEmployee("E11000");
    }
}
