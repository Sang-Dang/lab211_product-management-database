package data;

import tools.Util;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author User
 */
public class ProductListImpl extends ArrayList<Product> implements gui.ManagementInterface<Product> {
    
    private static final String filePath = "";
    
    public ProductListImpl() {
        super();
    }

    @Override
    public void print(Predicate<Product> condition) {
        int count = 0;
        for(Product i: this) {
            if(condition.test(i))
                System.out.println(i);
            count++;
        }
        System.out.println("You have " + count + " product(s).");
    }

    @Override
    public boolean addObject(Product object) {
        this.add(object);
        return true;
    }

    @Override
    public boolean removeObject(Product object) {
        this.remove(object);
        return true;
    }

    @Override
    public boolean updateObject(Product before, Product after) {
        Product location = this.get(getIndex(before));
        location = new Product(after.getID(),after.getName(),after.getPrice(),after.getQuantity(),after.getStatus());
        return true;
    }

    @Override
    public boolean checkExists(Product object) {
        return this.contains(object);
    }

    @Override
    public Product search(String key) {
        return (Product)this.stream().filter(p -> p.getName().equals(key)).toArray()[0];
    }

    @Override
    public boolean save() {
        return Util.saveLinesToFile(filePath, (String[])this.stream().toArray());
    }

    @Override
    public boolean load() {
        String[] lines = Util.readLinesFromFile(filePath);
        if(lines == null)
            return false;
        for(String i: lines) {
            String[] parts = i.split(Product.SEP);
            this.add(new Product(
                    parts[0],
                    parts[1],
                    parts[2],
                    parts[3],
                    parts[4]
            ));
        }
        return true;
    }

    @Override
    public int getIndex(Product object) {
        for(int i = 0; i < this.size(); i++) 
            if(this.get(i) == object)
                return i;
        return -1;
    }

    
}
