package nwalters.inventorytrackingsystemproject;

import ModelFolder.Inventory;
import ModelFolder.Part;
import ModelFolder.Product;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.util.Optional;


/****
 *** @author Nicholas Walters
 **/

/*%$%$%$%$%$%$%$%$%$%$%$  IMPROVEMENTS   %$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$*/
/****
 *** - I would try and mak it so that it will show up with either upper case or lower case, not just lower case for search bars
 *** - It would have been alot easier to use a switch case statement for the errors and to use an "Error" class instead of copy paste
 *** - It would have been alot easier knowing all the requirements upfront before working on it little by little each page
 ***/
/*%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%*/


/**
 * This class controlls the MainForm.fxml so that can manipulate the data.
 * This class stores the data and is the main screen where all of the action happens.
 * The user is able to add,modify,delete, and search for parts and products on this screen.
  */
public class MainFormController implements Initializable {





    /*$%$%$%%$%$%$%$%$%$%$ PRODUCT Table %$%$%$%$%$%$%$%$%$%$%$%$*/

    /****
     *** fx id for products search bar, product tableview ,name of product, product id, product price, product inventory
     **/
    public TextField mainProductSearchBarTF;

    public TableView mainFormProductTable;

    public TableColumn productNameColMain;

    public TableColumn productIDColMain;
    public TableColumn productCostPerUnitColMain;
    public TableColumn productStockInvetoryColMain;
    private Parent root;

    public static int modIndex;

    public static int getModIndex() {
        return modIndex;
    }
    /*M^^M@###@M^^M@###@M^^M@###@M^ PRODUCT Methods  on table or near ^M@###@M^^M@###@M^^M*/


    /****
     *** this method will return the product searched from the lists of Products
     *** @param mouseEvent
     **/
    public void productSearchBtnForNameOrId(MouseEvent mouseEvent) {
        System.out.println("You clicked on the products search button test");
        /****
         ***  this method will pull up a part with the id
         ***  this method will also find the part based on the name
         *** going to use a big try catch statement to get the errors
         *** using the same method as part search
         **/
        try {

            /****
             ***  this method will pull up a part with the id
             ***  this method will also find the part based on the name
             **/

            String lookForProductName = mainProductSearchBarTF.getText();

            ObservableList<Product> products = Inventory.lookupProduct(lookForProductName);

            if (products.size() == 0) {
                //try{
                /****
                 *** try and catch didn't work for getting the error to pop up, it would work for the ids just not names
                 *** commenting out try and catch
                 *** making it an else statement
                 **/
                int productIDfound = Integer.parseInt(lookForProductName);
                Product lookProductIdAlso = Inventory.lookupProduct(productIDfound);
                if (lookProductIdAlso != null)
                    products.add(lookProductIdAlso);

                /****
                 *** this is the error tha will pop up if it doesn't work
                 ***
                 **/

                if (lookProductIdAlso == null) {

                    //}catch (NumberFormatException e){
                    System.out.println("Product doesn't exist test");

                    Alert productNotFoundError = new Alert(Alert.AlertType.ERROR);

                    productNotFoundError.setTitle("- Error!!! -");

                    productNotFoundError.setHeaderText("^^ NO PRODUCT FOUND ^^");

                    productNotFoundError.setContentText("We apologize but that Product isn't found. Please check the ID or Name of the Product and" +
                            " try again.");
                    productNotFoundError.showAndWait();
                    return;

                }

            }

            /****
             *** this will reset the table and the search bar
             */
            mainProductSearchBarTF.setText("");

            mainFormProductTable.setItems(products);

            /****
             *** catch staement will catch the error
             *** it will display the error message that the product won't show up
             **/

        } catch (NumberFormatException z) {
            System.out.println("Invalid format or Product not showing up with name test ");

            Alert productNotFoundError = new Alert(Alert.AlertType.ERROR);

            productNotFoundError.setTitle("**-_  Error!!! _-**");

            productNotFoundError.setHeaderText("^PRO^  NO PRODUCT FOUND  ^PRO^");  // - fixed changed PART to PRODUCT

            productNotFoundError.setContentText("We apologize but that Product isn't found. Please check the ID or Name of the Product and" +
                    " try again.");
            productNotFoundError.showAndWait();

            mainProductSearchBarTF.setText("");

            return;
        }

    }


    /****
     *** this method will delete the product from the table
     *** @param mouseEvent
     **/

    public void productDeleteOrTakeAwayBttn(MouseEvent mouseEvent) {
        System.out.println("You clicked on the delete product button test");

        //test
        Product product = (Product) mainFormProductTable.getSelectionModel().getSelectedItem();
        /****
         *** if statement
         *** this will get all associated parts with the product
         *** if the product has one with it aka false then the warning will pop up
         *** going to do a big try and catch staement so I can check if there isn't anything selected when you hit delete - didn't work
         *** same try and catch as delete part button - don't need it just using an if, else if and else statement
         **/


        /****
         *** adding an try/ if statement - try wouldn't pull up so using an if
         *** this method will pop up if there isn't a product selected to delete
         *** same method as I used in mod part on main screen
         **/

        Product selectedProductThisOne = (Product) mainFormProductTable.getSelectionModel().getSelectedItem();

        if (selectedProductThisOne == null) {
            System.out.println("You didn't select a Product to delete test");

            Alert noProductSelectedErrorCheck = new Alert(Alert.AlertType.WARNING);

            noProductSelectedErrorCheck.setTitle("Error  :( :( :(");

            noProductSelectedErrorCheck.setHeaderText("## - Warning... Warning...- ##");

            noProductSelectedErrorCheck.setContentText("-- You must select a Product first to delete --");

            noProductSelectedErrorCheck.showAndWait();
            return;
        }


        /****
         *** changed to an else if statement
         **/

        else if (product.getAllAssociatedParts().size() != 0) {
            System.out.println("You clicked on a Product that has a part/parts associated with it test");

            Alert alert = new Alert((Alert.AlertType.WARNING));
            {
                alert.setTitle("WARNING");
                alert.setHeaderText("Warning");
                alert.setContentText("You must delete the parts from the associated list first before delete the product");
                alert.showAndWait();

            }

        } else {

            System.out.println(" You clicked on a product without any parts associated with it test");

            /****
             ***  need an alert to confrim whether or not the product will be deleted
             *** this will only happen if there aren't parts associated with it
             *** if not then it will allow the user to delete the product
             **/
            Alert confirmationDeletePartErrorCheckYesorNo = new Alert(Alert.AlertType.CONFIRMATION);

            confirmationDeletePartErrorCheckYesorNo.setTitle(" Delete?");

            confirmationDeletePartErrorCheckYesorNo.setHeaderText("^^^ **-  Please Confirm Deletion  -** ^^^");

            confirmationDeletePartErrorCheckYesorNo.setContentText("You have selected a Product from the Product Table. " +

                    "This Product doesn't have any Parts associated with it. Click" +

                    " Ok to Delete the Product, or click Cancel to Cancel the request.");

            Optional<ButtonType> OkorCancel = confirmationDeletePartErrorCheckYesorNo.showAndWait();

            /****
             *** using the same method and code as I did for part
             *** method to either get rid of the selected product or to Cancel
             *** using an if statement to let the user chose cancel or OK
             **/

            if (OkorCancel.isPresent() && OkorCancel.get() == ButtonType.OK) {

                /****
                 ***  naming allproducts to be the get Items list from the table
                 *** product to be remeoved will be the selected part
                 *** get rid of product will the be the method to call the part to be removed
                 *** using a for loop
                 **/
                ObservableList<Product> productToBeRemoved, allProducts;

                allProducts = mainFormProductTable.getItems();

                productToBeRemoved = mainFormProductTable.getSelectionModel().getSelectedItems();

                for (Product getRidOfProduct : productToBeRemoved) {
                    allProducts.remove(getRidOfProduct);
                }

            }

        }

    }


    /****
     *** this method will bring you to the modify product screen and lets you modify the product
     * @param mouseEvent
     */

    public void productModifyOrChangeBttn(MouseEvent mouseEvent) throws IOException {
        /****
         *** going to comment out because I am going to have the 2 controllers share info like mod a part
         **/

        System.out.println("You clicked on the modify or change product button test");

        /*
        Parent productModifyParent = FXMLLoader.load(getClass().getResource("ProductModifyForm.fxml"));

        Scene productModifyScene = new Scene(productModifyParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(productModifyScene);

        window.show();
        */

        /****
         *** need to create a method that will make it so it won't go to the screen if its clicke without a product
         *** using the same method as I used in add product/delete part
         *** this will make an error pop up if mod button is clicked without a product selected
         *** this will go after the catch statement
         **/
        try {


            Product productSelected = (Product) mainFormProductTable.getSelectionModel().getSelectedItem();


            /****
             *** - fixed named an index modIndex = it pulls up all the products and gets the index of the product selected
             *** - this will then help replace the product with the same index in the modify product screen
             *** - used key word indexOf to get the index of productSelected
             */
            modIndex = Inventory.getAllProducts().indexOf(productSelected);  // had to create an index to find the place

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ProductModifyForm.fxml"));

            root = loader.load();

            ProductModifyControllerScreen productModifyControllerScreen = loader.getController();

            productModifyControllerScreen.modProductReceivedToChange(productSelected);

            Stage stage = (Stage) ((Button) mouseEvent.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 744, 990);

            stage.setScene(scene);

            stage.show();

        } catch (Exception z) {
            System.out.println("You didn't select a Product to modify test");

            Alert noProductSelectedErrorCheck = new Alert(Alert.AlertType.WARNING);

            noProductSelectedErrorCheck.setTitle("Error  :( :(");

            noProductSelectedErrorCheck.setHeaderText("$## -- Warning... Warning... -- ##$");

            noProductSelectedErrorCheck.setContentText("You must select a Product first to modify the Part");

            noProductSelectedErrorCheck.showAndWait();
            return;
        }


    }


    /****
     *** this method will go to addProduct screen and adds a product
     *** @param mouseEvent
     **/
    public void productAddAnotherBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("You clicked on the add more products button test");

        Parent productAddParent = FXMLLoader.load(getClass().getResource("ProductAddForm.fxml"));

        Scene productAddScene = new Scene(productAddParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(productAddScene);

        window.show();
    }



    /*^^&^&^&^&^&^&^&^&^&^& PART  Table ^&^&^&^&^&^&^&^&&^^&&^&^&^^ */


    /****
     *** fx id for parts search bar, parts main search, part Id,price,part name, inventory
     **/
    public TextField partMainSearchBarTF;

    public TableView partsTableMainScreen;

    public TableColumn idPartColMain;

    public TableColumn priceCostPerUnitPartMain;

    public TableColumn namePartColMain;

    public TableColumn stockandInventoryColMain;



    /*@#*%&*@*@#*%&*@*@#*% PART Methods on or near Part Table  *@*@#*%&*@*@#*%&*@* */

    /****
     *** this method will find the part by either or by id or name
     *** @param mouseEvent
     **/
    public void partSearchBtnForNameOrId(MouseEvent mouseEvent) {
        System.out.println("You clicked on the partList search button test");

        /****
         *** adding a big try and catch statement so that it will catch the errors
         **/

        try {

            /****
             ***  this method will pull up a part with the id
             ***  this method will also find the part based on the name
             **/

            String lookForPartName = partMainSearchBarTF.getText();

            ObservableList<Part> parts = Inventory.lookupPart(lookForPartName);

            if (parts.size() == 0) {
                //try{
                /****
                 *** try and catch didn't work for getting the error to pop up, it would work for the ids just not names
                 *** commenting out try and catch
                 *** making it an else statement
                 **/
                int partIDfound = Integer.parseInt(lookForPartName);
                Part lookPartIdAlso = Inventory.lookupPart(partIDfound);
                if (lookPartIdAlso != null )
                    parts.add(lookPartIdAlso);

                /****
                 *** this is the error tha will pop up if it doesn't work
                 *** trying to get the id pull up the error will try a if lookupPartIDAlso with if
                 **/
                //else{
                if (lookPartIdAlso == null) {

                    //}catch (NumberFormatException e){
                    System.out.println("Part doesn't exist test");

                    Alert partNotFoundError = new Alert(Alert.AlertType.ERROR);

                    partNotFoundError.setTitle("- Error!!! -");

                    partNotFoundError.setHeaderText("^^ No PART FOUND ^^");

                    partNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
                            " try again.");
                    partNotFoundError.showAndWait();
                    return;

                }
                /****
                 *** couldn't get the part name to display
                 ***   commenting out
                 **/

                //if(partIDfound == 0){
                //System.out.println("Part doesn't exist test by Name");

                //Alert partNotFoundError = new Alert(Alert.AlertType.ERROR);

                //partNotFoundError.setTitle("- Error!!! -");

                //partNotFoundError.setHeaderText("^^ No PART FOUND ^^");

                //partNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
                //" try again.");
                //partNotFoundError.showAndWait();

                //}
            }
            /****
             *** trying a try catch statement with look for part name
             *** didn't work
             *** commenting out
             **/
            //try{
            //if(lookForPartName != null);
            // }catch (NumberFormatException e){
            // System.out.println("Part doesn't exist test by Name");

            //Alert partNotFoundError = new Alert(Alert.AlertType.ERROR);

            //partNotFoundError.setTitle("- Error!!! -");

            //partNotFoundError.setHeaderText("^^ No PART FOUND ^^");

            //partNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
            //" try again.");
            //partNotFoundError.showAndWait();


            /****
             *** couldn't get the name error message to display
             *** commenting out this test run
             **/
            //System.out.println("Part doesn't exist test by ID");

            //Alert partNotFoundError = new Alert(Alert.AlertType.ERROR);

            //partNotFoundError.setTitle("- Error!!! -");

            //partNotFoundError.setHeaderText("^^ No PART FOUND ^^");

            //partNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
            //" try again.");
            //partNotFoundError.showAndWait();


            /****
             ** this reset the table and the search bar after clicking on search again
             **/
            partMainSearchBarTF.setText("");

            partsTableMainScreen.setItems(parts);

        } catch (NumberFormatException z) {
            System.out.println("Invalid format or part not showing up with name test ");

            Alert partNotFoundError = new Alert(Alert.AlertType.ERROR);

            partNotFoundError.setTitle("-_  Error!!! _-");

            partNotFoundError.setHeaderText("^^ No PART FOUND ^^");

            partNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
                    " try again.");
            partNotFoundError.showAndWait();

            partMainSearchBarTF.setText("");

            return;
        }
    }


    /****
     *** this method will add another part and go to the add part screen
     *** @param mouseEvent
     **/
    public void addAnotherPartBttn(MouseEvent mouseEvent) throws IOException {

        System.out.println("You clicked on the add part button test");   // need to call the method to go to add part

        Parent addPartParent = FXMLLoader.load(getClass().getResource("AddAPartForm.fxml"));

        Scene addPartScene = new Scene(addPartParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(addPartScene);

        window.show();


    }

    /****
     *** this method will go to the modify part screen and will allow you to modify the part
     *** @param mouseEvent
     **/
    public void changeOrModifyPartBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("You clicked on the modify part button test ");

        /****
         *** going to comment out this so I can have the controllers talk to each other
         *** using a big try /catch
         *** this method will call upon the modify part screen info and receive that
         **/


        /*
        Parent modPartParent = FXMLLoader.load(getClass().getResource("ModifyAPartForm.fxml"));

        Scene modPartScene = new Scene(modPartParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(modPartScene);

        window.show();

         */
        try {
            Part partSelected = (Part) partsTableMainScreen.getSelectionModel().getSelectedItem();
            /****
             *** need to create a method that will make it so it won't go to the screen if its clicke without a part
             *** using the same method as I used in add product
             *** this will make an error pop up if add button is clicked without a part selected
             *** this will go after the catch statement
             **/

            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyAPartForm.fxml"));

            root = loader.load();

            ModifyAPartControllerScreen modifyAPartControllerScreen = loader.getController();

            modifyAPartControllerScreen.modPartReceivedToChange(partSelected);

            Stage stage = (Stage) ((Button) mouseEvent.getSource()).getScene().getWindow();

            Scene scene = new Scene(root, 687, 839);

            stage.setScene(scene);

            stage.show();
        } catch (Exception z) {
            System.out.println("You didn't select a Part to modify test");

            Alert noPartSelectedErrorCheck = new Alert(Alert.AlertType.WARNING);

            noPartSelectedErrorCheck.setTitle("Error  :( :(");

            noPartSelectedErrorCheck.setHeaderText("## - Warning... Warning...- ##");

            noPartSelectedErrorCheck.setContentText("You must select a Part first to modify the Part");

            noPartSelectedErrorCheck.showAndWait();
            return;
        }
    }


    /****
     *** this method will delete the part from the table
     *** @param mouseEvent
     **/
    public void partDeleteOrTakeawayBttn(MouseEvent mouseEvent) {
        System.out.println("You clicked on the delete part button test");

        /****
         *** need a confirmation statement
         *** need to delete the selected part
         *** need to make an error to pull up if nothing is selected
         *** same method as before for mod product, delete product on main screen
         *** casting part
         **/
        Part selectedPart = (Part) partsTableMainScreen.getSelectionModel().getSelectedItem();

        if (selectedPart == null) {
            System.out.println("You didn't select a Part to delete test");

            Alert noPartSelectedErrorCheck = new Alert(Alert.AlertType.WARNING);

            noPartSelectedErrorCheck.setTitle("Error     :( :( :( :(");

            noPartSelectedErrorCheck.setHeaderText("#$# - Warning... Warning...- #$#");

            noPartSelectedErrorCheck.setContentText("-+- You must select a Part first to delete -+-");

            noPartSelectedErrorCheck.showAndWait();
            return;
        }


        Alert confirmationDeletePartErrorCheckYesorNo = new Alert(Alert.AlertType.CONFIRMATION);

        confirmationDeletePartErrorCheckYesorNo.setTitle(" Delete?");

        confirmationDeletePartErrorCheckYesorNo.setHeaderText("^^ ** Please Confirm Deletion ** ^^");

        confirmationDeletePartErrorCheckYesorNo.setContentText("You have selected a part from the part table. Click" +
                " Ok to Delete the Part, or click Cancel to Cancel the request.");

        Optional<ButtonType> OkorCancel = confirmationDeletePartErrorCheckYesorNo.showAndWait();

        /****
         *** method to either get rid of the selected part or to Cancel
         *** using an if statement
         **/

        if (OkorCancel.isPresent() && OkorCancel.get() == ButtonType.OK) {

            /****
             ***  naming all parts to be the get Items list from the table
             *** part to be remeoved will be the selected part
             *** get rid of part will the be the method to call the part to be removed
             *** using a for loop
             **/
            ObservableList<Part> partToBeRemoved, allParts;

            allParts = partsTableMainScreen.getItems();

            partToBeRemoved = partsTableMainScreen.getSelectionModel().getSelectedItems();

            for (Part getRidOfPart : partToBeRemoved) {
                allParts.remove(getRidOfPart);
            }

        }

    }


    /*%&()&%&()%&()&%&()%&()&%&()%&()&%& OTHER METHODS  %&()&%&()%&()&%&()%&()&%&()%&()&%&() */


    /*X^X^X^XX^X^X^XX^^^X^X^ Exit button  X^^^x^X^X^X^XX^^^^XX^X^X^X^X^^XX^X^ */

    /****
     *** this method will close the program
     *** @param mouseEvent
     **/
    public void leaveOrCloseScreen(MouseEvent mouseEvent) throws IOException {
        System.out.println("You clicked on the exit button to close the screen test");

        System.exit(0);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /****
         *** need to call the info from the inventory to display
         **/

        /*$#%$%#$#$#$#$#$#$#%$%#$#$#$#$#     PART TABLE WITH DATA      $#$#%$%#$#$#$#$#$#$#%$%#$#$#$#$#$# */

        /****
         *** setter for part table
         *** this will get all the parts info from the inventory
         **/
        partsTableMainScreen.setItems(Inventory.getAllParts());

        /****
         *** this how we will get the name of parts to show up in the parts table
         **/
        namePartColMain.setCellValueFactory(new PropertyValueFactory<>("name"));

        /****
         *** this is will populate the ID parts table with workable data
         *** - fixed based on the test had to change idPart to id
         **/
        idPartColMain.setCellValueFactory(new PropertyValueFactory<>("id")); // had to change from the test

        /****
         *** this is will populate the price of the parts table with workable data
         **/
        priceCostPerUnitPartMain.setCellValueFactory(new PropertyValueFactory<>("price"));

        /****
         *** this is will populate the Inventory of the parts table with workable data
         **/
        stockandInventoryColMain.setCellValueFactory(new PropertyValueFactory<>("stock"));



        /*$#%$%#$#$#$#$#$#$#%$%#$#$#$#$#     PRODUCT TABLE WITH DATA      $#$#%$%#$#$#$#$#$#$#%$%#$#$#$#$#$# */

        /****
         *** setter for product table
         *** this will get all the product info from the inventory
         *** need to check if it will get the associated parts with it
         **/
        mainFormProductTable.setItems(Inventory.getAllProducts());

        /****
         *** this is will populate the ID product table with workable data
         **/
        productIDColMain.setCellValueFactory(new PropertyValueFactory<>("idProduct"));

        /****
         *** this is will populate the price of the product table with workable data
         **/
        productCostPerUnitColMain.setCellValueFactory(new PropertyValueFactory<>("price"));

        /****
         *** this how we will get the name of products to show up in the product table
         **/
        productNameColMain.setCellValueFactory(new PropertyValueFactory<>("name"));

        /****
         *** this is will populate the Inventory of the product table with workable data
         **/
        productStockInvetoryColMain.setCellValueFactory(new PropertyValueFactory<>("stock"));

    }


    /*\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\    OTHER METHODs   ^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\*/

    /****
     *** this method will chekc if id is found in the search bar
     *** @param numberCheck
     *** @return
     **/


    private boolean isValidNumber(String numberCheck) {
        try {
            Integer.parseInt(numberCheck);

            return true;
        } catch (NumberFormatException b) {

            return false;
        }
    }


    /*\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\\^\^\ */


/****
 *** end of the line
 *** don't continue
 **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^^#^#^#^

1. Test 1 = needs the required labels, based on the Software GUI Mockup = :)
2. Test 2 = PARTS BUTTONS needs to go to the required places = :)
2. A - needs to go  addpart screen = :)
2. B - needs to go modify part screen = :)
2. C - needs to pull up a delete screen or confirmation to delete the selected part = :)
2. D - needs the search bar to find part whether by id or name :)
2. E - needs an error to pull up if the part doesn't show up
3. Test 3 = PRODUCTS BUTTONS needs to go the required places = :)
3. A - needs to go addproduct screen = :)
3. B - needs to go to modifyproduct screen = :)
3. C - needs to delete the selected product or have a message to delete it = :)
3. D - needs to search the product by id or name :)
3. E - needs to pull up an error if the product won't show up = :)
4. Test 4 = application should exit or close when exit is clicked = :)
5. Test 5 = Error / validation on main screen while deleting a part = :)
5. A - need an error to pop up allowing the user to confirm whether or not they want to delete the part = :)
5. B - if ok then it should delete the part and go back to the main menu = :)
5. C - if cancel it should not delete the part and go back to main menu = :)
6. Test 6 = Error / validation on main screen while deleting a product = :)
6. A - need a message to pop up if their is a part associated with the product telling them to go to the mod screen = :)
6. B - allows the user to choose ok or cancel if there isn't a part associated with the product = :)
6. C - if the user clicks on ok it should delete the product and go back to the main screen = :)
6. D - if the user clicks on cancel it won't delete the product and goes back to main screen = :)

^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^^#^#^#^
 */
}