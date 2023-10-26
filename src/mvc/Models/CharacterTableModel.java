package mvc.Models;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterTableModel extends AbstractTableModel {

    private List <Character> chars = new ArrayList<>();

    @Override
    public int getRowCount() {
        return chars.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Character atChar = (Character) chars.toArray()[rowIndex];
        switch (columnIndex){
            case 0:
                return atChar.getId();
            case 1:
                return atChar.getCharName();
            case 2:
                return atChar.getCharLevel();
            case 3:
                return atChar.getCharClass();
        }
        return null;
    }

    public List<Character> getChars() {
        return chars;
    }

    public void setChars(List<Character> chars) {
        this.chars = chars;
    }
}
