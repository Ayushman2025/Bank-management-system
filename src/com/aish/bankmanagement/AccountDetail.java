package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AccountDetail extends JFrame implements ActionListener {

    String FrmNumber;
    String userName;

    JRadioButton AT1, AT2, AT3, AT4;

    JCheckBox AtmCard, InternetBanking, MobileBanking, EmailAlerts, CheckBook, EStatement, DeclarationCkb;

    JButton submit, cancel;

    AccountDetail(String FrNumber , String userName){
        super("Account Details");

        this.FrmNumber = FrNumber;
        this.userName = userName;

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("BM icons/bank.png"));
        Image image = imageIcon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(120,10,100,100);
        add(jLabel);

        JLabel page2 = new JLabel("PAGE 3 ");
        page2.setBounds(313,55,200,30);
        page2.setForeground(Color.black);
        page2.setFont(new Font("Releway", Font.BOLD, 22));
        add(page2);

        JLabel additionalDetail = new JLabel("Account Details");
        additionalDetail.setFont(new Font("Releway", Font.BOLD,22));
        additionalDetail.setForeground(Color.black);
        additionalDetail.setBounds(270,80,200,30);
        add(additionalDetail);

        JLabel formNo = new JLabel("Form No : " + FrmNumber);
        formNo.setFont(new Font("Releway", Font.BOLD,15));
        formNo.setForeground(Color.black);
        formNo.setBounds(600,20,200,22);
        add(formNo);

        JLabel AccountType = new JLabel("Account Type : ");
        AccountType.setForeground(Color.black);
        AccountType.setFont(new Font("Raleway", Font.BOLD, 18));
        AccountType.setBounds(90,150,200,30);
        add(AccountType);

        AT1 = new JRadioButton("Saving Account");
        AT1.setBounds(90,200,200,30);
        AT1.setForeground(Color.black);
        AT1.setBackground(new Color(206, 225, 214));
        AT1.setFont(new Font("Raleway", Font.BOLD, 15));
        add(AT1);

        AT2 = new JRadioButton("Fixed Deposit Account");
        AT2.setBounds(340,200,200,30);
        AT2.setForeground(Color.black);
        AT2.setBackground(new Color(206, 225, 214));
        AT2.setFont(new Font("Raleway", Font.BOLD, 15));
        add(AT2);

        AT3 = new JRadioButton("Current Account");
        AT3.setBounds(90,240,200,30);
        AT3.setForeground(Color.black);
        AT3.setBackground(new Color(206, 225, 214));
        AT3.setFont(new Font("Raleway", Font.BOLD, 15));
        add(AT3);

        AT4 = new JRadioButton("Recurring Deposit Account");
        AT4.setBounds(340,240,250,30);
        AT4.setForeground(Color.black);
        AT4.setBackground(new Color(206, 225, 214));
        AT4.setFont(new Font("Raleway", Font.BOLD, 15));
        add(AT4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(AT1);
        buttonGroup.add(AT2);
        buttonGroup.add(AT3);
        buttonGroup.add(AT4);

        JLabel CardNO = new JLabel("Card Number : ");
        CardNO.setForeground(Color.black);
        CardNO.setFont(new Font("Raleway", Font.BOLD, 18));
        CardNO.setBounds(90,310,200,30);
        add(CardNO);

        JLabel CardINfo = new JLabel("(Your 16-digit Card Number)");
        CardINfo.setForeground(Color.black);
        CardINfo.setFont(new Font("Raleway", Font.BOLD, 12));
        CardINfo.setBounds(90,335,300,30);
        add(CardINfo);

        JLabel CardDigits = new JLabel("XXXX-XXXX-XXXX-4571");
        CardDigits.setForeground(Color.black);
        CardDigits.setFont(new Font("Raleway", Font.BOLD, 18));
        CardDigits.setBounds(340,310,300,30);
        add(CardDigits);

        JLabel CardDgtInfo = new JLabel("(It would appears on ATM Card / Cheque Book and Statements)");
        CardDgtInfo.setForeground(Color.black);
        CardDgtInfo.setFont(new Font("Raleway", Font.BOLD, 12));
        CardDgtInfo.setBounds(340,335,400,30);
        add(CardDgtInfo);

        JLabel PIN = new JLabel("PIN : ");
        PIN.setForeground(Color.black);
        PIN.setFont(new Font("Raleway", Font.BOLD, 18));
        PIN.setBounds(90,385,200,30);
        add(PIN);

        JLabel PinINfo = new JLabel("(Your 4-digit Password)");
        PinINfo.setForeground(Color.black);
        PinINfo.setFont(new Font("Raleway", Font.BOLD, 12));
        PinINfo.setBounds(90,410,200,30);
        add(PinINfo);

        JLabel PinNumber = new JLabel("XXXX");
        PinNumber.setForeground(Color.black);
        PinNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        PinNumber.setBounds(340,385,200,30);
        add(PinNumber);

        JLabel ServiceRequired = new JLabel("Service Required : ");
        ServiceRequired.setForeground(Color.black);
        ServiceRequired.setFont(new Font("Raleway", Font.BOLD, 18));
        ServiceRequired.setBounds(90,470,200,30);
        add(ServiceRequired);

        AtmCard = new JCheckBox("ATM Card");
        AtmCard.setBounds(90,510,200,30);
        AtmCard.setForeground(Color.black);
        AtmCard.setBackground(new Color(206, 225, 214));
        AtmCard.setFont(new Font("Raleway", Font.BOLD, 15));
        add(AtmCard);

        InternetBanking = new JCheckBox("Internet Banking");
        InternetBanking.setBounds(340,510,250,30);
        InternetBanking.setForeground(Color.black);
        InternetBanking.setBackground(new Color(206, 225, 214));
        InternetBanking.setFont(new Font("Raleway", Font.BOLD, 15));
        add(InternetBanking);

        MobileBanking = new JCheckBox("Mobile Banking");
        MobileBanking.setBounds(90,550,200,30);
        MobileBanking.setForeground(Color.black);
        MobileBanking.setBackground(new Color(206, 225, 214));
        MobileBanking.setFont(new Font("Raleway", Font.BOLD, 15));
        add(MobileBanking);

        EmailAlerts = new JCheckBox("EMAIL Alerts");
        EmailAlerts.setBounds(340,550,200,30);
        EmailAlerts.setForeground(Color.black);
        EmailAlerts.setBackground(new Color(206, 225, 214));
        EmailAlerts.setFont(new Font("Raleway", Font.BOLD, 15));
        add(EmailAlerts);

        CheckBook = new JCheckBox("Cheque Book");
        CheckBook.setBounds(90,590,200,30);
        CheckBook.setForeground(Color.black);
        CheckBook.setBackground(new Color(206, 225, 214));
        CheckBook.setFont(new Font("Raleway", Font.BOLD, 15));
        add(CheckBook);

        EStatement = new JCheckBox("E-Statements");
        EStatement.setBounds(340,590,200,30);
        EStatement.setForeground(Color.black);
        EStatement.setBackground(new Color(206, 225, 214));
        EStatement.setFont(new Font("Raleway", Font.BOLD, 15));
        add(EStatement);

        DeclarationCkb = new JCheckBox("I herby declares that the above entered details correct to the best of my knowledge");
        DeclarationCkb.setBounds(90,655,700,30);
        DeclarationCkb.setForeground(Color.black);
        DeclarationCkb.setBackground(new Color(206, 225, 214));
        DeclarationCkb.setFont(new Font("Raleway", Font.BOLD, 12));
        DeclarationCkb.setSelected(true);
        add(DeclarationCkb);

        submit = new JButton("Submit");
        submit.setBounds(200,700,100,22);
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Raleway", Font.BOLD, 13));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(370,700,100,22);
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Raleway", Font.BOLD, 13));
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(new Color(206, 225, 214));
        setLayout(null);
        setVisible(true);
        setLocation(400,30);
        setSize(750,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        connectionc conAd = new connectionc();
        try {
            if (e.getSource() == submit){

                String Form_no = FrmNumber;

                String Account_type = "";
                if (AT1.isSelected()){
                    Account_type = "Saving Account";
                }else if (AT2.isSelected()){
                    Account_type = "Fixed Deposit Account";
                }else if (AT3.isSelected()){
                    Account_type = "Current Account";
                } else if (AT4.isSelected()) {
                    Account_type = "Recurring Deposit Account";
                }

                Random random = new Random();

                long ranCardNoGenerate = (random.nextLong() % 90000000L) + 1240058260000000L;
                String Card_no = " " + Math.abs(ranCardNoGenerate);

                long ranPinNoGenerate = (random.nextLong() % 9000L) + 1000L;
                String Pin_no = " " + Math.abs(ranPinNoGenerate);

                String Services_want = "";
                if (AtmCard.isSelected()){
                    Services_want =  Services_want + "ATM Card, ";
                }
                if (InternetBanking.isSelected()){
                    Services_want = Services_want + "Internet Banking, ";
                }
                if (MobileBanking.isSelected()) {
                    Services_want = Services_want + "Mobile Banking, ";
                }
                if (EmailAlerts.isSelected()) {
                    Services_want = Services_want + "EMAIL Alerts, ";
                }
                if (CheckBook.isSelected()) {
                    Services_want = Services_want + "Cheque Book, ";
                }
                if (EStatement.isSelected()) {
                    Services_want = Services_want + "E-Statements, ";
                }

                if (DeclarationCkb.isSelected()){

                    if (Account_type.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please Fill All Required Fields");
                    }else {

                        int RowAffected = conAd.statement.executeUpdate("INSERT INTO signup_three VALUES('"+Form_no+"', '"+Account_type+"', '"+Card_no+"', '"+Pin_no+"', '"+Services_want+"')");
                        conAd.statement.executeUpdate("INSERT INTO login VALUES('"+Form_no+"', '"+userName+"' , '"+Card_no+"', '"+Pin_no+"')");

                        String dialog;
                        if (RowAffected > 0) {
                            dialog = "Card No :" + Card_no + "\n PIN No : " + Pin_no;
                        }else {
                            dialog = "Some Error Occurs";
                        }

                        JOptionPane.showMessageDialog(null,dialog);

                        new Deposit(Pin_no, Card_no, userName);
                        setVisible(false);
                    }

                }else {
                    JOptionPane.showMessageDialog(null,"Please Check The Declaration Checkbox");
                }

            }

            else if (e.getSource() == cancel){
               System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }

    }

    public static void main(String[] args) { new AccountDetail("", ""); }
}
