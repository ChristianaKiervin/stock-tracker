package kiervinc_assignment5;


import assignment.utils.Stock;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.net.URL;
import javafx.beans.Observable;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



/**
 * FXML Controller class
 *
 * @author Christiana Kiervin
 * 
 * Assignment 5
 * 
 * Student #: 991622137
 * 
 * This program controls the operational logic behind the FXMLStock gui to allow users to add products
 * to a stock list and calculate the cost of buying more items.
 * 
 * 
 */
public class FXMLStockController implements Initializable {

    @FXML
    private ListView<Stock> lstProducts;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtQty;
    @FXML
    private TextField txtRestock;
    @FXML
    private TextField txtSalePrice;
    @FXML
    private TextField txtBuyPrice;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField txtNumBuy;
    @FXML
    private Button btnBuy;
    @FXML
    private Label lblFee;
    
    ObservableList<Stock> obsStockList = FXCollections.observableArrayList();
    @FXML
    private Label lblSelected;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        obsStockList.add(new Stock("ABC_123","Unknown Product", 0, 0, 0.00, 0.00));
        obsStockList.add(new Stock("XYZ_234","itemX", 20, 5, 5.00, 3.00));
        obsStockList.add(new Stock("DDD_567","itemY", 10, 5, 6.00, 4.00));
        obsStockList.add(new Stock("AAA_999","itemZ", 15, 5, 4.00, 2.00));
        
        lstProducts.setItems(obsStockList);
        
        lstProducts.getSelectionModel().selectFirst();
        
        lstProducts.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() 
        {
            
            /**
             * Any time the selected item changes,  update the label at the bottom of the gui
             * to display the toString() for the currently selected object.
             * 
             */
            @Override
            public void invalidated(Observable observable) {
                int index = lstProducts.getSelectionModel().getSelectedIndex();
                lblSelected.setText(obsStockList.get(index).toString());
            }   
        });
    
        
        
    }    

    /**
     * This method is triggered when users click the Add Product button.
     * It  adds an item to the current list of Stock objects given user's input and then displays
     * the new item in the ListView control. 
     * 
     * If a user gives invalid input, error message is shown.
     * 
     * @param event is the action of clicking the add product button.
     */
    @FXML
    private void addProd(ActionEvent event) {
        
        try {
            
            /*Get the values for each parameter that have been entered in the textfields, 
                create a new stock object, and add it to the observable list */
            obsStockList.add(new Stock(txtID.getText(), txtName.getText(), parseInt(txtQty.getText()), 
                                        parseInt(txtRestock.getText()), parseDouble(txtSalePrice.getText()), 
                                        parseDouble(txtBuyPrice.getText())));

            //update the listview control to contain the new observable list item
            lstProducts.setItems(obsStockList);
            
        } catch (Exception ex) {
            lblSelected.setText("Error");
        }
    
    }

    
    /**
     * This method allows the user to calculate the cost of restocking an object.
     * It retrieves the number of items a user wants to purchase and displays the cost in a label.
     * 
     * 
     * @param event is the action of clicking the Buy button.
     */
    @FXML
    private void buy(ActionEvent event) {
        
        
        int qty = parseInt(txtNumBuy.getText());
        Stock selectedItem = lstProducts.getSelectionModel().getSelectedItem();
        
        lblFee.setText(String.format("$%.2f ", selectedItem.reStockFee(qty)));
        
    }
    
}
