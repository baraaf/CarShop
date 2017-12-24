package carshop.employee;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author User
 */
public class EmployeeProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField nametext;
    
    @FXML
   private TextField usernametext;
    
    @FXML
     private TextField passwordtext;
    
    @FXML
     private TextField emailtext;
    
    
    @FXML
    private TextField teltext;
    
    @FXML
  private TextField salarytext;
   /* 
    @FXML
    private combobox combogender;
    
     @FXML
    private combobox comboyear;
     
      @FXML
    private combobox combomonth;
      
       @FXML
    private combobox comboday;
       
        @FXML
    private combobox hireday;
        
         @FXML
    private combobox hiremonth;
         
          @FXML
    private combobox hireyear;
          */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /*
    @FXML
    private void SaveButtonAction(ActionEvent event)throws IOException{
        
         String query = "INSERT INTO employees (name,gender,dob,tel,telephone,user_name,password,salary,hire_date)"
                 + " VALUES (" + "'" + nametext.getText() + 
                "'," + "'" + combogender.getText() + "',"+
                comboday.getText()+"-"+combomonth.getText()+"-"+comboyear.getText()+ 
                 "," + "'" + teltext.getText() + "'," + "'" +
                usernametext.getText() + "'," + "'" + passwordtext.getText() + "'," + "'"+salarytext.getText() +"'," +"'"+
           hireday.getText()+"-"+hiremonth.getText()+"-"+hireyear.getText()+ " );";
        
        System.out.println("Inserting\n" + query);
        insertStatement(query);
        
        
        Parent EmployeeProfile_parent = FXMLLoader.load(getClass().getResource("FXMLEmployeeProfile.fxml"));
        Scene EmployeeProfile_scene = new Scene(EmployeeProfile_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); //optional
                app_stage.setScene(EmployeeProfile_scene);
                app_stage.show(); 
    }
    */
     private void CancelButtonAction(ActionEvent event) throws IOException {
        Parent EmployeeProfile_parent = FXMLLoader.load(getClass().getResource("FXMLEmployeeProfile.fxml"));
        Scene EmployeeProfile_scene = new Scene(EmployeeProfile_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); //optional
                app_stage.setScene(EmployeeProfile_scene);
                app_stage.show(); 
            
    }
    
      private void insertStatement(String insert_query){
        
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:first.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement(); 
      System.out.println("Our query was: " + insert_query);
      stmt.executeUpdate(insert_query);
      stmt.close();
      c.commit();
      c.close();
    }catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);  
        }
      
    
    }
}
