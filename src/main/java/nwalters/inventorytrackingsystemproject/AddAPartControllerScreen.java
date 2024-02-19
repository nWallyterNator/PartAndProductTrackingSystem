package nwalters.inventorytrackingsystemproject;

import ModelFolder.InHouse;
import ModelFolder.Inventory;
import ModelFolder.OutSourced;
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
 *** - I would do a try / catch statement when I first started so that I can to do a null Pointer exception.
 *** - I would also try to make it easier to read.
 *** - I would use a boolean to name which radio button is selected that way the big if statement wouldn't be as big.
 *** - I didn't create an error for if the field was blank or empty, will add an error for that.
 **/
/*%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%$%$$%$%$%$%$%$%$%$%*/

/**
 * This class launches the ADDAPartForm.fxml.
 * This class allows the user to add a part with the appropriate data.
 * This data then will get transfered to the main menu screen.
 */
public class AddAPartControllerScreen implements Initializable {


    /*fx^xf^fx^xf^fx^xf^fx^xf^fx^xf^ FX IDS FOR ADD Part  fx^xf^fx^xf^fx^xf^fx^xf^*/

    /****
     *** fx ID textfield for id
     **/
    public TextField idTextFieldAddPart;

    /****
     *** fx ID for textfield for max number
     **/
    public TextField maxTextFieldAddPart;

    /****
     *** fx ID for textfield for inventory
     **/
    public TextField stockTextFieldAddPart;

    /****
     *** fx ID for textfield for price
     **/
    public TextField priceTextFieldAddPart;

    /****
     *** fx ID for textfield name
     **/
    public TextField nameTextFieldAddAPart;

    /****
     *** fx ID for Label that switches from MacineID to Company Name depending on what radio button is clicked
     **/
    public Label machineToCompanyName;

    /****
     *** fx ID for textfield for min
     **/
    public TextField minTextFieldAddPart;


    /****
     *** need to make a new ID from inventory to automatically add
     *** needs to be an integer
     **/
    int brandNewID;

    /****
     *** fx ID for textfield for machineID and company name
     **/
    public TextField machineAndCompanyNameTextField;

    /****
     *** fx ID for RadioButton outsourced
     **/
    public RadioButton outRadBttn;

    /****
     *** fx ID for RadioButton inhouse
     **/
    public RadioButton inRadBttn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    /*B%(**)%BB%(**)%BB%(**)%BB%(**)%BB%(**) BUTTONS  %BB%(**)%BB%(**)%BB%(**)%BB%(**)%BB%(**)%BB%(**)%B*/

    /****
     *** when the inhouse radioButton is selected it will input for machine ID
     *** @param mouseEvent
     **/
    public void idToCompanyName(MouseEvent mouseEvent) {
        System.out.println("Inhouse button is selected, it should return machine ID test");
        machineAndCompanyNameTextField.setPromptText("Machine ID");
        machineToCompanyName.setText("Machine ID");


    }

    /****
     *** this button will cancel the process of adding the part, and it goes back to the main menu
     *** @param mouseEvent
     **/
    public void exitAndCancelButtn(MouseEvent mouseEvent) throws IOException {

        System.out.println("Exit button clicked, left program test");           // need a method to get back to the main screen

        Parent cancelAddPartScreenParent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

        Scene cancelAddPartScreenScene = new Scene(cancelAddPartScreenParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

        window.setScene(cancelAddPartScreenScene);

        window.show();
    }

    /****
     *** when the outsourced radioButton is selected it will get input for company name
     *** need to be able to have the radio buttons switch the label of either id or company name
     *** setting a prompt text to switch as well
     *** @param mouseEvent
     **/
    public void outToInMachineID(MouseEvent mouseEvent) {
        System.out.println("OutSourced RadioButton Selected test, it should be a company name");

        machineAndCompanyNameTextField.setPromptText("Company Name Ex Nics Pizza");

        machineToCompanyName.setText("Company Name");

    }

    /****
     ***  this button will save the new part and go to the main menu
     *** @param mouseEvent
     **/
    public void partSavedBttn(MouseEvent mouseEvent) throws IOException {
        System.out.println("Save part back to main menu test");

        /*G%E#$^&*G%E#$^&*G%E#$^&*G%E#  GET INFO TO ADD    $^&*G%E#$^&*G%E#$^&*G%E#$^&*G%E#$^&*G%E#$ */

        /****
         *** this needs info needs to be accepted when the user clicks save
         *** this will get the info from the inputer
         *** need to parse for integers and doubles to receive the message
         *** with strings you can just use get text
         **/


        /****
         *** need to do an error check for invalid format regardless if its in inhouse or outsourced
         *** doing a false statement so that it will catch everything that isn't a number
         */

        /****
         *** checks if max is an int
         **/
        if (!isValidNumber(maxTextFieldAddPart.getText())) {
            System.out.println("Invalid format test");

            Alert wrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheck.setTitle("Error  :(");

            wrongFormatErrorCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheck.setContentText("Invalid Format. The Max Field needs to use numbers");

            wrongFormatErrorCheck.showAndWait();
            return;

        }

        /****
         *** check to see if price is a valid double by making it false
         **/
        if (!isValidDouble(priceTextFieldAddPart.getText())) {
            System.out.println("Price format test");

            Alert wrongFormatErrorCheckPriceCheck = new Alert(Alert.AlertType.ERROR);

            wrongFormatErrorCheckPriceCheck.setTitle("Error  :(");

            wrongFormatErrorCheckPriceCheck.setHeaderText("Invalid Format");

            wrongFormatErrorCheckPriceCheck.setContentText("Invalid Format. The Price Field needs to use numbers in decimal format." +
                    "Please check the form again");
            wrongFormatErrorCheckPriceCheck.showAndWait();

            return;
        }

        /****
         *** checks if min is an int
         **/
        if (!isValidNumber(minTextFieldAddPart.getText())) {
            System.out.println("Invalid format Min test");

            Alert minWrongFormatMinErrorCheck = new Alert(Alert.AlertType.ERROR);

            minWrongFormatMinErrorCheck.setTitle("Error  :(");

            minWrongFormatMinErrorCheck.setHeaderText("Invalid Format");

            minWrongFormatMinErrorCheck.setContentText("Invalid Format. The Min Field needs to use numbers");

            minWrongFormatMinErrorCheck.showAndWait();
            return;

        }

        /****
         *** check to see if inv is an int
         **/
        if (!isValidNumber(stockTextFieldAddPart.getText())) {
            System.out.println("Invalid format Inventory test");

            Alert wrongFormatInventoryErrorCheckStockLvl = new Alert(Alert.AlertType.ERROR);

            wrongFormatInventoryErrorCheckStockLvl.setTitle("Error  :(");

            wrongFormatInventoryErrorCheckStockLvl.setHeaderText("Invalid Format");

            wrongFormatInventoryErrorCheckStockLvl.setContentText("Invalid Format. The Inventory Field needs to use numbers");

            wrongFormatInventoryErrorCheckStockLvl.showAndWait();
            return;

        }


        /****
         *** this will get the name of the part from the inputer
         **/
        String name = nameTextFieldAddAPart.getText();

        /****
         *** this will get part cost from the inputer
         **/
        double price = Double.parseDouble(priceTextFieldAddPart.getText());

        /****
         *** this will get part max from the inputer
         **/
        int max = Integer.parseInt(maxTextFieldAddPart.getText());

        /****
         *** this will get part min from the inputer
         **/
        int min = Integer.parseInt(minTextFieldAddPart.getText());

        /****
         *** this will get part Inventory number from the inputer
         **/
        int stock = Integer.parseInt(stockTextFieldAddPart.getText());

        /****
         *** need a method to add up the ID
         *** calling the method from inventory and will have it add up each time
         */
        brandNewID = Inventory.getBrandNewPartID.getAndIncrement();

        /****
         *** need text field for radio button
         **/
        String machineID = machineAndCompanyNameTextField.getText();






        /*%$%$%$%$%$%%%$$%$%$%$%$%$   SAVING PART TO INVENTORY     %$%$%$%$%$%%%$$%$%$%$%$%%$%$%*/

        /****
         *** this needs to add the new part to the inventory
         *** need to do one for outsourced or inhouse
         *** need to do a bunch of if statements depending on what is picked
         *** starting with a big if statement if the inhouse is selected
         **/

        if (inRadBttn.isSelected()) {

            /*C0^*^*^*^$($$)C0^*^*^*^$     CONDITIONS AND ERROR CHECKS      ($$)C0^*^*^*^$($$* */
            /****
             *** this will check if the max is less than min
             *** if so then it will return an error
             **/
            if (max < min || min > max) {
                System.out.println("Min is greater than Max ERROR check test");

                Alert maxLessthanMinErrorCheck = new Alert(Alert.AlertType.ERROR);

                maxLessthanMinErrorCheck.setTitle("Error   :(");

                maxLessthanMinErrorCheck.setHeaderText("ERROR Please Try Again");

                maxLessthanMinErrorCheck.setContentText("The Minimum number must be lower than than the maximum number ");

                maxLessthanMinErrorCheck.showAndWait();
                return;

            }

            /****
             *** this error will check to make sure that the stock number is inbetween min and max
             **/

            else if (stock < min || stock > max) {
                System.out.println("Stock number in between min and max test");
                Alert stockInBetweenMinAndMaxErrorCheck = new Alert(Alert.AlertType.ERROR);

                stockInBetweenMinAndMaxErrorCheck.setTitle("Error   :(");

                stockInBetweenMinAndMaxErrorCheck.setHeaderText("ERROR!! STOCK ERROR");

                stockInBetweenMinAndMaxErrorCheck.setContentText("The Inventory number must be greater" +
                        " than the min number and less than the max number. Please try again.");

                stockInBetweenMinAndMaxErrorCheck.showAndWait();
            }

            /****
             *** need to use valid number method to check if the things are valid inputs
             *** checking if name is a number
             **/
            else if (isValidNumber(nameTextFieldAddAPart.getText())) {
                System.out.println("Invalid format test");

                Alert nameTestWrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

                nameTestWrongFormatErrorCheck.setTitle("Error  :(");

                nameTestWrongFormatErrorCheck.setHeaderText("Invalid Format");

                nameTestWrongFormatErrorCheck.setContentText("Invalid format. The Name text field needs to use letters." +
                        "Please check the Name Field and try again");

                nameTestWrongFormatErrorCheck.showAndWait();
                return;
            }

            /****
             *** makes sure that machine ID is an int not a string
             **/
            else if (!isValidNumber(machineAndCompanyNameTextField.getText())) {
                System.out.println("Invalid format test");

                Alert machineIDWrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

                machineIDWrongFormatErrorCheck.setTitle("Error  :(");

                machineIDWrongFormatErrorCheck.setHeaderText("Invalid Format");

                machineIDWrongFormatErrorCheck.setContentText("Machine Id requires a number not letters. Please use numbers in this field");

                machineIDWrongFormatErrorCheck.showAndWait();

                return;
            }
            /****
             ***  this error will chekc if the inventory equals max or min
             **/

            else if (stock == min || stock == max)  {
                System.out.println("Stock number in between min and max test");
                Alert equalsStockInBetweenMinAndMaxErrorCheck = new Alert(Alert.AlertType.ERROR);

                equalsStockInBetweenMinAndMaxErrorCheck.setTitle("Error   :(");

                equalsStockInBetweenMinAndMaxErrorCheck.setHeaderText("ERROR!! STOCK ERROR");

                equalsStockInBetweenMinAndMaxErrorCheck.setContentText("The Inventory number must be greater" +
                        " than the min number and less than the max number. It can't equal each other. Please try again.");

                equalsStockInBetweenMinAndMaxErrorCheck.showAndWait();
            }


            /****
             *** need an else statement if everything passes then it will save the part
             **/

            else {
                System.out.println("Part passed all conditions and saved to inventory test");

                Inventory.addPart(new InHouse(brandNewID, stock, min, max, name, price, Integer.parseInt(machineID)));
                Parent saVePaRtOuT = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

                Scene saVePaRtOuTScEne = new Scene(saVePaRtOuT);

                Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();


                window.setScene(saVePaRtOuTScEne);
                window.show();


            }


        }

        /****
         *** need to make a scenario if outsourced is clicked
         *** I am going to copy what I did above only for outSourced
         **/
        if (outRadBttn.isSelected()) {
            /****
             *** this will check if the max is less than min
             *** if so then it will return an error
             **/
            if (max < min || min > max) {
                System.out.println("Min is greater than Max ERROR check test");

                Alert maxLessthanMinErrorCheck = new Alert(Alert.AlertType.ERROR);

                maxLessthanMinErrorCheck.setTitle("Error   :(");

                maxLessthanMinErrorCheck.setHeaderText("ERROR Please Try Again");

                maxLessthanMinErrorCheck.setContentText("The Minimum number must be lower than than the maximum number ");

                maxLessthanMinErrorCheck.showAndWait();
                return;

            }

            /****
             *** this error will check to make sure that the stock number is inbetween min and max
             **/

            else if (stock < min || stock > max) {
                System.out.println("Stock number in between min and max test");
                Alert stockInBetweenMinAndMaxErrorCheck = new Alert(Alert.AlertType.ERROR);

                stockInBetweenMinAndMaxErrorCheck.setTitle("Error   :(");

                stockInBetweenMinAndMaxErrorCheck.setHeaderText("ERROR!! STOCK ERROR");

                stockInBetweenMinAndMaxErrorCheck.setContentText("The Inventory number must be greater" +
                        "than the min number and less than the max number. Please try again.");

                stockInBetweenMinAndMaxErrorCheck.showAndWait();
            }

            /****
             ***  this error will check if the inventory equals max or min
             **/
            else if (stock == min || stock == max)  {
                System.out.println("Stock number in between min and max test");
                Alert equalsStockInBetweenMinAndMaxErrorCheck = new Alert(Alert.AlertType.ERROR);

                equalsStockInBetweenMinAndMaxErrorCheck.setTitle("Error   :(");

                equalsStockInBetweenMinAndMaxErrorCheck.setHeaderText("ERROR!! STOCK ERROR");

                equalsStockInBetweenMinAndMaxErrorCheck.setContentText("The Inventory number must be greater" +
                        " than the min number and less than the max number. It can't equal each other. Please try again.");

                equalsStockInBetweenMinAndMaxErrorCheck.showAndWait();
            }


            /****
             *** need to use valid number method to check if the things are valid inputs
             *** checking if name is a number or string
             **/
            else if (isValidNumber(nameTextFieldAddAPart.getText())) {
                System.out.println("Invalid format test");

                Alert wrongFormatErrorCheckName = new Alert(Alert.AlertType.ERROR);

                wrongFormatErrorCheckName.setTitle("Error  :(");

                wrongFormatErrorCheckName.setHeaderText("Invalid Format");

                wrongFormatErrorCheckName.setContentText("Invalid format. The Name text field needs to use letters." +
                        "Please check the Name Field and try again");

                wrongFormatErrorCheckName.showAndWait();
                return;
            }

            /****
             *
             */
            else if (isValidNumber(machineAndCompanyNameTextField.getText())) {
                System.out.println("Invalid format test");

                Alert companyNameWrongFormatErrorCheck = new Alert(Alert.AlertType.ERROR);

                companyNameWrongFormatErrorCheck.setTitle("Error  :(");

                companyNameWrongFormatErrorCheck.setHeaderText("Invalid Format");

                companyNameWrongFormatErrorCheck.setContentText("Invalid format. The  Company Name text field needs to use letters." +
                        "Please check the Name Field and try again");

                companyNameWrongFormatErrorCheck.showAndWait();
                return;

            }


            /****
             *** need an else statement if everything passes then it will save the part
             **/

            else {
                System.out.println("Part passed all conditions and saved to inventory test");

                Inventory.addPart(new OutSourced(brandNewID, stock, min, max, name, price, machineID));
                Parent saVePaRtOuT = FXMLLoader.load(getClass().getResource("MainForm.fxml"));

                Scene saVePaRtOuTScEne = new Scene(saVePaRtOuT);

                Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();


                window.setScene(saVePaRtOuTScEne);
                window.show();


            }

        }
    }





    /*B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%B%(**)%BB%*/




    /*%$#%$^%^%^%^%$%$$#       OTHER METHODS           %$#%$^%^%^%^%$%$$#%$#%$^%^%^%^%$%$$#%$#%$^%^%^%^% */

    /****
     *** this method will check whether or not the input is a number
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

    /*%$#%$^%^%^%^%$%$$#%$#%$^%^%^%^%$%$$#%$#%$^%$#%$^%^%^%^%$%$$#%%$#%$^%^%^%^%$%$$#%$#%$^%^%^%^%$%$$#%$#%$^ */


    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^^#^#^#^

1. Test 1 = needs the required labels, based on the Software GUI Mockup = :)
2. Test 2 = needs to go to the addPart screen and needs to go back to main menu/save after cancel = :)
3. Test 3 = need to be able add a part to the inventory and  to main form = :)
4. Test 4 = checking the functionality of the buttons in the add part screen = :)
4. A - radio button inhouse clicked should have machine id = :)
4. B - radio button outsourced clicked should have company name = :)
5. Test 5 = need to make sure that the id is disabled  and the text box is disabled = :)
6. Test 6 = need to check the functionality of adding a part = :)
6. 6A - need to be able to key in the componenets for add a part and it should save = :)
6. 6B - need to make sure the same part pulls up in modify part with the same data = :)
6. 6C - when save is clicked on add part it should return to main menu = :)
7. Test 7 = make sure cancel button goes back to main menu = :)
8. Test 8 = Input Validation and Error tests = :)
8. 8A - need an errror to pop up if the min is higher than max = :)
8. 8B - need an error to pop up if the inventory is outside the range of the min and max = :)
9. Test 9 = Adding valid data check errors should pop up checking if the data meets the criteria = :)
9. 9A - need an error to pop up testing inhouse if its a number or letter = :)
9. 9B - need an error to pop up testing if price is a number a or not = :)
9. 9C - need an error to pop up if inventory is a number = :)
9. 9D - need an error  to pop up if max is a number or not = :)
9. 9E - need an error to pop up if min is a number or not = :)
9. 9F - need an error to pop up if name are letters or not = :)
9. 9G - need to check if outsourced works with letters or not = :)



^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#^#^#^#^^#^#^#^^#^#^#^^#^#^#^
 */
}
