import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class SignInWindow extends JFrame implements ActionListener{
    JLabel text1;
    JTextField userName;
    JLabel text2;
    JTextField password;
    JButton button;
    JButton updateIncome;

    String income;
    public SignInWindow(){
        
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical layout

        text1 = new JLabel("Enter your user name");
        text1.setAlignmentX(CENTER_ALIGNMENT);

        userName = new JTextField();
        userName.setPreferredSize(new Dimension(120, 20));
        userName.setAlignmentX(CENTER_ALIGNMENT);

        text2 = new JLabel("Enter your password");
        text2.setAlignmentX(CENTER_ALIGNMENT);

        password = new JTextField();
        password.setPreferredSize(new Dimension(120, 20));
        password.setAlignmentX(CENTER_ALIGNMENT);

        button = new JButton("Done");
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(70, 25));
        button.setMaximumSize(new Dimension(70, 25));
        button.addActionListener(this);
        button.setFocusable(false);

        panel.add(text1);
        panel.add(Box.createVerticalStrut(10)); // Add 20px vertical spacing
        panel.add(userName);
        panel.add(Box.createVerticalStrut(30)); // Add 20px vertical spacing
        panel.add(text2);
        panel.add(Box.createVerticalStrut(10)); // Add 20px vertical spacing
        panel.add(password);
        panel.add(Box.createVerticalStrut(30)); // Add 20px vertical spacing
        panel.add(button);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(panel);
        
        setTitle("Sign In");
        setSize(300, 400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        File file = new File(userName.getText() + ".csv");
        String enteredPassword = new String(password.getText()).trim();
        
        if(e.getSource() == button){
            if(!file.exists()){
                JOptionPane.showMessageDialog(null, "User name does not exist", "ERROR", JOptionPane.PLAIN_MESSAGE);
                return;
            } else {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String storedPassword = reader.readLine();

                    if (storedPassword.equals(enteredPassword)) {
                        //JOptionPane.showMessageDialog(this, "Sign-In successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        JFrame window = new JFrame();
                        window.setLayout(new GridBagLayout());

                        JPanel panel1 = new JPanel();
                        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // Vertical layout

                        JLabel label = new JLabel();
                        label.setText("Hello " + userName.getText() + " :)");
                        label.setFont(new Font("MV Boli", Font.BOLD, 20));
                        label.setAlignmentX(CENTER_ALIGNMENT);
                        

                        updateIncome = new JButton();
                        updateIncome.setText("Update Income");
                        updateIncome.setPreferredSize(new Dimension(150, 20));
                        updateIncome.setMaximumSize(new Dimension(150, 20));
                        updateIncome.setAlignmentX(CENTER_ALIGNMENT);
                        updateIncome.setFocusable(false);
                        //updateIncome.addActionListener(this);

                        JButton updateOutgoings = new JButton();
                        updateOutgoings.setText("Update Outgoings");
                        updateOutgoings.setPreferredSize(new Dimension(150, 20));
                        updateOutgoings.setMaximumSize(new Dimension(150, 20));
                        updateOutgoings.setAlignmentX(CENTER_ALIGNMENT);
                        updateOutgoings.setFocusable(false);

                        JButton currBalance = new JButton();
                        currBalance.setText("Current Balance");
                        currBalance.setPreferredSize(new Dimension(150, 20));
                        currBalance.setMaximumSize(new Dimension(150, 20));
                        currBalance.setAlignmentX(CENTER_ALIGNMENT);
                        currBalance.setFocusable(false);

                        JButton recentTran = new JButton();
                        recentTran.setText("Recent Transactions");
                        recentTran.setPreferredSize(new Dimension(160, 20));
                        recentTran.setMaximumSize(new Dimension(160, 20));
                        recentTran.setAlignmentX(CENTER_ALIGNMENT);
                        recentTran.setFocusable(false);

                        JButton spendingHabits = new JButton();
                        spendingHabits.setText("Spending Habits");
                        spendingHabits.setPreferredSize(new Dimension(150, 20));
                        spendingHabits.setMaximumSize(new Dimension(150, 20));
                        spendingHabits.setAlignmentX(CENTER_ALIGNMENT);
                        spendingHabits.setFocusable(false);

                        JButton logOut = new JButton();
                        logOut.setText("Log Out");
                        logOut.setPreferredSize(new Dimension(90, 30));
                        logOut.setMaximumSize(new Dimension(90, 30));
                        logOut.setAlignmentX(CENTER_ALIGNMENT);
                        logOut.setFocusable(false);

                        panel1.add(label);
                        panel1.add(Box.createVerticalStrut(30));
                        panel1.add(updateIncome);
                        panel1.add(Box.createVerticalStrut(10));
                        panel1.add(updateOutgoings);
                        panel1.add(Box.createVerticalStrut(10));
                        panel1.add(currBalance);
                        panel1.add(Box.createVerticalStrut(10));
                        panel1.add(recentTran);
                        panel1.add(Box.createVerticalStrut(10));
                        panel1.add(spendingHabits);
                        panel1.add(Box.createVerticalStrut(30));
                        panel1.add(logOut);

                        window.add(panel1);
                        window.setSize(300, 400);
                        window.setVisible(true);
                        window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        dispose(); // Close the SignInWindow

                        // Add a separate ActionListener for updateIncome
                        updateIncome.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Open a new window for updating income
                                JFrame incomeWindow = new JFrame();
                                incomeWindow.setLayout(new GridBagLayout());

                                JPanel incomePanel = new JPanel();
                                incomePanel.setLayout(new BoxLayout(incomePanel, BoxLayout.Y_AXIS)); // Vertical layout

                                JLabel incomeLabel = new JLabel("Enter your monthly income");
                                incomeLabel.setAlignmentX(CENTER_ALIGNMENT);

                                JTextField incomeField = new JTextField();
                                incomeField.setPreferredSize(new Dimension(120, 20));
                                incomeField.setMaximumSize(new Dimension(120, 20));
                                incomeField.setAlignmentX(CENTER_ALIGNMENT);

                                JButton incomeButton = new JButton("Submit");
                                incomeButton.setPreferredSize(new Dimension(80, 30));
                                incomeButton.setMaximumSize(new Dimension(80, 30));
                                incomeButton.setAlignmentX(CENTER_ALIGNMENT);
                                incomeButton.setFocusable(false);

                                // Add action for Submit button
                                incomeButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        income = incomeField.getText().trim(); // Get the trimmed input
                                        if (!income.isEmpty() && income.matches("\\d+")) { // Validate input as a numeric value
                                            try {
                                                if (!file.exists()) { // Check if the file exists
                                                    JOptionPane.showMessageDialog(incomeWindow, "The file does not exist. Please check the path.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                
                                                // Read the current content of the file
                                                StringBuilder fileContent = new StringBuilder();
                                                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                                                    String line;
                                                    while ((line = reader.readLine()) != null) {
                                                        fileContent.append(line).append(System.lineSeparator());
                                                    }
                                                }
                                
                                                // Split the file into lines
                                                String[] lines = fileContent.toString().split(System.lineSeparator());
                                
                                                // Rebuild the file content with updated income
                                                StringBuilder newContent = new StringBuilder();
                                
                                                // First line: keep the password
                                                if (lines.length >= 1) {
                                                    newContent.append(lines[0]).append(System.lineSeparator());
                                                } else {
                                                    // If the file is empty or missing the password
                                                    JOptionPane.showMessageDialog(incomeWindow, "The file is missing the password on the first line.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                                    return;
                                                }
                                
                                                // Second line: update with the new income
                                                newContent.append(income).append(System.lineSeparator());
                                
                                                // Append the rest of the lines (if any exist)
                                                for (int i = 2; i < lines.length; i++) {
                                                    newContent.append(lines[i]).append(System.lineSeparator());
                                                }
                                
                                                // Write the updated content back to the file
                                                try (FileWriter writer = new FileWriter(file)) {
                                                    writer.write(newContent.toString());
                                                }
                                
                                                // Display success message
                                                JOptionPane.showMessageDialog(incomeWindow, "Income updated successfully :)");
                                                incomeWindow.dispose(); // Close the window
                                
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                                JOptionPane.showMessageDialog(incomeWindow, "An error occurred while updating the file.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else {
                                            // Invalid input
                                            JOptionPane.showMessageDialog(incomeWindow, "Please enter a valid income (numeric value).", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                });
                                

                                // Add components to the income panel
                                incomePanel.add(incomeLabel);
                                incomePanel.add(Box.createVerticalStrut(10));
                                incomePanel.add(incomeField);
                                incomePanel.add(Box.createVerticalStrut(20));
                                incomePanel.add(incomeButton);

                                incomeWindow.add(incomePanel);

                                incomeWindow.setSize(350, 200);
                                incomeWindow.setVisible(true);
                                incomeWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            }
                        });

                        updateOutgoings.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                JFrame outgoingWindow = new JFrame();
                                outgoingWindow.setLayout(new GridBagLayout());

                                JPanel outgoingPanel = new JPanel();
                                outgoingPanel.setLayout(new BoxLayout(outgoingPanel, BoxLayout.Y_AXIS)); // Vertical layout

                                JLabel outgoingLabel1 = new JLabel("<html>Choose one of the categories below:<br>1. Rent<br>2. Bills<br>3. Food<br>4. Transport<br>5. Shopping</html>");
                                outgoingLabel1.setAlignmentX(CENTER_ALIGNMENT);

                                JTextField outgoingField1 = new JTextField();
                                outgoingField1.setPreferredSize(new Dimension(100, 20));
                                outgoingField1.setMaximumSize(new Dimension(100, 20));
                                //outgoingField1.setAlignmentX(CENTER_ALIGNMENT);

                                JLabel outgoingLabel2 = new JLabel("How much you spent?");
                                //outgoingLabel2.setAlignmentX(CENTER_ALIGNMENT);

                                JTextField outgoingField2 = new JTextField();
                                outgoingField2.setPreferredSize(new Dimension(100, 20));
                                outgoingField2.setMaximumSize(new Dimension(100, 20));
                                //outgoingField2.setAlignmentX(CENTER_ALIGNMENT);

                                JButton outgoingButton = new JButton("Submit");
                                outgoingButton.setPreferredSize(new Dimension(80, 30));
                                outgoingButton.setMaximumSize(new Dimension(80, 30));
                                //outgoingButton.setAlignmentX(CENTER_ALIGNMENT);
                                outgoingButton.setFocusable(false);

                                // Add action for Submit button
                                outgoingButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Fetch the inputs inside the actionPerformed method
                                        String categoryInput = outgoingField1.getText().trim();
                                        String amountInput = outgoingField2.getText().trim();
                                
                                        if (categoryInput.isEmpty() || amountInput.isEmpty()) {
                                            JOptionPane.showMessageDialog(outgoingWindow, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        } else if (!categoryInput.matches("\\d+")) {
                                            JOptionPane.showMessageDialog(outgoingWindow, "Invalid Input! Please enter a numeric value", "Error", JOptionPane.ERROR_MESSAGE);
                                            return;
                                        }
                                
                                        // Check if category is valid
                                        String category;
                                        switch (categoryInput) {
                                            case "1":
                                                category = "Rent";
                                                break;
                                            case "2":
                                                category = "Bills";
                                                break;
                                            case "3":
                                                category = "Food";
                                                break;
                                            case "4":
                                                category = "Transport";
                                                break;
                                            case "5":
                                                category = "Shopping";
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(outgoingWindow, "Invalid category option. Please enter a number between 1 and 5.", "Error", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                
                                        // Append to file
                                        try (FileWriter writer = new FileWriter(file, true)) {
                                            writer.write(category + " " + amountInput + System.lineSeparator());
                                            
                                            JOptionPane.showMessageDialog(outgoingWindow, "Outgoing recorded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                            outgoingWindow.dispose();
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                            JOptionPane.showMessageDialog(outgoingWindow, "Error writing to file.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                });                                

                                outgoingPanel.add(outgoingLabel1);
                                outgoingPanel.add(Box.createVerticalStrut(10));
                                outgoingPanel.add(outgoingField1);
                                outgoingPanel.add(Box.createVerticalStrut(20));
                                outgoingPanel.add(outgoingLabel2);
                                outgoingPanel.add(Box.createVerticalStrut(10));
                                outgoingPanel.add(outgoingField2);
                                outgoingPanel.add(Box.createVerticalStrut(30));
                                outgoingPanel.add(outgoingButton);

                                outgoingWindow.add(outgoingPanel);

                                outgoingWindow.setSize(300, 400);
                                outgoingWindow.setVisible(true);
                                outgoingWindow.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                            }
                        });

                        currBalance.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                                    // Read the income (stored in the second line of the file)
                                    String storedIncome = reader.readLine(); // Skip the password line
                                    storedIncome = reader.readLine(); // Get the income line
                                    
                                    if (storedIncome == null || !storedIncome.matches("\\d+")) {
                                        JOptionPane.showMessageDialog(window, "Income data is missing or invalid.", "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                        
                                    int income = Integer.parseInt(storedIncome);
                        
                                    // Calculate total outgoings
                                    String line;
                                    int totalOutgoings = 0;
                                    while ((line = reader.readLine()) != null) {
                                        String[] parts = line.split(" "); // Assuming "category amount" format
                                        if (parts.length == 2 && parts[1].matches("\\d+")) {
                                            totalOutgoings += Integer.parseInt(parts[1]);
                                        }
                                    }
                        
                                    // Calculate and display the current balance
                                    int currentBalance = income - totalOutgoings;
                                    JOptionPane.showMessageDialog(window, "Current Balance: " + currentBalance, "Current Balance", JOptionPane.INFORMATION_MESSAGE);
                        
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(window, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        });

                        recentTran.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e){
                                StringBuilder transactions = new StringBuilder();
                                String line;
                                try(BufferedReader reader = new BufferedReader(new FileReader(file))){

                                    while((line = reader.readLine()) != null){
                                        String[] parts = line.split(" "); // Assuming "category amount" format
                                        if (parts.length == 2 && parts[1].matches("\\d+")) {
                                            transactions.append(line).append("\n");
                                        }
                                    }
                                    if (transactions.length() > 0) {
                                        JOptionPane.showMessageDialog(window, "Recent Transactions:\n" + transactions.toString(), 
                                                                      "Recent Transactions", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(window, "No transactions found.", "Recent Transactions", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch(IOException ex){
                                    ex.printStackTrace();
                                }
                            }
                        });

                        spendingHabits.addActionListener(new ActionListener() {
                            String line;
                            int totalIncome = 0;
                            List<Integer> spendings = new ArrayList<>(); // Use a list to store values dynamically
                            List<String> options = new ArrayList<>();

                            public void actionPerformed(ActionEvent e){
                                JFrame spendingHabitsFrame = new JFrame();
                                spendingHabitsFrame.setSize(400, 600);
                                spendingHabitsFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                                try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                                    reader.readLine(); // skip the first line
                                    String income = reader.readLine(); // store income as string
                                    totalIncome = Integer.parseInt(income); // change string to int

                                    spendings.clear();
                                    options.clear();

                                    while((line = reader.readLine()) != null){
                                        String[] parts = line.split(" "); // Assuming "category amount" format
                                        if (parts.length == 2 && parts[1].matches("\\d+")) {
                                            spendings.add(Integer.parseInt(parts[1]));
                                            options.add(parts[0]);
                                        } 
                                    }
                                } catch(IOException ex){
                                    JOptionPane.showMessageDialog(null, "Error reading the file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                                }

                                JPanel panel = new JPanel() {
                                    @Override
                                    protected void paintComponent(Graphics g) {
                                        super.paintComponent(g); // Ensures proper rendering
                                        Graphics2D g2d = (Graphics2D) g;
                                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                
                                        if (!spendings.isEmpty() && totalIncome > 0) {
                                            int totalSpendings = 0;
                                
                                            // Calculate total spendings
                                            for (int spending : spendings) {
                                                totalSpendings += spending;
                                            }
                                
                                            int startAngle = 0;
                                            int centerX = 200; // Center of the circle (x-coordinate)
                                            int centerY = 200; // Center of the circle (y-coordinate)
                                            int radius = 150; // Radius of the circle
                                            Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE};
                                
                                            // Draw each segment
                                            for (int i = 0; i < spendings.size(); i++) {
                                                // Calculate arc angle
                                                double arcAngle = Math.round(360 * spendings.get(i) / totalSpendings);
                                                
                                                // Handle any rounding issues by adjusting the last segment to fill the gap
                                                if (i == spendings.size() - 1) {
                                                    double remainingAngle = 360.0 - startAngle;  // Adjust the last segment to fill the gap
                                                    arcAngle = remainingAngle;  // Adjust the last segment to fill the remaining space
                                                }
                                                // Draw pie segment
                                                g2d.setColor(colors[i % colors.length]);
                                                g2d.fillArc(centerX - radius, centerY - radius, radius * 2, radius * 2, startAngle, (int)arcAngle);
                                
                                                // Calculate percentage
                                                double percentage = Math.round(((double) spendings.get(i) / totalIncome) * 10000) / 100.0;
                                
                                                // Calculate the position for the percentage label
                                                double theta = Math.toRadians(startAngle + arcAngle / 2.0);
                                                int labelX = (int) (centerX + radius / 1.5 * Math.cos(theta));
                                                int labelY = (int) (centerY - radius / 1.5 * Math.sin(theta));

                                                // Draw the percentage label
                                                g2d.setColor(Color.BLACK);
                                                g2d.drawString(percentage + "%", labelX - 10, labelY + 5);

                                                // Update start angle for the next segment
                                                startAngle += arcAngle;
                                            }
                                            // Draw the legend below the pie chart
                                            int legendStartX = 50;
                                            int legendStartY = centerY + radius + 20; // Position the legend below the pie chart
                                            int legendBoxSize = 20; // Size of the color box

                                            // Draw legend
                                            for (int i = 0; i < options.size(); i++) {
                                                // Draw colored rectangle
                                                g2d.setColor(colors[i % colors.length]);
                                                g2d.fillRect(legendStartX, legendStartY + i * (legendBoxSize + 10), legendBoxSize, legendBoxSize);

                                                // Draw label
                                                g2d.setColor(Color.BLACK);
                                                g2d.drawString(options.get(i), legendStartX + legendBoxSize + 5, legendStartY + i * (legendBoxSize + 10) + 15);
                                            }
                                        }
                                    }
                                };
                                
                                spendingHabitsFrame.add(panel);
                                spendingHabitsFrame.setVisible(true);
                            }

                        });
                        
                    } else if(enteredPassword.isEmpty()){
                        JOptionPane.showMessageDialog(this, "Please enter your password", "ERROR", JOptionPane.PLAIN_MESSAGE);
                    } else{
                        JOptionPane.showMessageDialog(this, "Wrong password", "ERROR", JOptionPane.PLAIN_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "An error occurred while reading the file.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            
            } 
        }
    }
    
}
