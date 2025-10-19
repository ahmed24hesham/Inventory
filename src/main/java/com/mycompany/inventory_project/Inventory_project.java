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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Inventory_project {

    public static void main(String[] args) throws IOException {
        AdminRole a1 = new AdminRole();
        EmployeeRole e1 = new EmployeeRole();
        a1.addEmployee("E1234","Ahmed elsaeed b5a","ahmedelsaeed@gmail.com","moharambeck","01201428030");
        EmployeeUser []kk = a1.getListOfEmployees();
        for(int i =0;i<kk.length;i++){
            System.out.println(kk[i].getSearchKey());
        }
        a1.removeEmployee("E1234");
        
        System.out.println("---------------------------");
        
        e1.addProduct("p1234","tv","LG","aaaa",10,10000);
        Product [] kkk = e1.getListOfProducts();
                for(int i =0;i<kkk.length;i++){
            System.out.println(kkk[i].getSearchKey());
        }
                
        e1.purchaseProduct("111222339","p25", LocalDate.now());
        e1.purchaseProduct("111222340","p25", LocalDate.now());
        e1.purchaseProduct("111222341","p30", LocalDate.now());
        e1.purchaseProduct("111222342","p30", LocalDate.now());
       e1.returnProduct("111222339","p25",LocalDate.now(), LocalDate.now());
       e1.returnProduct("111222340","p25",LocalDate.now(), LocalDate.now());
       e1.returnProduct("111222341","p25",LocalDate.now(), LocalDate.now());   
        e1.applyPayment("111222333", LocalDate.of(2005,4,22));
    }
}
