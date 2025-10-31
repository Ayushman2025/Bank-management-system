package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, Back;
    String pin;
    String userName;
    String CardNO;

    FastCash(String pin, String CardNO, String userName){

        this.pin = pin;
        this.userName = userName;
        this.CardNO = CardNO;

        JLabel label = new JLabel("PLEASE SELECT WITHDRAW AMOUNT");
        label.setFont(new Font("Raleway", Font.BOLD, 17));
        label.setForeground(Color.white);
        label.setBounds(460, 180, 500, 25);
        add(label);

        b1 = new JButton("100");
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBounds(455,265,160,33);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("500");
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.white);
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBounds(723,265,160,33);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("1,000");
        b3.setBackground(new Color(65,125,128));
        b3.setForeground(Color.white);
        b3.setFont(new Font("Raleway", Font.BOLD, 14));
        b3.setBounds(455,306,160,33);
        b3.addActionListener(this);
        add(b3);

        b4 = new JButton("2,000");
        b4.setBackground(new Color(65,125,128));
        b4.setForeground(Color.white);
        b4.setFont(new Font("Raleway", Font.BOLD, 14));
        b4.setBounds(723,306,160,33);
        b4.addActionListener(this);
        add(b4);

        b5 = new JButton("5,000");
        b5.setBackground(new Color(65,125,128));
        b5.setForeground(Color.white);
        b5.setFont(new Font("Raleway", Font.BOLD, 14));
        b5.setBounds(455,348,160,33);
        b5.addActionListener(this);
        add(b5);

        b6 = new JButton("10,000");
        b6.setBackground(new Color(65,125,128));
        b6.setForeground(Color.white);
        b6.setFont(new Font("Raleway", Font.BOLD, 14));
        b6.setBounds(723,348,160,33);
        b6.addActionListener(this);
        add(b6);

        Back = new JButton("Back");
        Back.setBackground(new Color(65, 125, 128));
        Back.setForeground(Color.white);
        Back.setFont(new Font("Raleway", Font.BOLD, 14));
        Back.setBounds(723, 390, 160, 33);
        Back.addActionListener(this);
        add(Back);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("BM icons/atm2.png"));
        Image image = imageIcon.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel AtmImage = new JLabel(imageIcon1);
        AtmImage.setBounds(60,0,1500,800);
        add(AtmImage);

        setLayout(null);
        setSize(1600,830);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            connectionc con2 = new connectionc();
            Date date = new Date();

            if (e.getSource() == Back){
                setVisible(false);
                new AtmInterface(pin, CardNO, userName);
            }
            else if (e.getSource() == b1){

                ResultSet resultSet = con2.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");
                double balance = 0;
                while (resultSet.next()){

                    if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                        balance = balance + Double.parseDouble(resultSet.getString("amount"));
                    }else {
                        balance = balance - Double.parseDouble(resultSet.getString("amount"));
                    }
                }
                if (100 > balance){
                    JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");

                }
                else {
                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Withdraw', '100')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + 100 + " Withdraw Successfully");
                        setVisible(false);
                        new AtmInterface(pin, CardNO, userName);
                    }
                }
            } else if (e.getSource() == b2) {

                ResultSet resultSet = con2.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");
                double balance = 0;
                while (resultSet.next()){

                    if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                        balance = balance + Double.parseDouble(resultSet.getString("amount"));
                    }else {
                        balance = balance - Double.parseDouble(resultSet.getString("amount"));
                    }
                }
                if (500 > balance){
                    JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");
                }
                else {

                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Withdraw', '500')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + 500 + " Withdraw Successfully");
                        setVisible(false);
                        new AtmInterface(pin, CardNO, userName);
                    }
                }
            }else if (e.getSource() == b3){

                ResultSet resultSet = con2.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");
                double balance = 0;
                while (resultSet.next()){

                    if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                        balance = balance + Double.parseDouble(resultSet.getString("amount"));
                    }else {
                        balance = balance - Double.parseDouble(resultSet.getString("amount"));
                    }
                }
                if (1000 > balance){
                    JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");
                }
                else {

                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Withdraw', '1000')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + 1000 + " Withdraw Successfully");
                        setVisible(false);
                        new AtmInterface(pin, CardNO, userName);
                    }
                }
            } else if (e.getSource() == b4) {

                ResultSet resultSet = con2.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");
                double balance = 0;
                while (resultSet.next()){

                    if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                        balance = balance + Double.parseDouble(resultSet.getString("amount"));
                    }else {
                        balance = balance - Double.parseDouble(resultSet.getString("amount"));
                    }
                }
                if (2000 > balance){
                    JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");
                }
                else {

                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Withdraw', '2000')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + 2000 + " Withdraw Successfully");
                        setVisible(false);
                        new AtmInterface(pin, CardNO, userName);
                    }
                }
            }else if (e.getSource() == b5){

                ResultSet resultSet = con2.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");
                double balance = 0;
                while (resultSet.next()){

                    if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                        balance = balance + Double.parseDouble(resultSet.getString("amount"));
                    }else {
                        balance = balance - Double.parseDouble(resultSet.getString("amount"));
                    }
                }
                if (5000 > balance){
                    JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");
                }
                else {

                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Withdraw', '5000')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + 5000 + " Withdraw Successfully");
                        setVisible(false);
                        new AtmInterface(pin, CardNO, userName);
                    }
                }
            } else if (e.getSource() == b6) {

                ResultSet resultSet = con2.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");
                double balance = 0;
                while (resultSet.next()){

                    if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                        balance = balance + Double.parseDouble(resultSet.getString("amount"));
                    }else {
                        balance = balance - Double.parseDouble(resultSet.getString("amount"));
                    }
                }
                if (10000 > balance){
                    JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");
                }
                else {

                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Withdraw', '10000')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + 10000 + " Withdraw Successfully");
                        setVisible(false);
                        new AtmInterface(pin, CardNO, userName);
                    }
                }
            }

        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null, "There Are Some Exception Please Resolve");
        }

    }

    public static void main(String[] args) { new FastCash("", "",""); }
}
