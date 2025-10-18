package admin;


public abstract class Base {
public abstract String getSearchKey();
public abstract String lineRepresentation();
        public boolean checker (String id){
for(int i=1;i<id.length();i++){
if(Character.isDigit(id.charAt(i))==false)
return false;
}
return true;
        }
}
