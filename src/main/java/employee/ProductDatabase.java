package employee;

public class ProductDatabase extends DataBase<Product> {
    public ProductDatabase(String filename){
        super(filename);
    }
       public Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Product(parts[0].trim(),parts[1].trim(),parts[2].trim(),parts[3].trim(),Integer.parseInt(parts[4].trim()),Float.parseFloat(parts[5].trim()));
    }
}
