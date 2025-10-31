package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String userName;
    String pin;
    String CardNO;

    JLabel ShowAmount;

    JButton Back;

    BalanceEnquiry(String pin,String CardNO, String userName){

        this.pin = pin;
        this.userName = userName;
        this.CardNO = CardNO;

        JLabel jLabel1 = new JLabel("YOUR CURRENT BALANCE IS RS : ");
        jLabel1.setFont(new Font("Raleway", Font.BOLD, 15));
        jLabel1.setForeground(Color.white);
        jLabel1.setBounds(470,180,500,25);
        add(jLabel1);


        Back = new JButton("Back");
        Back.setBackground(new Color(65,125,128));
        Back.setForeground(Color.white);
        Back.setFont(new Font("Raleway", Font.BOLD, 14));
        Back.setBounds(723,394,160,33);
        Back.addActionListener(this);
        add(Back);

        connectionc con = new connectionc();
        double balance = 0;

        try {
            ResultSet resultSet = con.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' ");

            while (resultSet.next()){

                if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                    balance = balance + Double.parseDouble(resultSet.getString("amount"));
                }else {
                    balance = balance - Double.parseDouble(resultSet.getString("amount"));
                }
            }

        }catch (SQLException s){
            s.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }

        ShowAmount = new JLabel(""+balance);
        ShowAmount.setFont(new Font("Raleway", Font.BOLD, 17));
        ShowAmount.setForeground(Color.white);
        ShowAmount.setBounds(735,180,500,25);
        add(ShowAmount);

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

            if (e.getSource() == Back) {
                setVisible(false);
                new AtmInterface(pin, CardNO, userName);            }

        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }
    }

    public static void main(String[] args) { new BalanceEnquiry("", "",""); }
}
