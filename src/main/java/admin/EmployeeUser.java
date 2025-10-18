package admin;
public class EmployeeUser extends Base {
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
             System.out.println("Invalid Employee Id");
              return;
         }
         this.Name=name;
         if(email.contains("@gmail.com")||email.contains("@outlook.com")||email.contains("@yahoo.com")){
         this.Email=email;
         }
         else{
             System.out.println("Invalid Employee EmailAdress");
             this.employeeId=null;
             return;
         }
         
         this.Address=address;
         if(phoneNumber.length()==11){
         this.PhoneNumber=phoneNumber;
         }
         else{ 
             System.out.println("Invalid Employee PhoneNumber");
             this.employeeId=null;
             return;
         }
       }

    @Override
        public String lineRepresentation(){
            String employee;
          employee=this.employeeId + "," + this.Name +"," +this.Email +"," +this.Address +","+this.PhoneNumber;
          return employee;
        }
    @Override
        public String getSearchKey(){
            return this.employeeId;
        }
}