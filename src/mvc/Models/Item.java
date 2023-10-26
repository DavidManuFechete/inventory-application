package mvc.Models;

public class Item {

    private int id;
    private String itemName;
    private int itemLevel;
    private double price;
    private String specialization;

    public Item(int id, String itemName, int itemLevel, double price, String specialization){
        this.id = id;
        this.itemName = itemName;
        this.itemLevel = itemLevel;
        this.price = price;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemLevel() {
        return itemLevel;
    }

    public void setItemLevel(int itemLevel) {
        this.itemLevel = itemLevel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


}

