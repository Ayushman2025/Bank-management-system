package com.aish.bankmanagement;

import javax.swing.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {

    String CardNO;

    JButton Exit, Print;

    MiniStatement(String CardNO){

        this.CardNO = CardNO;

        JLabel label = new JLabel("=====Your Last Ten Transaction Statement=====");
        label.setFont(new Font("System", Font.BOLD, 20));
        label.setBounds(10,30,480,30);
        add(label);

        JLabel label1 = new JLabel("=================Thanks================");
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(10,580,480,30);
        add(label1);

        JLabel cardNO = new JLabel("Card Number :  " + CardNO.substring(0,4) + "XXXXXXXX" + CardNO.substring(12));
        cardNO.setFont(new Font("System", Font.BOLD, 16));
        cardNO.setBounds(30,80,450,22);
        add(cardNO);

        JLabel Bal = new JLabel();
        Bal.setFont(new Font("System", Font.BOLD, 16));
        Bal.setBounds(30,530,450,22);
        add(Bal);

        JLabel Statements = new JLabel();
        Statements.setBounds(30,140,470,360);
        Statements.setFont(new Font("System", Font.BOLD, 13));
        add(Statements);


        try {
            connectionc con = new connectionc();
            double balance = 0;

            ResultSet resultSet1 = con.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"' order by date desc limit 10;");

            while (resultSet1.next()){

                Statements.setText(Statements.getText()+
                        "<html>"
                        + resultSet1.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet1.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet1.getString("amount") +
                        "<br><br><html>");
            }

            ResultSet resultSet = con.statement.executeQuery("SELECT * FROM bank_st WHERE Card_Number = '"+CardNO+"'");

            while (resultSet.next()){

                if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Receive")) {
                    balance = balance + Double.parseDouble(resultSet.getString("amount"));
                }else {
                    balance = balance - Double.parseDouble(resultSet.getString("amount"));
                }
            }

            Bal.setText("Your Current Balance is Rs.  " + balance);

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }


        Exit = new JButton("Exit");
        Exit.setFont(new Font("System",Font.BOLD,16));
        Exit.setBackground(Color.black);
        Exit.setForeground(Color.white);
        Exit.setBounds(100,630,120,30);
        Exit.addActionListener(this);
        add(Exit);

        Print = new JButton("Print");
        Print.setFont(new Font("System",Font.BOLD,16));
        Print.setBackground(Color.black);
        Print.setForeground(Color.white);
        Print.setBounds(260,630,120,30);
        Print.addActionListener(this);
        add(Print);


        getContentPane().setBackground(new Color(207, 228, 213));
        setSize(500,700);
        setLocation(40,60);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Exit){
            setVisible(false);
        }else if (e.getSource() == Print){
            JOptionPane pane = new JOptionPane("Your Statement Print Successfully",JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog(null);
            dialog.setLocation(150,330);
            dialog.setVisible(true);
            setVisible(false);
        }
    }

    public static void main(String[] args) { new MiniStatement(""); }
}
