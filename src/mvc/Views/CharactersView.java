package mvc.Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CharactersView extends JFrame {

    private JFrame frame;

    private JScrollPane scrollPane_1;
    private JScrollPane scrollPane_2;
    JButton btnShowCharacters;
    JButton btnShowCapitalCities;
    JButton goBackButton;
    JScrollPane scrollPane;

    public CharactersView(){

        this.setBounds(100, 100, 1060, 543);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);

        ImageIcon img1 = new ImageIcon("icon.png");
        Image image = img1.getImage();
        Image rescaledImg = image.getScaledInstance(400,400, Image.SCALE_SMOOTH);
        this.setIconImage(rescaledImg);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(123, 194, 305, -134);
        this.getContentPane().add(scrollPane_1);

        scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(602, 204, 305, -144);
        this.getContentPane().add(scrollPane_2);

        btnShowCharacters = new JButton("CHARACTERS");
        btnShowCharacters.setBounds(169, 237, 141, 29);
        btnShowCharacters.setFocusable(false);
        //this.getContentPane().add(btnShowCharacters);

        goBackButton = new JButton("BACK");
        goBackButton.setBounds(10, 10, 141, 29);
        goBackButton.setFocusable(false);
        this.getContentPane().add(goBackButton);

        btnShowCapitalCities = new JButton("CAPITAL CITIES");
        btnShowCapitalCities.setBounds(700, 241, 141, 29);
        btnShowCapitalCities.setFocusable(false);
        //this.getContentPane().add(btnShowCapitalCities);

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("down.jpg"));
            JLabel lblNewLabel = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel.setBounds(27, 366, 230, 130);
            this.getContentPane().add(lblNewLabel);

            BufferedImage myPicture2 = ImageIO.read(new File("download6.jpg"));
            JLabel lblNewLabel_1 = new JLabel(new ImageIcon(myPicture2));
            lblNewLabel_1.setBounds(279, 366, 230, 130);
            this.getContentPane().add(lblNewLabel_1);
        }
        catch(Exception e){};


        try{
            BufferedImage myPicture1 = ImageIO.read(new File("loginwallpaper2.jpg"));
            JLabel lblNewLabel_2 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_2.setBounds(534, 366, 230, 130);
            this.getContentPane().add(lblNewLabel_2);
        }
        catch(Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("ashbringer.jpg"));
            JLabel lblNewLabel_3 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_3.setBounds(790, 366, 230, 130);
            this.getContentPane().add(lblNewLabel_3);
        }
        catch (Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("chars.jpg"));
            JLabel lblNewLabel_4 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_4.setBounds(27, 49, 230, 130);
            this.getContentPane().add(lblNewLabel_4);
        }
        catch (Exception e){};
        try{
            BufferedImage myPicture1 = ImageIO.read(new File("hero.jpg"));
            JLabel lblNewLabel_5 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_5.setBounds(279, 49, 230, 130);
            this.getContentPane().add(lblNewLabel_5);
        }
        catch (Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("dk.jpg"));
            JLabel lblNewLabel_6 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_6.setBounds(534, 49, 230, 130);
            this.getContentPane().add(lblNewLabel_6);
        }
        catch (Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("wallpaper1.jpg"));
            JLabel lblNewLabel_7 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_7.setBounds(790, 49, 230, 130);
            this.getContentPane().add(lblNewLabel_7);
        }
        catch (Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("wallpaper3.jpg"));
            JLabel lblNewLabel_mid = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_mid.setBounds(27, 206, 230, 130);
            this.getContentPane().add(lblNewLabel_mid);
        }
        catch (Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("wallpaper4.jpg"));
            JLabel lblNewLabel_mid_1 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_mid_1.setBounds(279, 206, 230, 130);
            this.getContentPane().add(lblNewLabel_mid_1);
        }
        catch (Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("wallpaper5.jpg"));
            JLabel lblNewLabel_mid_2 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_mid_2.setBounds(534, 206, 230, 130);
            this.getContentPane().add(lblNewLabel_mid_2);
        }
        catch (Exception e){};

        try{
            BufferedImage myPicture1 = ImageIO.read(new File("wallpaper6.jpg"));
            JLabel lblNewLabel_mid_3 = new JLabel(new ImageIcon(myPicture1));
            lblNewLabel_mid_3.setBounds(790, 206, 230, 130);
            this.getContentPane().add(lblNewLabel_mid_3);
        }
        catch (Exception e){};
    }

    public JButton getGoBackButton() {
        return goBackButton;
    }

    public void setGoBackButton(JButton goBackButton) {
        this.goBackButton = goBackButton;
    }

    public void goBackListener (ActionListener actionListener){
        goBackButton.addActionListener(actionListener);
    }

    public void showCharacterListener(ActionListener actionListener){
        btnShowCharacters.addActionListener(actionListener);
    }

    public void showCapitalsListeners(ActionListener actionListener){
        btnShowCapitalCities.addActionListener(actionListener);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JScrollPane getScrollPane_1() {
        return scrollPane_1;
    }

    public void setScrollPane_1(JScrollPane scrollPane_1) {
        this.scrollPane_1 = scrollPane_1;
    }

    public JScrollPane getScrollPane_2() {
        return scrollPane_2;
    }

    public void setScrollPane_2(JScrollPane scrollPane_2) {
        this.scrollPane_2 = scrollPane_2;
    }

    public JButton getBtnShowCharacters() {
        return btnShowCharacters;
    }

    public void setBtnShowCharacters(JButton btnShowCharacters) {
        this.btnShowCharacters = btnShowCharacters;
    }

    public JButton getBtnShowCapitalCities() {
        return btnShowCapitalCities;
    }

    public void setBtnShowCapitalCities(JButton btnShowCapitalCities) {
        this.btnShowCapitalCities = btnShowCapitalCities;
    }
}
