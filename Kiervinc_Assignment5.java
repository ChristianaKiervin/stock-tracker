
package kiervinc_assignment5;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Christiana
 * 
 * Student ID: 991622137
 * 
 * Assignment 5
 * 
 */
public class Kiervinc_Assignment5 extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 
    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLStock.fxml"));
        stage.setTitle("Stock of Products");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
