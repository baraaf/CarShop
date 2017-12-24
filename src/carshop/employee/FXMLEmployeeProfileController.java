/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop.employee;

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
public class FXMLEmployeeProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
      @FXML
            private void handleButtonActionBack(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("/carshop/employee/FXMLEmployeeHome.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }
        @FXML
            private void handleButtonActionEdit(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("/carshop/employee/EmployeeProfileEdit.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          Stage s=new Stage();
                //app_stage.hide(); 
                s.setScene(home_page_scene);
                s.show(); 

    }
    
}
