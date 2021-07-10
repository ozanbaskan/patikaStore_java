import java.lang.reflect.Array;
import java.util.ArrayList;

public class Brand implements Comparable<Brand>{

    private int id;
    private String name;
    private static int idCount = 1;
    private static ArrayList<Integer> deletedIds = new ArrayList<>();


    public Brand(String name)
    {

        if (deletedIds.isEmpty()) this.id = idCount++;
        else
        {
            this.id = deletedIds.get(0);
            deletedIds.remove(0);
        }
        this.name = name;
    }

    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.getName());
    }

    public void deleteBrandId()
    {
        deletedIds.add(this.id);
    }


    public String getName()
    {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
