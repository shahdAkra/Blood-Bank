/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ayah
 */
public class EmployeeController implements Initializable {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bloodbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    Employee emp;

    @FXML
    private Button insertBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button refreshBtn;
    @FXML
    private TextField nameIns;
    @FXML
    private TextField DOBIns;
    @FXML
    private TextField phoneNoIns;
    @FXML
    private TextField didIns;
    @FXML
    private TextField nameUP;
    @FXML
    private TextField DOB;
    @FXML
    private TextField phoneNoUp;
    @FXML
    private TextField depUp;
    @FXML
    private TextField IDdel;
    @FXML
    private TextField IDUp;
    @FXML
    private TextField IDins;
    @FXML
    private TextField depNo;
    @FXML
    private Button count;
    @FXML
    private Label answer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        emp = new Employee();
        // TODO
    }

    @FXML
    private void insertEmp(ActionEvent event) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("can not Connect to database ...");

        }

        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");

        stmt = conn.prepareStatement("insert into employees values(?,?,?,?,?)");
        stmt.setObject(1, IDins.getText());
        stmt.setObject(2, nameIns.getText());
        stmt.setObject(3, phoneNoIns.getText());
        stmt.setObject(4, DOBIns.getText());
        stmt.setObject(5, didIns.getText());        
        int i = stmt.executeUpdate();
        System.out.println(i + " records inserted");
        stmt = conn.prepareStatement("select * from department");
     

        conn.close();
    }

    @FXML
    private void updateEmp(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("can not Connect to database ...");

        }

        //STEP 4: Execute a query
        stmt = conn.prepareStatement("update employees set eName=? where eId=?");
        stmt.setObject(1, nameUP.getText());//1 specifies the first parameter in the query i.e. name
        stmt.setObject(2, IDUp.getText());
        stmt2 = conn.prepareStatement("update employees set DOB=? where eId=?");
        stmt2.setObject(1, DOB.getText());
        stmt2.setObject(2, IDUp.getText());
        System.out.println("lina");

        stmt3 = conn.prepareStatement("update employees set phoneNo=? where eId=?");
        stmt3.setObject(1, phoneNoUp.getText());
        stmt3.setObject(2, IDUp.getText());

        System.out.println("shahd");
        stmt4 = conn.prepareStatement("update employees set dId=? where eId=?");
        stmt4.setObject(1, depUp.getText());
        stmt4.setObject(2, IDUp.getText());
        System.out.println("hereee");

        try {
            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");

            int b = stmt2.executeUpdate();
            int c = stmt3.executeUpdate();
            int d = stmt4.executeUpdate();
            System.out.println(i + " records updated");
            System.out.println(b + " records updated");
            System.out.println(c + " records updated");
            System.out.println(d + " records updated");
            conn.close();
        } catch (AssertionError e) {
            System.out.println("111111111");
        } catch (Exception e) {
            System.out.println("222222222");
        }

    }

    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        try {
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("can not Connect to database ...");

        }

        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");
        stmt = con.prepareStatement("delete from employees where eId=?");
        stmt.setObject(1, IDdel.getText());

        int i = stmt.executeUpdate();
        System.out.println(i + " records deleted");
    }

    @FXML
    private void refresh(ActionEvent event) {
        IDins.setText(null);
        nameIns.setText(null);
        DOBIns.setText(null);
        DOB.setText(null);
        phoneNoIns.setText(null);
        phoneNoUp.setText(null);
        didIns.setText(null);
        IDUp.setText(null);
        IDdel.setText(null);
        nameUP.setText(null);
        depUp.setText(null);
        
        
    }

    @FXML
    private void count(ActionEvent event) throws SQLException, ClassNotFoundException {
          System.out.println("hereeeeeeeeeeeeee!!");
        Connection conn = null;
        PreparedStatement stmt3 = null;

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("can not Connect to database ...");

        }
    
        int num=Integer.parseInt(depNo.getText());
             System.out.println(num);
        String sql =" SELECT  COUNT(*) FROM employees where  did ="+Integer.parseInt(depNo.getText());
   
        stmt3 = conn.prepareStatement(sql);
        
   
       
        
        ResultSet rs = stmt3.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
//Print one row          
            for (int j = 1; j <= columnsNumber; j++) {

                System.out.print(rs.getString(j) + " "); //Print one element of a row
                answer.setText(rs.getString(j) + "\n");

            }

            System.out.println();//Move to the next line to print the next row.           

        }
        stmt3.executeQuery();
        conn.close();

    }
    }


