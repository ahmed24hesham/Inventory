package admin;
public class EmployeeUser {
    private String employeeId;
    private String  Name;
    private String  Email;
     private String Address;
      private String PhoneNumber;
       public EmployeeUser(String employeeId,String name,String email,String address,String phoneNumber){
         if((employeeId.charAt(0)=='E'||employeeId.charAt(0)=='e')&&checker(employeeId)){
                this.employeeId=employeeId;
         }
               
         else{
             System.out.println("Invalid Employee Id");// should start with E refer to employee
         }
         this.Name=name;
         if(email.contains("@gmail.com")||email.contains("@outlook.com")||email.contains("@yahoo.com")){
         this.Email=email;
         }
         else{
             System.out.println("Invalid Employee EmailAdress"); 
         }
         
         this.Address=address;
         if(phoneNumber.length()==11){
         this.PhoneNumber=phoneNumber;
         }
         else{ 
             System.out.println("Invalid Employee PhoneNumber");
// 11 num only 
         }
       }
       
        public String lineRepresentation(){
            String employee;
          employee=this.employeeId + "," + this.Name +"," +this.Email +"," +this.Address +","+this.PhoneNumber;
          return employee;
        }
        public String getSearchKey(){
            return this.employeeId;
        }
        public boolean checker (String id){
for(int i=1;i<id.length();i++){
if(Character.isDigit(id.charAt(i))==false)
return false;
}
return true;
        }
}