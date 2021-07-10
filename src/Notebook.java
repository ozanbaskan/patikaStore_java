public class Notebook extends Product{


    private int storage;
    private int ram;
    private double screenSize;


    public Notebook(double price, int discountRate, int stock, String name, Brand brand, int storage, int ram, double screenSize) {
        super(price, discountRate, stock, name, brand);
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
}
