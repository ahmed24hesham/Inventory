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
       public EmployeeUser createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new EmployeeUser(parts[0].trim(),parts[1].trim(),parts[2].trim(),parts[3].trim(),parts[4].trim());
    }     
}