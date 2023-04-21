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