package mvc.Controllers;

import mvc.DatabaseConnection;
import mvc.Models.*;
import mvc.Models.Character;
import mvc.Views.CharactersView;
import mvc.Views.ItemsView;
import mvc.Views.LoginUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArmoryController {

    private ItemsView view;
    private Armory armory;
    private LoginUI loginUI;
    private DatabaseConnection databaseConnection;
    private CharactersView charactersView;

    public ArmoryController(ItemsView view, Armory armory, LoginUI loginUI, CharactersView charactersView, DatabaseConnection databaseConnection) {

        this.armory = armory;
        this.view = view;
        this.loginUI = loginUI;
        this.databaseConnection = databaseConnection;
        this.charactersView = charactersView;

        this.loginUI.addLoginListener(new LoginListener());
        this.view.showListener(new ShowListener());
        this.view.refreshListener(new refreshListener());
        this.view.addItemListener(new addListener());
        this.view.sellItemListener(new sellListener());
        this.view.addCharacterListener(new CharacterListener());
        this.charactersView.goBackListener(new goBackListener());
        this.charactersView.showCharacterListener(new showCharListener());
    }

    class showCharListener implements ActionListener {
        List <Character> list = new ArrayList<>();
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                list.clear();
                armory.getItemList().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM characters";

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while(result.next()){

                    int id = result.getInt(1);
                    String charName = result.getString((2));
                    int charLevel = result.getInt(3);
                    String charClass = result.getString(4);
                    list.add(new Character(id,charName,charLevel,charClass));
                }

                JTable table = new JTable();
                CharacterTableModel charModel = new CharacterTableModel();
                table.setModel(charModel);

                String[] columnNamesItems = {"id", "Item Name", "Item Level", "Specialization", "Price"};
                int columnNumber = table.getColumnCount();
                for (int i = 0; i < columnNumber; i++)
                    table.getColumnModel().getColumn(i).setHeaderValue(columnNamesItems[i]);

                charModel.setChars(list);
                view.getScrollPane().setViewportView(table);

                //view.setItemList(list);
                connection.close();
            }
            catch (Exception ex){
                view.showErrorMsg("Something went wrong");
                ex.printStackTrace();
            }
        }
    }
    class goBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            charactersView.setVisible(false);
            view.setVisible(true);
        }
    }

    class CharacterListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            charactersView.setVisible(true);
        }
    }
    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String username = loginUI.getUsernameTextField().toString();
                String password = loginUI.getPasswordTextField().toString();
                if (username.equals("admin@") && password.equals("admin1234")){
                    view.showMsg("Successfully connected.");
                    loginUI.setVisible(false);
                    view.setVisible(true);
                }
                else
                    view.showErrorMsg("Incorrect username or password.");
            }
            catch (Exception ex){
                view.showErrorMsg("Something went wrong");
                ex.printStackTrace();
            }
        }
    }

    class ShowListener implements ActionListener{ // SELECT OPERATION
        List <Item> list = new ArrayList<>();
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                list.clear();
                armory.getItemList().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM items";

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);
                while(result.next()){

                    int id = result.getInt(1);
                    String itemName = result.getString((2));
                    double price = result.getDouble(3);
                    int itemLevel = result.getInt(4);
                    String specialization = result.getString(5);
                    list.add(new Item(id,itemName,itemLevel,price,specialization));
                }

                JTable table = new JTable();
                ItemTableModel itemModel = new ItemTableModel();
                table.setModel(itemModel);

                String[] columnNamesItems = {"id", "Item Name", "Item Level", "Specialization", "Price"};
                int columnNumber = table.getColumnCount();
                for (int i = 0; i < columnNumber; i++)
                    table.getColumnModel().getColumn(i).setHeaderValue(columnNamesItems[i]);

                itemModel.setItems(list);
                view.getScrollPane().setViewportView(table);
                //view.setItemList(list);
                connection.close();
            }
            catch (Exception ex){
                view.showErrorMsg("Something went wrong");
                ex.printStackTrace();
            }
        }
    }
        class addListener implements ActionListener {   // INSERT OPERATION

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into items (name, itemlevel, specialization," +
                        "                                                                                 price)" + "values(?, ?, ?,?)");

                preparedStatement.setString(1,view.getItemNameTextField());
                preparedStatement.setString(2,view.getItemLevelTextField());
                preparedStatement.setString(3,view.getComboBox().getSelectedItem().toString());
                preparedStatement.setDouble(4,view.getPriceTextField());

                preparedStatement.executeUpdate();

                connection.close();
                view.showMsg("Item set to your Armory.");
            }
            catch (Exception exception){
                view.showErrorMsg("Cannot set your item.");
            }
        }
    }
    class sellListener implements ActionListener{ // DELETE OPERATION

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Connection connection = databaseConnection.getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM items WHERE id = ?");
                preparedStatement.setInt(1, view.getSellTextField());
                preparedStatement.executeUpdate();

                connection.close();
                view.showMsg("Item has been sold.");
            }
            catch (Exception exception){
                view.showErrorMsg("Nonexistent item cannot be sold");
            }
        }
    }

    class refreshListener implements ActionListener{ // UPDATE OPERATION

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE items SET price = price + (price * 0.05)");

                preparedStatement.executeUpdate();

                connection.close();
                view.showMsg("Prices are refreshed.");
            }
            catch (Exception exception){
                view.showErrorMsg("Cannot refresh prices");
            }
        }
    }
}