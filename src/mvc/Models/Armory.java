package mvc.Models;

import java.util.ArrayList;
import java.util.List;

public class Armory {

    private String name;
    private List<Item> itemList;

    public Armory(String name){
        this.name = name;
        this.itemList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    @Override
    public String toString() {
        return "Armory{" +
                "name = '" + name + '\'' +
                ", Item List = " + itemList +
                '}';
    }
}
