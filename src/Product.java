import java.util.ArrayList;

public class Product {

    private int id;
    private double price;
    private int discountRate;
    private int stock;
    private String name;
    private Brand brand;

    static private int IdCount = 1;
    static private ArrayList<Integer> deletedIds = new ArrayList<>();

    public Product(double price, int discountRate, int stock, String name, Brand brand)
    {
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.name = name;
        this.brand = brand;
        createId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void deleteId()
    {
        deletedIds.add(this.id);
    }

    public void createId()
    {
        if (deletedIds.isEmpty())
        {
            this.id = IdCount++;
        }
        else
        {
            this.id = deletedIds.get(0);
            deletedIds.remove(0);
        }
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static int getIdCount() {
        return IdCount;
    }

    public static void setIdCount(int idCount) {
        IdCount = idCount;
    }

    public static ArrayList<Integer> getDeletedIds() {
        return deletedIds;
    }

    public static void setDeletedIds(ArrayList<Integer> deletedIds) {
        Product.deletedIds = deletedIds;
    }
}
