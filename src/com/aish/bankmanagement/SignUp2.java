package com.aish.bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp2 extends JFrame implements ActionListener {

    String FrmNumber;
    String userName;

    JComboBox ReligionCkb, CategoryCkb, IncomeCkb, QualificationCkb, OccupationCkb;

    JButton Next;

    JTextField panNumber, aadharNumber;

    JRadioButton sc1, sc2, eAc1, eAc2;

    SignUp2(String ApNo , String userName){
        super("SignUp Page 2");

        this.FrmNumber = ApNo;
        this.userName = userName;

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("BM icons/bank.png"));
        Image image = imageIcon.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel jLabel = new JLabel(imageIcon1);
        jLabel.setBounds(120,10,100,100);
        add(jLabel);

        JLabel page2 = new JLabel("PAGE 2 ");
        page2.setBounds(313,55,200,30);
        page2.setForeground(Color.black);
        page2.setFont(new Font("Releway", Font.BOLD, 22));
        add(page2);

        JLabel additionalDetail = new JLabel("Addition Details");
        additionalDetail.setFont(new Font("Releway", Font.BOLD,22));
        additionalDetail.setForeground(Color.black);
        additionalDetail.setBounds(270,80,200,30);
        add(additionalDetail);

        JLabel formNo = new JLabel("Form No : " + FrmNumber);
        formNo.setFont(new Font("Releway", Font.BOLD,15));
        formNo.setForeground(Color.black);
        formNo.setBounds(600,20,200,22);
        add(formNo);

        JLabel Religion = new JLabel("Religion : ");
        Religion.setBounds(90,190,150,30);
        Religion.setFont(new Font("Releway", Font.BOLD, 18));
        Religion.setForeground(Color.black);
        add(Religion);

        String[] religion = {"Select", "Hindu", "Muslim", "Sikh", "Christian", "Other"};
        ReligionCkb = new JComboBox<>(religion);
        ReligionCkb.setBounds(300,190,350,25);
        ReligionCkb.setFont(new Font("Releway", Font.BOLD,14));
        ReligionCkb.setForeground(Color.black);
        add(ReligionCkb);

        JLabel Category = new JLabel("Category : ");
        Category.setBounds(90,240,150,30);
        Category.setFont(new Font("Raleway", Font.BOLD, 18));
        Category.setForeground(Color.black);
        add(Category);

        String[] category = {"Select", "General", "OBC", "SC", "ST", "Other"};
        CategoryCkb = new JComboBox<>(category);
        CategoryCkb.setBounds(300,240,350,25);
        CategoryCkb.setFont(new Font("Raleway", Font.BOLD,14));
        CategoryCkb.setForeground(Color.black);
        add(CategoryCkb);


        JLabel Income = new JLabel("Income : ");
        Income.setBounds(90,290,150,30);
        Income.setFont(new Font("Releway", Font.BOLD, 18));
        Income.setForeground(Color.black);
        add(Income);

        String[] income = {"Select", "<1,00,000", "<2,50,000", "<5,00,000", "UpTo 10,00,000", "Above 10,00,000"};
        IncomeCkb = new JComboBox<>(income);
        IncomeCkb.setBounds(300,290,350,25);
        IncomeCkb.setFont(new Font("Raleway", Font.BOLD,14));
        IncomeCkb.setForeground(Color.black);
        add(IncomeCkb);

        JLabel Education = new JLabel("Education ");
        Education.setBounds(90,340,150,30);
        Education.setFont(new Font("Releway", Font.BOLD, 18));
        Education.setForeground(Color.black);
        add(Education);

        JLabel Qualification = new JLabel("Qualification : ");
        Qualification.setBounds(90,360,150,30);
        Qualification.setFont(new Font("Releway", Font.BOLD, 18));
        Qualification.setForeground(Color.black);
        add(Qualification);

        String[] qualification = {"Select", "Graduate", "Post-Graduate", "Phd", "Doctorate", "Other"};
        QualificationCkb = new JComboBox<>(qualification);
        QualificationCkb.setBounds(300,360,350,25);
        QualificationCkb.setFont(new Font("Raleway", Font.BOLD,14));
        QualificationCkb.setForeground(Color.black);
        add(QualificationCkb);

        JLabel Occupation = new JLabel("Occupation : ");
        Occupation.setBounds(90,410,150,30);
        Occupation.setFont(new Font("Releway", Font.BOLD, 18));
        Occupation.setForeground(Color.black);
        add(Occupation);

        String[] occupation = {"Select", "Student", "Employed", "Self-Employed", "Farmer", "Other"};
        OccupationCkb = new JComboBox<>(occupation);
        OccupationCkb.setBounds(300,410,350,25);
        OccupationCkb.setFont(new Font("Raleway", Font.BOLD,14));
        OccupationCkb.setForeground(Color.black);
        add(OccupationCkb);

        JLabel PANNumber = new JLabel("PAN Number : ");
        PANNumber.setBounds(90,460,150,30);
        PANNumber.setFont(new Font("Releway", Font.BOLD, 18));
        PANNumber.setForeground(Color.black);
        add(PANNumber);

        panNumber = new JTextField(50);
        panNumber.setBounds(300,460,350,25);
        panNumber.setFont(new Font("Releway", Font.BOLD,14));
        panNumber.setForeground(Color.black);
        add(panNumber);

        JLabel AadharNumber = new JLabel("Aadhar Number : ");
        AadharNumber.setBounds(90,510,170,30);
        AadharNumber.setFont(new Font("Releway", Font.BOLD, 18));
        AadharNumber.setForeground(Color.black);
        add(AadharNumber);

        aadharNumber = new JTextField(50);
        aadharNumber.setBounds(300,510,350,25);
        aadharNumber.setFont(new Font("Releway", Font.BOLD,14));
        aadharNumber.setForeground(Color.black);
        add(aadharNumber);

        JLabel SeniorCitizen = new JLabel("Senior Citizen : ");
        SeniorCitizen.setBounds(90,560,170,30);
        SeniorCitizen.setFont(new Font("Releway", Font.BOLD, 18));
        SeniorCitizen.setForeground(Color.black);
        add(SeniorCitizen);

        sc1 = new JRadioButton("Yes");
        sc1.setBounds(300,560,150,25);
        sc1.setFont(new Font("Releway", Font.BOLD,15));
        sc1.setForeground(Color.black);
        sc1.setBackground(new Color(203, 237, 215));
        add(sc1);

        sc2 = new JRadioButton("No");
        sc2.setBounds(470,560,150,25);
        sc2.setFont(new Font("Releway", Font.BOLD,15));
        sc2.setForeground(Color.black);
        sc2.setBackground(new Color(203, 237, 215));
        add(sc2);

        ButtonGroup group = new ButtonGroup();
        group.add(sc1);
        group.add(sc2);

        JLabel ExitingAccount = new JLabel("Exiting Account : ");
        ExitingAccount.setBounds(90,610,170,30);
        ExitingAccount.setFont(new Font("Releway", Font.BOLD, 18));
        ExitingAccount.setForeground(Color.black);
        add(ExitingAccount);

        eAc1 = new JRadioButton("Yes");
        eAc1.setBounds(300,610,150,25);
        eAc1.setFont(new Font("Releway", Font.BOLD,15));
        eAc1.setForeground(Color.black);
        eAc1.setBackground(new Color(203, 237, 215));
        add(eAc1);

        eAc2 = new JRadioButton("No");
        eAc2.setBounds(470,610,150,25);
        eAc2.setFont(new Font("Releway", Font.BOLD,15));
        eAc2.setForeground(Color.black);
        eAc2.setBackground(new Color(203, 237, 215));
        add(eAc2);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(eAc1);
        group1.add(eAc2);


        Next = new JButton("Next");
        Next.setBounds(515,685,130,25);
        Next.setFont(new Font("Releway", Font.BOLD,16));
        Next.setForeground(Color.black);
        Next.setBackground(Color.white);
        Next.addActionListener(this);
        add(Next);


        getContentPane().setBackground(new Color(203, 237, 215));
        setLayout(null);
        setVisible(true);
        setLocation(400,30);
        setSize(750,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        connectionc con = new connectionc();
        try {
            if (e.getSource() == Next){

                String Form_no = FrmNumber;
                String Religion = (String) ReligionCkb.getSelectedItem();
                String  Category = (String) CategoryCkb.getSelectedItem();
                String  Income = (String) IncomeCkb.getSelectedItem();
                String EdQualification = (String) QualificationCkb.getSelectedItem();
                String Occupation = (String) OccupationCkb.getSelectedItem();

                String PAN = panNumber.getText();
                String Aadhar = aadharNumber.getText();

                String Senior_Ctz = "";
                if (sc1.isSelected()){
                    Senior_Ctz = "Yes";
                }else if (sc2.isSelected()){
                    Senior_Ctz = "NO";
                }

                String Existing_Ac = "";
                if (eAc1.isSelected()){
                    Existing_Ac = "Yes";
                }else if (eAc2.isSelected()){
                    Existing_Ac = "NO";
                }


                if (Religion.equals("Select") || Category.equals("Select") || Income.equals("Select") || EdQualification.equals("Select") || Occupation.equals("Select") || PAN.isEmpty() || Aadhar.isEmpty() || Senior_Ctz.isEmpty() || Existing_Ac.isEmpty()){
                      JOptionPane.showMessageDialog(null,"Please Fill All Fields It's Are Mandatory");
                }else {

                    int RowAffected = con.statement.executeUpdate("INSERT INTO signup_two VALUES('"+Form_no+"' ,'"+Religion+"' ,'"+Category+"' ,'"+Income+"' ,'"+EdQualification+"' ,'"+Occupation+"' ,'"+PAN+"' ,'"+Aadhar+"' ,'"+Senior_Ctz+"' ,'"+Existing_Ac+"')");

                    String dialog;
                    if (RowAffected > 0){
                        dialog = "Your Details Stored Successfully";
                    }else {
                        dialog = "Your Details Not Stored";
                    }

                    JOptionPane.showMessageDialog(null,dialog);

                    new AccountDetail(FrmNumber , userName);
                    setVisible(false);
                }
            }

        }catch (Exception E){
            E.printStackTrace();
            JOptionPane.showMessageDialog(null,"There Are Some Exception Please Resolve");
        }
    }

    public static void main(String[] args) { new SignUp2("", ""); }
}
