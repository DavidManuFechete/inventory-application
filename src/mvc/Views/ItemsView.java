package mvc.Views;

import mvc.Models.Item;
import mvc.Models.ItemTableModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemsView extends JFrame {
    private List<Item> itemList = new ArrayList<>();
    private JFrame frame;
    private JTextField itemNameTextField;
    private JTextField itemLevelTextField;
    private JTextField priceTextField;
    private JTextField sellTextField;

    JScrollPane scrollPane;
    JButton addItemButton;
    JComboBox comboBox;
    JButton sellButton;
    JButton showButton;
    JButton charactersButton;
    JButton priceRefreshButton;
    JTable table;

    public ItemsView() {

        try {
            this.setContentPane(
                    new JLabel(new ImageIcon(ImageIO.read(new File("armory.jpg")))));
        } catch (IOException e) {};

        this.setBounds(100, 100, 1204, 555);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setTitle("The Armory");

        ImageIcon img1 = new ImageIcon("icon.png");
        Image image = img1.getImage();
        Image rescaledImg = image.getScaledInstance(400,400, Image.SCALE_SMOOTH);
        this.setIconImage(rescaledImg);

        JLabel itemLabel = new JLabel("Item Name");
        itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemLabel.setForeground(Color.WHITE);
        itemLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
        itemLabel.setBounds(10, 120, 61, 17);
        this.getContentPane().add(itemLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setForeground(Color.WHITE);
        priceLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
        priceLabel.setBounds(10, 261, 61, 17);
        this.getContentPane().add(priceLabel);

        JLabel specializationLabel = new JLabel("Specialization");
        specializationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        specializationLabel.setForeground(Color.WHITE);
        specializationLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
        specializationLabel.setBounds(10, 219, 77, 13);
        this.getContentPane().add(specializationLabel);

        JLabel itemLevelLabel = new JLabel("Item Level");
        itemLevelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        itemLevelLabel.setForeground(Color.WHITE);
        itemLevelLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
        itemLevelLabel.setBounds(10, 171, 61, 17);
        this.getContentPane().add(itemLevelLabel);

        comboBox = new JComboBox<String>();
        comboBox.setEditable(true);
        comboBox.addItem("Cloth");
        comboBox.addItem("Leather");
        comboBox.addItem("Mail");
        comboBox.addItem("Plate");
        comboBox.setBounds(88, 216, 96, 21);
        this.getContentPane().add(comboBox);

        itemLevelTextField = new JTextField();
        itemLevelTextField.setBounds(88, 170, 96, 21);
        itemLevelTextField.setColumns(10);
        this.getContentPane().add(itemLevelTextField);

        itemNameTextField = new JTextField();
        itemNameTextField.setColumns(10);
        itemNameTextField.setBounds(88, 119, 96, 21);
        this.getContentPane().add(itemNameTextField);

        priceTextField = new JTextField();
        priceTextField.setColumns(10);
        priceTextField.setBounds(88, 257, 96, 21);
        this.getContentPane().add(priceTextField);

        addItemButton = new JButton("ADD TO ARMORY");
        addItemButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addItemButton.setBounds(56, 308, 156, 36);
        addItemButton.setFocusable(false);
        this.getContentPane().add(addItemButton);

        sellTextField = new JTextField();
        sellTextField.setColumns(10);
        sellTextField.setBounds(102, 397, 61, 21);
        this.getContentPane().add(sellTextField);

        priceRefreshButton = new JButton("REFRESH");
        priceRefreshButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        priceRefreshButton.setBounds(10, 429, 110, 27);
        priceRefreshButton.setFocusable(false);
        this.getContentPane().add(priceRefreshButton);

        sellButton = new JButton("SELL");
        sellButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        sellButton.setBounds(10, 392, 77, 27);
        sellButton.setFocusable(false);
        this.getContentPane().add(sellButton);

        showButton = new JButton("SHOW");
        showButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        showButton.setBounds(10, 470, 77, 27);
        showButton.setFocusable(false);
        this.getContentPane().add(showButton);

        charactersButton = new JButton("GALLERY");
        charactersButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        charactersButton.setBounds(100,470,130,27);
        charactersButton.setFocusable(false);
        this.getContentPane().add(charactersButton);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(543, 120, 500, 282);
        this.getContentPane().add(scrollPane);

        //this.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getSellButton() {
        return sellButton;
    }

    public void setSellButton(JButton sellButton) {
        this.sellButton = sellButton;
    }

    public JButton getShowButton() {
        return showButton;
    }

    public void setShowButton(JButton showButton) {
        this.showButton = showButton;
    }

    public int getSellTextField() {
        return Integer.parseInt(sellTextField.getText());
    }

    public void setSellTextField(JTextField sellTextField) {
        this.sellTextField = sellTextField;
    }

    public String getItemNameTextField() {
        return itemNameTextField.getText();
    }

    public void setItemNameTextField(String itemNameTextField) {
        this.itemNameTextField.setText(itemNameTextField);
    }

    public String getItemLevelTextField() {
        return itemLevelTextField.getText();
    }

    public void setItemLevelTextField(JTextField itemLevelTextField) {
        this.itemLevelTextField = itemLevelTextField;
    }

    public double getPriceTextField() {
        return Double.parseDouble(priceTextField.getText());
    }

    public void setPriceTextField(JTextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JButton getAddItemButton() {
        return addItemButton;
    }

    public void setAddItemButton(JButton addItemButton) {
        this.addItemButton = addItemButton;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void addCharacterListener(ActionListener actionListener){
        charactersButton.addActionListener(actionListener);
    }
    public void addItemListener(ActionListener action){
        addItemButton.addActionListener(action);
    }

    public void sellItemListener(ActionListener action){
        sellButton.addActionListener(action);
    }
    public void showListener(ActionListener action){
        showButton.addActionListener(action);
    }
    public void refreshListener(ActionListener action){
        priceRefreshButton.addActionListener(action);
    }

    public void showErrorMsg(String msg){
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.ERROR_MESSAGE);
        refresh();
    }

    public void setItemList(List <Item> itemList){
        this.itemList = itemList;
    }

    public void showMsg(String msg){
        JOptionPane.showMessageDialog(this, msg, "", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }
    public void refresh(){
        sellTextField.setText(null);
        itemLevelTextField.setText(null);
        itemNameTextField.setText(null);
        priceTextField.setText(null);
    }
}
