package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {

    String pin, userName;
    String CardNO;

    JButton Change, Back;
    JLabel jLabel;

    JPasswordField NewPin;
    JTextField ReEnterNPin;

    PinChange(String pin, String CardNO, String userName){

        this.pin = pin;
        this.userName = userName;
        this.CardNO = CardNO;

        jLabel = new JLabel("CHANGE YOUR PIN");
        jLabel.setFont(new Font("Raleway", Font.BOLD, 17));
        jLabel.setForeground(Color.white);
        jLabel.setBounds(470, 160, 500, 25);
        add(jLabel);

        JLabel jLabel1 = new JLabel("Enter New PIN : ");
        jLabel1.setFont(new Font("Raleway", Font.BOLD, 16));
        jLabel1.setForeground(Color.white);
        jLabel1.setBounds(470, 205, 500, 25);
        add(jLabel1);

        NewPin = new JPasswordField();
        NewPin.setFont(new Font("Raleway", Font.BOLD, 16));
        NewPin.setForeground(Color.white);
        NewPin.setBackground(new Color(65,125,128));
        NewPin.setBounds(635, 205, 170, 25);
        add(NewPin);

        JLabel jLabel2 = new JLabel("Re-Enter New PIN : ");
        jLabel2.setFont(new Font("Raleway", Font.BOLD, 16));
        jLabel2.setForeground(Color.white);
        jLabel2.setBounds(470, 240, 500, 25);
        add(jLabel2);

        ReEnterNPin = new JTextField();
        ReEnterNPin.setFont(new Font("Raleway", Font.BOLD, 16));
        ReEnterNPin.setForeground(Color.white);
        ReEnterNPin.setBackground(new Color(65,125,128));
        ReEnterNPin.setBounds(635, 240, 170, 25);
        add(ReEnterNPin);

        Change = new JButton("Change");
        Change.setBackground(new Color(65, 125, 128));
        Change.setForeground(Color.white);
        Change.setFont(new Font("Raleway", Font.BOLD, 14));
        Change.setBounds(723, 350, 160, 33);
        Change.addActionListener(this);
        add(Change);

        Back = new JButton("Back");
        Back.setBackground(new Color(65, 125, 128));
        Back.setForeground(Color.white);
        Back.setFont(new Font("Raleway", Font.BOLD, 14));
        Back.setBounds(723, 392, 160, 33);
        Back.addActionListener(this);
        add(Back);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("BM icons/atm2.png"));
        Image image = imageIcon.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel AtmImage = new JLabel(imageIcon1);
        AtmImage.setBounds(60, 0, 1500, 800);
        add(AtmImage);

        setLayout(null);
        setSize(1600, 830);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            connectionc con = new connectionc();

            if (e.getSource() == Back){
                setVisible(false);
                new AtmInterface(pin, CardNO, userName);
            }
            else if (e.getSource() == Change) {

                String NEW_pin = NewPin.getText();
                String ReNew_pin = ReEnterNPin.getText();

                if (NEW_pin.isEmpty() || ReNew_pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Fill both Fields");
                }
                else if (!NEW_pin.equals(ReNew_pin)) {
                    JOptionPane.showMessageDialog(null, "Enter PIN does not match");
                }
                else {

                    int up3 = con.statement.executeUpdate("UPDATE signup_three SET Pin_Number = '" + ReNew_pin + "' WHERE Card_Number = " + CardNO + "");
                    int up1 = con.statement.executeUpdate("UPDATE login SET Pin_Number = " + ReNew_pin + " WHERE Card_Number = " + CardNO + "");
                    int up2 = con.statement.executeUpdate("UPDATE bank_st SET pin_Number = " + ReNew_pin + " WHERE Card_Number = " + CardNO + "");

                    if (up1 > 0 && up2 > 0 && up3 > 0) {
                        JOptionPane.showMessageDialog(null, "Your PIN Update Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "There Any Problem To Change Your PIN Please Try Again Latter");
                    }

                    setVisible(false);
                    new Login();
                }
            }
        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }
    }

    public static void main(String[] args) { new PinChange("", "",""); }
}
