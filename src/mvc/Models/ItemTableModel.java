package mvc.Models;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ItemTableModel extends AbstractTableModel {

    private List <Item> items = new ArrayList<>();

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Item atItem = (Item) items.toArray()[rowIndex];
        switch (columnIndex){
            case 0:
                return atItem.getId();
            case 1:
                return atItem.getItemName();
            case 2:
                return atItem.getItemLevel();
            case 3:
                return atItem.getSpecialization();
            case 4:
                return atItem.getPrice();
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
