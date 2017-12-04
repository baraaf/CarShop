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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLLoginController implements Initializable {

    public static int id;

    @FXML
    private Label label;

    @FXML
    private Label invalid_label;

    @FXML
    private TextField user_box;

    @FXML
    private PasswordField pass_box;

    @FXML
    private Button ss;

    @FXML
    private Button login_button;

    @FXML
    private Button exit_button;

    Float[] values = new Float[]{-1.0f, 0f, 0.6f, 1.0f};

    int a = 2; // as a flag, 2=> employee , 55=> manager
    @FXML
    private ProgressIndicator pii;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLEmployeeHome.fxml"));
        Scene Emp_home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
          Parent Mhome_page_parent = FXMLLoader.load(getClass().getResource("FXMLManager.fxml"));
        Scene Man_home_page_scene = new Scene(Mhome_page_parent);
        Stage Mapp_stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); 
        
        pii.setProgress(-1f);

        switch (isValidCredentials()) {
            case 1:
                //app_stage.hide(); //optional
                if (a==55) {
                app_stage.setScene(Man_home_page_scene);
                    }
                else{
                app_stage.setScene(Emp_home_page_scene);}
                /*try {
                      
                      DatabaseAPI db = new DatabaseAPI();
                      ResultSet rs = db.read( "SELECT e.name FROM employees as e WHERE e.eid="  + id +" " );
                      System.out.println("SELECT name FROM employees WHERE eid= "  + id +" " );
                      while ( rs.next() ) {
                      FXMLEmployeeHomeController.name= rs.getString("name");
                      }
                      FXMLEmployeeHomeController.welcoming_label.setText("welcome "+ FXMLEmployeeHomeController.name);
                      } catch ( Exception e ) {
                      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                      System.exit(0);
                      }
                 */
                app_stage.show();
                break;
            case 2:
                user_box.clear();
                pass_box.clear();
                invalid_label.setText("Sorry, invalid  password ");
                break;
            case 3:
                user_box.clear();
                pass_box.clear();
                invalid_label.setText("Sorry, invalid  username ");
                break;
            case 4:
                invalid_label.setText("Sorry, invalid  username and password");

                user_box.clear();
                pass_box.clear();
                break;
            default:
                break;
        }

    }

    private int isValidCredentials() {
        pii.setProgress(-1f);

        int let_in = 0;// initisl vslue
        System.out.println("SELECT * FROM employees WHERE name= " + "'" + user_box.getText() + "'"
                + " AND password= " + "'" + pass_box.getText() + "'");

        try {
            DatabaseAPI db = new DatabaseAPI();
            ResultSet rs = db.read("SELECT * FROM employees WHERE user_name= " + "'" + user_box.getText() + "'"
                    + " AND PASSWORD= " + "'" + pass_box.getText() + "'");

            ResultSet rs2 = db.read("SELECT * FROM employees WHERE user_name= " + "'" + user_box.getText() + "'");

            ResultSet rs3 = db.read("SELECT * FROM employees WHERE PASSWORD= " + "'" + pass_box.getText() + "'");

            while (rs.next()) {
                a=2;
                if (rs.getString("user_name") != null && rs.getString("password") != null) {
                    String username = rs.getString("user_name");
                    System.out.println("name = " + username);
                    String password = rs.getString("password");
                    System.out.println("password = " + password);
                    String s = rs.getString("eid");
                    id = Integer.parseInt(s);
                    System.out.println(id);
                    if (rs.getInt("rank") == 1) {
                        a = 55; // manager
                    }
                    return let_in = 1; // 1 true user and password
                }

            }

            while (rs2.next()) {
                if (rs2.getString("user_name") != null) {
                    return let_in = 2; // 2 wrong password
                }
            }

            while (rs3.next()) {
                if (rs3.getString("password") != null) {
                    return let_in = 3; // 3 => wrong username
                }
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return 4; // invalid  username and password
    }

    @FXML
    private void handleShow(ActionEvent event) throws IOException {
        String pass = pass_box.getText();
        System.out.println(pass);
        pass_box.setText(pass);
        pass_box.clear();

    }

    @FXML
    private void handleButtonActionExit(ActionEvent event) throws IOException {
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        app_stage.hide();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pass_box.setPromptText("Password");
        user_box.setPromptText("Username");
        //pass_box.setStyle("-fx-echo-char: *;");
        user_box.deselect();
        pass_box.deselect();

    }

}
