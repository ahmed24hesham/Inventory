package admin;
import java.io.FileNotFoundException;
public class AdminRole {
private EmployeeUserDatabase database=new EmployeeUserDatabase("data/Employee.txt");
public AdminRole(){
    database.readFromFile();
};
public void addEmployee(String employeeId,String name,String email,String address,String phoneNumber) throws FileNotFoundException{
    if(((employeeId.charAt(0)!='E'||employeeId.charAt(0)!='e'))&&!checker(employeeId)) // fe file id start with E,e
        return;
    if(!(email.contains("@gmail.com")||email.contains("@yahoo.com")||email.contains("@outlook"))) //validation for mails
        return;
    if(phoneNumber.length()!=11) // law num aktr aw a2l mn 11
        return;
     EmployeeUser e=new EmployeeUser(employeeId,name,email,address,phoneNumber);
    database.insertRecord(e);
    database.saveToFile();  
}
public EmployeeUser[]getListOfEmployees(){
    int size=database.returnAllRecords().size();
    EmployeeUser[] arr=new EmployeeUser[size];
    for(int i=0;i<size;i++){
    arr[i]=database.returnAllRecords().get(i);
    }
    return arr ;
}
public void removeEmployee(String key) throws FileNotFoundException{
    database.deleteRecord(key);
        database.saveToFile(); 
}
public void logout() throws FileNotFoundException{
    database.saveToFile();
}
        public boolean checker (String id){
for(int i=1;i<id.length();i++){
if(Character.isDigit(id.charAt(i))==false)
return false;
}
return true;
        }

}
