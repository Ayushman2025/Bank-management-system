package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmInterface extends JFrame implements ActionListener {

    String userName;
    String pin;
    String CardNO;

    JButton Deposit, FastCash, PinChange, CashWithdraw, MiniStatement, BalanceEnquiry,SendMoney, Exit;

    AtmInterface(String pin, String CardNO, String userName){
        super("WELCOME TO THE ATM");

        this.pin = pin;
        this.userName = userName;
        this.CardNO = CardNO;


        JLabel UserName = new JLabel("Welcome " + userName);
        UserName.setFont(new Font("Raleway", Font.BOLD, 16));
        UserName.setForeground(Color.white);
        UserName.setBounds(484,148,500,30);
        add(UserName);

       JLabel jLabel1 = new JLabel("Please Select Your Transaction");
       jLabel1.setFont(new Font("Raleway", Font.BOLD, 25));
       jLabel1.setForeground(Color.white);
       jLabel1.setBounds(484,173,430,45);
       add(jLabel1);

       Deposit = new JButton("Deposit");
       Deposit.setBackground(new Color(65,125,128));
       Deposit.setForeground(Color.white);
       Deposit.setFont(new Font("Raleway", Font.BOLD, 14));
       Deposit.setBounds(454,265,160,33);
       Deposit.addActionListener(this);
       add(Deposit);

       FastCash = new JButton("Fast Cash");
       FastCash.setBackground(new Color(65,125,128));
       FastCash.setForeground(Color.white);
       FastCash.setFont(new Font("Raleway", Font.BOLD, 14));
       FastCash.setBounds(454,306,160,33);
       FastCash.addActionListener(this);
       add(FastCash);

       PinChange = new JButton("Pin Change");
       PinChange.setBackground(new Color(65,125,128));
       PinChange.setForeground(Color.white);
       PinChange.setFont(new Font("Raleway", Font.BOLD, 14));
       PinChange.setBounds(454,348,160,33);
       PinChange.addActionListener(this);
       add(PinChange);

        SendMoney = new JButton("Send Money");
        SendMoney.setBackground(new Color(65,125,128));
        SendMoney.setForeground(Color.white);
        SendMoney.setFont(new Font("Raleway", Font.BOLD, 14));
        SendMoney.setBounds(454,388,160,33);
        SendMoney.addActionListener(this);
        add(SendMoney);

        CashWithdraw = new JButton("Cash Withdraw");
        CashWithdraw.setBackground(new Color(65,125,128));
        CashWithdraw.setForeground(Color.white);
        CashWithdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        CashWithdraw.setBounds(723,265,160,33);
        CashWithdraw.addActionListener(this);
        add(CashWithdraw);

        MiniStatement = new JButton("Mini Statement");
        MiniStatement.setBackground(new Color(65,125,128));
        MiniStatement.setForeground(Color.white);
        MiniStatement.setFont(new Font("Raleway", Font.BOLD, 14));
        MiniStatement.setBounds(723,306,160,33);
        MiniStatement.addActionListener(this);
        add(MiniStatement);

        BalanceEnquiry = new JButton("Balance Enquiry");
        BalanceEnquiry.setBackground(new Color(65,125,128));
        BalanceEnquiry.setForeground(Color.white);
        BalanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 14));
        BalanceEnquiry.setBounds(723,348,160,33);
        BalanceEnquiry.addActionListener(this);
        add(BalanceEnquiry);

        Exit = new JButton("Exit");
        Exit.setBackground(new Color(65,125,128));
        Exit.setForeground(Color.white);
        Exit.setFont(new Font("Raleway", Font.BOLD, 14));
        Exit.setBounds(723,388,160,33);
        Exit.addActionListener(this);
        add(Exit);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("BM icons/atm2.png"));
        Image image = imageIcon.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel AtmImage = new JLabel(imageIcon1);
        AtmImage.setBounds(60,0,1500,800);
        add(AtmImage);

        setLayout(null);
        setSize(1600,830);
//        setUndecorated(true);          // title bar ko hide kar deta hai
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == Exit){
                setVisible(false);
                new Login();
            }else if (e.getSource() == Deposit){
                setVisible(false);
                new Deposit(pin,CardNO,userName);
            } else if (e.getSource() == CashWithdraw) {
                setVisible(false);
                new Withdraw(pin,CardNO,userName);
            }else if (e.getSource() == BalanceEnquiry){
                setVisible(false);
                new BalanceEnquiry(pin,CardNO,userName);
            }else if (e.getSource() == FastCash){
                setVisible(false);
                new FastCash(pin,CardNO, userName);
            }else if (e.getSource() == PinChange){
                setVisible(false);
                new PinChange(pin,CardNO, userName);
            }else if (e.getSource() == MiniStatement){
                new MiniStatement(CardNO);
            } else if (e.getSource() == SendMoney) {
                setVisible(false);
                new SendMoney(pin,CardNO,userName);
            }

        }catch (Exception E){
           E.printStackTrace();
           JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }
    }

    public static void main(String[] args) { new AtmInterface("", "",""); }
}
