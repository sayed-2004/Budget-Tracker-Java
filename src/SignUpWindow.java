import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignUpWindow extends JFrame implements ActionListener{
    JButton button;
    JTextField userName;
    JTextField password;
    JTextField confirmPassword;
    JLabel text2;
    File file;

    SignUpWindow(){

        setLayout(new GridBagLayout()); // Centers the panel within the frame

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout
        
        text2 = new JLabel();
        text2.setText("Enter User Name");
        text2.setAlignmentX(CENTER_ALIGNMENT);

        userName = new JTextField();
        userName.setPreferredSize(new Dimension(120, 20));
        userName.setAlignmentX(CENTER_ALIGNMENT);

        JLabel text = new JLabel();
        text.setText("Enter Password");
        text.setAlignmentX(CENTER_ALIGNMENT);

        password = new JTextField();
        password.setPreferredSize(new Dimension(120, 20));  // Size of the text field


        JLabel text1 = new JLabel("Confirm Password");
        text1.setAlignmentX(CENTER_ALIGNMENT);

        confirmPassword = new JTextField();
        confirmPassword.setPreferredSize(new Dimension(120, 20));

        button = new JButton();
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(70, 25));
        button.setMaximumSize(new Dimension(70, 25));
        button.setText("Save");
        button.addActionListener(this);
        button.setFocusable(false);


        // Set the layout of the frame
        //setLayout(new FlowLayout());
        panel.add(text2);
        panel.add(Box.createVerticalStrut(10)); // Add 20px vertical spacing
        panel.add(userName);
        panel.add(Box.createVerticalStrut(30)); // Add 20px vertical spacing
        panel.add(text);
        panel.add(Box.createVerticalStrut(10)); // Add 20px vertical spacing
        panel.add(password);
        panel.add(Box.createVerticalStrut(30)); // Add 20px vertical spacing
        panel.add(text1);
        panel.add(Box.createVerticalStrut(10)); // Add 20px vertical spacing
        panel.add(confirmPassword);
        panel.add(Box.createVerticalStrut(30)); // Add 20px vertical spacing
        panel.add(button);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(panel);

        setTitle("Sign-Up");
        setSize(300, 400);  // Set a reasonable size for the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == button){
            if(!password.getText().equals(confirmPassword.getText())){
                JOptionPane.showMessageDialog(null, "Password did not match!", "ERROR", JOptionPane.PLAIN_MESSAGE);
            } else{
                if(userName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No user name entered", "ERROR", JOptionPane.PLAIN_MESSAGE);
                } else{
                    file = new File(userName.getText() + ".csv");
                    if(file.exists()){
                        JOptionPane.showMessageDialog(null, "This user name is taken!", "ERROR", JOptionPane.PLAIN_MESSAGE);
                    } else{
                        try{
                            FileWriter writer = new FileWriter(file);
                            writer.write(password.getText());
                            writer.close();
                        } catch(IOException f){
                            f.printStackTrace();
                        }
                    }
                }
                
            }
        }
    }

}
