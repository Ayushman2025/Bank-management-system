package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    String Name;
    JLabel HeadingLabel;
    JLabel cardNoLabel;
    JLabel passwordLabel;

    JTextField cardNo;
    JPasswordField PinNo;

    JButton SignupBt;
    JButton LoginBt;
    JButton ClearBt;
//    JButton Back;

    Login(){
        super("Bank Management System");

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("BM icons/bank.png"));
        Image image = imageIcon.getImage().getScaledInstance(124,124,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel bankImg = new JLabel(imageIcon1);
        bankImg.setBounds(438,20,124,124);
        add(bankImg);

//        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("BM icons/Screenshot 2025-09-02 013615.png"));
//        Image im = i.getImage().getScaledInstance(200,200,200);
//        ImageIcon i1 = new ImageIcon(im);
//        JLabel jLabel = new JLabel(i1);
//        jLabel.setBounds(750,20,200,200);
//        add(jLabel);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("BM icons/card.png"));
        Image image1 = imageIcon2.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(image1);
        JLabel cardImg = new JLabel(imageIcon3);
        cardImg.setBounds(750,420,150,150);
        add(cardImg);

        HeadingLabel = new JLabel("BANK USER LOGIN");
        HeadingLabel.setForeground(Color.white);
        HeadingLabel.setFont(new Font("",Font.BOLD,36));
        HeadingLabel.setBounds(330, 155,450,40);
        add(HeadingLabel);

        cardNoLabel = new JLabel("Card No : ");
        cardNoLabel.setForeground(Color.white);
        cardNoLabel.setFont(new Font("", Font.BOLD, 25));
        cardNoLabel.setBounds(200,255,150,100);
        add(cardNoLabel);

        cardNo = new JTextField(15);
        cardNo.setForeground(Color.black);
        cardNo.setFont(new Font("", Font.BOLD, 20));
        cardNo.setBounds(350, 285,350,30);
        add(cardNo);

        passwordLabel = new JLabel("Password : ");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("", Font.BOLD, 25));
        passwordLabel.setBounds(200,310,150,100);
        add(passwordLabel);

        PinNo = new JPasswordField(15);
        PinNo.setForeground(Color.black);
        PinNo.setFont(new Font("" ,Font.BOLD,20));
        PinNo.setBounds(350,340,350,30);
        add(PinNo);

        LoginBt = new JButton("LOGIN");
        LoginBt.setForeground(Color.white);
        LoginBt.setBackground(Color.black);
        LoginBt.setFont(new Font(" ", Font.BOLD, 15));
        LoginBt.setBounds(365,420,150,30);
        LoginBt.addActionListener(this);
        add(LoginBt);

        ClearBt = new JButton("CLEAR");
        ClearBt.setForeground(Color.white);
        ClearBt.setBackground(Color.black);
        ClearBt.setFont(new Font(" ", Font.BOLD, 15));
        ClearBt.setBounds(530,420,150,30);
        ClearBt.addActionListener(this);
        add(ClearBt);

        SignupBt = new JButton("OPEN  ACCOUNT");
        SignupBt.setForeground(Color.white);
        SignupBt.setBackground(Color.black);
        SignupBt.setFont(new Font(" ", Font.BOLD, 15));
        SignupBt.setBounds(365,465,315,30);
        SignupBt.addActionListener(this);
        add(SignupBt);

        ImageIcon imageIcon4 = new ImageIcon(ClassLoader.getSystemResource("BM icons/backbg.png"));
        Image image2 = imageIcon4.getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
        ImageIcon imageIcon5 = new ImageIcon(image2);
        JLabel backgroundImg = new JLabel(imageIcon5);
        backgroundImg.setBounds(0,0,1000,600);
        add(backgroundImg);

        setLayout(null);
        setSize(1000,600);
        setVisible(true);
        setLocation(220,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        connectionc con3 = new connectionc();

        try {
            if (e.getSource() == LoginBt){

                String Card_no = cardNo.getText();

                char[] passwordChar = PinNo.getPassword();
                String Pin_no = new String(passwordChar);

//                String Pin_no = PinNo.getText();

                String query = "SELECT * FROM login WHERE Card_Number = "+" "+Card_no+" "+" AND Pin_Number = "+" "+Pin_no+" "+" ";
//                String query = String.format("SELECT * FROM login WHERE Card_Number='%s' AND Pin_Number='%s' ", Card_no, Pin_no);
                ResultSet resultSet = con3.statement.executeQuery(query);

//                PreparedStatement preparedStatement = con3.connection.prepareStatement("SELECT Form_No FROM login WHERE Card_Number = ? AND Pin_Number = ?");
//                preparedStatement.setString(1,Card_no);
//                preparedStatement.setString(2,Pin_no);
//                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){

                    setVisible(false);
                    Name = resultSet.getString("Name");
                    new AtmInterface(Pin_no, Card_no, Name);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number and Password");
                }

            }
//            else if (e.getSource() == SignupBt) {
//               new SignUp();
//               setVisible(false);
//            }
                else if (e.getSource() == ClearBt) {
                cardNo.setText("");
                PinNo.setText("");
            }
                else if (e.getSource() == SignupBt) {
                new SignUp();
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }
    }

    public static void main(String[] args) { new Login(); }
}