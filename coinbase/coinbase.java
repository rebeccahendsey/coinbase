package coinbase;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.BorderFactory;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;


public class coinbase extends JFrame
{
        // Launch the application
        public static void main(String[] args)
        {
            coinbase frame = new coinbase();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(new Color(16, 89, 251));
            frame.setVisible(true);
             
        }

        // Create the frame
        public coinbase()
        {
            // Frame title display current time
            Date  date = new Date();
            String str = String.format("%tc", date);
        
            String titleString = "--- Coinbase --- " + str;

            setTitle(titleString);
            
            NumberFormat formatter = new DecimalFormat("#0.00");
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Size of the frame
            setSize(1000,1000);
            
            // Panel title
            JPanel contentPane = new JPanel();
            contentPane.setBorder(new TitledBorder(new EtchedBorder(),
                                  "coinbase"));;
            setContentPane(contentPane);
            

            // Field where to see status information
            JTextField status = new JTextField();
            status.setEditable(false);
            status.setBounds(300, 330, 100, 34);
            contentPane.add(status);
            status.setColumns(40);
            status.setBackground(Color.white);
            status.setBorder(null);

            // Border around textFields for log in and create an account
            Border border = BorderFactory.createLineBorder(new Color(188, 188, 188));

            // Border for textArea backgrounds
            Border border2 = BorderFactory.createLineBorder(new Color(188, 188, 188),2);

           
            // Log in section
            
            // Email text field
            JTextField EmailTA = new JTextField("");
            EmailTA.setBounds(250, 230, 200, 30);
            contentPane.add(EmailTA);
            EmailTA.setBorder(border);
            EmailTA.setVisible(true);
            EmailTA.setForeground(new Color(188, 188, 188));
            EmailTA.setHorizontalAlignment(JTextField.CENTER);
        
            // Sign in text field
            JTextField header_SI = new JTextField("Sign in to Coinbase");
            header_SI.setBounds(260, 140, 300, 70);
            contentPane.add(header_SI);
            header_SI.setBackground(new Color(16, 89, 251));
            header_SI.setEditable(false);
            header_SI.setFont(new Font("Tahoma", Font.PLAIN, 22));
            header_SI.setBorder(null);
            header_SI.setOpaque(false);
        
            // Password text field
            JTextField passTA = new JTextField("");
            passTA.setBounds(250, 290, 200, 30);
            contentPane.add(passTA);
            passTA.setBorder(border);
            passTA.setForeground(new Color(188, 188, 188));
            passTA.setHorizontalAlignment(JTextField.CENTER);

            // Email label
            JLabel emailL = new JLabel("Email");
            emailL.setBounds(250, 205, 200, 30);
            contentPane.add(emailL);
            emailL.setFont(new Font("Tahoma", Font.PLAIN, 10));

            // Password label
            JLabel passL = new JLabel("Password");
            passL.setBounds(250, 265, 200, 30);
            contentPane.add(passL);
            passL.setFont(new Font("Tahoma", Font.PLAIN, 10));
                
    

            // Extra information text area
            JTextArea ExtraInfo1 = new JTextArea ("Join 68+ million people on Coinbase" + 
                                    "\n" + "Buy, sell, and manage your crypto on the world’s most trusted crypto exchange" +
                                    "\n" + "   * 68+ million customerse   " + "\n" + "   * 100+ supported countries   ");
            ExtraInfo1.setBounds(180, 440, 390, 250);
            contentPane.add(ExtraInfo1);
            ExtraInfo1.setBackground(new Color(255, 255, 255));
            ExtraInfo1.setEditable(false);
            ExtraInfo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
            ExtraInfo1.setLineWrap(true);
            ExtraInfo1.setWrapStyleWord(true);
            ExtraInfo1.setBorder(null);
            ExtraInfo1.setOpaque(false);
            ExtraInfo1.setForeground(new Color(255, 255, 255));

            // Log in button
            JButton btnNewButton = new JButton("Log in");
            contentPane.add(btnNewButton);
            btnNewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0)
            {
                String emailFieldStr = EmailTA.getText();
                emailFieldStr        = emailFieldStr.trim();
                if (emailFieldStr == "" || emailFieldStr == null || emailFieldStr.length() == 0)
                {
                    JOptionPane.showMessageDialog(null,
                                    "Please enter a valid email address.");
                    
                    return;
                }
                String dataStr = null;
                dataStr="User : " + emailFieldStr;
     
                fileIO fio = new fileIO("users.txt");
                fio.wrTransactionData(dataStr);
                
                new BuyAndSell();
            }
        });

        btnNewButton.setBounds(250, 365, 200, 30);
        contentPane.add(btnNewButton);

        // Background box for log in
        JTextArea background1 = new JTextArea();
        background1.setBounds(200, 150, 300, 250);
        background1.setEditable(false);
        contentPane.add(background1);
        background1.setBorder(border2);
        

            
            // Sign up section
        
            // First name label
            JLabel FnameL = new JLabel("First name");
            FnameL.setBounds(650, 225, 90, 30);
            contentPane.add(FnameL);
            FnameL.setBorder(null);
            FnameL.setFont(new Font("Tahoma", Font.PLAIN, 10));
            
            // Last name label
            JLabel LnameL = new JLabel("Last name");
            LnameL.setBounds(760, 225, 90, 30);
            contentPane.add(LnameL);
            LnameL.setBorder(null);
            LnameL.setFont(new Font("Tahoma", Font.PLAIN, 10));

            // First name test field
            JTextField FnameTA = new JTextField("First name");
            FnameTA.setBounds(650, 250, 90, 30);
            contentPane.add(FnameTA);
            FnameTA.setBorder(border);
            FnameTA.setForeground(new Color(188, 188, 188));
            FnameTA.setHorizontalAlignment(JTextField.CENTER);

            // Create account label
            JTextField header_SU = new JTextField("Create your account today");
            header_SU.setBounds(620, 140, 300, 70);
            contentPane.add(header_SU);
            header_SU.setOpaque(false);
            header_SU.setEditable(false);
            header_SU.setFont(new Font("Tahoma", Font.PLAIN, 22));
            header_SU.setBorder(null);

            // Last name text field
            JTextField LnameTA = new JTextField("Last name ");
            LnameTA.setBounds(760, 250, 90, 30);
            contentPane.add(LnameTA);
            LnameTA.setBorder(border);
            LnameTA.setForeground(new Color(188, 188, 188));
            LnameTA.setHorizontalAlignment(JTextField.CENTER);
            
            // Email text field for create account
            JTextField EmailTA2 = new JTextField("Email");
            EmailTA2.setBounds(650, 310, 200, 30);
            contentPane.add(EmailTA2);
            EmailTA2.setBorder(border);
            EmailTA2.setForeground(new Color(188, 188, 188));
            EmailTA2.setHorizontalAlignment(JTextField.CENTER);

            // Email label for create account
            JLabel EmailL = new JLabel("Email");
            EmailL.setBounds(650, 285, 90, 30);
            contentPane.add(EmailL);
            EmailL.setBorder(null);
            EmailL.setFont(new Font("Tahoma", Font.PLAIN, 10));

            // Password text field for create account
            JTextField passTA2 = new JTextField("Choose password");
            passTA2.setBounds(650, 370, 200, 30);
            contentPane.add(passTA2);
            passTA2.setBorder(border);
            passTA2.setForeground(new Color(188, 188, 188));
            passTA2.setHorizontalAlignment(JTextField.CENTER);

            // Password label for create account
            JLabel PassL = new JLabel("Password");
            PassL.setBounds(650, 345, 90, 30);
            contentPane.add(PassL);
            PassL.setBorder(null);
            PassL.setFont(new Font("Tahoma", Font.PLAIN, 10));

            // Create account button
            JButton btnNewButton_2 = new JButton("Create account");
            btnNewButton_2.setBounds(650, 550, 200, 30);
            contentPane.add(btnNewButton_2);

            // State text field

            String state[] = {"Select State", "AK", "AZ", "AR", "CA", "CZ", "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
                                "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VI",
                                "VA", "WA", "WV", "WI", "WY"};
            @SuppressWarnings({ "unchecked", "rawtypes" })
                JComboBox stateF = new JComboBox(state);
                stateF.setBounds(650, 430, 200, 30);
                contentPane.add(stateF);

            // State label
            JLabel stateL = new JLabel("State");
            stateL.setBounds(650, 405, 200, 30);
            contentPane.add(stateL);
            stateL.setBorder(null);
            stateL.setFont(new Font("Tahoma", Font.PLAIN, 10));

            // Social security number text field
            JTextField ssn = new JTextField("Social security number");
            ssn.setBounds(650, 490, 200, 30);
            contentPane.add(ssn);
            ssn.setBorder(border);
            ssn.setForeground(new Color(188, 188, 188));
            ssn.setHorizontalAlignment(JTextField.CENTER);

            // Social security label
            JLabel ssnL = new JLabel("Social security number");
            ssnL.setBounds(650, 465, 200, 30);
            contentPane.add(ssnL);
            ssnL.setBorder(null);
            ssnL.setFont(new Font("Tahoma", Font.PLAIN, 10));
        
            // Background box for sign up
            JTextArea background2 = new JTextArea();
            background2.setBounds(600, 150, 300, 450);
            background2.setEditable(false);
            contentPane.add(background2);
            background2.setBorder(border2);

            // EXIT Button
            JButton btnNewButton_3 = new JButton("EXIT");
            btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnNewButton_3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0)
                {
                    int result = JOptionPane.showConfirmDialog(null,
                                 "Do you really want to exit Coinbase?",
                                 "Coinbase",
                                 JOptionPane.INFORMATION_MESSAGE);

                    
                    if (result == JOptionPane.OK_OPTION)
                    {
                        dispose();
                        System.exit(0);
                     }
                }
                
            });
            btnNewButton_3.setBounds(280, 700, 133, 34);
            contentPane.add(btnNewButton_3);
            
            // HELP Button
            JButton help = new JButton("HELP");
            help.setFont(new Font("Tahoma", Font.PLAIN, 16));
            help.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent e)
            {
                        
            }
            });
            help.setBounds(680, 700, 133, 34);
            contentPane.add(help);
            
            // Call thread to update date and time
            refreshTitleBar();
            
            // User will do the layout
            contentPane.setLayout(null);
            
            // Position frame in the middle of the screen
            this.setLocationRelativeTo(null);
        }

        // Thread to update TITLE BAR, date, and time
        private void refreshTitleBar()
        {
            Thread refreshAllTitleBar = new Thread()
            {
                public void run()
                {
                    while (true){
                        try{
                            // Display current time
                            Date  date = new Date();
                            String str = String.format("%tc", date);
                         
                            String titleString = "Coinbase " + str;
                       
                            setTitle(titleString);
                         
                            sleep(5000L);  // Sleep for 5 seconds or 5,000 milliseconds
                       
                        } // End try block
                  
                        catch (InterruptedException e){
                            JOptionPane.showMessageDialog(null,
                                    "ERROR. Interrupt Exception! Check Internet Connection!",
                                    "Title Top Bar",
                                    JOptionPane.WARNING_MESSAGE);
                            
                            continue;
                        }
                        finally{
                    
                        }
                    }   // End while true
                }
            };

          refreshAllTitleBar.start();
        }

        public class BuyAndSell {
            private JFrame f2 = new JFrame("Buy and Sell Cryptocurrencies ");
            
            public BuyAndSell() {
            
                f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f2.setSize(1000,1000);
                f2.setVisible(true);

                // Header
                JTextArea header = new JTextArea();
                header.setBounds(100, 200, 100, 200);
                header.setEditable(false);
                header.setBackground(new Color(134, 138, 135));
                f2.add(header);
                
                
            }
        }
}