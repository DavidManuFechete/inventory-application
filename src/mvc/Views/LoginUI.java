package mvc.Views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginUI extends JFrame {

    private JFrame frame;

    private JTextField usernameTextField;

    private JPasswordField passwordTextField;

    JButton loginButton;

    public LoginUI(){


        try {
            this.setContentPane(
                    new JLabel(new ImageIcon(ImageIO.read(new File("down.jpg")))));
        } catch (IOException e) {};

        this.setBounds(100, 100, 390, 471);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setTitle("Login");

        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userNameLabel.setBounds(136, 88, 101, 17);
        userNameLabel.setForeground(Color.WHITE);
        this.getContentPane().add(userNameLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordLabel.setBounds(136, 208, 101, 17);
        passwordLabel.setForeground(Color.WHITE);
        this.getContentPane().add(passwordLabel);

        ImageIcon img1 = new ImageIcon("icon.png");
        Image image = img1.getImage();
        Image rescaledImg = image.getScaledInstance(400,400, Image.SCALE_SMOOTH);
        this.setIconImage(rescaledImg);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        loginButton.setBounds(136, 330, 101, 34);
        loginButton.setFocusable(false);
        this.getRootPane().setDefaultButton(loginButton);
        this.getContentPane().add(loginButton);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(136, 115, 101, 28);
        this.getContentPane().add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(136, 235, 101, 28);
        this.getContentPane().add(passwordTextField);

        this.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public String getUsernameTextField() {
        return usernameTextField.getText();
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public String getPasswordTextField() {
        return String.valueOf(passwordTextField.getPassword());
    }

    public void setPasswordTextField(String passwordTextField) {
        this.passwordTextField.setText(passwordTextField);
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public void addLoginListener(ActionListener actionListener){
        loginButton.addActionListener(actionListener);
    }
}
