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


