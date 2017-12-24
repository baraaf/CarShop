/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop.manager;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Doctor Baraa
 */

   
public class AddCarController implements Initializable {

   
     @FXML
    private TextField model_bu;
     @FXML
    private TextField _bu;    
     @FXML
    private TextField capacity_bu;   
     @FXML
    private TextField price_day_bu;
  
    @FXML
    private Button save_b;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
            private void saveCar(ActionEvent event) throws IOException {
    
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app_stage.hide(); 

    }
             @FXML
            private void cancel(ActionEvent event) throws IOException {
    
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
         app_stage.hide(); 

    }
    
}
