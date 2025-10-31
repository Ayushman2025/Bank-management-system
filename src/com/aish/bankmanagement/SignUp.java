package com.aish.bankmanagement;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {

    Random random = new Random();
    long first = (random.nextLong() % 9000L) + 1000L;
    String ApNo = " " + Math.abs(first);

    JDateChooser DOB;

    JTextField name, fathersName, city, state, address, email, pinCode;

    JButton NextButton;

    JRadioButton G1, G2, G3, M1, M2, M3;


    SignUp(){
        super("SignUp Page");

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("BM icons/bank.png"));
        Image image = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(20,20,100,100);
        add(jLabel);

        JLabel ApplicationForm = new JLabel("APPLICATION FORM NO:" + ApNo);
        ApplicationForm.setForeground(Color.black);
        ApplicationForm.setFont(new Font("Releway", Font.BOLD, 32));
        ApplicationForm.setBounds(155,35,500,25);
        add(ApplicationForm);

        JLabel jLabel1 = new JLabel("PAGE 1");
        jLabel1.setForeground(Color.black);
        jLabel1.setFont(new Font("Releway",Font.BOLD, 18));
        jLabel1.setBounds(315,75,150,18);
        add(jLabel1);

        JLabel jLabel2 = new JLabel("Personal Details");
        jLabel2.setForeground(Color.black);
        jLabel2.setFont(new Font("Releway", Font.BOLD,18));
        jLabel2.setBounds(275,95,200,18);
        add(jLabel2);

        JLabel Name = new JLabel("Name : ");
        Name.setFont(new Font("Releway", Font.BOLD,18));
        Name.setForeground(Color.black);
        Name.setBounds(90,190,100,18);
        add(Name);

        name = new JTextField(50);
        name.setFont(new Font("Releway", Font.BOLD,14));
        name.setForeground(Color.black);
        name.setBounds(260,190,350,25);
        add(name);

        JLabel FatherName = new JLabel("Father's Name : ");
        FatherName.setFont(new Font("Releway", Font.BOLD,18));
        FatherName.setForeground(Color.black);
        FatherName.setBounds(90,240,150,18);
        add(FatherName);

        fathersName = new JTextField(50);
        fathersName.setFont(new Font("Releway", Font.BOLD,14));
        fathersName.setForeground(Color.black);
        fathersName.setBounds(260,240,350,25);
        add(fathersName);

        JLabel Gender = new JLabel("Gender : ");
        Gender.setFont(new Font("Releway", Font.BOLD,18));
        Gender.setForeground(Color.black);
        Gender.setBounds(90,290,100,18);
        add(Gender);

        G1 = new JRadioButton("Male");
        G1.setFont(new Font("Releway", Font.BOLD,15));
        G1.setForeground(Color.black);
        G1.setBackground(new Color(222,255,228));
        G1.setBounds(260,290,100,25);
        add(G1);

        G2 = new JRadioButton("Female");
        G2.setFont(new Font("Releway", Font.BOLD,15));
        G2.setForeground(Color.black);
        G2.setBackground(new Color(222,255,228));
        G2.setBounds(390,290,100,25);
        add(G2);

        G3 = new JRadioButton("Other");
        G3.setFont(new Font("Releway", Font.BOLD,15));
        G3.setForeground(Color.black);
        G3.setBackground(new Color(222,255,228));
        G3.setBounds(530,290,100,25);
        add(G3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(G1);
        buttonGroup.add(G2);
        buttonGroup.add(G3);

        JLabel DateOfBirth = new JLabel("Date Of Birth : ");
        DateOfBirth.setFont(new Font("Releway", Font.BOLD,18));
        DateOfBirth.setForeground(Color.black);
        DateOfBirth.setBounds(90,340,150,18);
        add(DateOfBirth);

        DOB = new JDateChooser();
        DOB.setForeground(Color.black);
        DOB.setFont(new Font("Releway",Font.BOLD, 14));
        DOB.setBounds(260,340,350,25);
        add(DOB);

        JLabel Email = new JLabel("Email Address : ");
        Email.setFont(new Font("Releway", Font.BOLD,18));
        Email.setForeground(Color.black);
        Email.setBounds(90,390,150,18);
        add(Email);

        email = new JTextField(50);
        email.setFont(new Font("Releway", Font.BOLD,14));
        email.setForeground(Color.black);
        email.setBounds(260,390,350,25);
        add(email);

        JLabel MaritalStatus = new JLabel("Marital Status : ");
        MaritalStatus.setFont(new Font("Releway", Font.BOLD,18));
        MaritalStatus.setForeground(Color.black);
        MaritalStatus.setBounds(90,440,150,18);
        add(MaritalStatus);

        M1 = new JRadioButton("Married");
        M1.setFont(new Font("Releway", Font.BOLD,15));
        M1.setForeground(Color.black);
        M1.setBackground(new Color(222,255,228));
        M1.setBounds(260,440,100,25);
        add(M1);

        M2 = new JRadioButton("Unmarried");
        M2.setFont(new Font("Releway", Font.BOLD,15));
        M2.setForeground(Color.black);
        M2.setBackground(new Color(222,255,228));
        M2.setBounds(390,440,120,25);
        add(M2);

        M3 = new JRadioButton("Other");
        M3.setFont(new Font("Releway", Font.BOLD,15));
        M3.setForeground(Color.black);
        M3.setBackground(new Color(222,255,228));
        M3.setBounds(530,440,100,25);
        add(M3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(M1);
        buttonGroup1.add(M2);
        buttonGroup1.add(M3);

        JLabel Address = new JLabel("Address : ");
        Address.setFont(new Font("Releway", Font.BOLD,18));
        Address.setForeground(Color.black);
        Address.setBounds(90,490,100,18);
        add(Address);

        address = new JTextField(50);
        address.setFont(new Font("Releway", Font.BOLD,14));
        address.setForeground(Color.black);
        address.setBounds(260,490,350,25);
        add(address);

        JLabel City = new JLabel("City : ");
        City.setFont(new Font("Releway", Font.BOLD,18));
        City.setForeground(Color.black);
        City.setBounds(90,540,100,22);
        add(City);

        city = new JTextField(50);
        city.setFont(new Font("Releway", Font.BOLD,14));
        city.setForeground(Color.black);
        city.setBounds(260,540,350,25);
        add(city);

        JLabel PinCode = new JLabel("Pin Code : ");
        PinCode.setFont(new Font("Releway", Font.BOLD,18));
        PinCode.setForeground(Color.black);
        PinCode.setBounds(90,590,150,18);
        add(PinCode);

        pinCode = new JTextField(50);
        pinCode.setFont(new Font("Releway", Font.BOLD,14));
        pinCode.setForeground(Color.black);
        pinCode.setBounds(260,590,350,25);
        add(pinCode);

        JLabel State = new JLabel("State : ");
        State.setFont(new Font("Releway", Font.BOLD,18));
        State.setForeground(Color.black);
        State.setBounds(90,640,100,18);
        add(State);

        state = new JTextField(50);
        state.setFont(new Font("Releway", Font.BOLD,14));
        state.setForeground(Color.black);
        state.setBounds(260,640,350,25);
        add(state);


        NextButton = new JButton("Next");
        NextButton.setFont(new Font("Releway", Font.BOLD,15));
        NextButton.setForeground(Color.white);
        NextButton.setBackground(Color.black);
        NextButton.setBounds(495,690,120,24);
        NextButton.addActionListener(this);
        add(NextButton);

        getContentPane().setBackground(new Color(222, 255, 228));
        setSize(730,780);
        setLocation(400,30);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        connectionc con = new connectionc();

        try{
            if (e.getSource() == NextButton){

                String ApplicationNo = ApNo;
                String Name = name.getText();
                String FName = fathersName.getText();

                String Gender = "";
                if (G1.isSelected()) {
                    Gender = "Male";
                } else if (G2.isSelected()) {
                    Gender = "Female";
                } else if (G3.isSelected()) {
                    Gender = "Other";
                }

                String DtOfBth = ((JTextField) DOB.getDateEditor().getUiComponent()).getText();

                String emailAddress = email.getText();

                String MarriedStatus = "";
                if (M1.isSelected()) {
                    MarriedStatus = "Married";
                } else if (M2.isSelected()) {
                    MarriedStatus = "UnMarried";
                } else if (M3.isSelected()) {
                    MarriedStatus = "Other";
                }

                String Address = address.getText();
                String City = city.getText();
                String PinCode = pinCode.getText();
                String State = state.getText();

                if (name.getText().isEmpty() || fathersName.getText().isEmpty() || email.getText().isEmpty() || address.getText().isEmpty() || city.getText().isEmpty() || pinCode.getText().isEmpty() || state.getText().isEmpty() || Gender.isEmpty() || MarriedStatus.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Fill All Fields It's Are Mandatory");
                } else if (DtOfBth.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Fill Your Date Of Birth");
                } else {

                    int RowAffected =  con.statement.executeUpdate("INSERT INTO SignUpT VALUES('"+ApplicationNo+"', '"+Name+"', '"+FName+"', '"+Gender+"', '"+DtOfBth+"', '"+emailAddress+"', '"+MarriedStatus+"', '"+Address+"', '"+City+"', '"+PinCode+"', '"+State+"')");
                    String dialog;
                    if (RowAffected > 0){
                        dialog = "Your Details Stored Successfully";
                    }else {
                        dialog = "Your Details Not Stored";
                    }

                    JOptionPane.showMessageDialog(null,dialog);

                    new SignUp2(ApNo ,Name);
                    setVisible(false);
                }


            }
        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }
    }

    public static void main(String[] args) { new SignUp(); }
}
