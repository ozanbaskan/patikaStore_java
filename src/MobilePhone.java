public class MobilePhone extends Product{

    private int storage;
    private int ram;
    private int camera;
    private double screenSize;
    private int batteryPower;
    private String color;


    public MobilePhone(double price, int discountRate, int stock, String name, Brand brand, int camera, int storage, int ram, double screenSize, int batteryPower, String color) {
        super(price, discountRate, stock, name, brand);
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.color = color;
        this.camera = camera;
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

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
