/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasegui;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ayah
 */
public class DepartmentController implements Initializable {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bloodbank";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    @FXML
    private Button inBtn;
    @FXML
    private Button upBTn;
    @FXML
    private Button delBtn;
    @FXML
    private Button refreshBtn;
    @FXML
    private TextField Intxt;//insertName txt
    @FXML
    private TextField idTXT;//insetID 
    @FXML
    private TextField delNtxt;//del Name
    @FXML
    private TextField upNtxt;//update name
    @FXML
    private TextField upIDtxt;//update id
    @FXML
    private TextField delIDtxt;//delete id 

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void InsertDep(ActionEvent event) throws ClassNotFoundException, SQLException {

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

        stmt = conn.prepareStatement("insert into department values(?,?)");
        stmt.setObject(1, idTXT.getText());//1 specifies the first parameter in the query  
        stmt.setObject(2, Intxt.getText());
        int i = stmt.executeUpdate();
        System.out.println(i + " records inserted");
        stmt = conn.prepareStatement("select * from department");
        ResultSet rs = stmt.executeQuery();

        conn.close();

    }

    @FXML
    private void UpdateDep(ActionEvent event) throws ClassNotFoundException, SQLException {
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
        stmt = conn.prepareStatement("update department set dName=? where dId=?");
        stmt.setObject(2, upIDtxt.getText());//1 specifies the first parameter in the query i.e. name  
        stmt.setObject(1, upNtxt.getText());

        int i = stmt.executeUpdate();
        System.out.println(i + " records updated");
    }

    @FXML
    private void DeleteDep(ActionEvent event) throws ClassNotFoundException, SQLException {

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
        stmt = con.prepareStatement("delete from department where dId=?");
        stmt.setObject(1, delIDtxt.getText());

        int i = stmt.executeUpdate();
        System.out.println(i + " records deleted");
    }

    @FXML
    private void refresh() throws SQLException {
        Intxt.setText(" ");
        idTXT.setText(" ");
        delNtxt.setText(" ");
        upNtxt.setText(" ");
        upIDtxt.setText(" ");
        delIDtxt.setText(" ");

    }
}
