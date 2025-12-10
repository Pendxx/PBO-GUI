import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements ActionListener
{
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    public LoginFrame()
    {
        setTitle("Login System");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(new JLabel("")); 
        add(loginButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if(user.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Berhasil!");
            new ImageViewer();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
