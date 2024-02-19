package nwalters.inventorytrackingsystemproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/****
 *** @author Nicholas Walters
 **/


/****
 ***  this method will launch the application
 **/

/*%@!!=++=%@!!=++=%@!!=++=%@!!=++=     ERRORS THAT I RAN INTO     %@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++= */
/**
 * - Logical error. I couldn't figure out how to do the search for uppercase, but I then realized that I didn't pass it through the other parameter.
 * - Logical error. I couldn't figure out how to get my products to save on the main screen.
 * - Logical error. I didn't realize that I was doing the Java Comments the wrong way. I didn't use the white space and period.
 * - Logical error. I didn't label all the classes.
 * - Logical error. When I would modify a product it wouldn't save the number of parts that would save, I had to change my method of getting the info from and making it an object.
 */
/*%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++=%@!!=++= */



/*$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&     FUTURE ENHANCEMENTS       $^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$*/
/**
 * - It would be cool to have pictures associated with the table to then click on a picture and have that as an additional search.
 * - Another future enchancement would be to have the ability to store all the saved products and parts into a saved database and then use a language like SQL to pull from that database.
 * - Another enhancement would be to have different colorschemes to more pleasing to the eye.
 * - Another future enhancement would be to add null pointer exceptions to all text boxes fields. The user might leave a space blank and this will catch those errors.
 */

/*$&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*$$%*&$^$^&*%**/

/**
 *This class launches the application so tha it can run.
 */
public class LaunchApplicationScreen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LaunchApplicationScreen.class.getResource("MainForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1111, 826);
        stage.setTitle("Inventory Tracking System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}