/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Doctor Baraa
 */
public class FXMLHomeOfHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
       @FXML
    private void handleButtonActionCustomer(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/carshop/customer/FXMLGuest.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
    }
    
           @FXML
    private void handleButtonActionEmployee(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/carshop/login/FXMLLogin.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            
    }
    
            
                @FXML
    private void handleButtonActionExit(ActionEvent event) throws IOException {
    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();         
                app_stage.hide();             
    }    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
