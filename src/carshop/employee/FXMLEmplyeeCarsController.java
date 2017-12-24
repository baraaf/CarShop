/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carshop.employee;

import static carshop.login.FXMLLoginController.id;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class FXMLEmplyeeCarsController implements Initializable {

    /**
     * Initializes the controller class.
     */
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

    @FXML
    private void handleButtonActionBackC(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/carshop/employee/FXMLEmployeeHome.fxml"));
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
        LoadDataFromDatabase();
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
                carshop.manager.cars c = new carshop.manager.cars(""+rs.getInt(1),rs.getString(2), "" + rs.getInt(3), "" + rs.getInt(6), "" + rs.getInt(5),rs.getString(4));
                data.add(c);

            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        car_table.setItems(data);

    }
}
