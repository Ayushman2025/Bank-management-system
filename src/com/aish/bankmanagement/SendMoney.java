package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class SendMoney extends JFrame implements ActionListener {

    String pin, userName;
    String CardNO;

    JButton Send, Back;
    JLabel jLabel;

    JTextField AcNumber, Amount;

    SendMoney(String pin, String CardNO, String userName){

            this.pin = pin;
            this.userName = userName;
            this.CardNO = CardNO;

            jLabel = new JLabel("SEND YOUR MONEY");
            jLabel.setFont(new Font("Raleway", Font.BOLD, 17));
            jLabel.setForeground(Color.white);
            jLabel.setBounds(470, 160, 500, 25);
            add(jLabel);

            JLabel jLabel1 = new JLabel("Enter Account Number : ");
            jLabel1.setFont(new Font("Raleway", Font.BOLD, 15));
            jLabel1.setForeground(Color.white);
            jLabel1.setBounds(470, 205, 500, 25);
            add(jLabel1);

            AcNumber = new JTextField();
            AcNumber.setFont(new Font("Raleway", Font.BOLD, 16));
            AcNumber.setForeground(Color.white);
            AcNumber.setBackground(new Color(65,125,128));
            AcNumber.setBounds(660, 205, 210, 25);
            add(AcNumber);

            JLabel jLabel2 = new JLabel("Enter Amount : ");
            jLabel2.setFont(new Font("Raleway", Font.BOLD, 15));
            jLabel2.setForeground(Color.white);
            jLabel2.setBounds(470, 240, 500, 25);
            add(jLabel2);

            Amount = new JTextField();
            Amount.setFont(new Font("Raleway", Font.BOLD, 16));
            Amount.setForeground(Color.white);
            Amount.setBackground(new Color(65,125,128));
            Amount.setBounds(660, 240, 210, 25);
            add(Amount);

            Send = new JButton("Send Money");
            Send.setBackground(new Color(65, 125, 128));
            Send.setForeground(Color.white);
            Send.setFont(new Font("Raleway", Font.BOLD, 14));
            Send.setBounds(723, 350, 160, 33);
            Send.addActionListener(this);
            add(Send);

            Back = new JButton("Exit");
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

        if (e.getSource() == Back) {
            setVisible(false);
            new AtmInterface(pin, CardNO, userName);
        }
        else if (e.getSource() == Send){

            String AcNum = AcNumber.getText();
            String amount = Amount.getText();

            if (AcNum.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Enter Account Number");
            }
            else if (amount.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Enter Amount");
            }
            else {
                connectionc con = new connectionc();
                Date date = new Date();

                try{


                    String query = "SELECT * FROM login WHERE Card_Number = "+AcNum+"";
                    ResultSet resultSet = con.statement.executeQuery(query);

                    if (resultSet.next()){
                        String Pin = resultSet.getString("Pin_Number");

                        ResultSet resultSet1 = con.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"'");
                        double balance = 0;
                        while (resultSet1.next()){

                            if (resultSet1.getString("type").equals("Deposit") || resultSet1.getString("type").equals("Receive")) {
                                balance = balance + Double.parseDouble(resultSet1.getString("amount"));
                            }else {
                                balance = balance - Double.parseDouble(resultSet1.getString("amount"));
                            }
                        }

                        if (balance < Double.parseDouble(amount)){
                            JOptionPane.showMessageDialog(null,"You Have Insufficient Balance");
                            setVisible(false);
                            new AtmInterface(pin,CardNO,userName);
                        }else {

                            int up1 = con.statement.executeUpdate("INSERT INTO bank_st VALUES('" + pin + "', '" + CardNO + "', '" + date + "', 'Send', '" + amount + "')");
                            int up2 = con.statement.executeUpdate("INSERT INTO bank_st VALUES('" + Pin + "', '" + AcNum + "', '" + date + "', 'Receive', '" + amount + "')");

                            if (up1 > 0 || up2 > 0){
                                JOptionPane.showMessageDialog(null, "Money Send Successfully");
                                setVisible(false);
                                new AtmInterface(pin,CardNO,userName);
                            }else {
                                JOptionPane.showMessageDialog(null, "! There are some Problem to Send money Please try again latter");
                            }
                        }

                    }else {
                        JOptionPane.showMessageDialog(null,"Account Number Not Exist Please Enter Existed Account Number");
                    }

                }catch (Exception E){
                    E.printStackTrace();
                    JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
                }
            }

        }

    }

    public static void main(String[] args) { new SendMoney("", "", ""); }
}
