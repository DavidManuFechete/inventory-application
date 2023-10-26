package mvc;

import mvc.Controllers.ArmoryController;
import mvc.Models.Armory;
import mvc.Views.CharactersView;
import mvc.Views.ItemsView;
import mvc.Views.LoginUI;


public class Main {
    public static void main(String[] args) {

        Armory armory = new Armory("Ironforge");
        LoginUI loginUI = new LoginUI();
        CharactersView charactersView = new CharactersView();

        ItemsView itemV = new ItemsView();
        DatabaseConnection databaseConnection = new DatabaseConnection();

        ArmoryController armoryController = new ArmoryController(itemV, armory, loginUI, charactersView, databaseConnection);
    }
}
