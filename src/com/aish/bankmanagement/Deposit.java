package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

   String userName;
   String pin;
   String CardNO;

   JTextField Amount;

   JButton Deposit, Back;

    Deposit(String pin, String CardNO, String userName){
        super("Deposit");

        this.pin = pin;
        this.userName = userName;
        this.CardNO = CardNO;

        JLabel jLabel1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        jLabel1.setFont(new Font("Raleway", Font.BOLD, 17));
        jLabel1.setForeground(Color.white);
        jLabel1.setBounds(504,178,500,25);
        add(jLabel1);

        Amount = new JTextField(25);
        Amount.setFont(new Font("Raleway", Font.BOLD, 17));
        Amount.setForeground(Color.white);
        Amount.setBackground(new Color(65,125,128));
        Amount.setBounds(504,220,335,26);
        add(Amount);

        Deposit = new JButton("Deposit");
        Deposit.setBackground(new Color(65,125,128));
        Deposit.setForeground(Color.white);
        Deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        Deposit.setBounds(723,350,160,33);
        Deposit.addActionListener(this);
        add(Deposit);

        Back = new JButton("Back");
        Back.setBackground(new Color(65,125,128));
        Back.setForeground(Color.white);
        Back.setFont(new Font("Raleway", Font.BOLD, 14));
        Back.setBounds(723,392,160,33);
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
            if (e.getSource() == Deposit){

                connectionc con2 = new connectionc();
                Date date = new Date();

                String amount = Amount.getText();

                if (amount.isEmpty() || amount.equals("0") ){
                    JOptionPane.showMessageDialog(null,"Please Enter A Valid Amount");
                }else {

                    int RowAffected = con2.statement.executeUpdate("INSERT INTO bank_st VALUES('"+pin+"', '"+CardNO+"', '"+date+"', 'Deposit', '"+amount+"')");

                    if (RowAffected > 0){
                        JOptionPane.showMessageDialog(null,"Rs : " + amount + " deposit Successfully");
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

    public static void main(String[] args) { new Deposit("", "",""); }
}
