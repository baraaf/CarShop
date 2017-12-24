/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop.customer;

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
public class FXMLCarsGuestController implements Initializable {

    private ObservableList<carshop.manager.cars> data;
    @FXML
    private TableView<carshop.manager.cars> car_table;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        setCellTable();
        LoadDataFromDatabase();
    }

    @FXML

    private void handleButtonActionBackC(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("carshop.customer.FXMLGuest.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();

    }

    @FXML
    private void handleButtonActionExit(ActionEvent event) throws IOException {

        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional

    }

    private void setCellTable() {
        model_b.setCellValueFactory(new PropertyValueFactory<>("model"));
        rpd_b.setCellValueFactory(new PropertyValueFactory<>("status"));

        capacity_b.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        rent_times_b.setCellValueFactory(new PropertyValueFactory<>("times_rented"));
        status_b.setCellValueFactory(new PropertyValueFactory<>("rent_price_day"));

    }

    private void LoadDataFromDatabase() {
        try {
            carshop.DatabaseAPI db = new carshop.DatabaseAPI();
            ResultSet rs = db.read("SELECT * FROM cars ");
            while (rs.next()) {
               if("available".equals(rs.getString("status"))){
                carshop.manager.cars c = new carshop.manager.cars(""+rs.getString(1),rs.getString(2), "" + rs.getInt(3), "" + rs.getInt(6), "" + rs.getInt(5),rs.getString(4));
                data.add(c);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        car_table.setItems(data);

    }
}
