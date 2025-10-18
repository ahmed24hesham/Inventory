package admin;
public class EmployeeUser {
    private String employeeId;
    private String  Name;
    private String  Email;
     private String Address;
      private String PhoneNumber;
       public EmployeeUser(String employeeId,String name,String email,String address,String phoneNumber){
                this.employeeId=employeeId;
                this.Name=name;
                this.Email=email;
                this.Address=address;
                this.PhoneNumber=phoneNumber;
       }
        public String lineRepresentation(){
            String employee;
          employee=this.employeeId + "," + this.Name +"," +this.Email +"," +this.Address +","+this.PhoneNumber;
          return employee;
        }
        public String getSearchKey(){
            return this.employeeId;
        }
}