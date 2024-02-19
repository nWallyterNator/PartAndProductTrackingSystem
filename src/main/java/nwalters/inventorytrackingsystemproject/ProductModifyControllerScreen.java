package nwalters.inventorytrackingsystemproject;


import ModelFolder.Product;
import ModelFolder.Part;
import ModelFolder.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Optional;
import java.util.ResourceBundle;

/****
 *** - imported from the controller to use modindex
 **/
import static nwalters.inventorytrackingsystemproject.MainFormController.modIndex;

/****
 *** @author Nicholas Walters
 **/

/*%$%$%$%$%$%$%$%$%$%$%$  IMPROVEMENTS   %$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$$%$%$%$$%$%$%$%$%$%$%$%$%$$
 *** - For whatever reason the add part button would get rid of the existing part, for future enhancements I would figure that out
 *** - The new Product when you modify the screen goes to 0, future enhancements would have that auto increment
 *** - I would have probably made the mod product screen first because that is the way I will be able to test my data on some of it
 *** - When I first started this project I didn't realize that there was a bunch of errors, so if I was to do this again i I would try to understand the requirments better
 **%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%%$%$%$$%$%$%$%$%$%$%$$%$%$%$%$%$%%$$%$%$%$%$%$%%$$%$%$%$%$%$%*/


/**
 * This class controlls the ProductModifyForm.fxml.
 * This allows the user to modify the existing product information and add or delete parts that are associated with it.
  */
public class ProductModifyControllerScreen implements Initializable {

    /*$%&@#!)()$%&@#!)()$%&@#!)()$%&@#!)()$%&@#!)  FX IDS PRODUCTS    ()$%&@#!)()$%&@#%&@#!)()$%&@#!)()*/


    /****
     *** fx id for Product textfield for name on Mod Product Screen
     **/
    public TextField nameProductTextFieldModPro;

    /****
     *** fx id for Product textfield for max on Mod Product Screen
     **/
    public TextField maxProductTextFieldModPro;

    /****
     *** fx id for Product textfield for stock on Mod Product Screen
     **/
    public TextField stockProductTextFieldModPro;

    /****
     *** fx id for Product textfield for price on Mod Product Screen
     **/
    public TextField priceProductTextFieldModPro;

    /****
     *** fx id for Product textfield for id on Mod Product Screen
     **/
    public TextField idProductTextFieldModPro;

    /****
     *** fx id for Product textfield for min on Mod Product Screen
     **/
    public TextField minProductTextFieldModPro;



    /*$%&@#!)()$%&@#!)()$%&@#!)()$%&@#!)$%&@#!)()$%&@#!)()$%&@#!)()$%&@#!)$%&@#!)()$%&@#!)()$%&@#!)()$%&@#!)*/

    /****
     *** this is what I want to call the variable to receive the modded product with the part
     **/
    Product pickThisProduct;






    /*(TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)    TOP PART ALL PARTS TABLE    (&&&MT)TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)(&&*/


    /****
     *** fx ID for top table with all parts the whole table on MOD Product Screen
     **/
    public TableView mTopAllPartsTableAModPro;

    /****
     *** fx ID for top table col for Part Inventory Level on MON Product Screen
     **/
    public TableColumn mTopPartStocklvlModProCol;

    /****
     *** fx ID for top table col for Part Cost on MON Product Screen
     **/
    public TableColumn mTopPartPriceModProCol;

    /****
     *** fx ID for top table col for Part Name on MON Product Screen
     **/
    public TableColumn mTopPartNameModProCol;

    /****
     *** fx ID for top table col for Part ID on MON Product Screen
     **/
    public TableColumn mTopPartIdModProCol;

    /*(&&&MT)TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)(&&&MT)TM&&&)*/


    /****
     *** fx ID for both tables for the search bar text field
     **/
    public TextField searchBarFindPartwProModPro;



    /*B@!$*$(%*(#$_)B@!$*$(%*(#$_)B@!$*$(%*(#$_)     BOTTOM PARTS TABLE      B@!$*$(%*(#$_)B@!$*$(_)B@!$*$(%*(#$_)*/


    /****
     *** fx ID for bottom table with all parts the whole table on MOD Product Screen
     **/
    public TableView mBttmMatchedPartsTableAModPro;

    /****
     *** fx ID for bottom table col for Part Name on MON Product Screen
     **/
    public TableColumn mBtmPartNameModProCol;

    /****
     *** fx ID for bottom table col for Part ID on MOD Product Screen
     **/
    public TableColumn mBtmPartIdModProCol;

    /****
     *** fx ID for bottom table col for Part Cost on MOD Product Screen
     **/
    public TableColumn mBtmPartCostModProCol;

    /****
     *** fx ID for bottom table col for Part Inventory Level on MON Product Screen
     **/
    public TableColumn mBtmPartInvModProCol;

    int brandNewProductID;

    /****
     *** - per the test don't need this index.
     *** - commenting out
     **/
    //int index = 0;      // fixed don't need because I got the inex from the main controller

    ObservableList<Part> associatedPartList = FXCollections.observableArrayList();


    Part partSelected;

    private Product getSelectedProduct;
    private Product selectedProduct = getSelectedProduct;




    /*B@!$*$(%*(#$_)B@!$*$(%*(#$_)B@!$*$(%*(#$_)B@!$*$(%*(#$_)B@!$*$(%*(#$_)B@!$*$(%*(#$_)B@!$*$(%*(#$_)B@!$*$(%*(#$*/




    /*Q?Q?Q?Q?^%^%$%$^%&^Q?Q?Q?Q?^%^%$%    BUTTONS     $^%&^Q?Q?Q?Q?^%^%$%$^%&^Q?Q?Q?Q?^%^%$%$^%&^*/

    /****
     *** this will add a part to the bottom table to have it assoicated with the product from mod product screen
     *** going to use the same method that I used in add a prdouct
     *** casting part to it because I didn't label the fx IDs <></>
     *** @param mouseEvent
     **/
    public void mAddProModPro(MouseEvent mouseEvent) {
        System.out.println(" Add Button Clicked from Mod Product Screen test");

        Part part = (Part) mTopAllPartsTableAModPro.getSelectionModel().getSelectedItem();



        /****
         *** this will make an error pop up if add button is clicked without a part
         **/
        if (part == null) {
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
            /****
             *** this part is deleting the part already on the table
             **/

            associatedPartList.addAll(part);
           //mBttmMatchedPartsTableAModPro.setItems(Inventory.getAllProducts());

            /****
             *** - needed to do a get all items with the part so that it will get updated.
             **/
            //mBttmMatchedPartsTableAModPro.setItems(associatedPartList);
           // mBttmMatchedPartsTableAModPro.getItems().add(part);
           // pickThisProduct.addAssoicatedPart(partSelected);

            mBttmMatchedPartsTableAModPro.getItems().addAll(part);




        }


    }

    /****
     *** this method will search for the all the parts on the top and bottom tables from mod product screen
     *** @param mouseEvent
     **/
    public void searchModProBttm(MouseEvent mouseEvent) {
        System.out.println("Searching for Product on Mod Product Screen test");


        /****
         *** doing the same method as I did in main menu form controller and Add Product screen
         *** using a big try and catch
         **/
        try {

            /****
             ***  this method will pull up a part with the id
             ***  this method will also find the part based on the name
             **/

            String lookForPartNameInAddProductForm = searchBarFindPartwProModPro.getText();

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
            searchBarFindPartwProModPro.setText("");

            mTopAllPartsTableAModPro.setItems(parts);

        } catch (NumberFormatException z) {
            System.out.println("Invalid format or part not showing up with name test ");

            Alert partNotFoundError = new Alert(Alert.AlertType.ERROR);

            partNotFoundError.setTitle("-_  Error!!! _-");

            partNotFoundError.setHeaderText("^^ No PART FOUND ^^");

            partNotFoundError.setContentText("We apologize but that Part isn't found. Please check the ID or Name of the Part and" +
                    " try again.");
            partNotFoundError.showAndWait();

            searchBarFindPartwProModPro.setText("");

            return;
        }
    }

    /****
     **** this will delete the parts from the bottom from the mod product screen
     *** @param mouseEvent
     **/
    public void deleteMatchedPartsModPro(MouseEvent mouseEvent) {
        System.out.println("You clicked on the delete button on Mod Product Screen test");
        /****
         *** using the same method as addAproduct screen
         **/


        /****
         *** this method will remove the items from the bottom table/ assoicated parts list
         *** need to add a confirmation method to verify if they want to get rid of it
         **/
        Alert confirmationDeleteCheck = new Alert(Alert.AlertType.CONFIRMATION);

        confirmationDeleteCheck.setTitle("Delete?");

        confirmationDeleteCheck.setHeaderText("*^* Please Confirm Deletion *^*");

        confirmationDeleteCheck.setContentText("You have selected a part for deletion. Are you sure you wish to delete" +
                "this part");

        Optional<ButtonType> okOrCancel = confirmationDeleteCheck.showAndWait();

        if (okOrCancel.isPresent() && okOrCancel.get() == ButtonType.OK) {
            ObservableList<Part> partSelected, allParts;

            allParts = mBttmMatchedPartsTableAModPro.getItems();

            partSelected = mBttmMatchedPartsTableAModPro.getSelectionModel().getSelectedItems();

            for (Part part : partSelected) {
                allParts.remove(part);
            }
        }

    }

    /****
     ***  this button will save the new part and go to the main menu from the mod product screen
     *** @param mouseEvent
     **/
    public void mSaveModPro(MouseEvent mouseEvent) throws IOException {
        System.out.println("Saving button clicked on Mod Product Screen test");
        ObservableList<Part> part;
        /****
         ***  going to use a bunch of if statements then an else statement
         *** using a big try statement
         **/


        /****
         *** having it save the modded product
         **/
        try {
            /****
             *** need to separate the data and name each one for the appropriate field
             **/
            /*[--@^**^@--][--@^**^@--][--@^**^@--]     PRODUCT ERROR CHECKING        [--@^**^@--][--@^**^@--][--@^**^@--]*/

            /****
             *** check to see if price is a valid double by making it false on the Product Table
             **/
            if (!isValidDouble(priceProductTextFieldModPro.getText())) {

                System.out.println("Price format test");

                Alert mWrongFormatErrorCheckPriceCheck = new Alert(Alert.AlertType.ERROR);

                mWrongFormatErrorCheckPriceCheck.setTitle("Error  :(");

                mWrongFormatErrorCheckPriceCheck.setHeaderText("Invalid Format");

                mWrongFormatErrorCheckPriceCheck.setContentText("Invalid Format. The Price Field needs to use numbers in decimal format." +
                        "Please check the form again");
                mWrongFormatErrorCheckPriceCheck.showAndWait();

                return;
            }
            /****
             *** checks to see if the Inventory is a valid format
             **/
            if (!isValidNumber(stockProductTextFieldModPro.getText())) {
                System.out.println("Invalid format test");

                Alert mWrongFormatErrorCheckInventoryCheck = new Alert(Alert.AlertType.ERROR);

                mWrongFormatErrorCheckInventoryCheck.setTitle("Error  :(");

                mWrongFormatErrorCheckInventoryCheck.setHeaderText("Invalid Format");

                mWrongFormatErrorCheckInventoryCheck.setContentText("Invalid Format. The Inventory uses numbers");

                mWrongFormatErrorCheckInventoryCheck.showAndWait();
                return;
            }
            /****
             *** checks if max is an int for the Product Table
             **/
            if (!isValidNumber(maxProductTextFieldModPro.getText())) {
                System.out.println("Invalid format test");

                Alert wrongFormatErrorCheckMaxCheckModScreen = new Alert(Alert.AlertType.ERROR);

                wrongFormatErrorCheckMaxCheckModScreen.setTitle("Error  :(");

                wrongFormatErrorCheckMaxCheckModScreen.setHeaderText("Invalid Format");

                wrongFormatErrorCheckMaxCheckModScreen.setContentText("Invalid Format. The Max Field needs to use numbers");

                wrongFormatErrorCheckMaxCheckModScreen.showAndWait();
                return;
            }

            /****
             *** checks if min is an int for the Product Table
             **/
            if (!isValidNumber(minProductTextFieldModPro.getText())) {
                System.out.println("Invalid format test");

                Alert mWrongFormatErrorCheckMinCheck = new Alert(Alert.AlertType.ERROR);

                mWrongFormatErrorCheckMinCheck.setTitle("Error  :(");

                mWrongFormatErrorCheckMinCheck.setHeaderText("Invalid Format");

                mWrongFormatErrorCheckMinCheck.setContentText("Invalid Format. The Min Field needs to use numbers");

                mWrongFormatErrorCheckMinCheck.showAndWait();
                return;

            }

            /*[--@^**^@--][--@^**^@--][--@^**^@--][--@^**^@--][--@^**^@--][--@^**^@--][--@^**^@--][--@^**^@--][--@^**^@--*/

            /*$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$    PRODUCT DATA TABLE      S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$*/




            /****
             *** id for product
             **/
            pickThisProduct.setIdProduct(Integer.parseInt(idProductTextFieldModPro.getText()));

            int modProID = Integer.parseInt(idProductTextFieldModPro.getText());

            /****
             *** this will get the Product max from the inputer
             **/
            pickThisProduct.setMax(Integer.parseInt(maxProductTextFieldModPro.getText()));
           // int maxModPro = Integer.parseInt(maxProductTextFieldModPro.getText());

            /****
             *** this will get the name of the Product from the inputer
             **/
            pickThisProduct.setName(nameProductTextFieldModPro.getText());
           //String nameModPro = nameProductTextFieldModPro.getText();

            /****
             *** this will get the Product min from the inputer
             **/
            pickThisProduct.setMin(Integer.parseInt(minProductTextFieldModPro.getText()));
            //int minModPro = Integer.parseInt(minProductTextFieldModPro.getText());

            /****
             *** this will get the Product cost from the inputer
             **/
            pickThisProduct.setPrice(Double.parseDouble(priceProductTextFieldModPro.getText()));
            //double priceModPro = Double.parseDouble(priceProductTextFieldModPro.getText());

            /****
             *** this will get Product Inventory number from the inputer
             **/
            pickThisProduct.setStock(Integer.parseInt(stockProductTextFieldModPro.getText()));
            //int inventoryModPro = Integer.parseInt(stockProductTextFieldModPro.getText());


            /****
             *** making the same methods as ProducatAddControllerScreen
             **/

            /****
             *** this error will check to make sure that the stock number is inbetween min and max for the product table
             *** had to change the fields to the object of pickThisProduct becasue it wasn't saving the correct data.
             **/
            if (pickThisProduct.getStock() < pickThisProduct.getMin() || pickThisProduct.getStock() > pickThisProduct.getMax()) {

                System.out.println("Stock number in between min and max test");
                Alert stockInBetweenMinAndMaxErrorCheck = new Alert(Alert.AlertType.ERROR);

                stockInBetweenMinAndMaxErrorCheck.setTitle("Error   :(");

                stockInBetweenMinAndMaxErrorCheck.setHeaderText("ERROR!! STOCK ERROR");

                stockInBetweenMinAndMaxErrorCheck.setContentText("The Inventory number must be greater" +
                        " than the min number and less than the max number. Please try again.");

                stockInBetweenMinAndMaxErrorCheck.showAndWait();
                return;
            }

            /****
             *** this will check if inventory = min or max
             **/
            if (pickThisProduct.getStock()== pickThisProduct.getMin() || pickThisProduct.getStock() == pickThisProduct.getMax()) {

                System.out.println("Stock number in between min and max test");
                Alert equalsStockInBetweenMinAndMaxErrorCheckModProScreen = new Alert(Alert.AlertType.ERROR);

                equalsStockInBetweenMinAndMaxErrorCheckModProScreen.setTitle("Error   :(");

                equalsStockInBetweenMinAndMaxErrorCheckModProScreen.setHeaderText("ERROR!! STOCK ERROR");

                equalsStockInBetweenMinAndMaxErrorCheckModProScreen.setContentText("The Inventory number must be greater" +
                        " than the min number and less than the max number. It can't be equal to each other. Please try again.");

                equalsStockInBetweenMinAndMaxErrorCheckModProScreen.showAndWait();
                return;
            }




            /****
             *** if statement will check to see if the anything is blank and if so it will produce an error
             *** using the same method as I did for ProductAddModifyControllerScreen
             *** I will use multple or statements
             *** Order is max, inventory,price, name and min
             **/

            if (maxProductTextFieldModPro.getText().isBlank() || stockProductTextFieldModPro.getText().isBlank() ||

                    priceProductTextFieldModPro.getText().isBlank() || nameProductTextFieldModPro.getText().isBlank()

                    || minProductTextFieldModPro.getText().isBlank()) {
                System.out.println("Blank Text Field Test");

                Alert blankTextFieldErrorCheck = new Alert(Alert.AlertType.ERROR);

                blankTextFieldErrorCheck.setTitle("Error   :(");

                blankTextFieldErrorCheck.setHeaderText("^^^ Blank ^^^^");

                blankTextFieldErrorCheck.setContentText("Blank Text Field. Please Check the form and try again. Make sure" +
                        "to fill out the missing fields. ");

                blankTextFieldErrorCheck.showAndWait();
                return;
            }/****
             *** checks to see if the name is a valid format
             **/

            if (isValidNumber(nameProductTextFieldModPro.getText())) {
                System.out.println("Invalid format Name test");

                Alert wrongFormatErrorCheckForModProScreen = new Alert(Alert.AlertType.ERROR);

                wrongFormatErrorCheckForModProScreen.setTitle("Error  :(");

                wrongFormatErrorCheckForModProScreen.setHeaderText("Invalid Format");

                wrongFormatErrorCheckForModProScreen.setContentText("Invalid Format. The Name uses letters");

                wrongFormatErrorCheckForModProScreen.showAndWait();
                return;

            }




            /****
             *** this will check if the max is less than min
             *** if so then it will return an error
             **/
            if (pickThisProduct.getMax() < pickThisProduct.getMin() || pickThisProduct.getMin() > pickThisProduct.getMax()) {
                System.out.println("Min is greater than Max ERROR check test");

                Alert maxLessthanMinProErrorCheck = new Alert(Alert.AlertType.ERROR);

                maxLessthanMinProErrorCheck.setTitle("Error   :(");

                maxLessthanMinProErrorCheck.setHeaderText("ERROR Please Try Again");

                maxLessthanMinProErrorCheck.setContentText("The Minimum number must be lower than than the maximum number ");

                maxLessthanMinProErrorCheck.showAndWait();
                return;
            }

            /****
             *** this is after where the if statements ends
             **/

            else {
                /****
                 *** this is if it passes all the tests
                 **/
                System.out.println("Passed all the tests and error checks for MODProduct screen");

                /****
                 *** making a variable to get the new product calling it modPro
                 **/
                //Product modPro = new Product(maxModPro, minModPro, modProID, inventoryModPro, nameModPro, priceModPro);
               // Product pickThisProduct = new Product()


                /****
                 *** for loop willget the part associated with table and add it
                 **/
                //for (Part partAndThenSome : associatedPartList) {
                    //modPro.addAssoicatedPart(partAndThenSome);

               // }
                /****
                 ***  calling update product method, calling the index that I set up before and modpro  in the parameters
                 *** - per the test it wasn't getting rid of the product
                 *** - tried updating and deleting - it wouldn't keep the id number
                 *** - tried updating index and the modPro(the one with the parts associated with it) - it would keep it
                 *** - tried calling upon the delete method to try and get rid of the selected product and index at 1 - it kept deleting the index at spot 0
                 *** - figured out that if I called a different index from the main Controller to get the index of selected product
                 **/
                // Inventory.updateProduct(index , modPro);         // fixed these are the attempts
                // Inventory.deleteProduct(productToMod);
                //Inventory.addProduct(modPro);
                //Inventory.deleteProduct(selectedProduct);
                //Inventory.deleteProduct(selectedProduct)
                Inventory.updateProduct(modIndex, pickThisProduct);
                // Inventory.deleteProduct(modifyProduct);
                // Inventory.deleteProduct(modifyProduct);
                //Inventory.updatePart(modIndex,partSelected);


                /****
                 *** goes back to main screen
                 **/


                {
                    Parent saveModPartScreenParent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

                    Scene saveModPartScreenScene = new Scene(saveModPartScreenParent);

                    Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

                    window.setScene(saveModPartScreenScene);

                    window.show();
                }

            }


            /*$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S$s$S*/


            /****
             *** catch staement to get any errors that don't pass
             **/

        } catch (NumberFormatException | IOException p) {

        }

    }


    /****
     *** this will cancel the process, not save the product and go to main screen from the mod product screen
     *** @param mouseEvent
     **/
    public void mExitOrCancelModProBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("Exiting the mod Product screen test");

        Parent cancelMProductModScreenParent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

        Scene cancelMProductModScreenScene = new Scene(cancelMProductModScreenParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(cancelMProductModScreenScene);

        window.show();
    }




    /*?Q?^%^%$%$^%&^Q?Q?^%^%$%$^%&^Q?Q?^%^%$%$^%&^Q?Q?^%^%$%$^%&^Q?Q?^%^%$%$^%&^Q?Q?^%^%$%$^%&^Q?Q?^%^%$%$^%&^Q*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /****
         *** need the table tobles and products to populate upon opening the screen
         **/

        /****
         *** need to activate the tables
         *** starting with the bottom table so I can see if I did the add Product screen correctly
         **/

        /* """"+++++""" """"+++++""" """"+++  BOTTOM TABLE     ++""" """"+++++""" """"+++++""" """"+++++"""*/

        /****
         *** the table getting activated and allowing to receive all the parts
         *** this table will only populate the parts that are assoiacted with the products
         *** if the table doesn't have any parts with it it will be blank
         **/

       // associatedPartList = pickThisProduct.getAllAssociatedParts();


        mBttmMatchedPartsTableAModPro.setItems((associatedPartList));




        /****
         *** getting the inventory level activated to receive info
         **/

        mBtmPartInvModProCol.setCellValueFactory(new PropertyValueFactory<>("stock"));

        /****
         *** getting the price for the bottom table
         **/
        mBtmPartCostModProCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        /****
         *** getting the name for the bottom table
         **/
        mBtmPartNameModProCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        /****
         *** getting the id for the bottom table
         *** - fixed based on the test had to change and refactor idPart to id
         **/
        mBtmPartIdModProCol.setCellValueFactory(new PropertyValueFactory<>("id")); // had to change to id


        /*++++""" """"+++++++""" """"+++++++""" """"+++++++""" """"+++++++""" """"+++++++""" """"+++++++""" """"++ */



        /*WMWMWMWMWMWWMWMWMWMWMWMWMWMWWMWMWM    TOP TABLE       WMWMWMWMWMWMWMWMWMWWMWMWMWMWMWMWWMWMMWWMWMWMWMW*/
        /****
         ***  getting method for the whole table
         **/
        mTopAllPartsTableAModPro.setItems(Inventory.getAllParts());

        /****
         *** getting the name for the top
         **/
        mTopPartNameModProCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        /****
         *** getting id for the top
         *** - fixed based on the test need to change idPart to id
         **/
        mTopPartIdModProCol.setCellValueFactory(new PropertyValueFactory<>("id"));  // changed to id

        /****
         *** getting price for top
         **/
        mTopPartPriceModProCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        /****
         *** get inventory for the top
         **/
        mTopPartStocklvlModProCol.setCellValueFactory(new PropertyValueFactory<>("stock"));



        /*MWWMWMWMWMWMWWMWMWMWMWMWWMWMWMWMWMWWMWMWMWMWMWWMWMWMWMWMWWMWMWMWMWMWWMWMWMWMWMWWMWMWMWMWMWWMWMWMWMW*/



        /* """"+++++""" """"+++++""" """"+++++""" """"+++++""" """"+++++""" """"+++++""" """"+++++""" """"+++++"" */

    }
    /*%$#%$^%^%^%^%$%$$#       OTHER METHODS AND ERRORS    %$#%$^%^%^%^%$%$$#%$#%$^%^%^%^%$%$$#%$#%$^%^%^%^% */

    /****
     *** this method will check whether or not the input is a number
     *** it will be a boolean
     *** I will also attach a try and catch statement so that it will catch any errors
     **/


    /****
     *** this method will check the number
     **/
    private boolean isValidNumber(String numberCheck) {
        try {
            Integer.parseInt(numberCheck);

            return true;
        } catch (NumberFormatException b) {

            return false;
        }
    }

    /****
     *** checks if it is a double - used for price
     *** @param validDouble
     *** @return
     **/
    private boolean isValidDouble(String validDouble) {
        try {
            Double.parseDouble(validDouble);

            return true;
        } catch (NumberFormatException z) {

            return false;
        }
    }


    /****
     *** this will display on the table once modified part is clicked from main menu
     **/
    public void modProductReceivedToChange(Product productSelected) {



        /****
         *** modifyProduct will equal the product selected which will allow me to get all the associated parts
         **/
        pickThisProduct = productSelected;

        /****
         *** receives price for product table on mod screen
         **/
        priceProductTextFieldModPro.setText(String.valueOf(pickThisProduct.getPrice()));

        /****
         *** receives name for product table on mod screen
         **/
        nameProductTextFieldModPro.setText(pickThisProduct.getName());

        /****
         *** receives id for product table on mod screen
         **/
        idProductTextFieldModPro.setText(String.valueOf(pickThisProduct.getIdProduct()));

        /****
         ***  receives min number for product table on mod screen
         **/
        minProductTextFieldModPro.setText(String.valueOf(pickThisProduct.getMin()));

        /****
         *** receives max number for product table on mod screen
         **/
        maxProductTextFieldModPro.setText(String.valueOf(pickThisProduct.getMax()));

        /****
         *** receives inventory level for product table on mod screen
         **/
        stockProductTextFieldModPro.setText(String.valueOf(pickThisProduct.getStock()));

        /****
         *** receives from Inventory the product that has all the products with the associated parts
         **/


        mBttmMatchedPartsTableAModPro.setItems(pickThisProduct.getAllAssociatedParts());





    }

    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^

1. Test 1 = needs the required labels, based on the Software GUI Mockup = :)
2. Test 2 = needs to go to the Productmodify screen and needs to go back to main menu/save after cancel = :)
3. Test 3 = need to check the functionality of the product modify screen = :)
3. 3A - need all data to be added = :)
3. 3B - no error messages when saved is clicked = :)
3. 3C - save should return to main menu = :)
3. 3D - need the updated product should be in the main menu = :)
3. 3E - when modify is clicked again the data should match = :)
4. Test 4 = need to check if the search will pull up the parts by id or name = :)
5. Test 5 = need to make sure an error will populate if the part doesn't match id or name = :)
6. Test 6 = need the remove button to remove the parts from the bottom table = :)
7. Test 7 = need cancel to go to the main menu = :)
8. Input Validation and Error tests for ProductMod screen =
8. 8A - need error to pop up if min is greater than max = :)
8. 8B - need error to pop up if inventory is out of the range of the min and max = :)
9. Test 9 = An error needs to pop up allowing them to make a selection on deleting the part associated with product or not = :)
9. 9A - if ok then it should remove the part from the bottom table = :)
9. 9B - if cancel it shouldn't remove the part and goes back to the same screen = :)
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

