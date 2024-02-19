module nwalters.inventorytrackingsystemproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens nwalters.inventorytrackingsystemproject to javafx.fxml;
    exports nwalters.inventorytrackingsystemproject;
    opens ModelFolder to javafx.base;
}