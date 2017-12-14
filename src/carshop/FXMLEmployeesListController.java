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
    private TableColumn<?, ?> name_b;
    @FXML
    private TableColumn<?, ?> gender_b;
    @FXML
    private TableColumn<?, ?> dob_b;
   
    @FXML
    private TableColumn<?, ?> telephone_b;
    @FXML
    private TableColumn<?, ?> salary_b;

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
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // con=dba.DBconnection.pmartConnection();
    data = FXCollections.observableArrayList();
        setCellTable();
        refreshTable();  
            }    
    
    private void setCellTable() {
       
        name_b.setCellValueFactory(new PropertyValueFactory<>("name"));
        gender_b.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dob_b.setCellValueFactory(new PropertyValueFactory<>("dob"));
        telephone_b.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        salary_b.setCellValueFactory(new PropertyValueFactory<>("salary"));
        hire_date_b.setCellValueFactory(new PropertyValueFactory<>("hire_date"));
        

    }

    private void refreshTable() {
              data.clear();

        try {
            DatabaseAPI db = new DatabaseAPI();
            ResultSet rs = db.read("SELECT * FROM employees");
            while (rs.next()) {
                System.out.println(rs.getString(2));
               employees e = new employees( ""+rs.getString(1),rs.getString(2),rs.getString(5), rs.getDate(3).toString(),  rs.getString(4),  ""+rs.getDouble(9),
   rs.getDate(10).toString());

                data.add(e);

            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        employees_table.setItems(data);

    }
    
 
            @FXML
    public void delete_row( ) {
    
      employees employee_selected=   employees_table.getSelectionModel().getSelectedItem();
      
      try {
            DatabaseAPI db = new DatabaseAPI();
             db.write("delete  from employees where eid ="+employee_selected.getEid());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
      refreshTable(); 

    }
    
    
    
}
