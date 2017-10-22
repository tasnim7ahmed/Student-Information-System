/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tasnim Ahmed
 */
public class STUDENT extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static Login login = new Login();
    public static LoginFinal loginfinal = new LoginFinal();
    public static Register register = new Register();
    public static StudentMenu sm = new StudentMenu();
    public static TeacherMenu tm = new TeacherMenu();
    public static StudentProfile sp = new StudentProfile();
    public static TeacherProfile tp = new TeacherProfile();
    public static AdminMenu am = new AdminMenu();
    public static StudentList sl = new StudentList();
    public static TeacherList tl = new TeacherList();
    STUDENT()
    {
        initialize();
    }
    
    public void initialize()
    {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("STUDENT INFORMATION SYSTEM");
        this.add(login, BorderLayout.CENTER);
        this.pack();
        this.validate();
        this.setVisible(true);

        setAction();
        
    }
    
    public static long hash(String a, String b) {
        String str = a + b;
        long prime = 3797;
        long MOD = 1000000007;
        long Hash = 0;
        for (int i = 0; i < str.length(); i++) {
            Hash = (prime * Hash) % MOD + str.charAt(i);
            Hash = Hash % MOD;
        }
        return Hash;
    }
    
    public void setAction()
    {
        login.jButton1.addActionListener(e->{
            loginfinal.jPasswordField1.setText("");
            loginfinal.jTextField1.setText("");
         this.remove(login);
            this.add(loginfinal, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        
        login.jButton2.addActionListener(e->{
         this.remove(login);
            this.add(register, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
            this.pack();
        });
        loginfinal.jButton4.addActionListener(e->{
         String username = loginfinal.jTextField1.getText();
         String password = loginfinal.jPasswordField1.getText();
         
         try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","student","123");
            Statement st = con.createStatement();
            String query = "Select * from teacher";
            ResultSet rs = st.executeQuery(query);
            int flag = 0;
            while(rs.next())
            {
                String usr = rs.getString(9);
                String pass = rs.getString(10);
                if(usr.equals(username) && pass.equals(password))
                {
                    flag = 1;
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String age = rs.getString(3);
                    String sex = rs.getString(4);
                    String address = rs.getString(8);
                    String dob = rs.getString(5);
                    String dept = rs.getString(6);
                    
                    String contact = rs.getString(8);
                    String sss = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
                    tp.jLabel20.setText(Integer.toString(id));
                    tp.jLabel6.setText(name);
                    tp.jLabel7.setText(age);
                    tp.jLabel5.setText(sex);
                    tp.jLabel15.setText(address);
                    tp.jLabel9.setText(dob);
                    tp.jLabel11.setText(dept);
                    sp.jLabel17.setText(contact);
                    sp.jLabel19.setText(sss);
                    this.remove(loginfinal);
                    this.add(tp, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
                    loginfinal.jTextField1.setText("");
                    loginfinal.jPasswordField1.setText("");
                    break;
                }
            }
            rs.close();
            st.close();
            con.close();
            if(flag==0)
            {
                JOptionPane.showMessageDialog(null,"Username or Password doesn't match, Try Again!" ,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

         
         
        });
        
        loginfinal.jButton3.addActionListener(e->{
         String username = loginfinal.jTextField1.getText();
         String password = loginfinal.jPasswordField1.getText();
         
         try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","student","123");
            Statement st = con.createStatement();
            String query = "Select * from student";
            ResultSet rs = st.executeQuery(query);
            int flag = 0;
            while(rs.next())
            {
                String usr = rs.getString(9);
                String pass = rs.getString(10);
                if(usr.equals(username) && pass.equals(password))
                {
                    flag = 1;
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String age = rs.getString(3);
                    String sex = rs.getString(4);
                    String address = rs.getString(11);
                    String dob = rs.getString(5);
                    String dept = rs.getString(6);
                    String sem = rs.getString(7);
                    String contact = rs.getString(8);
                    String sss = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
                    sp.jLabel20.setText(Integer.toString(id));
                    sp.jLabel6.setText(name);
                    sp.jLabel7.setText(age);
                    sp.jLabel5.setText(sex);
                    sp.jLabel15.setText(address);
                    sp.jLabel9.setText(dob);
                    sp.jLabel11.setText(dept);
                    sp.jLabel13.setText(sem);
                    sp.jLabel17.setText(contact);
                    sp.jLabel19.setText(sss);
                    this.remove(loginfinal);
                    this.add(sp, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
                    loginfinal.jTextField1.setText("");
                    loginfinal.jPasswordField1.setText("");
                    break;
                }
            }
            rs.close();
            st.close();
            con.close();
            if(flag==0)
            {
                JOptionPane.showMessageDialog(null,"Username or Password doesn't match, Try Again!" ,"ERROR",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

         
         
        });
        
        
        sp.jButton9.addActionListener(e -> {
        
         this.remove(sp);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        
        tp.jButton9.addActionListener(e -> {
        
         this.remove(tp);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        
        loginfinal.jButton5.addActionListener(e -> {
            
        
         this.remove(loginfinal);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        am.jButton2.addActionListener(e -> {
            
        
         this.remove(am);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        sl.jButton2.addActionListener(e -> {
            
        
         this.remove(sl);
                    this.add(am, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        sm.jButton2.addActionListener(e -> {
            
        
         this.remove(sm);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        tm.jButton2.addActionListener(e -> {
            
        
         this.remove(tm);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        tl.jButton2.addActionListener(e -> {
            
        
         this.remove(tl);
                    this.add(am, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        
        
        am.jButton3.addActionListener(e -> {
            
            DefaultTableModel model = (DefaultTableModel) sl.jTable1.getModel();
            int row = model.getRowCount();
                while (row > 0) {
                    model.removeRow(model.getRowCount() - 1);
                    row = model.getRowCount();
                }
                //System.out.println(row);
                // for(int i=0;i<row;i++)model.removeRow(i);

                try {
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "123");
                    Statement st = con.createStatement();
                    String query = "Select * from student";
                    ResultSet rs = st.executeQuery(query);
                    //System.out.print("Here\n");
                    while (rs.next()) {
                        
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String age = rs.getString(3);
                    String sex = rs.getString(4);
                    String address = rs.getString(11);
                    String dob = rs.getString(5);
                    String dept = rs.getString(6);
                    String sem = rs.getString(7);
                    String contact = rs.getString(8);
                    
                        model.addRow(new Object[]{id,name,age,sex,address,dob,dept,sem,contact});
                    }
                    
                    rs.close();
                    st.close();
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        
         this.remove(am);
                    this.add(sl, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        
        
        am.jButton4.addActionListener(e -> {
            
            DefaultTableModel model = (DefaultTableModel) tl.jTable1.getModel();
            int row = model.getRowCount();
                while (row > 0) {
                    model.removeRow(model.getRowCount() - 1);
                    row = model.getRowCount();
                }
                //System.out.println(row);
                // for(int i=0;i<row;i++)model.removeRow(i);

                try {
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "123");
                    Statement st = con.createStatement();
                    String query = "Select * from teacher";
                    ResultSet rs = st.executeQuery(query);
                    //System.out.print("Here\n");
                    while (rs.next()) {
                        
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String age = rs.getString(3);
                    String sex = rs.getString(4);
                    String address = rs.getString(8);
                    String dob = rs.getString(5);
                    String dept = rs.getString(6);
                    
                    String contact = rs.getString(8);
                    
                        model.addRow(new Object[]{id,name,age,sex,address,dob,dept,contact});
                    }
                    
                    rs.close();
                    st.close();
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        
         this.remove(am);
                    this.add(tl, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        
        
        
        loginfinal.jButton2.addActionListener(e -> {
            String username = loginfinal.jTextField1.getText();
         String password = loginfinal.jPasswordField1.getText();
         
         if(username.equals("admin") && password.equals("admin"))
         {
        
         this.remove(loginfinal);
                    this.add(am, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
         }
        });
        
        register.jButton3.addActionListener(e -> {
        
        this.remove(register);
                    this.add(sm, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        
        });
        
        register.jButton2.addActionListener(e -> {
        
        this.remove(register);
                    this.add(tm, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        
        });
        register.jButton4.addActionListener(e -> {
        
        this.remove(register);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        
        });
        sm.jButton1.addActionListener(e -> {
        
        
        String name = sm.jTextField3.getText();
        int age = Integer.parseInt(sm.jTextField4.getText());
        String sex = sm.jComboBox2.getItemAt(sm.jComboBox2.getSelectedIndex());
        String address = sm.jTextField6.getText();
        String DOB = sm.jTextField7.getText();
        String dept = sm.jComboBox3.getItemAt(sm.jComboBox3.getSelectedIndex());
        String sem = sm.jComboBox1.getItemAt(sm.jComboBox1.getSelectedIndex());
        String contact = sm.jTextField2.getText();
        int id = (int)hash(name,contact);
        String username = sm.jTextField1.getText();
        String password = sm.jPasswordField1.getText();
        try {
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "123");
                    Statement st = con.createStatement();
                    String query = "Insert into student values ( "+id+",'"+name+"',"+age+",'"+sex+"','"+DOB+"','"+dept+"','"+sem+"','"+contact+"','"+username+"','"+password+"','"+address+"')";
                    ResultSet rs = st.executeQuery(query);
                    //System.out.print("Here\n");
                   query = "commit";
                   rs = st.executeQuery(query);
                    JOptionPane.showMessageDialog(null,"Account Has Been Created Successfully!" ,"DONE!",JOptionPane.INFORMATION_MESSAGE);
                    rs.close();
                    st.close();
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
         this.remove(sm);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        
        tm.jButton1.addActionListener(e -> {
        
        
        String name = tm.jTextField3.getText();
        int age = Integer.parseInt(tm.jTextField4.getText());
        String sex = tm.jComboBox2.getItemAt(tm.jComboBox2.getSelectedIndex());
        String address = tm.jTextField6.getText();
        String DOB = tm.jTextField7.getText();
        String dept = tm.jComboBox3.getItemAt(tm.jComboBox3.getSelectedIndex());
        String contact = tm.jTextField2.getText();
        int id = (int)hash(name,contact);
        String username = tm.jTextField1.getText();
        String password = tm.jPasswordField1.getText();
        try {
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "student", "123");
                    Statement st = con.createStatement();
                    String query = "Insert into teacher values ( "+id+",'"+name+"',"+age+",'"+sex+"','"+DOB+"','"+dept+"','"+contact+"','"+address+"','"+username+"','"+password+"')";
                    ResultSet rs = st.executeQuery(query);
                    //System.out.print("Here\n");
                   query = "commit";
                   rs = st.executeQuery(query);
                    JOptionPane.showMessageDialog(null,"Account Has Been Created Successfully!" ,"DONE!",JOptionPane.INFORMATION_MESSAGE);
                    rs.close();
                    st.close();
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
         this.remove(tm);
                    this.add(login, BorderLayout.CENTER);
                    this.revalidate();
                    this.repaint();
                    this.pack();
        });
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        STUDENT alvy = new STUDENT();
    }
    
}
