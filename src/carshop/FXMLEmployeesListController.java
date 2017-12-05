/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Doctor Baraa
 */
public class FXMLEmployeesListController implements Initializable {

    /**
     * Initializes the controller class.
     */
     private ObservableList<employees> data;
    @FXML
    private TableView<employees> employees_table;
    @FXML
    private TableColumn<?, ?> eid_b;
    @FXML
    private TableColumn<?, ?> name_b;
    @FXML
    private TableColumn<?, ?> gender_b;
    @FXML
    private TableColumn<?, ?> dob_b;
    @FXML
    private TableColumn<?, ?> username_b;
    @FXML
   private TableColumn<?, ?> password_b;
    @FXML
    private TableColumn<?, ?> telephone_b;
    @FXML
    private TableColumn<?, ?> salary_b;
    @FXML
    private TableColumn<?, ?> a_id_b;
    @FXML
    private TableColumn<?, ?>  hire_date_b;
    
       @FXML
            private void handleButtonActionBack(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLManager.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
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
       // con=dba.DBconnection.pmartConnection();
        data = FXCollections.observableArrayList();
        setCellTable();
        LoadDataFromDatabase();
    }    
    
    private void setCellTable() {
        
    
        eid_b.setCellValueFactory(new PropertyValueFactory<>("eid"));
        name_b.setCellValueFactory(new PropertyValueFactory<>("name"));
        gender_b.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dob_b.setCellValueFactory(new PropertyValueFactory<>("dob"));
        username_b.setCellValueFactory(new PropertyValueFactory<>("username"));
        password_b.setCellValueFactory(new PropertyValueFactory<>("password"));
        telephone_b.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        salary_b.setCellValueFactory(new PropertyValueFactory<>("salary"));
        a_id_b.setCellValueFactory(new PropertyValueFactory<>("a_id "));
        hire_date_b.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
        

    }

    private void LoadDataFromDatabase() {
        data.clear();
        try {
            DatabaseAPI db = new DatabaseAPI();
            ResultSet rs = db.read("SELECT * FROM employees ");
            while (rs.next()) {
               employees e = new employees( rs.getString(2),rs.getString(3),  rs.getDate(4), rs.getString(5), rs.getString(6),
   rs.getDouble(7),rs.getInt(9), rs.getDate(8));
            
                data.add(e);

            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        employees_table.setItems(data);

    }
}