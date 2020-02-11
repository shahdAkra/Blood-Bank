/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasegui;

import employee.Employee;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import person.Person;

/**
 * FXML Controller class
 *
 * @author awj
 */
public class PersonController implements Initializable {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bloodbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    Person per;

    @FXML
    private Button insertBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private MenuButton insertBloodUnit;
    @FXML
    private TextField insertID;
    @FXML
    private TextField insertName;
    @FXML
    private TextField insertGender;
    @FXML
    private TextField insertDOB;
    @FXML
    private TextField insertPhoneNo;
    @FXML
    private TextField insertWeight;
    @FXML
    private TextField insertHieght;
    @FXML
    private TextField deleteID;
    @FXML
    private MenuItem A1Btn;
    @FXML
    private MenuItem A2Btn;
    @FXML
    private MenuItem B1Btn;
    @FXML
    private MenuItem B2Btn;
    @FXML
    private MenuItem O1Btn;
    @FXML
    private MenuItem O2Btn;
    @FXML
    private MenuItem AB1Btn;
    @FXML
    private MenuItem AB2Btn;
    @FXML
    private TextField uText;
    @FXML
    private Label DonarId;
    @FXML
    private TextField donarsafety;
    @FXML
    private TextField quantity;
    @FXML
    private Button donorInsertion;
    @FXML
    private Button donorUpdate;

    @FXML
    private TextField bloodUnitID;
    private TextField patientTime;
    @FXML
    private Button patientInsert;
    @FXML
    private Button patientUpdate;
    @FXML
    private Label patientId;
    @FXML
    private TextArea printDonor;
    @FXML
    private TextField donationCount;
    @FXML
    private Label answer;
    @FXML
    private Button donation;
    @FXML
    private Button COUNT2;
    @FXML
    private TextField TXT1;
    @FXML
    private Label answer1;
    @FXML
    private MenuItem A11;
    @FXML
    private MenuItem A22;
    @FXML
    private MenuItem B11;
    @FXML
    private MenuItem B22;
    @FXML
    private MenuItem O11;
    @FXML
    private MenuItem O22;
    @FXML
    private MenuItem AB11;
    @FXML
    private MenuItem AB22;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        per = new Person();

    }
//  int count=0;

    @FXML
    private void insertPerson(ActionEvent event) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

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

        stmt = conn.prepareStatement("insert into person() values(?,?,?,?,?,?,?,?)");
        stmt.setObject(1, insertID.getText());

        per.setID(Integer.parseInt(insertID.getText()));
        DonarId.setText(insertID.getText());//prints id on donaor tab 
        patientId.setText(insertID.getText());

        stmt.setObject(2, insertName.getText());

        stmt.setObject(3, insertGender.getText());
        stmt.setObject(4, uText.getText());
        stmt.setObject(5, insertDOB.getText());
        stmt.setObject(6, insertWeight.getText());
        stmt.setObject(7, insertPhoneNo.getText());
        stmt.setObject(8, insertHieght.getText());

        int i = stmt.executeUpdate();

        System.out.println(i + " records inserted");

        //stmt = conn.prepareStatement("select * from person");
        //ResultSet rs = stmt.executeQuery();
        conn.close();
    }

    @FXML
    private void updatePerson(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;
        PreparedStatement stmt5 = null;
        PreparedStatement stmt6 = null;
        PreparedStatement stmt7 = null;

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
        stmt = conn.prepareStatement("update person set pName=? where pId=?");
        stmt.setObject(1, insertName.getText());//1 specifies the first parameter in the query i.e. name
        stmt.setObject(2, insertID.getText());

        stmt2 = conn.prepareStatement("update person set gender=? where pId=?");
        stmt2.setObject(1, insertGender.getText());
        stmt2.setObject(2, insertID.getText());

        stmt3 = conn.prepareStatement("update person set uId=? where pId=?");
        stmt3.setObject(1, uText.getText());
        stmt3.setObject(2, insertID.getText());

        stmt4 = conn.prepareStatement("update person set DOB=? where pId=?");
        stmt4.setObject(1, insertDOB.getText());
        stmt4.setObject(2, insertID.getText());

        stmt5 = conn.prepareStatement("update person set weight=? where pId=?");
        stmt5.setObject(1, insertWeight.getText());
        stmt5.setObject(2, insertID.getText());

        stmt6 = conn.prepareStatement("update person set phoneNo=? where pId=?");
        stmt6.setObject(1, insertPhoneNo.getText());
        stmt6.setObject(2, insertID.getText());

        stmt7 = conn.prepareStatement("update person set hieght=? where pId=?");
        stmt7.setObject(1, insertHieght.getText());
        stmt7.setObject(2, insertID.getText());

        try {
            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");

            stmt2.executeUpdate();
            stmt3.executeUpdate();
            stmt4.executeUpdate();
            stmt5.executeUpdate();
            stmt6.executeUpdate();
            stmt7.executeUpdate();

            conn.close();
        } catch (AssertionError e) {
            System.out.println("111111111");
        } catch (Exception e) {
            System.out.println("222222222");
        }
    }

    @FXML
    private void deletePerson(ActionEvent event) throws ClassNotFoundException, SQLException {

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
        System.out.println("Deleting records into the table...");
        stmt = con.prepareStatement("delete from person where pId=?");
        stmt.setObject(1, deleteID.getText());

        int i = stmt.executeUpdate();
        System.out.println(i + " records deleted");
    }

    @FXML
    private void A1(ActionEvent event) {
        uText.setText("1");

    }

    @FXML
    private void A2(ActionEvent event) {
        uText.setText("2");
        // return 2;
    }

    @FXML
    private void B1(ActionEvent event) {
        uText.setText("3");

    }

    @FXML
    private void B2(ActionEvent event) {
        uText.setText("4");

    }

    @FXML
    private void O1(ActionEvent event) {
        uText.setText("5");

    }

    @FXML
    private void O2(ActionEvent event) {
        uText.setText("6");

    }

    @FXML
    private void AB1(ActionEvent event) {
        uText.setText("7");

    }

    @FXML
    private void AB2(ActionEvent event) {
        uText.setText("8");

    }

    @FXML
    private void insertBloodUnit(ActionEvent event) {

    }

    @FXML
    public void insertDonor(ActionEvent event) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
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

        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");
        System.out.println("DonorId is : " + DonarId.getText());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

        stmt = conn.prepareStatement("insert into donor values(?,?,?,?)");
        stmt.setObject(1, DonarId.getText());
        stmt.setObject(2, donarsafety.getText());
        stmt.setObject(3, quantity.getText());
        stmt.setObject(4, date);

        int i = stmt.executeUpdate();
        System.out.println(i + " records inserted");

        stmt2 = conn.prepareStatement("insert into donation (did) values (?) ");
        stmt2.setObject(1, DonarId.getText());
        stmt2.executeUpdate();

        ResultSet rs = stmt.executeQuery("select did from donation ");
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
//Print one row          
            for (int j = 1; j <= columnsNumber; j++) {

                System.out.print(rs.getString(j) + " "); //Print one element of a row
                printDonor.appendText(rs.getString(j) + "\n");

            }

            System.out.println();//Move to the next line to print the next row.           

        }

        conn.close();

    }

    @FXML
    private void DonaorUpdate(ActionEvent event) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
        PreparedStatement stmt3 = null;
        PreparedStatement stmt4 = null;
        PreparedStatement stmt5 = null;

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.out.println("can not Connect to database ...");

        }
        //get the value of count 

        //STEP 4: Execute a query
        stmt = conn.prepareStatement("update donor set safety=? where donorId=?");
        stmt.setObject(1, donarsafety.getText());
        stmt.setObject(2, DonarId.getText());

        stmt2 = conn.prepareStatement("update donor set quantity=? where donorId=?");
        stmt2.setObject(1, quantity.getText());
        stmt2.setObject(2, DonarId.getText());
        System.out.println(DonarId.getText());

        try {
            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");

            stmt2.executeUpdate();

            stmt.executeUpdate();

            conn.close();
        } catch (AssertionError e) {
            System.out.println("111111111");
        }
    }

    @FXML
    private void patientInsert(ActionEvent event) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;

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
        System.out.println("DonorId is : " + DonarId.getText());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        stmt = conn.prepareStatement("insert into patient values(?,?,?)");

        stmt.setObject(1, patientId.getText());
        stmt.setObject(2, bloodUnitID.getText());
        stmt.setObject(3, date);

        int i = stmt.executeUpdate();
        System.out.println(i + " records inserted");

        conn.close();
    }

    @FXML
    private void patientUpdate(ActionEvent event) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt2 = null;
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

        //STEP 4: Execute a query
        stmt = conn.prepareStatement("update patient set dUId=? where patientId=?");
        stmt.setObject(1, bloodUnitID.getText());
        stmt.setObject(2, patientId.getText());

        stmt2 = conn.prepareStatement("update patient set time=? where  patientId=?");
        stmt2.setObject(1, patientTime.getText());
        stmt2.setObject(2, patientId.getText());

        try {
            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");

            stmt2.executeUpdate();
            stmt.executeUpdate();

            conn.close();
        } catch (AssertionError e) {
            System.out.println("111111111");
        } catch (Exception e) {
            System.out.println("222222222");
        }
    }

    @FXML
    private void count(ActionEvent event) throws ClassNotFoundException, SQLException {
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

        int num = Integer.parseInt(donationCount.getText());
        System.out.println(num);
        String sql = " SELECT  COUNT(*) FROM donation where  did =" + Integer.parseInt(donationCount.getText());

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

    @FXML
    private void COUNT2(ActionEvent event) throws SQLException, ClassNotFoundException {
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

        int num = Integer.parseInt(TXT1.getText());
        System.out.println(num);
        String sql = " SELECT  COUNT(*) FROM person"
                + " where  uId=" + Integer.parseInt(TXT1.getText());

        stmt3 = conn.prepareStatement(sql);

        ResultSet rs = stmt3.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnsNumber = rsmd.getColumnCount();

        while (rs.next()) {
//Print one row          
            for (int j = 1; j <= columnsNumber; j++) {

                System.out.print(rs.getString(j) + " "); //Print one element of a row
                answer1.setText(rs.getString(j) + "\n");

            }

            System.out.println();//Move to the next line to print the next row.           

        }
        stmt3.executeQuery();
        conn.close();
    }

    @FXML
    private void A11(ActionEvent event) {
         TXT1.setText("1");
    }

    @FXML
    private void A22(ActionEvent event) {
         TXT1.setText("2");
    }

    @FXML
    private void B11(ActionEvent event) {
         TXT1.setText("3");
    }

    @FXML
    private void B22(ActionEvent event) {
         TXT1.setText("4");
    }

    @FXML
    private void O11(ActionEvent event) {
         TXT1.setText("5");
    }

    @FXML
    private void O22(ActionEvent event) {
         TXT1.setText("6");
    }

    @FXML
    private void AB11(ActionEvent event) {
         TXT1.setText("7");
    }

    @FXML
    private void AB22(ActionEvent event) {
         TXT1.setText("8");
    }
    
    
    
    

}
