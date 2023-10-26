package mvc.Models;

public class Character {
    private int id;
    private String charName;
    private int charLevel;
    private String charClass;

    public Character(int id, String charName, int charLevel, String charClass){
        this.id = id;
        this.charName = charName;
        this.charLevel = charLevel;
        this.charClass = charClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(int charLevel) {
        this.charLevel = charLevel;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }
}
