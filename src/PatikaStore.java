import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class PatikaStore {

    static private TreeSet<Brand> brands = new TreeSet<>();
    private HashMap<Integer,Notebook> notebooks = new HashMap<>();
    private HashMap<Integer,MobilePhone> mobilePhones = new HashMap<>();
    private Scanner s = new Scanner(System.in);

    static
    {
        brands.add(new Brand("Samsung"));
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Huawei"));
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("HP"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Monster"));
    }


    public void printBrands()
    {
        System.out.println();
        int count = 1;
        for (Brand b: brands)
        {
            System.out.println(count++ + ". " + b.getName());
        }
        System.out.println();
    }

    public void printNotebooks()
    {

        System.out.println("Notebook Listesi");
        System.out.println();
        System.out.println(String.format("%100s", "").replace(" ", "-"));
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM         |");
        for (Notebook n : this.notebooks.values())
        {
            System.out.println(String.format("| %-3s", n.getId()) + String.format("| %-30s", n.getName()) + String.format("| %-10.1f", n.getPrice()) + String.format("| %-10s", n.getBrand().getName()) + String.format("| %-10d", n.getStorage()) + String.format("| %-10.1f", n.getScreenSize()) + String.format("| %-12d|", n.getRam()));
        }
        System.out.println();
    }

    public void printMobilePhones()
    {
        System.out.println("Cep Telefonu Listesi");
        System.out.println();
        System.out.println(String.format("%134s", "").replace(" ", "-"));
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        for (MobilePhone m : this.mobilePhones.values())
        {
            System.out.println(String.format("| %-3s", m.getId()) + String.format("| %-30s", m.getName()) + String.format("| %-10.1f", m.getPrice()) + String.format("| %-10s", m.getBrand().getName()) + String.format("| %-10d", m.getStorage()) + String.format("| %-10d", m.getCamera()) + String.format("| %-10.1f", m.getScreenSize()) + String.format("| %-10d", m.getBatteryPower()) + String.format("| %-10d", m.getRam()) + String.format("| %-10s|", m.getColor()));
        }
        System.out.println();
    }

    public void addNotebook(Notebook notebook)
    {
        notebooks.put(notebook.getId(),notebook);
    }

    public void addMobilePhone(MobilePhone mobilePhone)
    {
        mobilePhones.put(mobilePhone.getId(),mobilePhone);
    }

    public Brand chooseBrand(String name)
    {
        for (Brand b : brands)
        {
            if (b.getName().equalsIgnoreCase(name))
            {
                return b;
            }
        }
        return null;
    }

    public void patikaPanel()
    {
        boolean breaking = false;
        while (!breaking)
        {
            System.out.println("###################################################");
            System.out.println("PatikaStore Ürün Yönetim Paneli!");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("0 - Çıkış Yap");
            int choice = this.getChoice(0,3);
            switch(choice)
            {
                case 1 -> {
                    this.notebookPanel();
                }
                case 2 -> {
                    this.mobilePhonePanel();
                }
                case 3 -> {
                    this.printBrands();
                }
                case 0 -> {
                    breaking = true;
                }
            }

        }

    }

    public int getChoice(int start, int end)
    {
        int choice = start - 1;
        do
        {
            try
            {
                System.out.print("Seçiniz: ");
                choice = s.nextInt();
            }
            catch (Exception e)
            {
                s.next();
                System.out.println("Uygun degil.");
            }

        } while (choice > end || choice < start);

        return choice;
    }

    public double getFloat()
    {
        double choice = 0;
        do
        {
            try
            {
                choice = s.nextDouble();
            }
            catch (Exception e)
            {
                s.next();
                System.out.println("Uygun degil.");
            }

        } while (choice <= 0);

        return choice;
    }

    public String getString()
    {
        String choice = "";
        do
        {
            try
            {
                choice = s.nextLine();
            }
            catch (Exception e)
            {
                s.next();
                System.out.println("Uygun degil.");
            }

        } while (choice.equals(""));

        return choice;
    }


    public void notebookPanel()
    {
            System.out.println();
            System.out.println("1 - Notebook Listele");
            System.out.println("2 - Notebook Ekle");
            System.out.println("3 - Notebook Sil");
            System.out.println("0 - Çıkış");
            int choice = this.getChoice(0,3);

            switch(choice)
            {
                case 1 -> {
                    this.printNotebooks();
                }
                case 2 -> {
                    double price;
                    int discountRate;
                    int stock;
                    String name;
                    String brandName;
                    int storage;
                    int ram;
                    double screenSize;

                    System.out.print("Marka seçiniz: ");
                    brandName = this.getString();
                    Brand brand = this.chooseBrand(brandName);
                    if (brand == null)
                    {
                        System.out.println("Böyle bir marka yok.");
                        break;
                    }
                    System.out.println("Eklemek istediğiniz ürün için değerleri giriniz.");
                    System.out.print("İsim giriniz: ");
                    name = this.getString();
                    System.out.print("Fiyat(TL): ");
                    price = this.getFloat();
                    System.out.print("İndirim Oranı(%) ");
                    discountRate = this.getChoice(1,1000000);
                    System.out.print("Stok ");
                    stock = this.getChoice(1,1000000);
                    System.out.print("Depolama(GB) ");
                    storage = this.getChoice(1,1000000);
                    System.out.print("Bellek(GB) ");
                    ram = this.getChoice(1,1000000);
                    System.out.print("Ekran Boyutu(İnç): ");
                    screenSize = this.getFloat();

                    System.out.println();

                    try
                    {
                        Notebook notebook = new Notebook(price,discountRate,stock,name, brand,storage, ram, screenSize);
                        this.addNotebook(notebook);
                        System.out.println("Notebook eklendi.");
                    }
                    catch (Exception e)
                    {
                        System.out.println("Eklenemedi...");
                    }

                }
                case 3 -> {
                    System.out.print("Silmek istediğiniz ürünün ID'sini ");
                    int id = getChoice(1, Product.getIdCount());
                    if (this.notebooks.get(id) != null)
                    {
                        System.out.println(this.notebooks.get(id).getName() + " silindi.");
                        this.notebooks.get(id).deleteId();
                        this.notebooks.remove(id);
                    }
                    else
                    {
                        System.out.println("Ürün bulunamadı.");
                    }
                }
                case 0 -> {
                    System.out.println("");
                }
            }

    }

    public void mobilePhonePanel()
    {
        System.out.println();
        System.out.println("1 - Cep Telefonu Listele");
        System.out.println("2 - Cep Telefonu Ekle");
        System.out.println("3 - Cep Telefonu Sil");
        System.out.println("0 - Çıkış");
        int choice = this.getChoice(0,3);

        switch(choice)
        {
            case 1 -> {
                this.printMobilePhones();
                this.mobilePhonePanel();
            }
            case 2 -> {
                double price;
                int discountRate;
                int stock;
                String name;
                String brandName;
                int storage;
                int ram;
                double screenSize;
                int batteryPower;
                String color;
                int camera;

                System.out.print("Marka seçiniz: ");
                brandName = this.getString();
                Brand brand = this.chooseBrand(brandName);
                if (brand == null)
                {
                    System.out.println("Böyle bir marka yok.");
                    break;
                }
                System.out.println("Eklemek istediğiniz ürün için değerleri giriniz.");
                System.out.print("İsim giriniz: ");
                name = this.getString();
                System.out.print("Fiyat(TL): ");
                price = this.getFloat();
                System.out.print("İndirim Oranı(%) ");
                discountRate = this.getChoice(1,1000000);
                System.out.print("Stok ");
                stock = this.getChoice(1,1000000);
                System.out.print("Depolama(GB) ");
                storage = this.getChoice(1,1000000);
                System.out.print("Bellek(GB) ");
                ram = this.getChoice(1,1000000);
                System.out.print("Ekran Boyutu(İnç): ");
                screenSize = this.getFloat();
                System.out.print("Pil Gücü ");
                batteryPower = this.getChoice(1,30000);
                System.out.print("Kamera(piksel) ");
                camera = this.getChoice(1,300);
                System.out.print("Renk: ");
                color = this.getString();

                System.out.println();

                try
                {
                    MobilePhone mobilePhone = new MobilePhone(price,discountRate,stock,name,brand,camera,storage, ram, screenSize,batteryPower,color);
                    this.addMobilePhone(mobilePhone);
                    System.out.println("Cep telefonu eklendi.");
                }
                catch (Exception e)
                {
                    System.out.println("Eklenemedi...");
                }
            }
            case 3 -> {
                System.out.print("Silmek istediğiniz ürünün ID'sini ");
                int id = getChoice(1, Product.getIdCount());
                if (this.mobilePhones.get(id) != null)
                {
                    System.out.println(this.mobilePhones.get(id).getName() + " silindi.");
                    this.mobilePhones.get(id).deleteId();
                    this.mobilePhones.remove(id);
                }
                else
                {
                    System.out.println("Ürün bulunamadı.");
                }
            }
            case 0 -> {
                System.out.println("");
            }
        }

    }


}
