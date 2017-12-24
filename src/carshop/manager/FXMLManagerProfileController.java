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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Doctor Baraa
 */
public class FXMLManagerProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField name_bu ;
    
      @FXML
    private TextField gender_bu ;
      
        @FXML
    private TextField dob_bu ;
        
          @FXML
    private TextField tel_bu ;
         
        @FXML
            private void handleButtonActionBackC(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("/carshop/manager/FXMLManager.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    initialize_data();
    
    
    
    
    }
    
    @FXML
        private void initialize_data() {
            
    
  
        }
        
 @FXML
            private void handleButtonActionEdit(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("/carshop/manager/FXMLManagerEditProfile.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          Stage s=new Stage();
                //app_stage.hide(); 
                s.setScene(home_page_scene);
                s.show(); 

    }

@FXML
private void nameClicked(ActionEvent event){
    name_bu.setDisable(false);
}    
  

@FXML
private void dobClicked(ActionEvent event){
    dob_bu.setDisable(false);
}    


@FXML
private void telClicked(ActionEvent event){
    tel_bu.setDisable(false);
}    


@FXML
private void genderClicked(ActionEvent event){
    gender_bu.setDisable(false);
}    


}
