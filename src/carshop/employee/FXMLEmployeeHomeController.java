/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;

import static carshop.FXMLLoginController.id;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Doctor Baraa
 */
public class FXMLEmployeeHomeController implements Initializable {
          public  static String name;

    @FXML
    private Button customer_button;
    
        @FXML
    private Button cars_button;
    
        @FXML
    private Button logout_button;
    
        @FXML
    private Button profile_button;
    
                @FXML
    public static  Label welcoming_label;

        
          @Override
    public void initialize(URL url, ResourceBundle rb) {
               
    }    
    
           @FXML

    private void handleButtonActionLogout(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
                app_stage.setScene(home_page_scene);
                app_stage.show();

    }
  
        @FXML

    private void handleButtonActionProfile(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLEmployeeProfile.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }
    
        @FXML

    private void handleButtonActionCars(ActionEvent event) throws IOException {
 Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLEmplyeeCars.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }
    
        @FXML

    private void handleButtonActionCustomers(ActionEvent event) throws IOException {
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCustomersFromEmployees.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }

}

