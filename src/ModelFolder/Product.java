package ModelFolder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/****
 *** @author Nicholas Walters
 **/

/****
 *** Product class - 1.
 **/

/**
 * This class will hold the info about the Product.
 */
public class Product {

    /****
     *** need observablelist assoicatedParts - 2A
     **/
    private ObservableList<Part> associatedPartsList = FXCollections.observableArrayList();

    /****
     *** need the max,min, id, inventory number for product - 2B,2D,2E,2F
     **/
    private int max, min, idProduct, stock;

    /****
     *** need the name of the product - 2C
     **/
    private String name;

    /****
     *** need the price of the product - 2G
     **/
    private double price;


    /****
     *** need constructor - 3A
     **/
    public Product(int max, int min, int idProduct, int stock, String name, double price) {
        this.max = max;
        this.min = min;
        this.idProduct = idProduct;
        this.stock = stock;
        this.name = name;
        this.price = price;
    }
    /****
     *** need getters and setters for methods  - 3B-3M
     **/


    /****
     *** returns the product max number - 3L
     **/
    public int getMax() {
        return max;
    }

    /****
     *** sets the product max number - 3G
     **/
    public void setMax(int max) {
        this.max = max;
    }

    /****
     *** returns the product min number - 3K
     **/
    public int getMin() {
        return min;
    }

    /****
     *** sets the product min number - 3F
     **/
    public void setMin(int min) {
        this.min = min;
    }

    /****
     *** returns the product id - 3H
     **/
    public int getIdProduct() {
        return idProduct;
    }

    /****
     *** sets the product id - 3B
     **/
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /****
     *** returns the product inventory number - 3J
     **/
    public int getStock() {
        return stock;
    }

    /****
     *** sets the product inventory number - 3E
     **/
    public void setStock(int stock) {
        this.stock = stock;
    }

    /****
     *** returns the product name - 3M
     **/
    public String getName() {
        return name;
    }

    /****
     *** sets the product name - 3C
     **/
    public void setName(String name) {
        this.name = name;
    }


    /****
     *** returns the product price - 3I
     **/
    public double getPrice() {
        return price;
    }

    /****
     *** sets the product price - 3D
     **/
    public void setPrice(double price) {
        this.price = price;
    }


    /****
     *** remaining methods - 4.
     *** need deleteAssoicatedPart - 4B
     *** need getAllAssociatedParts - 4C
     *** need deleteAssociatedPart - 4A
     **/


    /****
     *** method for getting all the associated parts - 4C
     **/
    public ObservableList<Part> getAllAssociatedParts() {
        return associatedPartsList;
    }


    /****
     *** method for adding associated part - 4A
     **/
    public void addAssoicatedPart(Part part) {
        associatedPartsList.add(part);
    }


    /****
     *** method for deleting associated part - 4B
     **/
    public boolean deleteAssociatedPart(Part selectedAssociatedPart) {

        if (associatedPartsList.contains(selectedAssociatedPart)) {

            return true;
        } else {

            return false;
        }
    }


    /****
     *** end of the line
     *** don't continue
     **/

/*#^#^#^#^#^#^##^#^#^#^ REQUIREMENTS  ^#^#^#^#^#^#^#^#^#^#^#^#
1. Name of Class = Product
2. Data Members =
2A. - Observable List = associatedParts
2B. - int = id
2C. - String = name
2D. - int = stock
2E. - int min
2F. - int max
2G. - Double price
3. Methods =
3A. - Constructor
!! needs
- int = id
- String = name
- Double = Price
- int = stock
- int = min
- int = max
3B. - setID
3C. - setName
3D. - setPrice
3E. - setStock
3F. - setMin
3G. - setMax
3H. - getid
3I. - getPrice
3J. - getStock
3K. - getMin
3l. - getMax
3M. - getName
4. More Methods =
4A. - addAssociatedPart(part:Part):void
4B. - deleteAssociatedPart(selectedAssociatedPart:part)boolean
4C. - getAllAssociatedParts():ObservableList<Part>


^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^##^^##^#^#^#^#^#^#^#^#^#
 */
}

