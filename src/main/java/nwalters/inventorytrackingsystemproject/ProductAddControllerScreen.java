package nwalters.inventorytrackingsystemproject;

import ModelFolder.Inventory;
import ModelFolder.Inventory.*;
import ModelFolder.Part;
import ModelFolder.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;

/****
 *** @author Nicholas Walters
 **/

/*%$%$%$%$%$%$%$%$%$%$%$  IMPROVEMENTS   %$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$$%$%$%$$%$%$%$%$%$%$%$%$%$$
 *** - I would do a try / catch statement when I first started so that I can to do a null Pointer exception
 *** - I couldn't get the blank form to work, so if I was to make it again I would spend more time getting that to work
 *** - I would have probably made the mod product screen first because that is the way I will be able to test my data on some of it
 *** - When I first started this project I didn't realize that there was a bunch of errors, so if I was to do this again i I would try to understand the requirments better
 **%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%%$%$%$$%$%$%$%$%$%$%$$%$%$%$%$%$%%$$%$%$%$%$%$%%$$%$%$%$%$%$%*/


/**
 * This class controls the data for the ProductAddForm.fxml.
 * This allows the user to add a product and add the appropriate data to the table.
 * This also allows the user to add parts to the product.
  */
public class ProductAddControllerScreen implements Initializable {


    /*#_-+=$$+=-_##_-+=$$+=-#_-+=$$+=-_##_-   FX IDS PRODUCT   =$$+=-_##_-+=$$+=-_##_-+=$$+=-_##*/

    /****
     *** fx id for Product textfield for ID
     **/
    public TextField idProductTextFieldAddPro;

    /****
     *** fx id for Product textfield for max
     **/
    public TextField maxProdcutTextFieldAddPro;

    /****
     *** fx id for Product textfield for inventory/stock
     **/
    public TextField stockProductTextFieldAddPro;

    /****
     *** fx id for Product textfield for price
     **/
    public TextField priceProductTextFieldAddPro;

    /****
     *** fx id for Product textfield for name
     **/
    public TextField nameProductTextFieldAddProduct;

    /****
     *** fx id for Product textfield for min
     **/
    public TextField minProductTextFieldAddPro;


    int brandNewProductID;

    ObservableList<Part> associatedPartList = FXCollections.observableArrayList();

    Part partSelected;



    /*=$$+=-_##_-+=$$+=-_##_-+=$$+=-_##=$$+=-_##_-+=$$+=-_##_-+=$$+=-_##=$$+=-_##_-+=$$+=-_##_-+=$$+=-_## */



    /*T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T TOP PARTS ALL PARTS FX IDS  %@T&&T%@T&&T%@T&&T%@T&&T%@T&&&T%@*/


    /****
     *** fx ID for top table with all parts the whole table
     **/
    public TableView topAllPartsTableAddPro;

    /****
     *** fx ID for top table col for Part Price
     **/
    public TableColumn topPartPriceAddProCol;

    /****
     *** fx ID for top table col for Part Name
     **/
    public TableColumn topPartNameAddProCol;

    /****
     *** fx ID for top table col for Part Stock/Inventory
     **/
    public TableColumn topPartStockAddProCol;

    /****
     *** fx ID for top table col for Part ID
     **/
    public TableColumn topPartIdAddProCol;

    /****
     *** fx id for Search bar for both tables
     */
    public TextField searchBarFindPartwProAddPro;


    /*T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@T&&T%@*/



    /*BP^%*(&)(&)*%PBBP%PBBP^%*(&)(&)  BOTTOM PARTS ASSOSICATED PARTS FX IDS  *)*%PBBP^%*(&)(&)*%PB*BP^%*(&)(&)*/

    /****
     *** fx ID for bottom table with associated parts the whole table
     **/

    /****
     *** fx ID for bottom table col for Part Stock/Invetory
     **/
    public TableView btmAssociatedPartsAddProTable;

    /****
     *** fx ID for bottom table col for Part Stock/Invetory
     **/
    public TableColumn btmPartStockLvlAddProCol;

    /****
     *** fx ID for bottom table col for Part Name
     **/
    public TableColumn btmPartNameAddProCol;

    /****
     *** fx ID for bottom table col for Part ID
     **/
    public TableColumn btmPartIDAddProCol;

    /****
     *** fx ID for bottom table col for Part price
     **/
    public TableColumn btmPartPriceAddProCol;


    /*BP^%*(&)(&)*%PBBP%PBBP^%*(&)BP^%*(&)(&)*%PBBP%PBBP^%*(&)BP^%*(&)(&)*%PBBP%PBBP^%*(&)BP^%*(&)(&)*%PBBP%PBB*/


    /**** Initialize method will populate the tables both the top parts table and the bottom table with the matching parts
     *** this will happen on the start up method
     *** @param url
     *** @param resourceBundle
     **/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&  BOTTOM TABLE OR ASSOCIATED PARTS LIST TABLE  *&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&*/
        /****
         *** this method will set all the associated parts from the testing data and input
         **/


        btmAssociatedPartsAddProTable.setItems(associatedPartList);

        /****
         ***  set the name for the bottom associated parts list
         **/
        btmPartNameAddProCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        /****
         *** set the id for the bottom associated parts list
         *** - fixed based on the test changed partID to id
         **/
        btmPartIDAddProCol.setCellValueFactory(new PropertyValueFactory<>("id"));  // had to fix and refactor idPart to id

        /****
         *** set the inventory for the bottom table
         **/
        btmPartStockLvlAddProCol.setCellValueFactory(new PropertyValueFactory<>("stock"));

        /****
         *** set the price for the bottom table
         **/
        btmPartPriceAddProCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        /*B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*%^*&B&*/


        /*#&*(---) #&*(---) #&*(---) #&*(---)     TOP TABLE       #&*(---) #&*(---) #&*(---) #&*(---) #&*(---)*/
        /****
         ***  this method will get all the parts listed to display in the top table
         **/
        topAllPartsTableAddPro.setItems((Inventory.getAllParts()));

        /****
         *** this will set the name col for the top table
         **/
        topPartNameAddProCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        /****
         *** this will set the ID col for the top table
         *** - fixed based on the test had to refactor the idPart to id
         **/
        topPartIdAddProCol.setCellValueFactory(new PropertyValueFactory<>("id")); // fixed based on the test

        /****
         *** this will set the stock col for the top table
         **/
        topPartStockAddProCol.setCellValueFactory(new PropertyValueFactory<>("stock"));

        /****
         *** this will set the price col for the top table
         **/
        topPartPriceAddProCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        /*#&*(---) #&*(---)#&*(---) #&*(---)#&*(---) #&*(---)#&*(---) #&*(---)#&*(---) #&*(---)#&*#&*(---) #&*(---)  */


    }



    /*#^&(ZBR$^#^&(ZBR$^   BUTTONS    #^&(ZBR$^#^&(ZB$^#^&(ZBR$^#^&(ZBR$^#^&(ZBR$^#^&(ZBR$^#^&#^&(ZBR$*/

    /****
     **** this will actually delete the parts from the bottom
     *** @param mouseEvent
     **/
    public void deletePartsFromTopTableBttn(MouseEvent mouseEvent) {
        System.out.println("Delete part from the bottom table test");

        /****
         *** this method will remove the items from the bottom table/ assoicated parts list
         *** need to add a confirmation method to verify if they want to get rid of it
         **/
        Alert confirmationDeleteCheck = new Alert(Alert.AlertType.CONFIRMATION);

        confirmationDeleteCheck.setTitle("Delete?");

        confirmationDeleteCheck.setHeaderText("** Please Confirm Deletion **");

        confirmationDeleteCheck.setContentText("You have selected a part for deletion. Are you sure you wish to delete" +
                "this part");

        Optional<ButtonType> okOrCancel = confirmationDeleteCheck.showAndWait();

        if (okOrCancel.isPresent() && okOrCancel.get() == ButtonType.OK) {
            ObservableList<Part> partSelected, allParts;

            allParts = btmAssociatedPartsAddProTable.getItems();

            partSelected = btmAssociatedPartsAddProTable.getSelectionModel().getSelectedItems();

            for (Part part : partSelected) {
                allParts.remove(part);
            }
        }


    }

    /****
     *** this will cancel the process,  and go bqck to main screen
     *** @param mouseEvent
     **/
    public void exitOrCancelAddProBttn(MouseEvent mouseEvent) throws IOException {                 // need a method to cancel to go back to main screen
        System.out.println("Cancel and exit to main menu screen test");

        Parent cancelProductAddScreenParent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

        Scene cancelProductAddScreenScene = new Scene(cancelProductAddScreenParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(cancelProductAddScreenScene);

        window.show();
    }

    /****
     *** this method will save the new product with the parts with it and go back to the main screen
     *** @param mouseEvent
     **/
    public void saveNewProductAddProBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("Save new product with the parts that are with it test");



        /*@&%**@&@&%**@&@&%**@&@&%**@&@&%**@    PRODUCT TABLE ERROR ChECKING *@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**/
        /****
         *** this needs info needs to be accepted when the user clicks save for the product table
         *** this will get the info from the inputer
         *** need to parse for integers and doubles to receive the message
         *** with strings you can just use get text
         **/

        /****
         *** need to call a bunch of if statements like I did with the other screens
         *** need to check to make sure min is < max, stock, blank for products
         **/

        /****
         *** check to see if price is a valid double by making it false on the Product Table
         *** going to use a try statement
         **/
        if (!isValidDouble(priceProductTextFieldAddPro.getText())) {

            System.out.println("Price format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Price Field needs to use numbers in decimal format." +
                    "Please check the form again");
            wrongFormatErrorCheck.showAndWait();

            return;
        }

        /****
         *** checks to see if the Inventory is a valid format
         **/
        if (!isValidNumber(stockProductTextFieldAddPro.getText())) {
            System.out.println("Invalid format test for inventory");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Inventory field needs numbers");

            wrongFormatErrorCheck.showAndWait();
            return;
        }

        /****
         *** checks if max is an int for the Product Table
         **/
        if (!isValidNumber(maxProdcutTextFieldAddPro.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Max Field needs to use numbers");

            wrongFormatErrorCheck.showAndWait();
            return;
        }

        /****
         *** checks if min is an int for the Product Table
         **/
        if (!isValidNumber(minProductTextFieldAddPro.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Min Field needs to use numbers");

            wrongFormatErrorCheck.showAndWait();
            return;

        }


        /*^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^  PRODUCT DATA TABLE          &%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^*/


        /****
         *** need a method to add up the ID
         *** calling the method from inventory and will have it add up each time
         */
        brandNewProductID = Inventory.getGetBrandNewProductID.getAndIncrement();

        /****
         *** this will get Product Inventory number from the inputer
         **/
        int inventoryAddPro = Integer.parseInt(stockProductTextFieldAddPro.getText());

        /****
         *** this will get the name of the Product from the inputer
         **/
        String nameAddPro = nameProductTextFieldAddProduct.getText();

        /****
         *** this will get the Product cost from the inputer
         **/
        double priceAddPro = Double.parseDouble(priceProductTextFieldAddPro.getText());

        /****
         *** this will get the Product max from the inputer
         **/
        int maxAddPro = Integer.parseInt(maxProdcutTextFieldAddPro.getText());

        /****
         *** this will get the Product min from the inputer
         **/
        int minAddPro = Integer.parseInt(minProductTextFieldAddPro.getText());


        /****
         *** this will check if the max is less than min
         *** if so then it will return an error
         **/
        if (maxAddPro < minAddPro || minAddPro > maxAddPro) {
            System.out.println("Min is greater than Max ERROR check test");

            Alert maxLessthanMinProErrorCheck = new Alert(Alert.AlertType.ERROR);

            maxLessthanMinProErrorCheck.setTitle("Error   :(");

            maxLessthanMinProErrorCheck.setHeaderText("ERROR Please Try Again");

            maxLessthanMinProErrorCheck.setContentText("The Minimum number must be lower than than the maximum number ");

            maxLessthanMinProErrorCheck.showAndWait();
            return;
        }
        /****
         *** this error will check to make sure that the stock number is inbetween min and max for the product table
         **/
        if (inventoryAddPro < minAddPro || inventoryAddPro > maxAddPro) {

            System.out.println("Stock number in between min and max test");
            Alert stockInBetweenMinAndMaxErrorCheck = new Alert(Alert.AlertType.ERROR);

            stockInBetweenMinAndMaxErrorCheck.setTitle("Error   :(");

            stockInBetweenMinAndMaxErrorCheck.setHeaderText("ERROR!! STOCK ERROR");

            stockInBetweenMinAndMaxErrorCheck.setContentText("The Inventory number must be greater" +
                    "than the min number and less than the max number. Please try again.");

            stockInBetweenMinAndMaxErrorCheck.showAndWait();
            return;
        }


        /****
         *** checks to see if the name is a valid format
         **/

        if (isValidNumber(nameProductTextFieldAddProduct.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Name uses letters");

            wrongFormatErrorCheck.showAndWait();
            return;
        }


        /****
         *** this error will check to make sure that the stock number equals min or  max for the product table
         **/
        if (inventoryAddPro == minAddPro || inventoryAddPro == maxAddPro) {

            System.out.println("Stock number in between min and max test");
            Alert equalsStockInBetweenMinAndMaxErrorCheckAddProScreen = new Alert(Alert.AlertType.ERROR);

            equalsStockInBetweenMinAndMaxErrorCheckAddProScreen.setTitle("Error   :(");

            equalsStockInBetweenMinAndMaxErrorCheckAddProScreen.setHeaderText("ERROR!! STOCK ERROR");

            equalsStockInBetweenMinAndMaxErrorCheckAddProScreen.setContentText("The Inventory number must be greater" +
                    "than the min number and less than the max number. It can't be equal to each other. Please try again.");

            equalsStockInBetweenMinAndMaxErrorCheckAddProScreen.showAndWait();
            return;
        }


        /****
         *** method to make sure that it isn't a blank field in the Product Table - didn't catch the error, will try blank again
         *** trying the empty method to see if I like it better
         *** I will use multple or statements
         *** Order is max, inventory,price, name and min
         *** tried blank as well didn't catch the error will try a try and catch
         ***/
        /*
        if (maxProdcutTextFieldAddPro.getText().isEmpty() || stockProductTextFieldAddPro.getText().isEmpty() ||

                priceProductTextFieldAddPro.getText().isEmpty() || nameProductTextFieldAddProduct.getText().isEmpty()

                || minProductTextFieldAddPro.getText().isEmpty() ) {
            System.out.println("Blank Text Field Test");

            Alert blankTextFieldErrorCheck = new Alert(Alert.AlertType.ERROR);

            blankTextFieldErrorCheck.setTitle("Error   :(");

            blankTextFieldErrorCheck.setHeaderText("^^^ Blank ^^^^");

            blankTextFieldErrorCheck.setContentText("Blank Text Field. Please Check the form and try again. Make sure" +
                    "to fill out the missing fields. ");

            blankTextFieldErrorCheck.showAndWait();
            return;

         */


        if (maxProdcutTextFieldAddPro.getText().isBlank() || stockProductTextFieldAddPro.getText().isBlank() ||

                priceProductTextFieldAddPro.getText().isBlank() || nameProductTextFieldAddProduct.getText().isBlank()

                || minProductTextFieldAddPro.getText().isBlank()) {
            System.out.println("Blank Text Field Test");

            Alert blankTextFieldErrorCheck = new Alert(Alert.AlertType.ERROR);

            blankTextFieldErrorCheck.setTitle("Error   :(");

            blankTextFieldErrorCheck.setHeaderText("^^^ Blank ^^^^");

            blankTextFieldErrorCheck.setContentText("Blank Text Field. Please Check the form and try again. Make sure" +
                    "to fill out the missing fields. ");

            blankTextFieldErrorCheck.showAndWait();
            return;
        }


        /****
         *** a big else statement to save the new product if it passes the condtions
         **/

        else {

            System.out.println("Product passed all conditions and saved to inventory test");

            Product product = new Product(maxAddPro, minAddPro, brandNewProductID, inventoryAddPro, nameAddPro, priceAddPro);

            /****
             *** need to add for loop to get the associated parts with it
             **/
            for (Part matchedPart : associatedPartList) {
                product.addAssoicatedPart(matchedPart);
            }
            /****
             *** need to add the product from the inventory class
             **/
            Inventory.addProduct(product);

            {
                Parent saveModPartScreenParent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

                Scene saveModPartScreenScene = new Scene(saveModPartScreenParent);

                Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

                window.setScene(saveModPartScreenScene);

                window.show();
            }
        }

        /*@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@&@&%**@& */

        /*^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^&%&^^^^& */
    }

    /****
     *** this method will search for the all the parts on the top and bottom tables
     *** @param mouseEvent
     **/
    public void searchAddProBttn(MouseEvent mouseEvent) {
        System.out.println("Searching for parts in the add product screen");

        /****
         *** doing the same method as I did in main menu form controller
         **/
        try {

            /****
             ***  this method will pull up a part with the id
             ***  this method will also find the part based on the name
             **/

            String lookForPartNameInAddProductForm = searchBarFindPartwProAddPro.getText();

            ObservableList<Part> parts = Inventory.lookupPart(lookForPartNameInAddProductForm);

            if (parts.size() == 0) {

                /****
                 *** making it an else statement
                 **/
                int partIDfoundProductAddControllerScreen = Integer.parseInt(lookForPartNameInAddProductForm);
                Part lookPartIdAlso = Inventory.lookupPart(partIDfoundProductAddControllerScreen);
                if (lookPartIdAlso != null)
                    parts.add(lookPartIdAlso);

                /****
                 *** this is the error tha will pop up if it doesn't work
                 *** trying to get the id pull up the error will try a if lookupPartIDAlso with if
                 **/
                //else{
                if (lookPartIdAlso == null) {

                    System.out.println("Part doesn't exist test");

                    Alert partFromProductAddScreenNotFoundError = new Alert(Alert.AlertType.ERROR);

                    partFromProductAddScreenNotFoundError.setTitle("- Error!!! -");

                    partFromProductAddScreenNotFoundError.setHeaderText("^^ No PART FOUND ^^");

                    partFromProductAddScreenNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
                            " try again.");
                    partFromProductAddScreenNotFoundError.showAndWait();
                    return;

                }

            }

            /****
             ** this reset the table and the search bar after clicking on search again
             **/
            searchBarFindPartwProAddPro.setText("");

            topAllPartsTableAddPro.setItems(parts);

        } catch (NumberFormatException z) {
            System.out.println("Invalid format or part not showing up with name test ");

            Alert partNotFoundError = new Alert(Alert.AlertType.ERROR);

            partNotFoundError.setTitle("-_  Error!!! _-");

            partNotFoundError.setHeaderText("^^ No PART FOUND ^^");

            partNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
                    " try again.");
            partNotFoundError.showAndWait();

            searchBarFindPartwProAddPro.setText("");

            return;
        }
    }

    /****
     *** this will add a part to the bottom table to have it assoicated with the product
     *** @param mouseEvent
     **/
    public void addProAddProBttn(MouseEvent mouseEvent) {
        System.out.println("Add button was clicked test from Add a Product screen");

        Part partSelected = (Part) topAllPartsTableAddPro.getSelectionModel().getSelectedItem();

        /****
         *** this will make an error pop up if add button is clicked without a part
         **/
        if (partSelected == null) {
            Alert noPartAttachedErrorCheck = new Alert(Alert.AlertType.WARNING);

            noPartAttachedErrorCheck.setTitle("Error :(");

            noPartAttachedErrorCheck.setHeaderText("## Warning... Warning... ##");

            noPartAttachedErrorCheck.setContentText("You must select a part first to add to the product screen");

            noPartAttachedErrorCheck.showAndWait();
            return;


            /****
             *** this will make it so if the part is selected with the add button that it will add
             **/

        } else {
            associatedPartList.add(partSelected);


        }
    }
    /*#^&(ZBR$^#^&(ZB$^#^&(ZBR$^#^&(ZBR#^&(ZBR$^#^&(ZB$^#^&(ZBR$^#^&(ZBR#^&(ZBR$^#^&(ZB$^#^&(ZBR$^#^&(ZBR*/


    /*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#  OTHER METHODS  *#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%**/

    /****
     *** this method will check whether or not the input is a number for the product table
     *** it will be a boolean
     *** I will also attach a try and catch statement so that it will catch any errors
     **/
    private boolean isValidNumber(String numberCheck) {
        try {
            Integer.parseInt(numberCheck);

            return true;
        } catch (NumberFormatException b) {

            return false;
        }
    }

    private boolean isValidDouble(String validDouble) {
        try {
            Double.parseDouble(validDouble);

            return true;
        } catch (NumberFormatException z) {

            return false;
        }
    }


    /*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*#*%^*$%*/


    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^

1. Test 1 = needs the required labels, based on the Software GUI Mockup = :)
2. Test 2 = needs to go to the addProduct screen and needs to go back to main menu/save after cancel = :)
3. Test 3 = ID needs to be disabled from add product screen = :)
4. Test 4 = need to check adding a part to the prdouct = :)
4. A - needs to make sure it will let you input all the required data = :)
4. B - no error messages when saved is clicked = :)
4. C - add button should add the product to the bottom = :)
4. D - after save it should take you to the main menu screen = :)
4. E - need the new product to show up on the main menu :)
4. F - need to make sure the data mataches the info keyed in from modify part = :)
5. Test 5 = need to check the functionality of the search bar = :)
5. A - find the part with id or name = :)
5. B - need the list to repopulate = :)
6. Test 6 = an error should populate if there isn't a valid found id or name when search is clicked = :)
7. Test 7 = need to delete a part from the bottom table after there is one in the table = :)
8. Test 8 = need cancel to close the screen and go back to main menu screen = :)
9. Input Validation and Error tests for ProductAdd screen = :)
9. 9A - need an error to pop up if min is greater than max = :)
9. 9B - need an error to show up if inventory isn't in the range of min and max = :)
10. Test 10 = Adding valid data check errors should pop up checking if the data meets the criteria = :)
10. 10A - need an error to pop up testing inhouse if its a number or letter = :)
10. 10B - need an error to pop up testing if price is a number a or not = :)
10. 10C - need an error to pop up if inventory is a number = :)
10. 10D - need an error  to pop up if max is a number or not = :)
10. 10E - need an error to pop up if min is a number or not = :)
10. 10F - need an error to pop up if name are letters or not = :)
10. 10G - need to check if outsourced works with letters or not = :)






^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^
 */
}
