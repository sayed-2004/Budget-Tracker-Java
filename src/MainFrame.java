import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements ActionListener{
    JButton signIn;
    JButton signUp;
    SignUpWindow signUpWindow;
    SignInWindow signInWindow;
    
    MainFrame(){        

        setLayout(new GridBagLayout()); // Centers the panel within the frame

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout

        JLabel label = new JLabel();
        label.setText("Welcome to Budget Tracker");
        label.setForeground(Color.black); // change text coor
        label.setFont(new Font("MV Boli", Font.BOLD, 20));
        label.setAlignmentX(CENTER_ALIGNMENT); // Align label to the center of the panel

        signIn = new JButton();
        signIn.setAlignmentX(CENTER_ALIGNMENT); // Align button to the center of the panel
        signIn.setPreferredSize(new Dimension(120, 40)); // Preferred size
        signIn.setMaximumSize(new Dimension(80, 20));   // Enforce max size
        signIn.addActionListener(this);
        signIn.setText("Sign In");
        signIn.setFocusable(false);

        signUp = new JButton();
        signUp.setAlignmentX(CENTER_ALIGNMENT); // Align button to the center of the panel
        signUp.setPreferredSize(new Dimension(120, 40)); // Preferred size
        signUp.setMaximumSize(new Dimension(80, 20));   // Enforce max size
        signUp.addActionListener(this);
        signUp.setText("Sign Up");
        signUp.setFocusable(false);

        panel.add(label);
        panel.add(Box.createVerticalStrut(30)); // Add 20px vertical spacing
        panel.add(signIn);
        panel.add(Box.createVerticalStrut(10)); // Add 20px vertical spacing
        panel.add(signUp);

        // Add the panel to the frame
        add(panel);

        setTitle("Welcome");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {
            if (signUpWindow == null) {
                signUpWindow = new SignUpWindow(); // Open the Sign-In window only if it's not already open
                signUpWindow.addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e){
                        signUpWindow = null;
                    }
                });
            }
        } else if(e.getSource() == signIn){
            signInWindow = new SignInWindow(); // Open the Sign-In window only if it's not already open
        }
            
    }
}
