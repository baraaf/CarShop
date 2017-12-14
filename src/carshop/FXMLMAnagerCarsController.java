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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Doctor Baraa
 */
public class FXMLMAnagerCarsController implements Initializable {
private ObservableList<cars> data;
    @FXML
    private TableView<cars> car_table;
    @FXML
    private TableColumn<?, ?> model_b;
    @FXML
    private TableColumn<?, ?> capacity_b;
    @FXML
    private TableColumn<?, ?> rpd_b;
    @FXML
    private TableColumn<?, ?> rent_times_b;
    @FXML
    private TableColumn<?, ?> status_b;

    
        @FXML
            private void handleButtonActionBackC(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLManager.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          
                app_stage.hide(); 
                app_stage.setScene(home_page_scene);
                app_stage.show(); 

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     data = FXCollections.observableArrayList();
        setCellTable();
        refreshTable();    }    
    
private void setCellTable() {
        model_b.setCellValueFactory(new PropertyValueFactory<>("model"));
        rpd_b.setCellValueFactory(new PropertyValueFactory<>("status"));

        capacity_b.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        rent_times_b.setCellValueFactory(new PropertyValueFactory<>("times_rented"));
        status_b.setCellValueFactory(new PropertyValueFactory<>("rent_price_day"));

    }

    private void refreshTable() {
        System.out.println(FXMLLoginController.id);
      data.clear();
        try {
            DatabaseAPI db = new DatabaseAPI();
            ResultSet rs = db.read("SELECT * FROM cars ");
            while (rs.next()) {
                cars c = new cars(""+rs.getInt(1),rs.getString(2), "" + rs.getInt(3), "" + rs.getInt(6), ""+ rs.getInt(5),rs.getString(4));
                data.add(c);

            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        car_table.setItems(data);

    }
 
            @FXML

    public void delete_row( ) {
    
      cars car_selected=   car_table.getSelectionModel().getSelectedItem();
      
      try {
            DatabaseAPI db = new DatabaseAPI();
             db.write("delete  from cars where car_id ="+car_selected.getCar_id());
            System.out.println("delete  from cars where car_id ="+car_selected.getCar_id());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
      refreshTable(); 

    }
    
    public void add_row( ) {
    
      cars car_selected=   car_table.getSelectionModel().getSelectedItem();
      
      try {
            DatabaseAPI db = new DatabaseAPI();
             //db.write("insert into cars  values ("+car_selected.getCar_id()+","+);
            System.out.println("delete  from cars where car_id ="+car_selected.getCar_id().toString());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }
    
    
    
    
    
   
    public void edit_cell_capacity(CellEditEvent editedCell) {
    
      cars car_selected=   car_table.getSelectionModel().getSelectedItem();
      

    }
    public void edit_cell_rent(CellEditEvent editedCell) {
    
      cars car_selected=   car_table.getSelectionModel().getSelectedItem();
      

    }
      public void edit_cell_times_rented(CellEditEvent editedCell) {
    
      cars car_selected=   car_table.getSelectionModel().getSelectedItem();
      

    }
        public void edit_cell_status(CellEditEvent editedCell) {
    
      cars car_selected=   car_table.getSelectionModel().getSelectedItem();
      

    }
     @FXML
            private void handleButtonActionAddCsr(ActionEvent event) throws IOException {
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("AddCar.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          Stage s=new Stage();
                //app_stage.hide(); 
                s.setScene(home_page_scene);
                s.show(); 

    }
}


