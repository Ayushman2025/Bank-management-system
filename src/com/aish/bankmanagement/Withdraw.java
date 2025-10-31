package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    String userName;
    String pin;
    String CardNO;

    JTextField Amount;

    JButton Withdraw, Back;

    Withdraw(String pin, String CardNO, String userName) {

        this.pin = pin;
        this.userName = userName;
        this.CardNO = CardNO;

        JLabel jLabel2 = new JLabel("MAXIMUM WITHDRAW IS RS. 10,000");
        jLabel2.setFont(new Font("Raleway", Font.BOLD, 15));
        jLabel2.setForeground(Color.white);
        jLabel2.setBounds(490, 165, 500, 25);
        add(jLabel2);

        JLabel jLabel1 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        jLabel1.setFont(new Font("Raleway", Font.BOLD, 16));
        jLabel1.setForeground(Color.white);
        jLabel1.setBounds(490, 200, 500, 25);
        add(jLabel1);

        Amount = new JTextField(25);
        Amount.setFont(new Font("Raleway", Font.BOLD, 16));
        Amount.setForeground(Color.white);
        Amount.setBackground(new Color(65, 125, 128));
        Amount.setBounds(490, 235, 340, 25);
        add(Amount);

        Withdraw = new JButton("Withdraw");
        Withdraw.setBackground(new Color(65, 125, 128));
        Withdraw.setForeground(Color.white);
        Withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        Withdraw.setBounds(723, 350, 160, 33);
        Withdraw.addActionListener(this);
        add(Withdraw);

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
            if (e.getSource() == Withdraw) {

                connectionc con2 = new connectionc();
                Date date = new Date();

                String amount = Amount.getText();
                double amt = Double.parseDouble(amount);


                ResultSet resultSet = con2.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");
                double balance = 0;
                while (resultSet.next()){

                    if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                        balance = balance + Double.parseDouble(resultSet.getString("amount"));
                    }else {
                        balance = balance - Double.parseDouble(resultSet.getString("amount"));
                    }
                }

                if (amount.isEmpty() || amount.equals("0")) {
                    JOptionPane.showMessageDialog(null, "Please Enter A Valid Amount");
                } else if (amt > 10000) {
                    JOptionPane.showMessageDialog(null, "Please Enter An Amount UpTo Rs. 10,000");
                }else if (amt > balance){
                    JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");
                }
                else {

                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Withdraw', '"+amount+"')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + amount + " Withdraw Successfully");
                        setVisible(false);
                        new AtmInterface(pin, CardNO, userName);
                    }
                }

            } else if (e.getSource() == Back) {
                setVisible(false);
                new AtmInterface(pin, CardNO, userName);
            }

        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }
    }

    public static void main(String[] args) { new Withdraw("", "",""); }
}
