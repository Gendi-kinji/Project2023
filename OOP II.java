import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class Parent extends JFrame{

    private JLabel lblWelcome;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblAdmission;
    private JTextField txtAdmission;
    private JButton btnSubmit;
    Connection connection=null;

    public Parent(){
        super("Student sign-in");
        setLayout(new CardLayout());

    lblWelcome=new JLabel("Welcome to the platform");
    lblName=new JLabel("Name:");
    txtName=new JTextField(30);
    lblAdmission=new JLabel("Admission number:");
    txtAdmission=new JTextField(30);
    btnSubmit=new JButton("Submit");

    add(lblWelcome);
    add(lblName);
    add(txtName);
    add(lblAdmission);
    add(txtAdmission);
    add(btnSubmit);

    btnSubmit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Class.forName();
                connection=DriverManager.getConnection();
                String name= txtName.getText();
                int Admission=Integer.parseInt(txtAdmission.getText());
                String Query="";
               PreparedStatement statement=connection.prepareStatement();
               statement.setString(1,name);
               statement.setInt(2,Admission);
               ResultSet rs= statement.executeQuery();
               if (rs.next()){
                   
               }


            }catch(SQLException ex){
                ex.printStackTrace();

            }

        }
    });

}}
public abstract class Notification {
    public float Administration;
    public  float Remedial;
    public float Medical;
    public float Damages;
    public float FeeBal;

    public abstract float getFeeBal();
}
import java.util.Scanner;

public class Calculator extends Notification{
    Scanner scan=new Scanner(System.in);

    float Administration= scan.nextInt();
    float Medical= scan.nextInt();
    float Remedial= scan.nextInt();
    float Damages=scan.nextFloat();
    float FeeBal=Damages+Remedial+Medical+Administration;
    @Override
    public float getFeeBal() {
        return FeeBal;
    }
}
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Fees extends Calculator{
    private JFrame Frame;
    private JLabel lblFee;
    private JLabel lblAdministration;
    private JLabel lblMedical;
    private JLabel lblRemedial;
    private JLabel lblDamages;
    private JButton btnCancel;
    private JButton btnOk;
    public Fees(){
        Frame=new JFrame("Fee notification");
        lblFee=new JLabel("Total fee balance is"+getFeeBal());
        lblAdministration=new JLabel("Administration fee:"+Administration);
        lblMedical=new JLabel("Medical:"+Medical);
        lblRemedial=new JLabel("Remedial:"+Remedial);
        lblDamages=new JLabel("Damages"+Damages);
        btnCancel=new JButton("Cancel");
        btnOk=new JButton("Ok");
        Frame.setLayout(new CardLayout());
        Frame.add(Frame);
        Frame.add(lblFee);
        Frame.add(lblAdministration);
        Frame.add(lblMedical);
        Frame.add(lblRemedial);
        Frame.add(lblDamages);
        Frame.add(btnCancel);
        Frame.add(btnOk);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnCancel.isSelected()){
                    Parent pare=new Parent();

                }

            }
        });
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (btnOk.isSelected()){
                    Parent pare=new Parent();

                }
            }
        });


    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User extends JFrame{
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblNumber;
    private JTextField txtNumber;
    private JLabel lblStatus;
    private JRadioButton radioParent;
    private JRadioButton radioAdministration;
    private JButton btnSubmit;

    public User(){
        super("Sign-in");
        setLayout(new CardLayout());
        lblName=new JLabel("Name");
        txtName=new JTextField(45);
        lblNumber=new JLabel("Phone number");
        txtNumber=new JTextField(45);
        lblStatus=new JLabel("Are you a:");
        radioParent=new JRadioButton("Parent/Guardian");
        radioAdministration=new JRadioButton("Administration");
        btnSubmit=new JButton("Submit");

        add(lblName);
        add(txtName);
        add(lblNumber);
        add(txtNumber);
        add(lblStatus);
        add(radioParent);
        add(radioAdministration);
        add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if(radioParent.isSelected()){
                     Parent par=new Parent();
                 } else if (radioAdministration.isSelected()) {
                     

                 }
            }
        });
    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administration extends Calculator{
    private JFrame fram;
    private JLabel lblAdd;
    private JTextField txtAdd;
    private JLabel lblMed;
    private JTextField txtMed;
    private JLabel lblDamage;
    private JTextField txtDamage;
    private JLabel lblRem;
    private JTextField txtRem;
    private JLabel lblTotal;
    private JTextField txtTotal;
    private JButton btnSubmit;
    public Administration(){
        fram=new JFrame("Administration");
        lblAdd=new JLabel("Administration:");
        txtAdd=new JTextField(30);
        lblMed=new JLabel("Medical:");
        txtMed=new JTextField(30);
        lblDamage=new JLabel("Damages:");
        txtDamage=new JTextField(30);
        lblRem=new JLabel("Remedial:");
        txtRem=new JTextField(30);
        lblTotal=new JLabel("Total:");
        txtTotal=new JTextField(30);
        btnSubmit=new JButton("Submit");
        fram.setLayout(new FlowLayout());
        fram.add(lblAdd);
        fram.add(txtAdd);
        fram.add(lblMed);
        fram.add(txtMed);
        fram.add(lblDamage);
        fram.add(txtDamage);
        fram.add(lblRem);
        fram.add(txtRem);
        fram.add(lblTotal);
        fram.add(txtTotal);
        fram.add(btnSubmit);
        Administration=Float.parseFloat(txtAdd.getText());
        Medical=Float.parseFloat(txtMed.getText());
        Damages=Float.parseFloat(txtDamage.getText());
        Remedial=Float.parseFloat(txtRem.getText());
        FeeBal=Float.parseFloat(txtTotal.getText());
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(FeeBal>=0){
                    Fees fee=new Fees();
                }
                else{
                    User us=new User();
                }
            }
        });


    }

}


