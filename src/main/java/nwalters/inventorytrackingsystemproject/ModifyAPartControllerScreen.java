package nwalters.inventorytrackingsystemproject;

import ModelFolder.*;
import ModelFolder.Part;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/****
 *** @author Nicholas Walters
 **/

/*%$%$%$%$%$%$%$%$%$%$%$  IMPROVEMENTS   %$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$*/
/****
 *** - I did create an error to pull up if the form was blank, however it seems like .empty method will be better
 *** - I will try .empty method for add product page to see how that works
 *** - In the future I could probably make a bunch of if/else-if/else statements vs ifs. I feel like the text is  sloppy
 **/
/*%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%*/


/**
 * This class opens up the ModifyAPartForm.fxml screen.
 * This will allow the user to change input on the screen and allow the user to change info about the part.
  */
public class ModifyAPartControllerScreen implements Initializable {


    /*M^&&^MM^&&^MM^&&^MM^&&^MM^  FX ID FOR MOD PART  &^MM^&&^MM^&&^MM^&&^MM^&&^MM^&&^M*/

    /****
     *** fx id of the radio button outsourced
     **/
    public RadioButton modOutBttnLabel;

    /****
     *** fx ID for label that will change if its machine id to company name
     **/
    public Label machineToCompanyName;

    /****
     *** fx ID text field for price
     **/
    public TextField modPriceTextFieldPart;

    /****
     *** fx ID for textfield for Stock
     **/
    public TextField modInventoryTextFieldPart;

    /****
     *** fx ID for textfield for Name
     **/
    public TextField modNameTextFieldPart;

    /****
     *** fx ID for text field for max
     **/
    public TextField modMaxTextFieldPart;

    /****
     *** fx ID for text field ID
     **/
    public TextField modIdTextFieldPart;

    /****
     *** fx ID for text field Min
     **/
    public TextField modMinTextFieldPart;

    /****
     *** fx ID for textfield machineID/company name
     **/
    public TextField modCompanyToMacIDTextFieldPart;

    /****
     *** fx ID for inhouse radio button
     **/
    public RadioButton modInhousePartRdTextField;

    int modPartID;

    /*@!#^#^#@@!#^#^#@@!#^#^#@@!#^  OPENING SCREEN    #^#@@!#^#^#@@!##^#@@!#^#^#@@!#^#^#@@!#^#^#@@!#^#^#@*/

    /****
     *** @param url
     *** @param resourceBundle
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

/*
#@@!#^#^#@@!##^#@@!#^#^#@@!#^#@@!#^#^#@@!##^#@@!#^#^#@@!#^#@@!#^#^#@@!##^#@@!#^#^#@@!#^#@@!#^#^#@@!##*/







    /*B&$$$&&BB&$$$&&BB&$$$&&BB&$$$&&BB&$$$  BUTTONS  B&$$$&&BB&$$$&&BB&$$$&&BB&$$$&&BB&$$$&&B*/

    /*S$#@^&S$#@^&S$#@^&S$#@^&S$#@^&S$#@^   SAVE BUTTON     S$#@^&S$#@^&S$#@^&&S$#@^&S$#@^&S$#@^&*/

    /****
     *** button to make sure the new changed part will save and go back to the main menu controller
     *** @param mouseEvent
     **/
    public void modSavePartBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("Save button clicked in mod part screen test");

        /**
         *** method to check that the inputs are all valid and are numbers  or not
         *** starting with max, using false statement
         */

        if (!isValidNumber(modMaxTextFieldPart.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheckModPartScreen = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheckModPartScreen.setTitle("Error  :(");

            wrongFormatErrorCheckModPartScreen.setHeaderText("Invalid Format");

            wrongFormatErrorCheckModPartScreen.setContentText("Invalid Format. The Max Field needs to use numbers");

            wrongFormatErrorCheckModPartScreen.showAndWait();
            return;
        }

        /****
         *** check to see if min is a valid number
         **/
        if (!isValidNumber(modMinTextFieldPart.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Min Field needs to use numbers");

            wrongFormatErrorCheck.showAndWait();
            return;
        }


        /****
         *** check to see if inventory is a valid number
         **/
        if (!isValidNumber(modInventoryTextFieldPart.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Inventory Field needs to use numbers");

            wrongFormatErrorCheck.showAndWait();
            return;
        }

        /****
         *** check to see if price is a valid double
         **/
        if (!isValidDouble(modPriceTextFieldPart.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Price needs to have numbers");

            wrongFormatErrorCheck.showAndWait();
            return;

        }

        /****
         *** checks to see if the name is a valid format
         **/

        if (isValidNumber(modNameTextFieldPart.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Name uses letters");

            wrongFormatErrorCheck.showAndWait();
            return;
        }

        /****
         *** method to make sure that it isn't a blank field
         ***/
        if (modCompanyToMacIDTextFieldPart.getText().isBlank() || modNameTextFieldPart.getText().isBlank() ||

                modMinTextFieldPart.getText().isBlank() || modMaxTextFieldPart.getText().isBlank()

                || modPriceTextFieldPart.getText().isBlank() || modInventoryTextFieldPart.getText().isBlank()) {
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
         *** gets the input from the Inputer and assigns it to the table
         *** this will also make the input the correct fields
         **/

        /****
         ***  modded part id
         **/
        int modPartID = Integer.parseInt(modIdTextFieldPart.getText());

        /****
         *** modded part price
         **/
        double modPartPrice = Double.parseDouble(modPriceTextFieldPart.getText());

        /****
         *** modded part max
         **/
        int maxModPart = Integer.parseInt(modMaxTextFieldPart.getText());

        /****
         *** modded part for min
         **/
        int minModPart = Integer.parseInt(modMinTextFieldPart.getText());

        /****
         *** modded part for company name
         **/

        String companyNameModPart = modCompanyToMacIDTextFieldPart.getText();

        /****
         *** modded part for inventory
         **/
        int stockModdedPart = Integer.parseInt(modInventoryTextFieldPart.getText());

        /****
         *** modded part name
         **/
        String nameModPart = modNameTextFieldPart.getText();

        int machineIDMod = 0;

        /****
         *** method to make sure max is greater than min
         **/
        if (minModPart > maxModPart || maxModPart < minModPart) {
            System.out.println("Min is greater than Max ERROR check test");

            Alert maxLessthanMinErrorCheck = new Alert(Alert.AlertType.ERROR);

            maxLessthanMinErrorCheck.setTitle("Error   :(");

            maxLessthanMinErrorCheck.setHeaderText("ERROR Please Try Again");

            maxLessthanMinErrorCheck.setContentText("The Minimum number must be lower than than the maximum number ");

            maxLessthanMinErrorCheck.showAndWait();
            return;
        }
        /****
         *** method to check if the inventory is inbetween the min and max numbers
         **/
        if (stockModdedPart < minModPart || stockModdedPart > maxModPart) {
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
         *** method to check if the inventory equals the min and max numbers
         **/
        if (stockModdedPart == minModPart || stockModdedPart == maxModPart) {
            System.out.println("Stock number in between min and max test");
            Alert equalsStockInBetweenMinAndMaxErrorCheckModPartScreen = new Alert(Alert.AlertType.ERROR);

            equalsStockInBetweenMinAndMaxErrorCheckModPartScreen.setTitle("Error   :(");

            equalsStockInBetweenMinAndMaxErrorCheckModPartScreen.setHeaderText("ERROR!! STOCK ERROR");

            equalsStockInBetweenMinAndMaxErrorCheckModPartScreen.setContentText("The Inventory number must be greater" +
                    " than the min number and less than the max number.It can't be equal to each other. Please try again.");

            equalsStockInBetweenMinAndMaxErrorCheckModPartScreen.showAndWait();
            return;
        }



        /****
         *** checks to see if machine id is a number if inhouse is selected
         **/
        if (modInhousePartRdTextField.isSelected()) {
            if (!isValidNumber(modCompanyToMacIDTextFieldPart.getText())) {
                System.out.println("Machine ID invalid format test");
                Alert machineIDErrorCheck = new Alert(Alert.AlertType.ERROR);

                machineIDErrorCheck.setTitle("Error!! :( :(");

                machineIDErrorCheck.setHeaderText("xxx Invalid Format xxx");

                machineIDErrorCheck.setContentText("The Machine ID field  requires a valid number for the machine id");

                machineIDErrorCheck.showAndWait();
                return;

                /****
                 *** if it passed the conditions it should update the new part
                 **/
            } else {
                Inventory.updatePart(modPartID, new InHouse(modPartID, stockModdedPart,
                        minModPart, maxModPart, nameModPart,
                        modPartPrice, Integer.parseInt(companyNameModPart)));

            }
        }


        /****
         *** checks to make sure that company name isn't an int
         *** this is the conditions if outsourced is clicked
         **/

        if (modOutBttnLabel.isSelected()) {
            if (isValidNumber(modCompanyToMacIDTextFieldPart.getText())) {
                Alert companyNameErrorCheck = new Alert(Alert.AlertType.ERROR);

                companyNameErrorCheck.setTitle("Error!! :( :(");

                companyNameErrorCheck.setHeaderText("*** Invalid Format ***");

                companyNameErrorCheck.setContentText("This Company Name Field requires letters");

                companyNameErrorCheck.showAndWait();
                return;
            }


            /****
             *** else statement if outsourced is clicked
             **/
            else {
                Inventory.updatePart(modPartID, new OutSourced(modPartID, stockModdedPart,
                        minModPart, maxModPart, nameModPart, modPartPrice, companyNameModPart));
            }
        }
        /****
         *** this method will go to the main screen while saving the part
         **/
        {
            System.out.println("Save button clicked in mod part screen test leaving screen");        // need a method to get back to main form

            Parent saveModPartScreenParent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

            Scene saveModPartScreenScene = new Scene(saveModPartScreenParent);

            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

            window.setScene(saveModPartScreenScene);

            window.show();
        }


    }
    /*#@^&S$#@^&S#@^&S$#@^&S#@^&S$#@^&S#@^&S$#@^&S#@^&S$#@^&S#@^&S$#@^&S#@^&S$#@^&S*/

    /****
     *** method to cancel, not save and go back to main menu
     *** @param mouseEvent
     **/
    public void modExitAndCancelBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("Cancel button clicked in mod part screen test");        // need a method to get back to main form

        Parent cancelModPartScreenParent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

        Scene cancelModPartScreenScene = new Scene(cancelModPartScreenParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(cancelModPartScreenScene);

        window.show();
    }

    /****
     *** method for when inhouse radio button is selected to make sure that its machine ID
     *** need to set up a prompt text and change label
     *** @param mouseEvent
     **/
    public void modMachineIDtoCompanyRadBttn(MouseEvent mouseEvent) {
        System.out.println("Inhouse Radio Bttn clicked from mod part screen test");
        machineToCompanyName.setText("Machine ID");
        modCompanyToMacIDTextFieldPart.setPromptText("Ex 1001");
    }

    /****
     *** method when OutSourced radio button is clicked
     *** need to set up prompt text and change label
     *** @param mouseEvent
     **/

    public void modOutToInRdnBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("OutSourced Radio Button clicked from mod part screen test");
        machineToCompanyName.setText("Company Name");
        modCompanyToMacIDTextFieldPart.setPromptText("Company Name Ex Walmart");

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
    public void modPartReceivedToChange(Part partSelected) {

        /****
         *** receives name for modded part and sets it
         **/
        modNameTextFieldPart.setText(partSelected.getName());


        /****
         *** receives price
         **/
        modPriceTextFieldPart.setText(String.valueOf(partSelected.getPrice()));

        /****
         ***  receives min
         **/
        modMinTextFieldPart.setText(String.valueOf(partSelected.getMin()));

        /****
         *** receives stock number
         **/
        modInventoryTextFieldPart.setText(String.valueOf(partSelected.getStock()));

        /****
         *** receives max
         **/
        modMaxTextFieldPart.setText(String.valueOf(partSelected.getMax()));

        /****
         *** receives id
         **/
        modIdTextFieldPart.setText(String.valueOf(partSelected.getId()));

        /****
         *** need to use an instance of and if statement for the radio buttons
         **/

        /****
         *** outsourced
         **/

        if (partSelected instanceof OutSourced) {
            /****
             *** OutSourced radio button
             *** making it a boolean so that will set the provided info
             **/
            modOutBttnLabel.setSelected(true);

            /****
             *** textfield for company name
             **/
            modCompanyToMacIDTextFieldPart.setText(((OutSourced) partSelected).getCompanyName());

            /****
             *** set label
             **/
            machineToCompanyName.setText("Company Name");
        }
        /***
         *** else if statement to distinguish between inhouse or outsourced
         *** doing the same thing as I did for outsourced
         *** need to convert string into int with value of
         **/
        else if (partSelected instanceof InHouse) {
            modInhousePartRdTextField.setSelected(true);

            machineToCompanyName.setText("Machine ID");

            modCompanyToMacIDTextFieldPart.setText(String.valueOf(((InHouse) partSelected).getMachineID()));


        }


    }

    /* $#%$^%^%^%^%$%$$#%$#%$$#%$^%^%^%^%$%$$#%$#%$$#%$^%^%^%^%$%$$#%$#%$$#%$^%^%^%^%$%$$#%$#%$*/
    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^     REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^^#^#^#^^#^#^#^
1. Test 1 = needs the required labels, based on the Software GUI Mockup = :)
2. Test 2 = needs to go to the addPart screen and needs to go back to main menu/save after cancel = :)
3. Test 3 = need to be able add a part to the inventory and  to main form = :)
4. Test 4 = need to check the functionality of radio buttons
4. A - inhouse radio button should show machine id = :)
4. B - outhouse radio button should show company name = :)
5. Test 5 = needs to make sure that ID is disabled = :)
6. Test 6 =  checking the functionality of modifying an existing part
6. 6A - need to allow all the info to be added = :)
6. 6B - no errrors = :)
6. 6C - it should save the part and changes :)
7. Test 7 = cancel button should return to main menu
8. Test 8 = Input Validation and Error tests = :)
8. 8A - need an error to pop up saying that the min is higher than the max = :)
8. 8B - need an error saying that inventory is out of the range of the min and max = :)
9. Test 9 = Adding valid data check errors should pop up checking if the data meets the criteria = :)
9. 9A - need an error to pop up testing inhouse if its a number or letter = :)
9. 9B - need an error to pop up testing if price is a number a or not = :)
9. 9C - need an error to pop up if inventory is a number = :)
9. 9D - need an error  to pop up if max is a number or not = :)
9. 9E - need an error to pop up if min is a number or not = :)
9. 9F - need an error to pop up if name are letters or not = :)
9. 9G - need to check if outsourced works with letters or not = :)


^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^^#^#^#^^#^#^#^
 */

}
